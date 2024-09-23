// import store from '@/store'
import axios from 'axios'

axios.defaults.baseURL = process.env.VUE_APP_API_URL
axios.defaults.headers.post['Content-Type'] = 'application/json'

/** 요청(Request) 시 인터셉트(interceptor) */
axios.interceptors.request.use(function (config) {
  console.log('request interceptor!!')
  return config
}, function (error) {
  console.log(error)
  return Promise.reject(error)
})

/** Response 시 인터셉트(interceptor) */
axios.interceptors.response.use(function (response) {
  console.log('Response Interceptor!!')
  return response
}, function (error) {
  console.log(error)
  return Promise.reject(error)
})

export default axios
