import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:8080', // Spring Boot 서버 주소
    withCredentials: true, // 인증 정보(Cookies, Authorization 등)를 함께 전송
});

export default instance;
