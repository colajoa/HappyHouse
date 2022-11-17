<template>
  <div id="main">
    <div id="divbody" class="text-center">
      <main class="form-user w-100 m-auto">
        <router-view></router-view>
      </main>
    </div>
  </div>
</template>

<script>
export default {
  mounted() {},
};
</script>

<style scoped>
.blank {
  position: relative;
  width: fit-content;
  height: 104px;
}
#divbody {
  display: flex;
  align-items: center;
  padding-top: 125px;
  padding-bottom: 125px;
}

.form-user {
  max-width: 330px;
  padding: 15px;
}

.form-user .form-floating:focus-within {
  z-index: 2;
}
</style>
