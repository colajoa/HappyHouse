<template>
  <!-- <div id="map"></div> -->
  <div id="map" class="d-flex" style="z-index: 0"></div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "AptMap",
  data() {
    return {
      map: null,
      markers: [],
      clusterer: null,
    };
  },
  computed: {
    ...mapState("aptStore", ["apt", "apts"]),
  },
  watch: {
    apts: function () {
      if (this.apts) {
        this.displaymarkers();
      }
    },
    apt: function () {
      this.setMapCenter();
    },
  },
  created() {},
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${process.env.VUE_APP_KAKAO_SDK_KEY}&libraries=services,clusterer,drawing`;
      document.head.appendChild(script);
    }
  },
  methods: {
    // Map
    initMap() {
      const container = document.getElementById("map");
      const options = {
        // 멀티캠퍼스 좌표
        center: new kakao.maps.LatLng(37.501339, 127.039582),
        level: 2,
      };
      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);

      var markerPosition = new kakao.maps.LatLng(37.501339, 127.039582);

      var marker = new kakao.maps.Marker({
        position: markerPosition,
      });

      marker.setMap(this.map);

      var mapTypeControl = new kakao.maps.MapTypeControl();
      this.map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

      var zoomControl = new kakao.maps.ZoomControl();
      this.map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

      this.clusterer = new kakao.maps.MarkerClusterer({
        map: this.map,
        averageCenter: true,
        minLevel: 4,
      });
    },
    setMapCenter() {
      let map = this.map;
      let apt = this.apt;

      var geocoder = new kakao.maps.services.Geocoder();
      const address = `${apt.법정동} ${apt.지번}`;

      geocoder.addressSearch(address, function (result, status) {
        if (status === kakao.maps.services.Status.OK) {
          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

          var marker = new kakao.maps.Marker({
            position: coords,
          });

          let content = `<div style="width:150px;text-align:center;padding:6px 0;">
              <span class="title">
                ${apt.아파트}
                </span>
                </div>
            `;
          var infowindow = new kakao.maps.InfoWindow({
            content,
          });
          infowindow.open(map, marker);

          map.setCenter(coords);
          map.setLevel(2);
        }
      });
    },
    displaymarkers() {
      this.clearMarkers(null);
      this.clusterer.clear();

      let map = this.map;
      let markers = this.markers;

      var geocoder = new kakao.maps.services.Geocoder();

      this.apts.forEach((apt) => {
        const address = `${apt.법정동} ${apt.지번}`;
        geocoder.addressSearch(address, function (result, status) {
          if (status == kakao.maps.services.Status.OK) {
            let coords = new kakao.maps.LatLng(result[0].y, result[0].x);

            let marker = new kakao.maps.Marker({
              position: coords,
              map: map,
              title: apt.아파트,
            });

            marker.setMap(map);
            markers.push(marker);

            let content = `
              <div style="width:150px;text-align:center;padding:6px 0">
                ${apt.아파트}
              </div>
            `;
            var infowindow = new kakao.maps.InfoWindow({
              content,
            });
            infowindow.open(map, marker);
            map.setCenter(coords);
          }
        });
      });
      this.clusterer.addMarkers(this.markers);
    },
    setMarkers(map) {
      for (var marker in this.markers) {
        marker.setMap(map);
      }
    },
    clearMarkers() {
      this.setMarkers(null);
      this.markers = [];
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
  margin-left: 4%;
  width: 96%;
  height: 91%;

  /* width: 100%;
  height: 100%;
  position: absolute;
  left: 0;
  top: 0;
  margin: 0;
  padding: 0; */
}
</style>
