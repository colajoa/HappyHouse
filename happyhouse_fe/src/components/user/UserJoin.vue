<template>
  <form autocomplete="off">
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
        :class="[isValidName ? 'form-control' : 'form-control is-invalid']"
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
        :class="[isValidId ? 'form-control' : 'form-control is-invalid']"
        id="join-middle"
        placeholder="아이디"
        v-model="id"
        ref="id"
        @keypress="checkId"
      />
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input
        type="password"
        :class="[isValidPass ? 'form-control' : 'form-control is-invalid']"
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
        :class="[isValidPhone ? 'form-control' : 'form-control is-invalid']"
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
      msg: null,
      isValidId: true,
      isValidPass: true,
      isValidName: true,
      isValidPhone: true,
    };
  },
  methods: {
    ...mapActions(userStore, ["userJoin", "checkDuplicateId"]),
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
    // 빈 칸일 경우
    isBlank() {
      if (!this.name) {
        this.isValidName = false;
        this.$refs.name.focus();
        return false;
      } else {
        this.isValidName = true;
      }
      if (!this.id) {
        this.isValidId = false;
        this.$refs.id.focus();
        return false;
      } else {
        this.isValidId = true;
      }
      if (!this.password) {
        this.isValidPass = false;
        this.$refs.password.focus();
        return false;
      } else {
        this.isValidPass = true;
      }
      if (!this.phoneNumber) {
        this.isValidPhone = false;
        this.$refs.phoneNumber.focus();
        return false;
      } else {
        this.isValidPhone = true;
      }
      return true;
    },
    // 유효성 검사
    validation() {
      if (!this.validateId(this.id)) {
        this.isValidId = false;
        this.$refs.id.focus();
        return false;
      } else {
        this.isValidId = true;
      }
      if (!this.validatePw(this.password)) {
        console.log(this.password);
        this.isValidPass = false;
        this.$refs.password.focus();
        return false;
      } else {
        this.isValidPass = true;
      }
      if (!this.validatePhone(this.phoneNumber)) {
        this.isValidPhone = false;
        this.$refs.phoneNumber.focus();
        return false;
      } else {
        this.isValidPhone = true;
      }

      return true;
    },

    async checkId() {
      try {
        await this.checkDuplicateId(this.id);
        this.msg = "사용 가능한 아이디입니다.";
        console.log("사용 가능한 아이디");
      } catch (e) {
        console.log(e.response.data);
        // 아이디 존재할 경우
        if (e.response.data.code == "ID_EXISTS") {
          this.msg = "중복된 아이디입니다.";
          console.log("중복된 아이디입니다");
          console.log(e);
        } else {
          console.log(e);
        }
      }
    },
    validateId: (id) => {
      if (id.length >= 6 && id.length <= 12) {
        console.log(id.length);
        return true;
      }
      return false;
    },

    validatePw: (pw) => {
      if (pw.length >= 8) return true;
      return false;
    },

    validatePhone: (phone) => {
      const regPhone = /^01([0|1|6|7|8|9])-?([0-9]{4})-?([0-9]{4})$/;
      return regPhone.test(phone);
    },
  },
};
</script>

<style scoped>
.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-user input#join-first[type="text"] {
  margin-bottom: 0.5px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-user input#join-middle {
  margin-bottom: 0.5px;
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
