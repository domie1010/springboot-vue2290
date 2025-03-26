<template>
	<div class="addEdit-block" :style='{"padding":"30px","fontSize":"14px","color":"#666","background":"none"}'>
		<el-form
			:style='{"border":"0px solid #e3e3e3","padding":"30px 30px 20px","borderRadius":"8px","alignItems":"flex-start","flexWrap":"wrap","background":"rgba(255,255,255,1)","display":"flex","fontSize":"inherit"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
		>
			<template >
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="书名" prop="bookname">
					<el-input  v-model="ruleForm.bookname" placeholder="书名" clearable  :readonly="ro.bookname"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="书名" prop="bookname">
					<el-input v-model="ruleForm.bookname" placeholder="书名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="文献类型" prop="booktype">
					<el-input  v-model="ruleForm.booktype" placeholder="文献类型" clearable  :readonly="ro.booktype"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="文献类型" prop="booktype">
					<el-input v-model="ruleForm.booktype" placeholder="文献类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' class="select" v-if="type!='info'"  label="书籍类型" prop="shujileixing">
					<el-select :disabled="ro.shujileixing" v-model="ruleForm.shujileixing" placeholder="请选择书籍类型" >
						<el-option
							v-for="(item,index) in shujileixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="书籍类型" prop="shujileixing">
					<el-input v-model="ruleForm.shujileixing"
						placeholder="书籍类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="著者" prop="author">
					<el-input  v-model="ruleForm.author" placeholder="著者" clearable  :readonly="ro.author"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="著者" prop="author">
					<el-input v-model="ruleForm.author" placeholder="著者" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="出版年份" prop="chubanyear">
					<el-input  v-model="ruleForm.chubanyear" placeholder="出版年份" clearable  :readonly="ro.chubanyear"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="出版年份" prop="chubanyear">
					<el-input v-model="ruleForm.chubanyear" placeholder="出版年份" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="出版社" prop="chubanshe">
					<el-input  v-model="ruleForm.chubanshe" placeholder="出版社" clearable  :readonly="ro.chubanshe"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="出版社" prop="chubanshe">
					<el-input v-model="ruleForm.chubanshe" placeholder="出版社" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="数源数据库" prop="sourceku">
					<el-input  v-model="ruleForm.sourceku" placeholder="数源数据库" clearable  :readonly="ro.sourceku"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="数源数据库" prop="sourceku">
					<el-input v-model="ruleForm.sourceku" placeholder="数源数据库" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' class="upload" v-if="type!='info' && !ro.cover" label="封面" prop="cover">
					<file-upload
						tip="点击上传封面"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.cover?ruleForm.cover:''"
						@change="coverUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' class="upload" v-else-if="ruleForm.cover" label="封面" prop="cover">
					<img v-if="ruleForm.cover.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.cover.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.cover.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="数量" prop="shuliang">
					<el-input  v-model.number="ruleForm.shuliang" placeholder="数量" clearable  :readonly="ro.shuliang"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' v-else class="input" label="数量" prop="shuliang">
					<el-input v-model="ruleForm.shuliang" placeholder="数量" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' class="textarea" v-if="type!='info'" label="来源" prop="laiyuan">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="来源"
					  v-model="ruleForm.laiyuan" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' v-else-if="ruleForm.laiyuan" label="来源" prop="laiyuan">
					<span :style='{"fontSize":"14px","lineHeight":"40px","minWidth":"900px","color":"inherit","fontWeight":"500","display":"inline-block"}'>{{ruleForm.laiyuan}}</span>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' v-if="type!='info'"  label="详细信息" prop="info">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.info" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"20px 0","margin":"0 0 2px 0","color":"inherit","borderRadius":"0px","background":"none","width":"100%","fontSize":"inherit"}' v-else-if="ruleForm.info" label="详细信息" prop="info">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","minWidth":"900px","color":"inherit","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.info"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"10px 0 20px","margin":"30px 0","alignItems":"center","textAlign":"center","background":"none","display":"flex","width":"calc(100% - 150px)","perspective":"320px","-webkitPerspective":"320px","fontSize":"48px","justifyContent":"center"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao16" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"inline-block"}'></span>
					确定
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao09" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"inline-block"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui01" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"inline-block"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				bookname : false,
				booktype : false,
				shujileixing : false,
				author : false,
				chubanyear : false,
				chubanshe : false,
				sourceku : false,
				cover : false,
				laiyuan : false,
				info : false,
				shuliang : false,
				clicktime : false,
				clicknum : false,
				discussnum : false,
				storeupnum : false,
			},
			
			
			ruleForm: {
				bookname: '',
				booktype: '',
				shujileixing: '',
				author: '',
				chubanyear: '',
				chubanshe: '',
				sourceku: '',
				cover: '',
				laiyuan: '',
				info: '',
				shuliang: '',
				clicktime: '',
			},
		
			shujileixingOptions: [],

			
			rules: {
				bookname: [
				],
				booktype: [
				],
				shujileixing: [
				],
				author: [
				],
				chubanyear: [
				],
				chubanshe: [
				],
				sourceku: [
				],
				cover: [
				],
				laiyuan: [
				],
				info: [
				],
				shuliang: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				clicktime: [
				],
				clicknum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				discussnum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				storeupnum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='bookname'){
							this.ruleForm.bookname = obj[o];
							this.ro.bookname = true;
							continue;
						}
						if(o=='booktype'){
							this.ruleForm.booktype = obj[o];
							this.ro.booktype = true;
							continue;
						}
						if(o=='shujileixing'){
							this.ruleForm.shujileixing = obj[o];
							this.ro.shujileixing = true;
							continue;
						}
						if(o=='author'){
							this.ruleForm.author = obj[o];
							this.ro.author = true;
							continue;
						}
						if(o=='chubanyear'){
							this.ruleForm.chubanyear = obj[o];
							this.ro.chubanyear = true;
							continue;
						}
						if(o=='chubanshe'){
							this.ruleForm.chubanshe = obj[o];
							this.ro.chubanshe = true;
							continue;
						}
						if(o=='sourceku'){
							this.ruleForm.sourceku = obj[o];
							this.ro.sourceku = true;
							continue;
						}
						if(o=='cover'){
							this.ruleForm.cover = obj[o];
							this.ro.cover = true;
							continue;
						}
						if(o=='laiyuan'){
							this.ruleForm.laiyuan = obj[o];
							this.ro.laiyuan = true;
							continue;
						}
						if(o=='info'){
							this.ruleForm.info = obj[o];
							this.ro.info = true;
							continue;
						}
						if(o=='shuliang'){
							this.ruleForm.shuliang = obj[o];
							this.ro.shuliang = true;
							continue;
						}
						if(o=='clicktime'){
							this.ruleForm.clicktime = obj[o];
							this.ro.clicktime = true;
							continue;
						}
						if(o=='clicknum'){
							this.ruleForm.clicknum = obj[o];
							this.ro.clicknum = true;
							continue;
						}
						if(o=='discussnum'){
							this.ruleForm.discussnum = obj[o];
							this.ro.discussnum = true;
							continue;
						}
						if(o=='storeupnum'){
							this.ruleForm.storeupnum = obj[o];
							this.ro.storeupnum = true;
							continue;
						}
				}
				















			}
			
			
			
            this.$http({
				url: `option/shujileixing/shujileixing`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.shujileixingOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `jingjishu/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.info = this.ruleForm.info.replace(reg,'../../../springbootuxmu8kmc/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
















	if(this.ruleForm.cover!=null) {
		this.ruleForm.cover = this.ruleForm.cover.replace(new RegExp(this.$base.url,"g"),"");
	}















var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "jingjishu/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `jingjishu/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.jingjishuCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `jingjishu/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.jingjishuCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.jingjishuCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    coverUploadChange(fileUrls) {
	    this.ruleForm.cover = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #333;
	  	  font-weight: 500;
	  	  display: inline-block;
	  	  width: 150px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  padding: 0 12px;
	  	  color: inherit;
	  	  font-size: 14px;
	  	  border-color: #e3e3e3;
	  	  border-radius: 3px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  background: none;
	  	  width: auto;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 400px;
	  	  height: 44px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border-radius: 3px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  color: inherit;
	  	  background: none;
	  	  width: auto;
	  	  font-size: 14px;
	  	  border-color: #e3e3e3;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 250px;
	  	  height: 44px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border-radius: 3px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  color: inherit;
	  	  background: none;
	  	  width: auto;
	  	  font-size: 14px;
	  	  border-color: #e3e3e3;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 250px;
	  	  height: 44px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  cursor: pointer;
	  	  color: #bbb;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #e3e3e3;
	  	  line-height: 100px;
	  	  border-radius: 3px;
	  	  background: none;
	  	  width: auto;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  min-width: 200px;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  cursor: pointer;
	  	  color: #bbb;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #e3e3e3;
	  	  line-height: 100px;
	  	  border-radius: 3px;
	  	  background: none;
	  	  width: auto;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  min-width: 200px;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  cursor: pointer;
	  	  color: #bbb;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #e3e3e3;
	  	  line-height: 100px;
	  	  border-radius: 3px;
	  	  background: none;
	  	  width: auto;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  min-width: 200px;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  padding: 12px;
	  	  color: inherit;
	  	  font-size: 14px;
	  	  border-color: #e3e3e3;
	  	  min-height: 250px;
	  	  border-radius: 3px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  background: none;
	  	  width: auto;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 900px;
	  	  height: auto;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 1px solid #f09a2b;
				cursor: pointer;
				padding: 0 10px 0 6px;
				margin: 0px 10px;
				color: #fff;
				display: inline-block;
				font-size: 14px;
				line-height: 24px;
				transition: all 0.3s;
				border-radius: 3px;
				box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2);
				text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.4);
				background: linear-gradient(to bottom, #FE962B 0%,#FEAE46 100%);
				width: auto;
				height: 44px;
			}
	
	.add-update-preview .btn .btn1:hover {
				transform: scale(1.09) rotate(3deg);
			}
	
	.add-update-preview .btn .btn2 {
				border: 1px solid #719e37;
				cursor: pointer;
				padding: 0 10px 0 6px;
				margin: 0px 10px;
				color: #fff;
				font-size: 14px;
				line-height: 24px;
				transition: all 0.3s;
				border-radius: 3px;
				box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2);
				text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.2);
				background: linear-gradient(to bottom, #9bc747 0%,#82bd42 100%);
				width: auto;
				height: 44px;
			}
	
	.add-update-preview .btn .btn2:hover {
				transform: scale(1.09) rotate(3deg);
			}
	
	.add-update-preview .btn .btn3 {
				border: 1px solid #0f70ad;
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 10px;
				color: #fff;
				font-size: 14px;
				line-height: 24px;
				transition: all 0.3s;
				border-radius: 3px;
				box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2);
				text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.2);
				background: linear-gradient(to bottom, #208ed3 0%,#0272bd 100%);
				width: auto;
				min-width: 78px;
				height: 44px;
			}
	
	.add-update-preview .btn .btn3:hover {
				transform: scale(1.09) rotate(3deg);
			}
	
	.add-update-preview .btn .btn4 {
				border: 1px solid #af2b1b;
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 10px;
				color: #fff;
				font-size: 14px;
				line-height: 24px;
				transition: all 0.3s;
				border-radius: 3px;
				box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2);
				text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.4);
				background: linear-gradient(to bottom, #bc3423 0%,#cd4433 100%);
				width: auto;
				min-width: 78px;
				height: 44px;
			}
	
	.add-update-preview .btn .btn4:hover {
				transform: scale(1.09) rotate(3deg);
			}
	
	.add-update-preview .btn .btn5 {
				border: 1px solid #323537;
				cursor: pointer;
				padding: 0 20px;
				margin: 0 10px;
				color: #fff;
				font-size: 14px;
				line-height: 24px;
				transition: all 0.3s;
				border-radius: 3px;
				box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2);
				text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.4);
				background: linear-gradient(to bottom, #4b4f51 0%,#414547 100%);
				width: auto;
				min-width: 78px;
				height: 44px;
			}
	
	.add-update-preview .btn .btn5:hover {
				transform: scale(1.09) rotate(3deg);
			}
</style>
