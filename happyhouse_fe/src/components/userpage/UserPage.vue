<template>
  <form>
    <img
      class="mb-4"
      src="@/assets/img/building-logo.png"
      alt=""
      width="100"
      height="100"
    />
    <h2 class="mb-3" style="color: #2f4d5a">{{ userInfo.name }}</h2>

    <div class="">
      <div class="form-control" id="form-first" ref="name" style="border: none">
        <svg xmlns="http://www.w3.org/2000/svg" height="48" width="48">
          <path
            d="M24 23.95q-3.3 0-5.4-2.1-2.1-2.1-2.1-5.4 0-3.3 2.1-5.4 2.1-2.1 5.4-2.1 3.3 0 5.4 2.1 2.1 2.1 2.1 5.4 0 3.3-2.1 5.4-2.1 2.1-5.4 2.1ZM8 40v-4.7q0-1.9.95-3.25T11.4 30q3.35-1.5 6.425-2.25Q20.9 27 24 27q3.1 0 6.15.775 3.05.775 6.4 2.225 1.55.7 2.5 2.05.95 1.35.95 3.25V40Z"
          />
        </svg>
      </div>
    </div>
    <div>
      <div class="form-control" id="form-middle" ref="id" style="border: none">
        <label
          ><h2>{{ userInfo.id }}</h2></label
        >
      </div>
    </div>
    <div class="">
      <div class="form-control" id="form-middle" style="border: none">
        <svg xmlns="http://www.w3.org/2000/svg" height="48" width="48">
          <path
            d="M13 46q-1.2 0-2.1-.9-.9-.9-.9-2.1V5q0-1.2.9-2.1.9-.9 2.1-.9h22q1.2 0 2.1.9.9.9.9 2.1v38q0 1.2-.9 2.1-.9.9-2.1.9Zm0-7.5h22v-29H13Z"
          />
        </svg>
      </div>
    </div>
    <div class="">
      <div
        class="form-control"
        id="form-last"
        ref="phoneNumber"
        style="border: none"
      >
        <label
          ><h2>{{ userInfo.phone_number }}</h2></label
        >
      </div>
    </div>

    <router-link :to="{ name: 'userupdate' }">
      <span id="custom-link" class="span-inline userupdate-btn">정보수정</span>
    </router-link>
    <router-link :to="{ name: 'userdelete' }">
      <span id="custom-link" class="span-inline userdelete-btn">회원탈퇴</span>
    </router-link>
  </form>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "UserPage",
  data() {
    return {};
  },
  computed: {
    ...mapState("userStore", ["userInfo"]),
  },
  methods: {},
};
</script>

<style scoped>
.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-user input#form-first[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-user input#form-middle {
  margin-bottom: -1px;
  border-radius: 0;
}

.form-user input#form-last[type="text"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

.span-inline {
  display: inline-block;
  padding: 10px 15px;
  margin: 15px;
}

.userupdate-btn {
  margin-right: 40px;
}

.userdelete-btn {
  margin-left: 40px;
}
#custom-link {
  color: #2f4d5a;
}

#custom-link:hover {
  color: #409cc5;
}

svg {
  fill: rgb(47, 77, 90);
}
</style>
