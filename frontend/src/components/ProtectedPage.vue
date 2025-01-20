<template>
  <div>
    <h1>보호된 리소스</h1>
    <div v-if="data">
      <pre>{{ data }}</pre>
    </div>
    <div v-else>
      로딩 중...
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      data: null,
    };
  },
  mounted() {
    const token = localStorage.getItem('jwt');
    if (!token) {
      alert('로그인이 필요합니다.');
      this.$router.push('/');
      return;
    }

    axios
        .get('http://localhost:8080/api/protected', {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        })
        .then((response) => {
          this.data = response.data;
        })
        .catch((error) => {
          console.error('인증 실패:', error);
          alert('인증에 실패했습니다. 다시 로그인해주세요.');
          this.$router.push('/');
        });
  },
};
</script>
