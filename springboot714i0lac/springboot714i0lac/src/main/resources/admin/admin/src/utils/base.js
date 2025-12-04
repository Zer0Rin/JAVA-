const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot714i0lac/",
            name: "springboot714i0lac",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot714i0lac/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于SpringBoot的音乐网站设计与实现"
        } 
    }
}
export default base
