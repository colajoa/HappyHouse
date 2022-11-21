<template>
  <div>
    <h2 class="text-center fw-normal" style="color: #2f4d5a">공지사항 등록</h2>
    <div class="container">
      <div class="mb-3 d-flex justify-content-center">
        <input
          type="text"
          class="form-control form-control-lg"
          id=""
          placeholder="글 제목"
        />
      </div>
      <div class="mb-3 d-flex justify-content-center">
        <textarea
          class="form-control form-control-lg"
          id=""
          placeholder="내용을 입력하세요."
          rows="10"
        ></textarea>
      </div>
      <div class="d-flex justify-content-center">
        <div class="row">
          <div id="custom-btn-div" class="d-flex justify-content-end gap-2">
            <button class="btn btn-custom">작성</button>
            <router-link class="btn btn-custom" :to="{ name: 'boardlist' }"
              >취소</router-link
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
h2 {
  padding: 10px;
  margin-top: 50px;
  margin-bottom: 50px;
}
.form-control {
  width: 90%;
  border-radius: 0.2rem;
  padding-left: 1.5rem;
  padding-right: 1.5rem;
}

.row {
  width: 90%;
}

textarea {
  resize: none;
  padding-top: 2rem;
  padding-bottom: 2rem;
}
</style>
