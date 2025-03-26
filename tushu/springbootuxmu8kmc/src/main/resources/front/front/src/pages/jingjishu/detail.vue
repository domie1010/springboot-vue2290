<template>
<div>
	<div :style='{"width":"100%","padding":"16px calc(50% - 600px)","background":"#ecf2ea"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'/'" :style='{"fontSize":"14px","lineHeight":"1"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index" to="/index/jingjishu"><a>{{item.name}}</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item3"><a href="javascript:void(0);">详情</a></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div :style='{"width":"100%","padding":"16px calc(50% - 600px)","background":"#ecf2ea"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
	<div class="detail-preview" :style='{"width":"100%","padding":"0 10% 30px","margin":"30px auto","position":"relative","flexWrap":"wrap","display":"flex"}'>
		<div class="attr" :style='{"width":"calc(100% - 500px)","margin":"0 0 0 30px","position":"relative","background":"#fff","display":"flex","order":"2"}'>

			<div class="info" :style='{"width":"100%"}'>
				<div class="item" :style='{"margin":"0 0 10px 0","alignItems":"center","justifyContent":"space-between","display":"flex"}'>
					<div :style='{"color":"#000000","fontSize":"18px","fontWeight":"700"}'>
                    {{detail.bookname}}
                    </div>
					<div @click="storeup(1)" v-show="!isStoreup" :style='{"border":"1px solid #00AA3A","cursor":"pointer","padding":"0","align-items":"center","display":"flex"}'><i v-if="true" :style='{"padding":"10px","fontSize":"20px","color":"#fff","background":"#00aa3a"}' class="el-icon-star-off"></i><span :style='{"color":"#00AA3A","padding":"10px","fontSize":"14px"}'>点我收藏({{detail.storeupnum}})</span></div>
					<div @click="storeup(-1)" v-show="isStoreup" :style='{"border":"1px solid #00AA3A","cursor":"pointer","padding":"0","align-items":"center","display":"flex"}'><i v-if="true" :style='{"padding":"10px","fontSize":"20px","color":"#fff","background":"#00aa3a"}' class="el-icon-star-on"></i><span :style='{"color":"#00AA3A","padding":"10px","fontSize":"14px"}'>取消收藏({{detail.storeupnum}})</span></div>
				</div>

				<div class="item" :style='{"padding":"0 0 4px","margin":"0 0 5px 0","borderColor":"#f6f6f6","flexWrap":"wrap","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid"}'>
					<div class="lable" :style='{"margin":"0 5px 0 0","color":"#000000","textAlign":"left","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>文献类型</div>
					<div  :style='{"padding":"0px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#333","flex":"1","height":"auto"}'>{{detail.booktype}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0 4px","margin":"0 0 5px 0","borderColor":"#f6f6f6","flexWrap":"wrap","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid"}'>
					<div class="lable" :style='{"margin":"0 5px 0 0","color":"#000000","textAlign":"left","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>书籍类型</div>
					<div  :style='{"padding":"0px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#333","flex":"1","height":"auto"}'>{{detail.shujileixing}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0 4px","margin":"0 0 5px 0","borderColor":"#f6f6f6","flexWrap":"wrap","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid"}'>
					<div class="lable" :style='{"margin":"0 5px 0 0","color":"#000000","textAlign":"left","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>著者</div>
					<div  :style='{"padding":"0px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#333","flex":"1","height":"auto"}'>{{detail.author}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0 4px","margin":"0 0 5px 0","borderColor":"#f6f6f6","flexWrap":"wrap","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid"}'>
					<div class="lable" :style='{"margin":"0 5px 0 0","color":"#000000","textAlign":"left","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>出版年份</div>
					<div  :style='{"padding":"0px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#333","flex":"1","height":"auto"}'>{{detail.chubanyear}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0 4px","margin":"0 0 5px 0","borderColor":"#f6f6f6","flexWrap":"wrap","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid"}'>
					<div class="lable" :style='{"margin":"0 5px 0 0","color":"#000000","textAlign":"left","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>出版社</div>
					<div  :style='{"padding":"0px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#333","flex":"1","height":"auto"}'>{{detail.chubanshe}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0 4px","margin":"0 0 5px 0","borderColor":"#f6f6f6","flexWrap":"wrap","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid"}'>
					<div class="lable" :style='{"margin":"0 5px 0 0","color":"#000000","textAlign":"left","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>数源数据库</div>
					<div  :style='{"padding":"0px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#333","flex":"1","height":"auto"}'>{{detail.sourceku}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0 4px","margin":"0 0 5px 0","borderColor":"#f6f6f6","flexWrap":"wrap","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid"}'>
					<div class="lable" :style='{"margin":"0 5px 0 0","color":"#000000","textAlign":"left","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>来源</div>
					<div  :style='{"padding":"0px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#333","flex":"1","height":"auto"}'>{{detail.laiyuan}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0 4px","margin":"0 0 5px 0","borderColor":"#f6f6f6","flexWrap":"wrap","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid"}'>
					<div class="lable" :style='{"margin":"0 5px 0 0","color":"#000000","textAlign":"left","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>数量</div>
					<div  :style='{"padding":"0px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#333","flex":"1","height":"auto"}'>{{detail.shuliang}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0 4px","margin":"0 0 5px 0","borderColor":"#f6f6f6","flexWrap":"wrap","borderWidth":"0 0 1px","display":"flex","borderStyle":"solid"}'>
					<div class="lable" :style='{"margin":"0 5px 0 0","color":"#000000","textAlign":"left","width":"auto","fontSize":"14px","lineHeight":"24px","height":"auto"}'>点击次数</div>
					<div  :style='{"padding":"0px 10px 0","fontSize":"14px","lineHeight":"24px","color":"#333","flex":"1","height":"auto"}'>{{detail.clicknum}}</div>
				</div>
				<div class="btn" :style='{"row-gap":"20px","width":"470px","padding":"10px 0","flexWrap":"wrap","display":"block"}'>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 10px 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#598969","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="btnAuth('jingjishu','修改')" @click="editClick">修改</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 10px 0","color":"#fff","borderRadius":"4px","background":"#00AA3A","display":"inline-block","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="btnAuth('jingjishu','删除')" @click="delClick">删除</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 10px 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#0F672D","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="btnAuth('jingjishu','图书借阅')" @click="onAcross('tushujieyue','','','')" type="warning">图书借阅</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0 5px 10px 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#0F672D","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="btnAuth('jingjishu','书籍入库')" @click="onAcross('shujiruku','','','')" type="warning">书籍入库</el-button>
					<!-- hasPay 否 -->
				</div>
			</div>
		</div>
		
			<div v-if="detailBanner.length" :style='{"border":"1","width":"470px","padding":"0","height":"auto"}'>
			  <div class="swiper21" :style='{"width":"100%","height":"auto"}'>
			    <div class="swiper-container mySwiper21">
			      <div class="swiper-wrapper">
			        <div class="swiper-slide" v-for="item in detailBanner" :key="item.id">
			          <div :style='{"width":"100%","height":"auto"}'>
			            <img :style='{"objectFit":"cover","width":"100%","height":"400px"}' v-if="item.substr(0,4)=='http'" :src="item" class="image">
			            <img :style='{"objectFit":"cover","width":"100%","height":"400px"}' v-else :src="baseUrl + item" class="image">
			          </div>
			        </div>
			      </div>
			      <div class="swiper-button-prev" :style='{"width":"24px","margin":"-12px 0 0","top":"50%","height":"24px"}'>
			        <span class="icon iconfont icon-jiantou39" :style='{"width":"24px","fontSize":"24px","color":"#fff","height":"24px"}'></span>
			      </div>
			      <div class="swiper-button-next" :style='{"width":"24px","margin":"-12px 0 0","top":"50%","height":"24px"}'>
			        <span class="icon iconfont icon-jiantou18" :style='{"width":"24px","fontSize":"24px","color":"#fff","height":"24px"}'></span>
			      </div>
			    </div>
			  </div>
			  <div class="swiper22" :style='{"width":"100%","margin":"18px 0 0","height":"auto"}'>
			    <div class="swiper-container mySwiper22">
			      <div class="swiper-wrapper">
			        <div class="swiper-slide" v-for="item in detailBanner" :key="item.id">
			          <div>
						<img :style='{"objectFit":"cover","width":"100%","height":"100px"}' v-if="item.substr(0,4)=='http'" :src="item" class="image">
						<img :style='{"objectFit":"cover","width":"100%","height":"100px"}' v-else :src="baseUrl + item" class="image">
			          </div>
			        </div>
			      </div>
			      <div class="swiper-button-prev" :style='{"width":"14px","margin":"-7px 0 0","top":"50%","height":"14px"}'>
			        <span class="icon iconfont icon-jiantou39" :style='{"width":"14px","fontSize":"14px","color":"#fff","height":"14px"}'></span>
			      </div>
			      <div class="swiper-button-next" :style='{"width":"14px","margin":"-7px 0 0","top":"50%","height":"14px"}'>
			        <span class="icon iconfont icon-jiantou18" :style='{"width":"14px","fontSize":"14px","color":"#fff","height":"14px"}'></span>
			      </div>
			    </div>
			  </div>
			</div>


		

		
		<el-tabs class="detail" :style='{"border":"0px solid #DCDFE6","width":"100%","boxShadow":"0 0px 0px 0 rgba(0, 0, 0, .1)","margin":"20px 0 0","background":"#fff","order":"6"}' v-model="activeName" type="border-card">
																		<el-tab-pane label="详细信息" name="first">
				<div v-html="detail.info"></div>
			</el-tab-pane>
														<el-tab-pane label="评论" name="second">
				<el-form class="add comment" :style='{"padding":"0","margin":"20px 0"}' :model="form" :rules="rules" ref="form">
					<el-form-item class="item" :style='{"width":"100%","display":"flex","height":"auto"}' label="评论" prop="content">
						<editor
						    :style='{"minHeight":"200px","border":"0","color":"#333","borderRadius":"4px","width":"100%","lineHeight":"32px","fontSize":"14px"}'
						    v-model="form.content" 
						    class="editor" 
						    action="file/upload">
						</editor>
					</el-form-item>
					<el-form-item class="btn" :style='{"width":"100%","margin":"10px 0px 0 60px","height":"auto"}'>
						<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#0F672D","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="submitForm('form')">立即提交</el-button>
						<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#000000","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="resetForm('form')">重置</el-button>
					</el-form-item>
				</el-form>
				
				<div v-if="infoList.length" :style='{"border":"1px solid #333","padding":"20px"}' class="comment">
					<div :style='{"padding":"8px 0","margin":"0 0 0px","borderColor":"#999","alignItems":"center","borderWidth":"0 0 0px 0","width":"100%","borderStyle":"solid","height":"auto"}' v-for="item in infoList" :key="item.id" @mouseenter="discussEnter(item.id)"
						@mouseleave="discussLeave">
						<div class="user" :style='{"width":"100%","alignItems":"center","display":"flex","height":"auto"}'>
							<el-image v-if="item.avatarurl" :style='{"width":"40px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"40px"}' :size="50" :src="baseUrl + item.avatarurl"></el-image>
							<el-image v-if="!item.avatarurl" :style='{"width":"40px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"40px"}' :size="50" :src="require('@/assets/touxiang.png')"></el-image>
							<div :style='{"color":"#333","fontSize":"16px"}' class="name">{{item.nickname}}</div>
						</div>
						<div :style='{"padding":"8px","margin":"10px 0px 0px","color":"#333","borderRadius":"4px","background":"#ECF2EA","wordWrap":"break-word","lineHeight":"30px","fontSize":"14px"}' class="content-block-ask">
							<div v-html="item.content"></div>
							<div class="btn" :style='{"width":"100%","margin":"8px 0 0 0","alignItems":"center","justifyContent":"flex-end","display":"flex","height":"40px"}'>
							  <!-- <el-button :style='{"cursor":"pointer","padding":"0","margin":"0 10px","outline":"none","color":"#FFFFFF","borderRadius":"4px","background":"#0F672D","width":"60px","lineHeight":"26px","fontSize":"14px"}'>回复</el-button> -->
							  <el-button v-if="showIndex==item.id&&userid==item.userid" @click="discussDel(item.id)" :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 10px","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#000000","width":"60px","lineHeight":"26px","fontSize":"14px"}'>删除</el-button>
							</div>
						</div>
						<div :style='{"padding":"8px","margin":"10px 0px 0px","color":"#333","borderRadius":"4px","background":"#ECF2EA","wordWrap":"break-word","lineHeight":"30px","fontSize":"14px"}' class="content-block-reply" v-if="item.reply">
							回复：<span v-html="item.reply"></span>
						</div>
					</div>
				</div>
				
				<el-pagination
				  background
				  id="pagination" class="pagination"
				  :pager-count="7"
				  :page-size="pageSize"
				  :page-sizes="pageSizes"
				  prev-text="上一页"
				  next-text="下一页"
				  :hide-on-single-page="false"
				  :layout='["prev","pager","next"].join()'
				  :total="total"
				  :style='{"border":"2px solid #00aa3a","padding":"0 10px","margin":"10px auto","whiteSpace":"nowrap","color":"#000","borderRadius":"4px","textAlign":"center","width":"50%","lineHeight":"32px","fontWeight":"500","height":"32px","order":"50"}'
				  @current-change="curChange"
				  @prev-click="prevClick"
				  @next-click="nextClick"
				></el-pagination>
			</el-tab-pane>
		</el-tabs>
	</div>
	<div class="share_view" :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","bottom":"20%","background":"#fff","display":"none","position":"fixed","right":"0","zIndex":"11"}'>
	</div>
</div>
</template>

<script>
  import CountDown from '@/components/CountDown';
  import axios from 'axios'
  import Swiper from "swiper";
  
  export default {
    //数据集合
    data() {
      return {
        tablename: 'jingjishu',
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '图书馆书籍'
          }
        ],
        title: '',
        detailBanner: [],
		id: 0,
        detail: {},
        activeName: 'first',
		userid: localStorage.getItem('userid'),
        form: {
          content: '',
          userid: localStorage.getItem('userid'),
          nickname: localStorage.getItem('username'),
          avatarurl: '',
        },
		showIndex: -1,
        infoList: [],
        rules: {
          content: [
            { required: true, message: '请输入内容', trigger: 'blur' }
          ],
        },
        total: 1,
        pageSize: 5,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        storeupParams: {
          name: '',
          picture: '',
          refid: 0,
          tablename: 'jingjishu',
          userid: localStorage.getItem('userid')
        },
        isStoreup: false,
        storeupInfo: {},
        buynumber: 1,
		centerType: false,
		shareUrl: location.href,
      }
    },
    created() {
		if(this.$route.query.centerType) {
			this.centerType = true
		}
		this.id = this.$route.query.id
        this.init();
    },
	mounted() {
		setTimeout(()=>{
			let mySwiper22 = new Swiper(".mySwiper22", {"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"freeMode":true,"watchSlidesVisibility":true,"watchSlidesProgress":true,"loopedSlides":5,"slidesPerView":4,"spaceBetween":10})
			let option21 = {...{"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"loopedSlides":5,"spaceBetween":10}}
			option21.thumbs = {
				swiper: mySwiper22
			}
			new Swiper(".mySwiper21", option21)
		},100)
	},
    //方法集合
    methods: {
        init() {
          this.baseUrl = this.$config.baseUrl;
          this.$http.get(this.tablename + '/detail/'  + this.id, {}).then(res => {
            if (res.data.code == 0) {
              this.detail = res.data.data;
              this.title = this.detail.bookname;
              this.detailBanner = this.detail.cover ? this.detail.cover.split(",") : [];
              this.$forceUpdate();

			  this.getDiscussList(1);
			  this.getStoreupStatus();

            }
          });
        },
      onAcross(acrossTable,crossOptAudit,statusColumnName,tips,statusColumnValue){
        localStorage.setItem('crossTable',`jingjishu`);
        localStorage.setItem('crossObj', JSON.stringify(this.detail));
        localStorage.setItem('statusColumnName',statusColumnName);
        localStorage.setItem('statusColumnValue',statusColumnValue);
        localStorage.setItem('tips',tips);
        if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
            var obj = JSON.parse(localStorage.getItem('crossObj'));
            for (var o in obj){
                if(o==statusColumnName && obj[o]==statusColumnValue){
                    this.$message({
                        type: 'success',
                        message: tips,
                        duration: 1500
                    });
                    return
                }
            }
        }
        this.$router.push({path: '/index/' + acrossTable + 'Add', query: {type: 'cross'}});
      },
      storeup(type) {
        if (type == 1 && !this.isStoreup) {
          this.storeupParams.name = this.title;
          this.storeupParams.picture = this.detailBanner[0];
          this.storeupParams.refid = this.detail.id;
          this.storeupParams.type = type;
          this.$http.post('storeup/add', this.storeupParams).then(res => {
            if (res.data.code == 0) {
              this.isStoreup = true;
			  this.detail.storeupnum++
			  this.$http.post('jingjishu/update', this.detail).then(res => {});
              this.$message({
                type: 'success',
                message: '收藏成功!',
                duration: 1500,
              });
            }
          });
        }
        if (type == -1 && this.isStoreup) {
          this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'jingjishu', userid: localStorage.getItem('userid')}}).then(res => {
            if (res.data.code == 0 && res.data.data.list.length > 0) {
              this.isStoreup = true;
              this.storeupInfo = res.data.data.list[0];
              let delIds = new Array();
              delIds.push(this.storeupInfo.id);
              this.$http.post('storeup/delete', delIds).then(res => {
                if (res.data.code == 0) {
                  this.isStoreup = false;
				  this.detail.storeupnum--
				  this.$http.post('jingjishu/update', this.detail).then(res => {});
                  this.$message({
                    type: 'success',
                    message: '取消成功!',
                    duration: 1500,
                  });
                }
              });
            }
          });
        }
      },
      getStoreupStatus(){
        if(localStorage.getItem("Token")) {
            this.$http.get('storeup/list', {params: {page: 1, limit: 1, type: 1, refid: this.detail.id, tablename: 'jingjishu', userid: localStorage.getItem('userid')}}).then(res => {
              if (res.data.code == 0 && res.data.data.list.length > 0) {
                this.isStoreup = true;
                this.storeupInfo = res.data.data.list[0];
              }
            });
        }
      },
      curChange(page) {
        this.getDiscussList(page);
      },
      prevClick(page) {
        this.getDiscussList(page);
      },
      nextClick(page) {
        this.getDiscussList(page);
      },
		// 返回按钮
		backClick(){
			history.back()
		},
		// 下载
		download(file){
			if(!file) {
				this.$message({
				  type: 'error',
				  message: '文件不存在',
				  duration: 1500,
				});
				return;
			}
		  let arr = file.replace(new RegExp('upload/', "g"), "")
		  axios.get(this.baseUrl + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: localStorage.getItem("Token")
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  },err=>{
			  axios.get((location.href.split(this.$config.name).length>1 ? location.href.split(this.$config.name)[0] :'') + this.$config.name + '/file/download?fileName=' + arr, {
			  	headers: {
			  		token: localStorage.getItem("Token")
			  	},
			  	responseType: "blob"
			  }).then(({
			  	data
			  }) => {
			  	const binaryData = [];
			  	binaryData.push(data);
			  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
			  		type: 'application/pdf;chartset=UTF-8'
			  	}))
			  	const a = document.createElement('a')
			  	a.href = objectUrl
			  	a.download = arr
			  	// a.click()
			  	// 下面这个写法兼容火狐
			  	a.dispatchEvent(new MouseEvent('click', {
			  		bubbles: true,
			  		cancelable: true,
			  		view: window
			  	}))
			  	window.URL.revokeObjectURL(data)
			  })
		  })
      },
      getDiscussList(page) {
        this.$http.get('discussjingjishu/list', {params: {page, limit: this.pageSize, refid: this.detail.id}}).then(res => {
          if (res.data.code == 0) {
            this.infoList = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = res.data.data.pageSize;this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
            this.totalPage = res.data.data.totalPage;
          }
        });
      },
	  discussEnter(index){
		  this.showIndex = index
	  },
	  discussLeave(){
		  this.showIndex = -1
	  },
	  discussDel(id){
		  this.$confirm('是否删除此评论？')
		    .then(_ => {
		      this.$http.post('discussjingjishu/delete',[id]).then(res=>{
				  if(res.data&&res.data.code==0){
					  this.addDiscussNum(1)
					  this.$message({
					    type: 'success',
					    message: '删除成功!',
					    duration: 1500,
						onClose: () => {
							this.getDiscussList(1);
						}
					  });
				  }
			  })
		    }).catch(_ => {});
	  },
      submitForm(formName) {
        let sensitiveWords = "";
        let sensitiveWordsArr = [];
        if(sensitiveWords) {
            sensitiveWordsArr = sensitiveWords.split(",");
        }
        for(var i=0; i<sensitiveWordsArr.length; i++){
            //全局替换
            var reg = new RegExp(sensitiveWordsArr[i],"g");
            //判断内容中是否包括敏感词
            if (this.form.content.indexOf(sensitiveWordsArr[i]) > -1) {
                // 将敏感词替换为 **
                this.form.content = this.form.content.replace(reg,"**");
            }
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.form.refid = this.detail.id;
            this.form.avatarurl = localStorage.getItem('headportrait')?localStorage.getItem('headportrait'):'';
            this.$http.post('discussjingjishu/add', this.form).then(res => {
              if (res.data.code == 0) {
                this.form.content = '';
				this.addDiscussNum(2)
                this.getDiscussList(1);
                this.$message({
                  type: 'success',
                  message: '评论成功!',
                  duration: 1500,
                });
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
	  addDiscussNum(type){
		  if(type==2){
			  this.detail.discussnum++
		  }else if(type==1){
			  if(this.detail.discussnum!=0){
				  this.detail.discussnum--
			  }else{
				  this.detail.discussnum = 0
			  }
		  }
		  this.$http.post('jingjishu/update',this.detail).then(res=>{
			  
		  })
	  },


		// 权限判断
		btnAuth(tableName,key){
			if(this.centerType){
				return this.isBackAuth(tableName,key)
			}else{
				return this.isAuth(tableName,key)
			}
		},
		// 修改
		editClick(){
			this.$router.push(`/index/jingjishuAdd?type=edit&&id=${this.detail.id}`);
		},
		// 删除
		delClick(){
			this.$confirm('是否删除此图书馆书籍？')
			  .then(_ => {
			    this.$http.post('jingjishu/delete', [this.detail.id]).then(res => {
			      if (res.data.code == 0) {
			        this.$message({
			          type: 'success',
			          message: '删除成功!',
			          duration: 1500,
					  onClose: () => {
						  history.back()
					  }
			        });
			      }
			    });
			  }).catch(_ => {});
		},
    },
    components: {
      CountDown
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.editor /deep/ .avatar-uploader {
		height: 0;
		line-height: 0;
	}
	
	.detail-preview {
	
	  .attr {
	    .el-carousel /deep/ .el-carousel__indicator button {
	      width: 0;
	      height: 0;
	      display: none;
	    }
	
	    .el-input-number__decrease:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled) {
	      border-color: none;
	    }
	  }
	
	  .detail {
	    & /deep/ .el-tabs__header .el-tabs__nav-wrap {
	      margin-bottom: 0;
	    }
	
	    & .add .el-textarea {
	      width: auto;
	    }
	  }
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: red;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: red;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		border-radius: 4px 0 0 4px;
		top: 1px;
		left: 1px;
		background: #f5f5f5;
		width: 40px;
		justify-content: center;
		border-width: 0 1px 0 0;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 38px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease i {
		color: #666;
		font-size: 14px;
	}

	.attr .el-input-number /deep/ .el-input-number__increase {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		right: 1px;
		border-radius: 0 4px 4px 0;
		top: 1px;
		background: #f5f5f5;
		width: 40px;
		justify-content: center;
		border-width: 0 0 0 1px;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 38px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__increase i {
		color: #666;
		font-size: 14px;
	}
	
	.attr .el-input-number /deep/ .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		border-radius: 4px;
		padding: 0 40px;
		outline: none;
		color: #666;
		background: #FFF;
		display: inline-block;
		width: 100%;
		font-size: 14px;
		line-height: 40px;
		text-align: center;
		height: 40px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
		padding: 0 10px;
		margin: 0;
		background: #fff;
		border-color: #707270;
		border-width: 0 0 1px 0;
		border-style: solid;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
		padding: 0 30px;
		margin: 0 10px;
		color: #333;
		font-weight: 500;
		display: inline-block;
		font-size: 14px;
		border-color: #fff;
		line-height: 32px;
		background: transparent;
		border-width: 1px 1px 0 1px;
		position: relative;
		border-style: solid;
		list-style: none;
		height: 32px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
		color: #343434;
		background: #FFF;
		border-color: #707270;
		border-width: 1px 1px 0 1px;
		border-style: solid;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
		color: #343434;
		background: #FFF;
		border-color: #707270;
		border-width: 1px 1px 0 1px;
		border-style: solid;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
		padding: 15px;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		width: 60px;
		font-size: 14px;
		line-height: 40px;
		text-align: right;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 9px;
		color: #00AA3A;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb .item1 /deep/ .el-breadcrumb__inner a {
		color: #00AA3A;
		display: inline-block;
	}
	
	.breadcrumb-preview .el-breadcrumb .item2 /deep/ .el-breadcrumb__inner a {
		color: #00AA3A;
		display: inline-block;
	}
		
	.breadcrumb-preview .el-breadcrumb .item3 /deep/ .el-breadcrumb__inner a {
		color: #999;
		display: inline-block;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 40px;
		height: 40px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 0px;
		padding: 0 10px;
		margin: 0 5px;
		color: #666;
		background: none;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 0px;
		padding: 0 10px;
		margin: 0 5px;
		color: #666;
		background: none;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px;
		margin: 0 5px;
		color: #C0C4CC;
		background: none;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px;
		margin: 0 5px;
		color: #C0C4CC;
		background: none;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 0px;
		background: none;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 0px;
		background: #00AA3A;
		text-align: center;
		min-width: 30px;
		height: 28px;
}

#pagination.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 0px;
		background: #00AA3A;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}

	#pagination.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	.share_view{
		position: fixed;
		right:0;
		bottom: 20%;
		background: #fff;
		box-shadow: 0 4px 6px rgba(0,0,0,.1);
		.share{
			width: 40px;
			height: 40px;
			display: flex;
			align-items: center;
			justify-content: center;
			border-bottom: 1px solid #eee;
			cursor: pointer;
		}
		.share:last-of-type{
			border:none;
		}
	}

	.swiper21 .swiper-button-prev:after {
		display:none;
	}
	.swiper21 .swiper-button-next:after {
        display:none;
	}
	.swiper22 .swiper-button-prev:after {
        display:none;
	}
	.swiper22 .swiper-button-next:after {
        display:none;
	}
	
	.swiper22 .swiper-slide div {
				width: 100%;
				opacity: 0.4;
				height: auto;
			}
	.swiper22 .swiper-slide.swiper-slide-thumb-active div {
				opacity: 1;
			}

	.detail-preview .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	
	.detail-preview .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				display: block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}
</style>
