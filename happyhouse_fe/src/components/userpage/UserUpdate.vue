<template>
  <form>
    <img
      class="mb-4"
      src="@/assets/img/building-logo.png"
      alt=""
      width="100"
      height="100"
    />
    <h1 class="h3 mb-3 fw-normal" style="color: #2f4d5a">회원 정보 수정</h1>
    <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
      <li class="nav-item" role="presentation">
        <button
          class="nav-link active"
          id="info-tab"
          data-bs-toggle="tab"
          data-bs-target="#info-tab-pane"
          type="button"
          role="tab"
          aria-controls="info-tab-pane"
          aria-selected="true"
        >
          회원정보 수정
        </button>
      </li>
      <li class="nav-item" role="presentation">
        <button
          class="nav-link"
          id="password-tab"
          data-bs-toggle="tab"
          data-bs-target="#password-tab-pane"
          type="button"
          role="tab"
          aria-controls="password-tab-pane"
          aria-selected="false"
        >
          비밀번호 변경
        </button>
      </li>
    </ul>
    <div class="tab-content" id="myTabContent">
      <div
        class="tab-pane fade show active"
        id="info-tab-pane"
        role="tabpanel"
        aria-labelledby="info-tab"
        tabindex="0"
      >
        <div class="form-floating">
          <input
            type="text"
            :class="[isValidName ? 'form-control' : 'form-control is-invalid']"
            id="form-first"
            placeholder="이름"
            v-model="name"
            ref="name"
          />
          <label for="floatingInput">이름</label>
        </div>

        <div class="form-floating">
          <input
            type="text"
            :class="[isValidPhone ? 'form-control' : 'form-control is-invalid']"
            id="form-last"
            placeholder="전화번호"
            v-model="phoneNumber"
            ref="phoneNumber"
          />
          <label for="floatingInput">전화번호</label>
        </div>
        <button
          type="button"
          class="w-100 btn btn-lg btn-custom"
          @click="updateUserInfo"
        >
          회원정보 수정
        </button>
      </div>
      <!--비밀번호 변경-->
      <div
        class="tab-pane fade"
        id="password-tab-pane"
        role="tabpanel"
        aria-labelledby="password-tab"
        tabindex="0"
      >
        <div class="form-floating">
          <input
            type="text"
            :class="[isValidNow ? 'form-control' : 'form-control is-invalid']"
            id="form-first"
            placeholder="현재 비밀번호"
            v-model="password"
            ref="password"
          />
          <label for="floatingInput">현재 비밀번호</label>
        </div>
        <div class="form-floating">
          <input
            type="text"
            :class="[isValidNew ? 'form-control' : 'form-control is-invalid']"
            id="form-last"
            placeholder="새로운 비밀번호"
            v-model="newPassword"
            ref="newPassword"
          />
          <label for="floatingIput">새로운 비밀번호</label>
        </div>
        <button
          type="button"
          class="w-100 btn btn-lg btn-custom"
          @click="updatePassword"
        >
          비밀번호 변경
        </button>
      </div>
    </div>
  </form>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  name: "UserUpdate",
  data() {
    return {
      name: null,
      phoneNumber: null,
      password: null,
      newPassword: null,
      isValidName: true,
      isValidPhone: true,
      isValidNow: true,
      isValidNew: true,
    };
  },
  created() {
    this.name = this.userInfo.name;
    this.phoneNumber = this.userInfo.phone_number;
  },
  computed: {
    ...mapState("userStore", ["userInfo"]),
  },
  methods: {
    ...mapActions("userStore", [
      "changeUserInfo",
      "changePassword",
      "getUserInfo",
    ]),
    async updateUserInfo() {
      if (!this.isBlankUserInfo()) return;
      const user = {
        id: this.userInfo.id,
        name: this.name,
        phone_number: this.phoneNumber,
      };
      try {
        await this.changeUserInfo(user);
        alert("회원정보가 수정되었습니다.");
        const token = sessionStorage.getItem("token");
        await this.getUserInfo({ from: this.userInfo.role, token });
        this.$router.replace("/mypage/info");
      } catch (e) {
        alert("서버 오류입니다.\n잠시 후 다시 시도해주세요.");
      }
    },
    async updatePassword() {
      if (!this.isBlankPass()) return;
      const pwds = {
        nowPassword: this.password,
        newPassword: this.newPassword,
      };
      try {
        await this.changePassword(pwds);
        alert("비밀번호가 수정되었습니다.");
        this.$router.replace("/mypage/info");
      } catch (e) {
        console.log(e);
        if (e.response.data.code == "INVALID_PASSWORD") {
          alert("비밀번호가 일치하지 않습니다.");
          this.isValidNow = false;
          this.$refs.password.focus();
        } else {
          alert("서버 오류입니다.\n잠시 후 다시 시도해주세요.");
        }
      }
    },
    isBlankUserInfo() {
      if (!this.name) {
        this.isValidName = false;
        this.$refs.name.focus();
        return false;
      } else {
        this.isValidName = true;
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
    isBlankPass() {
      if (!this.password) {
        this.isValidNow = false;
        this.$refs.password.focus();
        return false;
      } else {
        this.isValidNow = true;
      }
      if (!this.newPassword) {
        this.isValidNew = false;
        this.$refs.newPassword.focus();
        return false;
      } else {
        this.isValidNew = true;
      }
      return true;
    },
  },
};
</script>

<style scoped>
.form-user .form-floating:focus-within {
  z-index: 2;
}

.form-user input#form-first {
  margin-top: 10px;
  margin-bottom: -1px;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}
.form-user input#form-middle {
  margin-bottom: -1px;
  border-radius: 0;
}
.form-user input#form-last {
  margin-bottom: 10px;
  border-top-right-radius: 0;
  border-top-left-radius: 0;
}

.nav-link {
  color: #67b0d1;
}
</style>
