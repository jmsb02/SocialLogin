<template>
  <HelloWorld msg="helloworld"/>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  }
}
</script>
<style scoped>
/* 부모 컨테이너를 화면 중앙에 배치 */
.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh; /* 전체 화면의 높이를 기준으로 중앙 배치 */
  text-align: center;
  background-color: #f9f9f9;
}

/* 제목 스타일 */
.title {
  font-size: 2.5rem;
  font-weight: bold;
  color: #333;
  margin-bottom: 1rem;
}

/* 메시지 스타일 */
.message {
  font-size: 1.2rem;
  color: #666;
  margin-bottom: 2rem;
}

/* 버튼 스타일 */
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

