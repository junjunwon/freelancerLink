<template>
    <div>
        <button @click="write">Write</button>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>날짜</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(item, idx) in list" :key="item.id" @click="showInfo(idx)" style="cursor:pointer;">
                    <td>{{item.id}}</td>
                    <td>{{item.title}}</td>
                    <td>{{item.content}}</td>
                    <td>{{item.modifiedDate}}</td>
                </tr>
            </tbody>
        </table>
        <div class="board_info" v-if="selected">
            <div style="float:right"><button @click="closeInfo">X</button></div>
            <div><button @click="deleteArticle(item.id)">삭제</button></div>
            <div><button @click="moveUpdatePage(item.id)">수정</button></div>
            <table>
                <input type="hidden" v-text="item.id">
                <tr><th>제목</th><td></td></tr>
                <tr><th>본문</th><td><span v-text="item.content"></span></td></tr>
            </table>
        </div>
      <div class="form-group">
        <button @click="$router.back()">돌아가기</button>
      </div>
    </div>
</template>

<script>
export default {
    created() {
      this.fetchData()
    },
    data() {
        return {
            selected : false,
            list : [],
            item : null
        }
    },
    methods: {
        fetchData() {
            // this.$axios.get('/api/boards')
            // .then(response => {
            //     this.list = response.data.data;
            // })
            // .catch(error => {
            //     console.log(error)
            // })
          this.$axios.get('/board/list')
              .then((response) => {
                alert("post success2 !!"+response.data);
                this.list = response.data.data;
              })
              .catch((ex) => {
                alert("error occur!!" + ex);
              })
        },
        write() {
            this.$router.push({name:'write'})
        },
        showInfo(idx) {
            this.item = this.list[idx]
            this.selected = true
        },
        closeInfo(){
            this.item = null
            this.selected = false
        },
        deleteArticle(id){
            let articleId = id;
            this.$axios.delete('/api/boards/delete/'+articleId)
            .then(() => {
                window.location.reload();
            })
        },
        moveUpdatePage(id){
            this.$router.push({ path:'/board/update/', query : {id : id }})
        }
    },
}
</script>