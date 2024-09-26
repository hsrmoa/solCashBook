const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // npm run build 시 타켓 디렉토리(백엔드)
  outputDir:'../src/main/resources/static',
  // npm run serve 개발 진행 시 포트가 다르기 떄문에 프록시 설정필요
  // target : 백엔드 port가 들어감
  // changeOrigin -> true로 해야 cros 문제 해결할 수 있음
  devServer:{
    proxy:{
      '/api': {
        target: 'http://localhost:80',
        changeOrigin: true,
        ws:false, // 웹소켓여부?
      }
    }
  },
  chainWebpack:config => {
    config.plugins.delete('prefetch');  // prefetch삭제
  }
})
