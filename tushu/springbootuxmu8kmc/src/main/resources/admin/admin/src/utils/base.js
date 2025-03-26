const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootuxmu8kmc/",
            name: "springbootuxmu8kmc",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootuxmu8kmc/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园数字化图书馆系统"
        } 
    }
}
export default base
