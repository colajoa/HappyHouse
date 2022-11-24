<template>
  <div>
    <!-- <div class="d-flex" id="area"> -->
    <!-- <div>
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
              <option
                v-for="sido in sidos"
                :value="sido.value"
                :key="sido.value"
              >
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
              <option
                v-for="dong in dongs"
                :value="dong.value"
                :key="dong.value"
              >
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
              <option
                v-for="year in years"
                :value="year.value"
                :key="year.value"
              >
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
            <button
              type="button"
              class="btn-custom circle-btn"
              data-bs-toggle="button"
              autocomplete="off"
            >
              <svg
                class="bi pe-none"
                width="24"
                height="24"
                role="img"
                aria-label="Heart"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M11.975 22.15 9.95 20.325q-2.625-2.35-4.337-4.075-1.713-1.725-2.7-3.1-.988-1.375-1.388-2.55-.4-1.175-.4-2.45 0-2.725 1.813-4.55Q4.75 1.775 7.475 1.775q1.275 0 2.425.45t2.075 1.325q.925-.875 2.075-1.325 1.15-.45 2.425-.45 2.725 0 4.563 1.825 1.837 1.825 1.837 4.55 0 1.25-.387 2.425-.388 1.175-1.388 2.538-1 1.362-2.725 3.099Q16.65 17.95 14 20.325Zm0-4.225q2.35-2.15 3.863-3.625 1.512-1.475 2.374-2.575.863-1.1 1.188-1.925.325-.825.325-1.65 0-1.4-.925-2.312-.925-.913-2.325-.913-1.075 0-2.025.663-.95.662-1.325 1.687H10.85q-.375-1.025-1.337-1.687-.963-.663-2.038-.663-1.35 0-2.262.913Q4.3 6.75 4.3 8.15q0 .85.338 1.7.337.85 1.2 1.95.862 1.1 2.35 2.562 1.487 1.463 3.787 3.563Zm.05-6.5Z"
                />
              </svg>
            </button>

            <button
              type="button"
              class="btn btn-primary"
              data-bs-toggle="button"
              aria-pressed="false"
              autocomplete="off"
            >
              관심지역 등록 토글
            </button>
          </td>
        </tr>
      </table>
    </div> -->
    <!-- <apt-map style="z-index: -1"></apt-map> -->

    <div>
      <div class="row">
        <div class="col apt-col">
          <select
            id="sido"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
            v-model="sidoCode"
            ref="sidoCode"
            @change="gugunList"
          >
            <option v-for="sido in sidos" :value="sido.value" :key="sido.value">
              {{ sido.text }}
            </option>
          </select>
        </div>
        <div class="col apt-col">
          <select
            id="gugun"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
            v-model="gugunCode"
            ref="gugunCode"
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
        </div>
        <div class="col apt-col">
          <select
            id="dong"
            class="form-select form-select-sm"
            aria-label=".form-select-sm example"
            v-model="dongCode"
            ref="dongCode"
            @change="yearList"
          >
            <option v-for="dong in dongs" :value="dong.value" :key="dong.value">
              {{ dong.text }}
            </option>
          </select>
        </div>
      </div>
      <div class="row">
        <div class="col apt-col">
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
        </div>
        <div class="col apt-col">
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
        </div>
        <div class="col apt-col d-flex justify-content-center">
          <button
            type="button"
            class="btn btn-custom"
            @click="searchApt"
            style="padding-top: 0; padding-bottom: 0"
          >
            검색
          </button>
        </div>
      </div>
      <div>
        <!-- <button
          type="button"
          class="btn-custom circle-btn"
          data-bs-toggle="button"
          autocomplete="off"
        >
          <svg
            class="bi pe-none"
            width="24"
            height="24"
            role="img"
            aria-label="Heart"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M11.975 22.15 9.95 20.325q-2.625-2.35-4.337-4.075-1.713-1.725-2.7-3.1-.988-1.375-1.388-2.55-.4-1.175-.4-2.45 0-2.725 1.813-4.55Q4.75 1.775 7.475 1.775q1.275 0 2.425.45t2.075 1.325q.925-.875 2.075-1.325 1.15-.45 2.425-.45 2.725 0 4.563 1.825 1.837 1.825 1.837 4.55 0 1.25-.387 2.425-.388 1.175-1.388 2.538-1 1.362-2.725 3.099Q16.65 17.95 14 20.325Zm0-4.225q2.35-2.15 3.863-3.625 1.512-1.475 2.374-2.575.863-1.1 1.188-1.925.325-.825.325-1.65 0-1.4-.925-2.312-.925-.913-2.325-.913-1.075 0-2.025.663-.95.662-1.325 1.687H10.85q-.375-1.025-1.337-1.687-.963-.663-2.038-.663-1.35 0-2.262.913Q4.3 6.75 4.3 8.15q0 .85.338 1.7.337.85 1.2 1.95.862 1.1 2.35 2.562 1.487 1.463 3.787 3.563Zm.05-6.5Z"
            />
          </svg>
        </button> -->
        <div class="row">
          <div class="col"></div>
          <div class="col"></div>
          <div class="col d-flex justify-content-center">
            <button
              type="button"
              class="btn heart-btn"
              data-bs-toggle="button"
              aria-pressed="false"
              autocomplete="off"
              @click="regArea"
              style="border: none"
            >
              <svg
                class="bi pe-none"
                width="24"
                height="24"
                role="img"
                aria-label="Heart"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="m12 21.9-1.85-1.7q-2.75-2.525-4.487-4.288Q3.925 14.15 2.925 12.8t-1.363-2.488Q1.2 9.175 1.2 7.95q0-2.625 1.8-4.413Q4.8 1.75 7.45 1.75q1.2 0 2.4.487 1.2.488 2.15 1.363.95-.875 2.15-1.363 1.2-.487 2.4-.487 2.65 0 4.45 1.787 1.8 1.788 1.8 4.413 0 1.225-.362 2.362-.363 1.138-1.363 2.488t-2.737 3.112Q16.6 17.675 13.85 20.2Z"
                />
              </svg>
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapMutations, mapState } from "vuex";
// import AptMap from "@/components/apt/AptMap.vue";

const aptStore = "aptStore";
export default {
  // name: "AptArea",
  // components: {
  //   AptMap,
  // },
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
    this.sidoCode = null;
    this.CLEAR_SIDO_LIST();
    this.CLEAR_GUGUN_LIST();
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
      "registerArea",
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
      if (this.gugunCode) {
        this.getDong(this.gugunCode);
      }
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
    },
    async regArea() {
      // 비어있을 때 에러
      if (!this.dongCode) {
        if (!this.sidoCode) this.$refs.sidoCode.focus();
        else if (!this.gugunCode) this.$refs.gugunCode.focus();
        else this.$refs.dongCode.focus();
        return;
      }

      try {
        await this.registerArea(this.dongCode);
        alert("등록되었습니다.");
      } catch (e) {
        console.log(e);
        alert("서버 오류입니다.\nQnA에 남겨주세요!");
      }
    },
  },
};
</script>

<style scoped>
.heart-btn.active {
  background: rgba(255, 255, 255, 0);
  fill: red;
  border-color: none;
}

.heart-btn {
  border-color: none;
  background: none;
  fill: black;
}
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
.circle-btn {
  height: 50px;
  width: 50px;
  border-radius: 50%;
  align-content: center;
  margin: 0;
  padding: 6px;
  display: inline-block;
  --bs-btn-active-bg: ;
}
.apt-col {
  padding-left: 1px;
  padding-right: 1px;
  padding-top: 1px;
  padding-bottom: 1px;
}
</style>
