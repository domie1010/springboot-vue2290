<template>
<div :style='{"width":"100%","padding":"20px 10%","margin":"30px auto","position":"relative"}'>
    <el-form
	  :style='{"border":"1px solid #333","width":"100%","padding":"40px","margin":"0 0 40px","position":"relative"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="auto"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="借阅号" prop="jieyuehao">
              <el-input v-model="ruleForm.jieyuehao" placeholder="借阅号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="书名" prop="bookname">
            <el-input  v-model="ruleForm.bookname" 
                placeholder="书名" clearable :readonly=" false  ||ro.bookname"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="书籍类型" prop="shujileixing">
            <el-input  v-model="ruleForm.shujileixing" 
                placeholder="书籍类型" clearable :readonly=" false  ||ro.shujileixing"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="出版社" prop="chubanshe">
            <el-input  v-model="ruleForm.chubanshe" 
                placeholder="出版社" clearable :readonly=" false  ||ro.chubanshe"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="出版年份" prop="chubanyear">
            <el-input  v-model="ruleForm.chubanyear" 
                placeholder="出版年份" clearable :readonly=" false  ||ro.chubanyear"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="数量" prop="shuliang">
            <el-input  v-model.number="ruleForm.shuliang" 
                placeholder="数量" clearable :readonly=" false  ||ro.shuliang"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="封面" v-if="type!='cross' || (type=='cross' && !ro.cover)" prop="cover">
            <file-upload
            tip="点击上传封面"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.cover?ruleForm.cover:''"
            @change="coverUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' class="upload" v-else label="封面" prop="cover">
                <img v-if="ruleForm.cover.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.cover.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.cover.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="账号" prop="zhanghao">
            <el-input  v-model="ruleForm.zhanghao" 
                placeholder="账号" clearable :readonly=" false  ||ro.zhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="姓名" prop="xingming">
            <el-input  v-model="ruleForm.xingming" 
                placeholder="姓名" clearable :readonly=" false  ||ro.xingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="手机" prop="shouji">
            <el-input  v-model="ruleForm.shouji" 
                placeholder="手机" clearable :readonly=" false  ||ro.shouji"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="身份" prop="shenfen">
            <el-input  v-model="ruleForm.shenfen" 
                placeholder="身份" clearable :readonly=" false  ||ro.shenfen"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="头像" v-if="type!='cross' || (type=='cross' && !ro.touxiang)" prop="touxiang">
                    <el-image v-if="ruleForm.touxiang" :src="ruleForm.touxiang?baseUrl + ruleForm.touxiang:''" style="width:150px;height:150px;"></el-image>
                    <el-button @click="imgAddClick">人脸识别</el-button>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' class="upload" v-else label="头像" prop="touxiang">
                <img v-if="ruleForm.touxiang.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.touxiang.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.touxiang.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}' label="借阅时间" prop="jieyueshijian">
              <el-date-picker
				  :disabled=" false  ||ro.jieyueshijian"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.jieyueshijian" 
                  type="datetime"
                  placeholder="借阅时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","float":"left","display":"inline-block"}'  label="状态" prop="zhuangtai">
            <el-select v-model="ruleForm.zhuangtai" placeholder="请选择状态"  >
              <el-option
                  v-for="(item,index) in zhuangtaiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>

      <el-form-item :style='{"width":"100%","clear":"both","padding":"0 10px","margin":"0"}'>
        <el-button v-if="!faceMatchFlag" :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#00AA3A","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onSubmit">人脸校验</el-button>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#00AA3A","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="faceMatchFlag" type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid #00AA3A","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#9e9e9e","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    <imgAdd ref="imgAdd" @imgChange="imgChange"></imgAdd>
</div>
</template>

<script>
import imgAdd from "@/components/img";
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            jieyuehao : false,
            bookname : false,
            shujileixing : false,
            chubanshe : false,
            chubanyear : false,
            shuliang : false,
            cover : false,
            zhanghao : false,
            xingming : false,
            shouji : false,
            shenfen : false,
            touxiang : false,
            jieyueshijian : false,
            zhuangtai : false,
        },
        type: '',
        userface : '',
        faceMatchFlag: false,
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          jieyuehao: this.getUUID(),
          bookname: '',
          shujileixing: '',
          chubanshe: '',
          chubanyear: '',
          shuliang: '',
          cover: '',
          zhanghao: '',
          xingming: '',
          shouji: '',
          shenfen: '',
          touxiang: '',
          jieyueshijian: '',
          zhuangtai: '待归还',
        },
        zhuangtaiOptions: [],


        rules: {
          jieyuehao: [
          ],
          bookname: [
            { required: true, message: '书名不能为空', trigger: 'blur' },
          ],
          shujileixing: [
            { required: true, message: '书籍类型不能为空', trigger: 'blur' },
          ],
          chubanshe: [
          ],
          chubanyear: [
          ],
          shuliang: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          cover: [
          ],
          zhanghao: [
          ],
          xingming: [
          ],
          shouji: [
          ],
          shenfen: [
          ],
          touxiang: [
          ],
          jieyueshijian: [
          ],
          zhuangtai: [
            { required: true, message: '状态不能为空', trigger: 'blur' },
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
        imgAdd
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.jieyueshijian = this.getCurDateTime()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
        imgAddClick(){
            this.$refs.imgAdd.onTake()
        },
        imgChange(e){
            this.ruleForm.touxiang = 'upload/' + e
        },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='jieyuehao'){
              this.ruleForm.jieyuehao = obj[o];
              this.ro.jieyuehao = true;
              continue;
            }
            if(o=='bookname'){
              this.ruleForm.bookname = obj[o];
              this.ro.bookname = true;
              continue;
            }
            if(o=='shujileixing'){
              this.ruleForm.shujileixing = obj[o];
              this.ro.shujileixing = true;
              continue;
            }
            if(o=='chubanshe'){
              this.ruleForm.chubanshe = obj[o];
              this.ro.chubanshe = true;
              continue;
            }
            if(o=='chubanyear'){
              this.ruleForm.chubanyear = obj[o];
              this.ro.chubanyear = true;
              continue;
            }
            if(o=='shuliang'){
              this.ruleForm.shuliang = obj[o];
              this.ro.shuliang = true;
              continue;
            }
            if(o=='cover'){
              this.ruleForm.cover = obj[o].split(",")[0];
              this.ro.cover = true;
              continue;
            }
            if(o=='zhanghao'){
              this.ruleForm.zhanghao = obj[o];
              this.ro.zhanghao = true;
              continue;
            }
            if(o=='xingming'){
              this.ruleForm.xingming = obj[o];
              this.ro.xingming = true;
              continue;
            }
            if(o=='shouji'){
              this.ruleForm.shouji = obj[o];
              this.ro.shouji = true;
              continue;
            }
            if(o=='shenfen'){
              this.ruleForm.shenfen = obj[o];
              this.ro.shenfen = true;
              continue;
            }
            if(o=='touxiang'){
              this.ruleForm.touxiang = obj[o].split(",")[0];
              this.ro.touxiang = true;
              continue;
            }
            if(o=='jieyueshijian'){
              this.ruleForm.jieyueshijian = obj[o];
              this.ro.jieyueshijian = true;
              continue;
            }
            if(o=='zhuangtai'){
              this.ruleForm.zhuangtai = obj[o];
              this.ro.zhuangtai = true;
              continue;
            }
          }
          this.ruleForm.shuliang = 0
		  this.ro.shuliang = false;
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            this.userface = res.data.data.touxiang;
            if((json.zhanghao!=''&&json.zhanghao) || json.zhanghao==0){
                this.ruleForm.zhanghao = json.zhanghao
            }
            if((json.xingming!=''&&json.xingming) || json.xingming==0){
                this.ruleForm.xingming = json.xingming
            }
            if((json.shouji!=''&&json.shouji) || json.shouji==0){
                this.ruleForm.shouji = json.shouji
            }
            if((json.shenfen!=''&&json.shenfen) || json.shenfen==0){
                this.ruleForm.shenfen = json.shenfen
            }
          }
        });
        this.zhuangtaiOptions = "已归还,待归还".split(',')
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`tushujieyue/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
            if(!this.faceMatchFlag) {
                //人脸校验
                if(!this.ruleForm.touxiang) {
                    this.$message({
                      message: "请上传人脸图片",
                      type: 'error',
                      duration: 1500
                    });
                    return;
                }
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$config.baseUrl,"g"),"");
            }
            let params = {
                face1:this.userface.replace("upload/",""),
                face2:this.ruleForm.touxiang.replace("upload/",""),
            }
            this.$http.get('matchFace', {params: params}).then(res => {
              if (res.data && res.data.code == 0) {
                    if(res.data.score>60) {
                        this.faceMatchFlag = true;
                        this.$message({
                          message: "匹配成功",
                          type: "success",
                          duration: 1500,
                        });
                    } else {
                        this.faceMatchFlag = false;
                        this.$message.error("匹配失败");
                        return;
                    }
                } else {
                  this.faceMatchFlag = false;
                  this.$message.error("匹配失败");
                  return;
              }
            });
            return;
        }

		  if(this.ruleForm.jieyuehao){
			  this.ruleForm.jieyuehao = String(this.ruleForm.jieyuehao)
		  }
		if(!this.ruleForm.shuliang){
			this.$message.error("数量不能为空");
			return
		}
        var obj = JSON.parse(localStorage.getItem('crossObj'));
        var table = localStorage.getItem('crossTable');
        obj.shuliang = obj.shuliang - this.ruleForm.shuliang
        if(obj.shuliang<0){
          this.$message.error("数量不足");
          return
        }
      
        //this.$http.post(table+`/update`, obj).then(res => {});
        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('tushujieyue/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算
                          var obj = JSON.parse(localStorage.getItem('crossObj'));
                          var table = localStorage.getItem('crossTable');

                          obj.shuliang = parseFloat(obj.shuliang) - parseFloat(this.ruleForm.shuliang)

                          this.$http.post(table+`/update`,obj).then(res => {});
                          this.$http.post(`tushujieyue/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {
                  var obj = JSON.parse(localStorage.getItem('crossObj'));
                  var table = localStorage.getItem('crossTable');

                  obj.shuliang = parseFloat(obj.shuliang) - parseFloat(this.ruleForm.shuliang)

                  this.$http.post(table+`/update`,obj).then(res => {});
                  this.$http.post(`tushujieyue/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
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
        this.$router.go(-1);
      },
      coverUploadChange(fileUrls) {
          this.ruleForm.cover = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
      touxiangUploadChange(fileUrls) {
          this.ruleForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: auto;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: left;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: auto;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #333;
	  border-radius: 0px;
	  padding: 0 12px;
	  color: #000;
	  width: auto;
	  font-size: 14px;
	  min-width: 400px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #333;
	  border-radius: 0px;
	  padding: 0 10px;
	  color: #000;
	  width: auto;
	  font-size: 14px;
	  min-width: 400px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #333;
	  border-radius: 0px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #000000;
	  width: auto;
	  font-size: 14px;
	  min-width: 350px;
	  height: 40px;
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
	  border: 1px solid #333;
	  cursor: pointer;
	  border-radius: 0px;
	  color: #000000;
	  width: auto;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  min-width: 400px;
	  height: 120px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #333;
	  cursor: pointer;
	  border-radius: 0px;
	  color: #000000;
	  width: auto;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  min-width: 400px;
	  height: 120px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #333;
	  cursor: pointer;
	  border-radius: 0px;
	  color: #000000;
	  width: auto;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  min-width: 400px;
	  height: 120px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #333;
	  border-radius: 0px;
	  padding: 12px;
	  outline: none;
	  color: #000;
	  width: auto;
	  font-size: 14px;
	  min-width: 780px;
	  height: 120px;
	}
</style>
