<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","backgroundColor":"#ECF2EA","background":"url(http://codegen.caihongy.cn/20231023/595d22725fdb4421ab3806ffa9cde944.png),url(http://codegen.caihongy.cn/20231023/4169fe3a937a4c71a2f8462a8bc2c54c.png)","display":"flex","width":"100%","backgroundSize":"57vw 55vh,100%","backgroundPosition":"6vw calc(50vh - 150px),left top","position":"relative","backgroundRepeat":"no-repeat,no-repeat"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"minHeight":"55vh","padding":"50px 30px 0","borderRadius":"0px","top":"calc(50vh - 150px)","left":"65vw","background":"#fff","width":"30vw","position":"absolute"}' :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"margin":"0 0 30px 0","color":"#000000","textAlign":"center","width":"100%","lineHeight":"40px","fontSize":"30px","fontWeight":"700"}'>校园数字化图书馆系统登录</div>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 0 20px"}' prop="username">
				<div v-if="true" :style='{"width":"64px","flex-shrink":"0","lineHeight":"44px","fontSize":"14px","color":"#000000","textAlign":"right"}'>账号：</div>
				<input :style='{"border":"1px solid #C7C7C7","padding":"0 10px","color":"#000000","borderRadius":"10px","width":"100%","fontSize":"14px","lineHeight":"30px"}' v-model="loginForm.username" placeholder="请输入账户">
			</el-form-item>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"100%","margin":"0 0 20px"}' prop="password">
				<div v-if="true" :style='{"width":"64px","flex-shrink":"0","lineHeight":"44px","fontSize":"14px","color":"#000000","textAlign":"right"}'>密码：</div>
				<input :style='{"border":"1px solid #C7C7C7","padding":"0 10px","color":"#000000","borderRadius":"10px","width":"100%","fontSize":"14px","lineHeight":"30px"}' v-model="loginForm.password" placeholder="请输入密码" type="password">
			</el-form-item>

			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"100%","box-sizing":"border-box","padding":"0 64px"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>

			
			<el-form-item :style='{"width":"100%","padding":"0 0px"}'>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 0 0 64px","outline":"none","color":"#fff","borderRadius":"8px","background":"#00AA3A","width":"calc(100% - 64px)","fontSize":"16px","fontWeight":"600","height":"40px"}' @click="submitForm('loginForm')">登录</el-button>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 5px","color":"#000","display":"none","box-sizing":"border-box","outline":"1px solid #666","borderRadius":"4px","background":"#fff","width":"auto","fontSize":"14px","height":"40px"}' @click="resetForm('loginForm')">重置</el-button>
			</el-form-item>
			<div :style='{"width":"calc(100% - 64px)","margin":"20px 0 0 64px","flexWrap":"wrap","display":"flex"}'>
			<router-link :style='{"cursor":"pointer","margin":"0 10px 10px 0","fontSize":"14px","textDecoration":"none","color":"#000000","background":"#fff"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='是'" v-for="(item, index) in roles" :key="index">注册{{item.roleName.replace('注册','')}}</router-link>
			</div>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
</div>
</template>

<script>
import menu from '@/config/menu'
export default {
	//数据集合
	data() {
		return {
            baseUrl: this.$config.baseUrl,
            loginType: 1,
			roleMenus: [],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: '请输入账户', trigger: 'blur' }
				],
				password: [
					{ required: true, message: '请输入密码', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}],
			flag: false,
			verifyCheck2: false,
		}
	},
  components: {
  },
	created() {
		this.roleMenus = menu.list()
		for(let item in this.roleMenus) {
		    if(this.roleMenus[item].hasFrontLogin=='是') {
		        this.roles.push(this.roleMenus[item]);
		    }
		}
		
	},
	mounted() {
	},
    //方法集合
    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']
			
			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("请选择登录用户类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }

		this.loginPost(formName)
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
	  loginPost(formName) {
		this.$refs[formName].validate((valid) => {
		  if (valid) {
		    this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
		      if (res.data.code === 0) {
		        localStorage.setItem('Token', res.data.token);
		        localStorage.setItem('UserTableName', this.loginForm.tableName);
		        localStorage.setItem('username', this.loginForm.username);
		        localStorage.setItem('adminName', this.loginForm.username);
		        localStorage.setItem('sessionTable', this.loginForm.tableName);
		        localStorage.setItem('role', this.role);
		        localStorage.setItem('keyPath', 0);
		        this.$router.push('/');
		        this.$message({
		          message: '登录成功',
		          type: 'success',
		          duration: 1500,
		        });
		      } else {
		        this.$message.error(res.data.msg);
		      }
		    });
		  } else {
		    return false;
		  }
		});
	  },
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20231023/595d22725fdb4421ab3806ffa9cde944.png),url(http://codegen.caihongy.cn/20231023/4169fe3a937a4c71a2f8462a8bc2c54c.png);
		
		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}
		
		.list-item /deep/ .el-form-item__content {
			display: flex;
		}

		.list-code /deep/ .el-form-item__content {
			display: flex;
		}

		.list-type /deep/ .el-form-item__content {
			display: flex;
		}

		.list-btn /deep/ .el-form-item__content {
			display: flex;
			justify-content: center;
		}
		
		.list-item /deep/ .el-input .el-input__inner {
			border: 1px solid #C7C7C7;
			border-radius: 10px;
			padding: 0 10px;
			color: #000000;
			width: 100%;
			font-size: 14px;
			line-height: 30px;
		}
		
		.list-code /deep/ .el-input .el-input__inner {
			border: 1px solid #C7C7C7;
			border-radius: 10px 0 0 10px;
			padding: 0 10px;
			outline: none;
			color: #000000;
			flex: 1;
			display: inline-block;
			vertical-align: middle;
			width: calc(100% - 110px);
			font-size: 14px;
			height: 44px;
		}

		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #000000;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			background: #000000;
			border-color: #000000;
		}
		.list-type /deep/ .el-radio__label {
			color: #000000;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: #000000;
			font-size: 14px;
		}
	}

</style>
