<template>
  <!-- <div id="map"></div> -->
  <div id="map"></div>
</template>

<script>
// import AptArea from "@/components/apt/AptArea.vue";
export default {
  // components: {
  //   AptArea,
  // },
  name: "AptMap",
  data() {
    return {
      map: null,
      markers: [],
    };
  },
  created() {},
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=915cffed372954b7b44804ed422b9cf0";
      document.head.appendChild(script);
    }
  },
  methods: {
    // Map
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 5,
      };
      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);
    },
    reduceMap() {
      document.getElementById("map").style.width = "80%";
    },
  },
};
</script>

<style scoped>
.container {
  height: 800px;
  width: 800px;
  padding: 0;
  margin: 0;
}

#map {
  /* display: none; */
  position: absolute;
  bottom: 0px;
  margin-left: 4%;
  width: 96%;
  height: 91.6vh;

  /* width: 100%;
  height: 100%;
  position: absolute;
  left: 0;
  top: 0;
  margin: 0;
  padding: 0; */
}
</style>
