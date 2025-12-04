package com.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "9021000127605975";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCuGq2gAozk1Ukhn8XajnsIxHWkqso3cNvySG5kZWTS9VhpDrywtMqzXHY143QqOk4KMrfqR4ZqwrhlsoYGespp6bvQyKrWZmMi7QRmJXYgCctDytZ89ckaWvKRyMFXImgWByZBxRFKQHnYT9aMSNftCewThN6xOd6nRkcoR0tzBG/HZB7mIGtWtwx4cDOMONMO7qLRZD4CscTxwP6QiWnWVNl2KisuwcPcspVH2rpxhCEPNt96ZzS0uMxrR/6aJ3sc+RTy2i2kHlzgkA7nZeGVT10i0mi+Yxti3Fv/7wyt3HXe9dcQp8mp5gEhDABqsGmzZ1EtDwP87VCqadu+GU9dAgMBAAECggEAY/2wb/BnCNmx+ZywXjhsUvm58wufvb2UpI6S0Bgnkr0TvKqZFgePTvmwbnymb8YyocrFM8lGWrRggQ/Jx5jn/XIeyuckrqP5Fcr4Ns4XDIlzcwjgrL3gdMF9BNs+pxN8ogITJ7zNlE55bBFWUBVZ5apIKmGqIDDzPjCvl2Ny4qfYt7AT0hU3ZVTzMIyFCLv9XsMe4Umbx5lQ08OXwDzyiw8MlMUvHb5gTYUs622vP9Y3vRMbUC3JUS2r8Wg3NFqXIEK0UtQ3RLL0Nq4jcJt4iP0vi0XympNBjv9OJ+hDGjAeZQ7Qu479A51zsA0m7PxwdeO+nNbtIOv9j8b/ZkdfoQKBgQD5wZ1aXU3Ic4Z2L3lr+BjxyPTh3C51bb4yfZCE1A/khBMeWcLoxyD5nM3eV5iZL3i/wzcyLSF7u6kT7E42tzgrL+wb6gZrjkBIwTU504RpVWjlT02d4PzUyWgkq8en7pKrYrHJ3hKQ8zYOzIeBW74k0nmJmGaByhlwHQHY+bVimQKBgQCydOglUywzjrhcaHTqWkxjU18Ca0lutnmlcyVYR/DK6C8caDGOTYAWnDhNL3QOBtdmQM354KOJ2Ilzy0DBszeaA+ebwXSxi3vKlm6r3o7UwMotXFxU16j4Tl+lwXbLLk6Rg+VID8ggZPG4rzPUyjAeU2OeQ8IP1wOUS8gz3W9RZQKBgBTVlOXD4Mg28uGLBkr+cD5DMEJjFrEPDY2yscqS0hyS8/FVNZArhFGuRfIlRoKI1j7Q7xrNbvyeY/VYghHIaPQZVE3j0NNKE4y+KU2Amowa5twyKFxiN1Uc1AYzGj2lBjEr037ueogC8eB8KVWeLJdvw1m6D9sF2+dhVBUgh4QJAoGAAvOkE1n41TF7IywnIukzckEixSt5H3etM2tgJsGp3fFRNisTBsOJZtZWqBAs3z6FuY9A2O06R0FppJysCYgpV0bRQeZFQ9qGxacPVZBs1GAL+AwbCtw2U0UYl+lHSb0OV6HS3QpFySNiTCe5t79QZHAEqc19HD32NTG7sf/ro3ECgYAIdELx9jqeQU94Lqf82h6pu/jv3oqgHsnB8XHgy2MG62JY62hFgh2E0WFV3OzHAAFYOvT7J78qM0PNtM4Glyp6QDbFe6Gg/1j++koSf6Lm0xan3s+gaZHwl2OpaufS7KvuPcFeDUs3QqmjWbtkoElUW9Fs25RHGmyGH+zax8HJdg==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2ANDY9KTvI3dJdCw/p5MZIyPf6nCY2BixoYLSXrejy+7UOl1eJC8U4XHG1gnqo4cFwyYu9J5Uk3898eTqvwLxq0CUn1N1dT5LhvpJFwTqyxnDzbewYDTdpAytC9iyNR1KgoIB5nnHjnf2xl+IDIMiOb949UOsr7cHkKNYkY29CoxK1ItKAeKHY27U49lssFRjO8RUk22pLstMDFZ+p7kUAHcJO4tsl7lmj1OP7u/cgKIg/T91mTnVzWThRgTmZsKv07PmbFziUEA9lUb5FCuE/8k1a5G8PmlxkLfjdJaNQiJxaYy9VU/FEZBv9u8+57mBjhXuq8fy829H+PkE+AKyQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/springboot714i0lac/";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url_b = "http://localhost:8080/springboot714i0lac/admin/dist/index.html#/";
    public static String return_url_f = "http://localhost:8080/springboot714i0lac/front/dist/index.html#/";


	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

