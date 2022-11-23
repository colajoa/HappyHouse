<template>
  <form>
    <img
      class="mb-4"
      src="@/assets/img/building-logo.png"
      alt=""
      width="100"
      height="100"
    />
    <h1 class="h3 mb-3 fw-normal" style="color: #2f4d5a">회원 탈퇴</h1>
    <div class="form-floating">
      <input
        type="password"
        class="form-control"
        id="floatingPassword"
        placeholder="비밀번호"
        v-model="password"
        ref="password"
      />
      <label for="floatingPassword">비밀번호</label>
    </div>
    <div class="form-floating">
      <input
        type="password"
        class="form-control"
        id="floatingPassword"
        placeholder="비밀번호"
        v-model="checkPassword"
        ref="password"
        @keypress="comparePassword"
      />
      <label for="floatingPassword">비밀번호 확인</label>
    </div>
    <div>
      <button
        type="button"
        class="w-100 btn btn-lg btn-custom"
        @click="removeUser"
      >
        탈퇴하기
      </button>
    </div>
  </form>
</template>

<script>
import { mapActions } from "vuex";
export default {
  name: "UserDelete",
  data() {
    return {
      password: null,
      checkPassword: null,
      isCorrect: false,
    };
  },
  methods: {
    ...mapActions("userStore", ["getUserByPassword", "withdrawUser"]),
    async removeUser() {
      const pwd = {
        pwd: this.password,
      };
      try {
        const result = confirm("정말로 탈퇴하시겠습니까?");
        if (result) {
          await this.withdrawUser(pwd);
          this.$router.replace("/");
        }
      } catch (e) {
        console.log(e);
        if (e.response.data.code == "INVALID_PASSWORD") {
          alert("비밀번호가 일치하지 않습니다.");
        } else {
          alert("서버 오류가 발생했습니다.");
        }
      }
    },
    // 비밀번호 확인
    comparePassword() {
      console.log(this.isCorrect);
      if (this.password != this.checkPassword) {
        this.isCorrect = false;
      } else {
        this.isCorrect = true;
      }
    },
  },
};
</script>

<style></style>
