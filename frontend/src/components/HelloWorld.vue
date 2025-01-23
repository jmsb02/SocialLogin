<template>
  <div class="container">
    <h1 class="title">로그인 성공!</h1>
    <p class="message">환영합니다. JWT가 저장되었습니다.</p>
    <button class="button" @click="goToHome">홈으로 이동</button>
  </div>
</template>

<script>
export default {
  mounted() {
    // URL에서 토큰 추출
    const urlParams = new URLSearchParams(window.location.search);
    const token = urlParams.get('token');

    if (token) {
      // JWT를 로컬 스토리지에 저장
      localStorage.setItem('jwt', token);
    } else {
      alert('토큰이 전달되지 않았습니다. 다시 로그인해주세요.');
    }
  },
  methods: {
    goToHome() {
      // 홈으로 이동 (라우팅 활용)
      this.$router.push('/');
    },
  },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f9f9f9;
  text-align: center;
}

.title {
  font-size: 2.5rem;
  color: #333;
  margin-bottom: 1rem;
}

.message {
  font-size: 1.2rem;
  margin-bottom: 2rem;
}

.button {
  padding: 0.8rem 2rem;
  font-size: 1rem;
  background-color: #4285f4;
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.button:hover {
  background-color: #357ae8;
}
</style>
