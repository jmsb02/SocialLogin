<template>
  <div>
    <h1>로그인 처리 중...</h1>
  </div>
</template>

<script>
import { useRouter } from 'vue-router';

export default {
  setup() {
    const router = useRouter();

    // URL 파라미터에서 JWT 토큰 추출
    const urlParams = new URLSearchParams(window.location.search);
    const token = urlParams.get('token');

    if (token) {
      // JWT를 로컬 스토리지에 저장
      localStorage.setItem('jwt', token);

      alert('로그인 성공! JWT가 저장되었습니다.');
      router.push('/'); // 리디렉션 후 홈 또는 보호된 리소스로 이동
    } else {
      alert('로그인 실패. 토큰이 없습니다.');
      router.push('/');
    }
  },
};
</script>
