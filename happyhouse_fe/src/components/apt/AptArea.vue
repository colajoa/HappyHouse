<template>
  <div id="area">
    <table>
      <tr>
        <td>
          <select
            id="sido"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
          >
            <option value="">시/도</option>
          </select>
        </td>
        <td>
          <select
            id="gugun"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
          >
            <option value="">구/군</option>
          </select>
        </td>
        <td>
          <select
            id="dong"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
          >
            <option value="">동</option>
          </select>
        </td>
        <td>
          <select
            id="year"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
          >
            <option value="">연도</option>
          </select>
        </td>
        <td>
          <select
            id="month"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
          >
            <option value="">월</option>
          </select>
        </td>
        <td>
          <select
            id="day"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
          >
            <option value="">일</option>
          </select>
        </td>
        <td>
          <button type="button" class="btn btn-outline-primary">검색</button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "AptArea",
  methods: {
    searchBtn() {
      this.$emit("reduceMap");
    },
  },
};
</script>

<style scoped>
#area {
  width: fit-content;
  height: 50px;
  margin: 5px;
}

td {
  padding: 0 5px;
}

td select {
  margin: 0 15px;
}

td button {
  margin: 0 20px;
}
</style>
>
