<template>
  <div class="container">
    <h1 class="title">Login with OAuth 2.0</h1>
    <div class="buttons">
      <button class="button github" @click="handleLogin('github')">GitHub</button>
      <button class="button kakao" @click="handleLogin('kakao')">Kakao</button>
      <button class="button google" @click="handleLogin('google')">Google</button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    handleLogin(provider) {
      const SERVER_URL = 'http://localhost:8080'; // 서버 URL
      window.location.href = `${SERVER_URL}/oauth2/authorization/${provider}`;
    },
  },
};
</script>

<style scoped>
/* 부모 컨테이너를 화면 중앙에 배치 */
.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh; /* 전체 화면 중앙 */
  background-color: #f9f9f9; /* 배경색 추가 */
  text-align: center;
}

/* 제목 스타일 */
.title {
  font-size: 2.5rem;
  font-weight: bold;
  color: #333;
  margin-bottom: 2rem;
}

/* 버튼 컨테이너 */
.buttons {
  display: flex;
  flex-direction: column; /* 버튼을 수직 정렬 */
  gap: 1rem; /* 버튼 간 간격 */
}

/* 버튼 스타일 */
.button {
  width: 200px;
  padding: 0.8rem;
  font-size: 1.2rem;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: all 0.3s ease;
  text-align: center;
}

.github {
  background-color: #24292e;
  color: white;
}

.github:hover {
  background-color: #1b1f23;
}

.kakao {
  background-color: #fee500;
  color: #3c1e1e;
}

.kakao:hover {
  background-color: #fddc00;
}

.google {
  background-color: #4285f4;
  color: white;
}

.google:hover {
  background-color: #357ae8;
}
</style>
