<template>
  <div>
    <h2>로그인된 회원의 관심 지역만 보임</h2>

    <ul class="list-group" role="group">
      <li
        v-for="area in areas"
        :key="area"
        class="list-group-item list-group-item-action"
        aria-current="true"
        data-bs-toggle="list"
      >
        여기에 관심지역
      </li>
      <li class="list-group-item list-group-item-action" data-bs-toggle="list">
        A second link item
      </li>
      <li class="list-group-item list-group-item-action" data-bs-toggle="list">
        A third link item
      </li>
      <li class="list-group-item list-group-item-action" data-bs-toggle="list">
        A fourth link item
      </li>
    </ul>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.list-group {
  border-radius: 0;
}
</style>
