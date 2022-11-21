<template>
  <form>
    <img
      class="mb-4"
      src="@/assets/img/building-logo.png"
      alt=""
      width="100"
      height="100"
    />
    <h1 class="h3 mb-3 fw-normal" style="color: #2f4d5a">HappyHouse</h1>

    <div class="form-floating">
      <input
        type="text"
        class="form-control"
        id="join-first"
        placeholder="이름"
        v-model="name"
        ref="name"
      />
      <label for="floatingInput">이름</label>
    </div>
    <div class="form-floating">
      <input
        type="text"
        class="form-control"
        id="join-middle"
        placeholder="아이디"
        v-model="id"
        ref="id"
      />
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input
        type="password"
        class="form-control"
        id="join-middle"
        placeholder="비밀번호"
        v-model="password"
        ref="password"
      />
      <label for="floatingPassword">비밀번호</label>
    </div>
    <div class="form-floating">
      <input
        type="text"
        class="form-control"
        id="join-last"
        placeholder="전화번호"
        v-model="phoneNumber"
        ref="phoneNumber"
      />
      <label for="floatingInput">전화번호</label>
    </div>

    <button type="button" class="w-100 btn btn-lg btn-custom" @click="join">
      회원가입
    </button>
  </form>
</template>

<script>
import { mapActions } from "vuex";

const userStore = "userStore";
export default {
  name: "UserJoin",
  data() {
    return {
      id: null,
      password: null,
      name: null,
      phoneNumber: null,
    };
  },
  methods: {
    ...mapActions(userStore, ["userJoin"]),
    async join() {
      // 빈 칸이 존재하면 input에 focus
      if (!this.isBlank()) return;

      // 유효성 검사
      if (!this.validation()) return;

      const user = {
        id: this.id,
        pwd: this.password,
        name: this.name,
        phone_number: this.phoneNumber,
      };
      try {
        await this.userJoin(user);
        this.$router.replace("/user/login");
      } catch (e) {
        console.log(e);
      }
    },
    isBlank() {
      if (!this.name) {
        this.$refs.name.focus();
        return false;
      }
      if (!this.id) {
        this.$refs.id.focus();
        return false;
      }
      if (!this.password) {
        this.$refs.password.focus();
        return false;
      }
      if (!this.phoneNumber) {
        this.$refs.phoneNumber.focus();
        return false;
      }
      return true;
    },
    validation() {
      return true;
    },
  },
};
</script>

<style scoped>
.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-user input#join-first[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-user input#join-middle {
  margin-bottom: -1px;
  border-radius: 0;
}

.form-user input#join-last[type="text"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

.span-inline {
  display: inline-block;
  padding: 10px 15px;
  margin: 10px;
}
</style>
