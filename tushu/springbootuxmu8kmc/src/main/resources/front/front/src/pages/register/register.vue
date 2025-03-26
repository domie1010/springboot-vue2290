<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","width":"100%","background":"url(\"http://codegen.caihongy.cn/20231023/595d22725fdb4421ab3806ffa9cde944.png\") 6vw calc(50vh - 150px) / 57vw 55vh fixed no-repeat, url(\"http://codegen.caihongy.cn/20231023/4169fe3a937a4c71a2f8462a8bc2c54c.png\") left top / 100% fixed no-repeat","display":"flex"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"minHeight":"55vh","border":"1px solid #edeef0","padding":"50px 30px 0","margin":"calc(50vh - 150px) 0 10vh 65vw","borderRadius":"0px","background":"#fff","width":"30vw","minWidth":"400px"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"margin":"0 0 30px 0","color":"#000000","textAlign":"center","width":"100%","lineHeight":"40px","fontSize":"30px","fontWeight":"700"}'>校园数字化图书馆系统注册</p></div>
			<el-form-item :style='{"width":"100%","margin":"0 0 20px"}' v-if="tableName=='yonghu'" prop="zhanghao">
				<div v-if="true" :style='{"width":"80px","flex-shrink":"0","lineHeight":"44px","fontSize":"14px","color":"#000000"}' :class="changeRules('zhanghao')?'required':''">账号：</div>
				<el-input v-model="registerForm.zhanghao"  placeholder="请输入账号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","margin":"0 0 20px"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="true" :style='{"width":"80px","flex-shrink":"0","lineHeight":"44px","fontSize":"14px","color":"#000000"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","margin":"0 0 20px"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="true" :style='{"width":"80px","flex-shrink":"0","lineHeight":"44px","fontSize":"14px","color":"#000000"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","margin":"0 0 20px"}' v-if="tableName=='yonghu'" prop="xingming">
				<div v-if="true" :style='{"width":"80px","flex-shrink":"0","lineHeight":"44px","fontSize":"14px","color":"#000000"}' :class="changeRules('xingming')?'required':''">姓名：</div>
				<el-input v-model="registerForm.xingming"  placeholder="请输入姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","margin":"0 0 20px"}' v-if="tableName=='yonghu'" prop="xingbie">
				<div v-if="true" :style='{"width":"80px","flex-shrink":"0","lineHeight":"44px","fontSize":"14px","color":"#000000"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in yonghuxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","margin":"0 0 20px"}' v-if="tableName=='yonghu'" prop="shouji">
				<div v-if="true" :style='{"width":"80px","flex-shrink":"0","lineHeight":"44px","fontSize":"14px","color":"#000000"}' :class="changeRules('shouji')?'required':''">手机：</div>
				<el-input v-model="registerForm.shouji"  placeholder="请输入手机" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","margin":"0 0 20px"}' v-if="tableName=='yonghu'" prop="shenfen">
				<div v-if="true" :style='{"width":"80px","flex-shrink":"0","lineHeight":"44px","fontSize":"14px","color":"#000000"}' :class="changeRules('shenfen')?'required':''">身份：</div>
                <el-select v-model="registerForm.shenfen" placeholder="请选择身份" >
                  <el-option
                      v-for="(item,index) in yonghushenfenOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","margin":"0 0 20px"}' v-if="tableName=='yonghu'" prop="touxiang">
				<div v-if="true" :style='{"width":"80px","flex-shrink":"0","lineHeight":"44px","fontSize":"14px","color":"#000000"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="yonghutouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px auto 5px","outline":"none","color":"#fff","borderRadius":"8px","background":"#00AA3A","display":"block","width":"80%","fontSize":"16px","height":"44px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"1px solid","cursor":"pointer","padding":"0 10px","margin":"20px auto 5px","outline":"none","color":"#000","borderRadius":"8px","background":"#fff","display":"block","width":"80%","fontSize":"16px","height":"44px"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"20px 10%","color":"rgba(159, 159, 159, 1)","display":"flex","lineHeight":"1","fontSize":"12px","textDecoration":"none","justifyContent":"center"}' to="/login">已有账户登录</router-link>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
            yonghushenfenOptions: [],
		}
    },
	mounted() {
		this.tableName = this.$route.query.role;
		if(this.tableName=='yonghu'){
			this.registerForm = {
                zhanghao: '',
                mima: '',
                xingming: '',
                xingbie: '',
                shouji: '',
                shenfen: '',
                touxiang: '',
			}
		}
		if ('yonghu' == this.tableName) {
			this.requiredRules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }]
		}
		if ('yonghu' == this.tableName) {
			this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
		}
		if ('yonghu' == this.tableName) {
			this.requiredRules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }]
		}
		if ('yonghu' == this.tableName) {
			this.requiredRules.shenfen = [{ required: true, message: '请输入身份', trigger: 'blur' }]
		}
	},
    created() {
      this.pageFlag = this.$route.query.pageFlag;
      if ('yonghu' == this.tableName) {
        this.rules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
        this.yonghuxingbieOptions = "男,女".split(',');
      if ('yonghu' == this.tableName) {
        this.rules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }];
      }
      if ('yonghu' == this.tableName) {
        this.rules.shouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
        this.yonghushenfenOptions = "学生,教师".split(',');
      if ('yonghu' == this.tableName) {
        this.rules.shenfen = [{ required: true, message: '请输入身份', trigger: 'blur' }];
      }
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      yonghutouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
				if((!this.registerForm.zhanghao) && `yonghu` == this.tableName){
					this.$message.error(`账号不能为空`);
					return
				}
               if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `yonghu` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.xingbie) && `yonghu` == this.tableName){
					this.$message.error(`性别不能为空`);
					return
				}
					if(`yonghu` == this.tableName && this.registerForm.shouji &&(!this.$validate.isMobile2(this.registerForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
				if((!this.registerForm.shenfen) && `yonghu` == this.tableName){
					this.$message.error(`身份不能为空`);
					return
				}
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
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
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url("http://codegen.caihongy.cn/20231023/595d22725fdb4421ab3806ffa9cde944.png") 6vw calc(50vh - 150px) / 57vw 55vh fixed no-repeat, url("http://codegen.caihongy.cn/20231023/4169fe3a937a4c71a2f8462a8bc2c54c.png") left top / 100% fixed no-repeat;
		
		.el-input {
		  width: auto;
		}
		
		.el-date-editor.el-input {
			width: auto;
		}
		
		.el-form-item /deep/ .el-form-item__content {
						display: flex;
					}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1px solid #C7C7C7;
						border-radius: 10px;
						padding: 0 10px;
						color: #000000;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1px solid #C7C7C7;
						border-radius: 8px;
						padding: 0 10px;
						color: #000000;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #C7C7C7;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						color: #000000;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #C7C7C7;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						color: #000000;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px dashed #C7C7C7;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #C7C7C7;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px dashed #C7C7C7;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #C7C7C7;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px dashed #C7C7C7;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #C7C7C7;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 60px;
		  		  text-align: center;
		  		  height: 60px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: -10px;
				position: absolute;
				content: "*";
			}
</style>
