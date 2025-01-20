// src/api/protectedApi.js
import axios from './axios'; // 커스텀 axios 인스턴스 가져오기

export const fetchProtectedResource = () => {
    // JWT 토큰을 Authorization 헤더에 추가하여 API 호출
    return axios.get('/api/protected', {
        headers: {
            Authorization: `Bearer ${localStorage.getItem('jwt')}`,
        },
    });
};
