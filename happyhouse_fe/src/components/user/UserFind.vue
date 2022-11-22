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
    <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
      <li class="nav-item" role="presentation">
        <button
          class="nav-link active"
          id="id-tab"
          data-bs-toggle="tab"
          data-bs-target="#id-tab-pane"
          type="button"
          role="tab"
          aria-controls="id-tab-pane"
          aria-selected="true"
        >
          아이디 찾기
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
          비밀번호 찾기
        </button>
      </li>
    </ul>
    <div class="tab-content" id="myTabContent">
      <!--아이디 찾기 탭-->
      <div
        class="tab-pane fade show active"
        id="id-tab-pane"
        role="tabpanel"
        aria-labelledby="id-tab"
        tabindex="0"
      >
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="form-first"
            placeholder="이름"
            v-model="name"
          />
          <label for="floatingInput">이름</label>
        </div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="form-last"
            placeholder="전화번호"
            v-model="phoneNumber"
          />
          <label for="floatingIput">전화번호</label>
        </div>
        <button
          type="button"
          class="w-100 btn btn-lg btn-custom"
          @click="findId"
        >
          아이디 찾기
        </button>
      </div>

      <!--비밀번호 찾기 탭-->
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
            class="form-control"
            id="form-first"
            placeholder="이름"
            v-model="name"
          />
          <label for="floatingInput">이름</label>
        </div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="form-middle"
            placeholder="아이디"
            v-model="id"
          />
          <label for="floatingInput">아이디</label>
        </div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="form-last"
            placeholder="전화번호"
            v-model="phoneNumber"
          />
          <label for="floatingInput">전화번호</label>
        </div>
        <button
          type="button"
          class="w-100 btn btn-lg btn-custom"
          @click="findPassword"
        >
          비밀번호 찾기
        </button>
      </div>

      <!--비밀번호 변경 탭-->
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
            class="form-control"
            id="form-first"
            placeholder="새로운 비밀번호"
            v-model="newPassword"
          />
          <label for="floatingInput">새로운 비밀번호</label>
        </div>

        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="form-last"
            placeholder="비밀번호 확인"
            v-model="checkPassword"
          />
          <label for="floatingInput">비밀번호 확인</label>
        </div>
        <button
          type="button"
          class="w-100 btn btn-lg btn-custom"
          @click="changePassword"
        >
          비밀번호 변경
        </button>
      </div>
    </div>
  </form>
</template>

<script>
import { mapActions } from "vuex";

const userStore = "userStore";
export default {
  name: "UserFind",
  data() {
    return {
      id: null,
      name: null,
      phoneNumber: null,
    };
  },
  computed: {},
  methods: {
    ...mapActions(userStore, ["getUserId", "setNewPassword"]),
    // 아이디 찾기
    async findId() {
      const user = {
        name: this.name,
        phone_number: this.phoneNumber,
      };
      this.id = await this.getUserId(user).catch((e) => {
        if (e.response.data.code == "USER_NOT_FOUND")
          alert("일치하는 정보의 사용자가 없습니다.");
      });
      if (this.id !== undefined) {
        alert(`찾으시는 사용자의 아이디는 ${this.id}입니다.`);
        this.$router.replace("/user/login");
      }
    },
    // 비밀번호 찾기
    async findPassword() {
      const user = {
        name: this.name,
        id: this.id,
        phone_number: this.phoneNumber,
      };
      await this.setNewPassword(user);
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
.span-inline {
  display: inline-block;
  padding: 10px 15px;
  margin: 10px;
}

.nav-link {
  color: #67b0d1;
}
</style>
