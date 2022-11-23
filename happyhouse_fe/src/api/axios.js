import axios from "axios";

const token = sessionStorage.getItem("token");

// axios 객체 생성
export default axios.create({
  baseURL: "http://localhost:8888",
  headers: {
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": "*",
    Authorization: token ? token : "",
  },
  withCredentials: true,
});
