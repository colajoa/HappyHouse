<template>
  <div id="area">
    <table>
      <tr>
        <td>
          <select
            id="sido"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
            v-model="sidoCode"
            @change="gugunList"
          >
            <option v-for="sido in sidos" :value="sido.value" :key="sido.value">
              {{ sido.text }}
            </option>
          </select>
        </td>
        <td>
          <select
            id="gugun"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
            v-model="gugunCode"
            @change="dongList"
          >
            <option
              v-for="gugun in guguns"
              :value="gugun.value"
              :key="gugun.value"
            >
              {{ gugun.text }}
            </option>
          </select>
        </td>
        <td>
          <select
            id="dong"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
            v-model="dongCode"
            @change="yearList"
          >
            <option v-for="dong in dongs" :value="dong.value" :key="dong.value">
              {{ dong.text }}
            </option>
          </select>
        </td>
        <td>
          <select
            id="year"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
            v-model="yearCode"
            @change="monthList"
          >
            <option v-for="year in years" :value="year.value" :key="year.value">
              {{ year.text }}
            </option>
          </select>
        </td>
        <td>
          <select
            id="month"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
            v-model="monthCode"
          >
            <option
              v-for="month in months"
              :value="month.value"
              :key="month.value"
            >
              {{ month.text }}
            </option>
          </select>
        </td>
        <td>
          <button type="button" class="btn btn-custom" @click="searchApt">
            검색
          </button>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
import { mapActions, mapMutations, mapState } from "vuex";

const aptStore = "aptStore";
export default {
  name: "AptArea",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
      yearCode: null,
      monthCode: null,
    };
  },
  computed: {
    ...mapState(aptStore, [
      "sidos",
      "guguns",
      "dongs",
      "years",
      "months",
      "apts",
    ]),
  },
  created() {
    this.CLEAR_SIDO_LIST();
    this.CLEAR_APT_LIST();
    this.CLEAR_DONG_LIST();
    this.CLEAR_YEAR_LIST();
    this.CLEAR_MONTH_LIST();
    this.getSido();
    // console.log(this.sidos);
  },
  methods: {
    ...mapActions(aptStore, [
      "getSido",
      "getGugun",
      "getDong",
      "getYear",
      "getMonth",
      "getAptList",
    ]),
    ...mapMutations(aptStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
      "CLEAR_YEAR_LIST",
      "CLEAR_MONTH_LIST",
      "CLEAR_APT_LIST",
    ]),
    gugunList() {
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    dongList() {
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.gugunCode) this.getDong(this.gugunCode);
    },
    yearList() {
      this.CLEAR_YEAR_LIST();
      this.yearCode = null;
      if (this.dongCode) this.getYear();
      console.log(this.years);
    },
    monthList() {
      this.CLEAR_MONTH_LIST();
      this.month = null;
      if (this.yearCode) this.getMonth(this.yearCode);
      console.log(this.months);
    },
    async searchApt() {
      this.CLEAR_APT_LIST();
      if (this.dongCode && this.yearCode && this.monthCode) {
        const date = `${this.yearCode}${this.monthCode}`;
        await this.getAptList({ dongCode: this.dongCode, date });
        console.log(this.apts);
      } else {
        alert("검색 조건을 다시 확인하세요!");
      }
      // Reduce Map
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

.btn-custom {
  --bs-btn-font-weight: 600;
  --bs-btn-color: white;
  --bs-btn-bg: #67b0d1; /*연한거*/
  --bs-btn-border-radius: 0.5rem;
  --bs-btn-hover-color: white;
  --bs-btn-hover-bg: #409cc5;
  --bs-btn-active-color: var(--bs-btn-color);
  --bs-btn-active-bg: var(--bs-btn-bg);
}
</style>
>
