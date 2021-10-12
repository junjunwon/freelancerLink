<template>
  <div>
    <div class="h-100 bg-plum-plate bg-animation">
      <div class="d-flex h-100 justify-content-center align-items-center">
        <b-col md="8" class="mx-auto app-login-box">
          <div class="app-logo-inverse mx-auto mb-3"/>

          <div class="modal-dialog w-100 mx-auto">
            <div class="modal-content">
              <div class="modal-body">
                <div class="h5 modal-title text-center">
                  <h4 class="mt-2">
                    <div>Welcome back,</div>
                    <span>Please sign in to your account below.</span>
                  </h4>
                  <br />
                </div>
                <b-form-group id="exampleInputGroup1"
                              label-for="exampleInput1">
                  <b-form-input id="exampleInput1"
                                type="text"
                                required
                                placeholder="Enter id..."
                                v-model="loginInfo.id">
                  </b-form-input>
                  <br />
                </b-form-group>
                <b-form-group id="exampleInputGroup2"
                              label-for="exampleInput2">
                  <b-form-input id="exampleInput2"
                                type="password"
                                required
                                placeholder="Enter password..."
                                v-model="loginInfo.password">
                  </b-form-input>
                  <br />
                </b-form-group>
                <b-form-checkbox name="check" id="exampleCheck">
                  Keep me logged in
                </b-form-checkbox>
                <div class="divider"/>
                <h6 class="mb-0">
                  No account?
                  <a href="javascript:void(0);" class="text-primary">Sign up now</a>
                </h6>
              </div>
              <div class="modal-footer clearfix">
                <div class="float-left">
                  <a href="javascript:void(0);" class="btn-lg btn btn-link">Recover
                    Password</a>
                </div>
                <div class="float-right">
                  <b-button variant="primary" size="lg" @click="login">Login to Dashboard</b-button>
                </div>
              </div>
            </div>
          </div>
        </b-col>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  data(){
    return {
      loginInfo : [
        {
          id : ''
        },
        {
          password : ''
        }
      ]
    }
  },
  methods : {
    login(){
        this.$axios.get('/api/login')
          .then((response)=>{
            alert("login success"+response.data)
            // this.$router.push("/api/login")
            this.$router.push("/board/list")
          })
          .catch((ex)=>{
            console.error("failed login", ex)
          })

    }
  }
}
</script>