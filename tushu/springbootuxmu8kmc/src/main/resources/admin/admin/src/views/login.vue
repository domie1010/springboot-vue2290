<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231119/4d40a5c1a21546ddb769bc21fd89af7a.jpg)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
      <el-form :style='{"border":"0px solid #f6f6f6","padding":"40px 40px 40px 580px","margin":"0 auto","alignItems":"flex-start","textAlign":"center","display":"flex","minHeight":"450px","borderRadius":"0","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20231119/f4513a2051d84f3eb0fcde72c88f4c84.png) no-repeat 80px 90% / 250px,url(http://codegen.caihongy.cn/20231119/2359b77423a443648e74713e5846b20e.png) no-repeat 20px 20px / auto 110px,url(http://codegen.caihongy.cn/20231119/a0ad204cb6af4417af99ee45b955f6b3.png) no-repeat 1% center / 480px 99%,#fff","width":"880px","fontSize":"14px","height":"auto"}'>
        <div v-if="true" :style='{"padding":"0px","margin":"0 0 20px","borderColor":"#ddd","color":"#333","textAlign":"left","display":"inline-block","background":"none","borderWidth":"0px","width":"86%","lineHeight":"30px","fontSize":"18px","borderStyle":"solid","fontWeight":"500"}' class="title-container">校园数字化图书馆系统登录</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 0 10px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"#333","left":"-100px","textAlign":"right","width":"100px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>用户名：</div>
          <input :style='{"border":"1px solid #eee","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .3)","outline":"0px solid #eee","color":"#ccc","outlineOffset":"0px","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit","height":"40px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 0 10px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"#333","left":"-100px","textAlign":"right","width":"100px","lineHeight":"44px","fontSize":"inherit","position":"absolute"}'>密码：</div>
          <input :style='{"border":"1px solid #eee","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .3)","outline":"0px solid #eee","color":"#ccc","outlineOffset":"0px","borderRadius":"4px","background":"none","width":"100%","fontSize":"inherit","height":"40px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>

		<div class="list-item select" :style='{"width":"100%","margin":"0 0 10px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}' v-if="roles.length>1">
		  <el-select v-model="rulesForm.role" placeholder="请选择角色">
		    <el-option v-for="item in roles" :key="item.roleName" :label="item.roleName" :value="item.roleName" />
		  </el-select>
		</div>

		
        <div :style='{"margin":"20px 0 0","alignItems":"center","flexWrap":"wrap","background":"none","flexDirection":"column","display":"flex","width":"600px","fontSize":"16px","position":"relative","justifyContent":"flex-start"}'>
          <el-button v-if="loginType==1" :style='{"border":"0px solid #4FA1D9","cursor":"pointer","padding":"0 20px","margin":"0 0 0px","color":"#fff","textAlign":"center","letterSpacing":"4px","borderRadius":"4px","background":"#333","width":"auto","fontSize":"16px","height":"40px","order":"10"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>

import menu from "@/utils/menu";
export default {
  data() {
    return {
		verifyCheck2: false,
		flag: false,
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
      },
      menus: [],
      roles: [],
      tableName: "",
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {

  },
  destroyed() {
	    },
  components: {
  },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
        this.$storage.set("pageFlag", "register");
		this.$router.push({path:'/register'})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}
		
		this.loginPost()
    },
	loginPost() {
		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/" });
			} else {
				this.$message.error(data.msg);
			}
		});
	},
  }
}
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20231119/4d40a5c1a21546ddb769bc21fd89af7a.jpg);
        
  .list-item /deep/ .el-input .el-input__inner {
		border: 1px solid #eee;
		border-radius: 4px;
		padding: 0 10px;
		box-shadow: 0 0 0px rgba(64, 158, 255, .3);
		outline: 0px solid #eee;
		color: #ccc;
		background: none;
		width: 100%;
		font-size: inherit;
		outline-offset: 0px;
		height: 40px;
	  }
  
  .list-item.select /deep/ .el-select .el-input__inner {
		border: 1px solid #eee;
		border-radius: 4px;
		padding: 0 10px;
		margin: 0;
		color: #ccc;
		background: none;
		width: 100%;
		font-size: 14px;
		min-width: 260px;
		height: 40px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border: 1px solid #eee;
  	  	border-radius: 4px 0 0 4px;
  	  	padding: 0 10px;
  	  	color: #ccc;
  	  	background: none;
  	  	width: calc(100% - 80px);
  	  	font-size: inherit;
  	  	height: 40px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: #999;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        background: #2b9afc;
        border-color: #2b9afc;
      }
  .list-type /deep/ .el-radio__label {
		color: #999;
		font-size: 14px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: #2b9afc;
        font-size: 14px;
      }
}

</style>
