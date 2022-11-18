import axios from "axios";

// axios 객체 생성
export default axios.create({
  baseURL: "http://localhost:8888",
  headers: {
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": "*",
    Authorization: "",
  },
  withCredentials: true,
});
