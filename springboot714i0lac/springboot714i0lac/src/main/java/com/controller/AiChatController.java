package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
// 导入处理超时的相关类
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.util.*;

@RestController
@RequestMapping("/api/ai")
public class AiChatController {

    @Value("${ai.api.key}")
    private String apiKey;

    @Value("${ai.api.url}")
    private String apiUrl;

    @Value("${ai.api.model}")
    private String modelName;

    @PostMapping("/chat")
    public Map<String, Object> chat(@RequestBody Map<String, String> userMessage) {
        // 打印日志方便调试
        System.out.println("正在连接 DeepSeek V3.2 (思考模式)...");
        System.out.println("API URL: " + apiUrl);
        System.out.println("Model: " + modelName);

        String content = userMessage.get("message");

        // 1. 设置超时时间 (关键步骤)
        // 思考模式 (Reasoner) 可能会花费 30-60 秒来思考，默认的 RestTemplate 可能会超时报错
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(120000); // 设置读取超时为 120秒 (2分钟)
        factory.setConnectTimeout(60000); // 连接超时 60秒
        RestTemplate restTemplate = new RestTemplate(factory);

        // 2. 构建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        // 3. 构建请求体
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", modelName);
        requestBody.put("stream", false); // 目前我们还是用非流式，等待它思考完一次性返回

        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("role", "user");
        messageMap.put("content", content);
        requestBody.put("messages", Collections.singletonList(messageMap));

        // 4. 发送请求
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(apiUrl, entity, Map.class);
            Map<String, Object> responseBody = response.getBody();

            // 5. 解析结果
            if (responseBody == null || !responseBody.containsKey("choices")) {
                return getErrorMap("API 返回为空");
            }

            List<Map<String, Object>> choices = (List<Map<String, Object>>) responseBody.get("choices");
            Map<String, Object> firstChoice = choices.get(0);
            Map<String, Object> message = (Map<String, Object>) firstChoice.get("message");

            // DeepSeek 思考模式返回的内容依然在 content 里
            // (注：思考过程通常在 reasoning_content 字段，但目前标准接口只取最终结果即可)
            String aiContent = (String) message.get("content");

            Map<String, Object> result = new HashMap<>();
            result.put("reply", aiContent);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            // 如果报错超时，提示用户
            if (e.getMessage().contains("Read timed out")) {
                return getErrorMap("思考时间过长，连接超时。请尝试问简单一点的问题，或在后台增加超时时间配置。");
            }
            return getErrorMap("连接失败: " + e.getMessage());
        }
    }

    private Map<String, Object> getErrorMap(String msg) {
        Map<String, Object> errorResult = new HashMap<>();
        errorResult.put("reply", "[系统警报] " + msg);
        return errorResult;
    }
}