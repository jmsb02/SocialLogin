<template>
  <div>
    <h1>OAuth2 Login</h1>
    <button @click="handleLogin('google')">Login with Google</button>
    <button @click="handleLogin('github')">Login with GitHub</button>
    <button @click="handleLogin('kakao')">Login with Kakao</button>
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
