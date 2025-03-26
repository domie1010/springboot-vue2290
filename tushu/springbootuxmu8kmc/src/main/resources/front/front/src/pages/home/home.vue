<template>
<div class="home-preview" :style='{"width":"100%","margin":"0 auto","flexDirection":"column","background":"#f6f6f6","display":"flex"}'>




		
	<!-- 新闻资讯 -->
	<div id="animate_newsnews" class="news animate__animated" :style='{"padding":"50px 10%","backgroundColor":"#ecf2ea","margin":"0 auto","backgroundImage":"url(http://codegen.caihongy.cn/20231108/e4529fafd82e408eb35be5812d8f06e4.jpg)","width":"100%","backgroundSize":"100% 470px","position":"relative","backgroundRepeat":"no-repeat","order":"2"}'>
		<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
			<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		</div>
		
		<div class="title" :style='{"margin":"0 0 42px","textAlign":"left","background":"url(http://codegen.caihongy.cn/20231108/790b0679cc8e4697ae015e18030d9c73.png) no-repeat left center","width":"auto","fontSize":"#000000","minWidth":"252px","height":"128px"}'>
			<span :style='{"fontSize":"43px","lineHeight":"180px","color":"#fff","fontWeight":"600"}'>公告信息</span>
		</div>
		
			
			
			
			
			
			
			
			
			
			
		




		<div class="list list15 index-pv1" :style='{"width":"100%","height":"auto"}'>
			<div class="tab" :style='{"border-top":"2px solid #fff","padding":"25px 0","top":"50px","display":"flex","width":"calc(80% - 390px)","justify-content":"space-between","position":"absolute","right":"10%","justifyContent":"space-between","border-bottom":"2px solid rgb(255, 255, 255)","height":"auto"}'>
				<div class="item" :class="newsIndex15 == 0 ? 'active' : ''" @click="newsIndexClick15(0)">
					<div :style='{"color":"inherit","fontSize":"24px"}'>全部</div>
				</div>
				<template v-for="(item,index) in newsCategoryList15">
				<div v-if="index < 3" class="item" :class="newsIndex15 == index + 1 ? 'active' : ''" @click="newsIndexClick15(index+1)">
					<!-- <img :style='{"width":"60px","margin":"0 10px 0 0","objectFit":"cover","display":"block","height":"60px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg"> -->
					<div :style='{"color":"inherit","fontSize":"24px"}'>{{item.typename}}</div>
				</div>
				</template>
				<div class="more" @click="moreBtn('news')">
				  <div :style='{"color":"inherit","fontSize":"24px"}'>查看更多</div>
				  <span class="icon iconfont icon-qita7" :style='{"border":"2px solid #fff","padding":"0 10px","margin":"0 10px 0 2px","color":"inherit","borderRadius":"4px","left":"0","fontSize":"26px","position":"absolute"}'></span>
				</div>
			</div>
		  <div v-if="newsList.length" class="content" :style='{"width":"100%","justifyContent":"space-between","display":"flex","height":"auto"}'>
		    <div @click="toDetail('newsDetail', newsList[0])" class="left list-item animation-box" :style='{"cursor":"pointer","padding":"0 0 40px","background":"#fff","display":"flex","width":"390px","position":"relative","flex-wrap":"wrap","height":"auto"}'>
		      <img :style='{"width":"100%","objectFit":"cover","display":"block","height":"250px"}' :src="baseUrl + newsList[0].picture">
		      <div :style='{"padding":"14px 20px 0","margin":"0 0 20px 0","overflow":"hidden","whiteSpace":"nowrap","color":"#00AA3A","width":"100%","lineHeight":"26px","fontSize":"18px","textOverflow":"ellipsis","fontWeight":"700"}' class="name">{{newsList[0].title}}</div>
		      <div :style='{"padding":"0 20px","margin":"0 0 14px","whiteSpace":"nowrap","overflow":"hidden","color":"#666","width":"100%","lineHeight":"20px","fontSize":"14px","textOverflow":"ellipsis"}' class="desc">{{newsList[0].introduction}}</div>
		      <div :style='{"left":"20px","bottom":"14px","position":"absolute"}'>
		        <span class="icon iconfont " :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
		        <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{newsList[0].addtime}}</span>
		      </div>
		      <div :style='{"width":"40","padding":"0 10px","order":"4"}'>
		        <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
		        <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{newsList[0].name}}</span>
		      </div>
		      <div :style='{"width":"20%","padding":"0 0 0 20px"}'>
		        <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
		        <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{newsList[0].thumbsupnum}}</span>
		      </div>
		      <div :style='{"width":"20%","padding":"0 10px"}'>
		        <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
		        <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{newsList[0].storeupnum}}</span>
		      </div>
		      <div :style='{"width":"20%","padding":"0 10px"}'>
		        <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
		        <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{newsList[0].clicknum}}</span>
		      </div>
		    </div>
		    <div v-if="newsList.length > 1" class="right" :style='{"row-gap":"16px","width":"calc(100% - 420px)","flexWrap":"wrap","justifyContent":"space-between","display":"flex","height":"auto"}'>
			  <template v-for="(item,index) in newsList">
		      <div v-if="index > 0" @click="toDetail('newsDetail', item)" class="list-item animation-box">
		        <div class="date">
		          <div class="day">{{item.addtime.split(" ")[0].split("-")[2]}}</div>
		          <div class="year">{{item.addtime.split(" ")[0].split("-")[0] + '-' + item.addtime.split(" ")[0].split("-")[1]}}</div>
		        </div>
		        <div :style='{"width":"0","flex":"1","flex-wrap":"wrap","display":"flex"}' class="info">
		          <div class="name">{{item.title}}</div>
		          <div class="desc">{{item.introduction}}</div>
		          <div class="publisher" :style='{"width":"40%","padding":"0 10px","display":"inline-block","order":"4"}'>
		            <span class="icon iconfont icon-geren16"></span>
		            <span class="text">{{item.name}}</span>
		          </div>
		          <div class="like" :style='{"padding":"0 10px","display":"inline-block"}'>
		            <span class="icon iconfont icon-zan10"></span>
		            <span class="text">{{item.thumbsupnum}}</span>
		          </div>
		          <div class="collect" :style='{"padding":"0 10px","display":"inline-block"}'>
		            <span class="icon iconfont icon-shoucang10"></span>
		            <span class="text">{{item.storeupnum}}</span>
		          </div>
		          <div class="view" :style='{"padding":"0 10px","display":"inline-block"}'>
		            <span class="icon iconfont icon-chakan9"></span>
		            <span class="text">{{item.clicknum}}</span>
		          </div>
		        </div>
		      </div>
			  </template>
		    </div>
		  </div>
		</div>







		<div @click="moreBtn('news')" :style='{"border":"1px solid #000","cursor":"pointer","margin":"30px auto 0","textAlign":"center","display":"block","width":"100%","lineHeight":"54px"}'>
			<span :style='{"color":"#000","fontSize":"18px","fontWeight":"700"}'>查看更多</span>
			<i :style='{}' class="icon iconfont "></i>
		</div>
		
		</div>
	<!-- 新闻资讯 -->


<!-- 商品推荐 -->
<div id="animate_recommendjingjishu" class="recommend animate__animated" :style='{"width":"80%","padding":"40px 0","margin":"0 auto","position":"relative","order":"1"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"margin":"10px auto 20px","color":"#000000","textAlign":"left","background":"url(http://codegen.caihongy.cn/20231108/785b92a18bec459faffc7c29ddd93c9d.png) no-repeat left center","width":"auto","minWidth":"252px","height":"128px"}'>
		<span :style='{"fontSize":"43px","lineHeight":"180px","color":"#000000","fontWeight":"600"}'>图书馆书籍推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	



	<div v-if="jingjishuRecommend.length" class="list list12 index-pv1 list12jingjishu" :style='{"width":"100%","padding":"10px","background":"none","height":"auto"}'>
	  <div class="tab" :style='{"padding":"20px 0","margin":"0 0 20px","borderColor":"#000","borderWidth":"2px 0","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"space-between","height":"auto"}'>
	    <template v-for="item,index in recommendList12jingjishu">
		<div v-if="index < 4" @click="recommendIndexClick12(index + 1, 'jingjishu')" class="item" :class="index + 1 == recommendIndex12jingjishu ? 'active' : ''">
			<img v-if="item.image" :style='{"width":"44px","margin":"0 5px 0 0","objectFit":"cover","display":"block","height":"44px"}' :src="baseUrl + (item.image?item.image.split(',')[0]:'')">
			<div :style='{"color":"inherit","fontSize":"18px"}'>{{item[recommendColumn12jingjishu]}}</div>
		</div>
		</template>
		<div class="more" @click="moreBtn('jingjishu')">
		  <div :style='{"fontSize":"18px","color":"inherit","fontWeight":"600","order":"2"}'>查看更多</div>
		  <span class="icon iconfont icon-qita7" :style='{"border":"2px solid #000","padding":"0 10px","margin":"0 10px 0 2px","fontSize":"26px","color":"inherit","borderRadius":"4px"}'></span>
		</div>
	  </div>
	  <div class="list" :style='{"margin":"40px 0 0","overflow":"hidden","flexWrap":"wrap","background":"none","display":"flex","justifyContent":"space-between","height":"auto"}'>
	    <div :style='{"cursor":"pointer","width":"49%","margin":"0 0 30px","position":"relative","height":"auto"}' class="item list-item animation-box" v-for="item,index in jingjishuRecommend" :key="index" @click="toDetail('jingjishuDetail', item)">
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","display":"block","height":"288px"}' v-if="preHttp(item.cover)" :src="item.cover.split(',')[0]" alt="" />
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","display":"block","height":"288px"}' v-else :src="baseUrl + (item.cover?item.cover.split(',')[0]:'')" alt="" />
			<div class="line1" :style='{"padding":"0 10px","color":"#333","textAlign":"center","background":"#fff","width":"100%","lineHeight":"60px","fontSize":"16px"}'>{{item.bookname}}</div>
			<div class="line1" :style='{"padding":"0 10px","color":"#333","textAlign":"center","background":"#fff","width":"100%","lineHeight":"60px","fontSize":"16px"}'>{{item.chubanyear}}</div>
			<div class="line1" :style='{"padding":"0 10px","color":"#333","textAlign":"center","background":"#fff","width":"100%","lineHeight":"60px","fontSize":"16px"}'>{{item.chubanshe}}</div>
	    </div>
	  </div>
	</div>




	
	<div @click="moreBtn('jingjishu')" :style='{"border":"2px solid #000000","cursor":"pointer","padding":"16px 60px","whiteSpace":"nowrap","top":"90px","textAlign":"center","background":"#fff","display":"block","lineHeight":"1em","position":"absolute","right":"0"}'>
		<span :style='{"color":"#000000","fontSize":"16px","fontWeight":"600"}'>查看更多</span>
		<i :style='{}' class="icon iconfont "></i>
	</div>
	
</div>
<!-- 商品推荐 -->


<!-- 特价商品 -->
<div id="animate_listjingjishu" class="lists animate__animated" :style='{"width":"100%","padding":"40px 10%","margin":"0 auto","position":"relative","background":"#fff","order":"3"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"margin":"0 0 40px","minWidth":"252px","background":"url(http://codegen.caihongy.cn/20231108/785b92a18bec459faffc7c29ddd93c9d.png) no-repeat left center","height":"128px"}'>
	  <span :style='{"fontSize":"43px","lineHeight":"180px","color":"#000000","fontWeight":"600"}'>图书馆书籍展示</span>
	</div>
	
	
	
	
	
	
	
	
	
	




	<div v-if="jingjishuList.length" class="list list13 index-pv1" :style='{"width":"100%","background":"none","height":"auto"}'>
	  <div :style='{"width":"100%","padding":"12px 0px","justifyContent":"center","display":"flex","height":"auto"}' class="top">
		<template v-for="item,index in jingjishuList">
		<template v-if="index < 5">
		<img @click="toDetail('jingjishuDetail', item)" :name="item.id" :style='{"cursor":"pointer","width":"18%","margin":"0 1%","objectFit":"cover","display":"block","height":"200px"}' v-if="preHttp(item.cover)" :src="item.cover.split(',')[0]" alt="" />
		<img @click="toDetail('jingjishuDetail', item)" :name="item.id" :style='{"cursor":"pointer","width":"18%","margin":"0 1%","objectFit":"cover","display":"block","height":"200px"}' v-else :src="baseUrl + (item.cover?item.cover.split(',')[0]:'')" alt="" />
		</template>
		</template>
	  </div>
	  <div v-if="jingjishuList.length > 5" :style='{"width":"100%","padding":"12px 0px","justifyContent":"center","display":"flex","height":"auto"}' class="center">
		<template v-for="item,index in jingjishuList">
		<template v-if="index > 4 && index < 8">
		<img @click="toDetail('jingjishuDetail', item)" :name="item.id" :style='{"cursor":"pointer","width":"18%","margin":"0 1%","objectFit":"cover","display":"block","height":"200px"}' v-if="preHttp(item.cover)" :src="item.cover.split(',')[0]" alt="" />
		<img @click="toDetail('jingjishuDetail', item)" :name="item.id" :style='{"cursor":"pointer","width":"18%","margin":"0 1%","objectFit":"cover","display":"block","height":"200px"}' v-else :src="baseUrl + (item.cover?item.cover.split(',')[0]:'')" alt="" />
		</template>
		</template>
	  </div>
	  <div v-if="jingjishuList.length > 8" :style='{"width":"100%","padding":"12px 0px","justifyContent":"center","display":"flex","height":"auto"}' class="bottom">
		<template v-for="item,index in jingjishuList">
		<template v-if="index == 8">
		<img @click="toDetail('jingjishuDetail', item)" :name="item.id" :style='{"cursor":"pointer","width":"18%","margin":"0 1%","objectFit":"cover","display":"block","height":"200px"}' v-if="preHttp(item.cover)" :src="item.cover.split(',')[0]" alt="" />
		<img @click="toDetail('jingjishuDetail', item)" :name="item.id" :style='{"cursor":"pointer","width":"18%","margin":"0 1%","objectFit":"cover","display":"block","height":"200px"}' v-else :src="baseUrl + (item.cover?item.cover.split(',')[0]:'')" alt="" />
		</template>
		</template>
	  </div>
	</div>


	
	
	<div @click="moreBtn('jingjishu')" :style='{"border":"2px solid #000","cursor":"pointer","padding":"16px 60px","margin":"40px auto","top":"40px","textAlign":"center","background":"none","display":"block","width":"auto","position":"absolute","right":"10%"}'>
		<span :style='{"color":"#000000","fontSize":"16px","fontWeight":"600"}'>查看更多</span>
		<i :style='{}' class="icon iconfont "></i>
	</div>
	

</div>
<!-- 特价商品 -->
	
</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        systemIntroductionDetail: {},
        newsList: [],
        jingjishuRecommend: [],

        jingjishuList: [],


		newsIndex15: 0,
		newsCategoryList15: [],
		recommendIndex12jingjishu: 0,
		recommendList12jingjishu: [],
		recommendColumn12jingjishu: '',


      }
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.getNewsList();
		this.getNewsCategory()
		this.getSystemIntroduction();
		this.getList();
		this.jingjishuRecommendCate()
    },
	mounted() {
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
		
		this.swiperChanges()
	},
	beforeDestroy() {
	  window.removeEventListener('scroll', this.handleScroll)
	},
    //方法集合
    methods: {
		swiperChanges() {












































			setTimeout(()=>{






















			},250)
		},
		newsIndexClick15(index) {
			this.newsIndex15 = index
			this.getNewsList()
		},
		getNewsCategory() {
			this.$http.get('newstype/list', {}).then(res => {
				if (res.data.code == 0) {
					this.newsCategoryList15 = res.data.data
				}
			});
		},
		jingjishuRecommendCate(){
			this.$http.get('shujileixing/list',{}).then(res => {
			  if (res.data.code == 0) {
				this.recommendList12jingjishu = res.data.data.list
			  }
			});
			this.recommendColumn12jingjishu = 'shujileixing'
		},
		recommendIndexClick12(index, name) {
			this['recommendIndex12' + name] = index
			this.getList()
			
			document.querySelectorAll('.recommend .list12' + name + ' .list .item').forEach(el => {
			  el.classList.remove("active")
			})
			setTimeout(() => {
			  document.querySelectorAll('.recommend .list12' + name + ' .list .item').forEach(el => {
			    el.classList.add("active")
			  })
			}, 1);
		},


		handleScroll() {
			let arr = [
				{id:'search',css:'animate__fadeInDown'},
				{id:'about',css:'animate__zoomInUp'},
				{id:'system',css:'animate__bounce'},
				{id:'animate_recommendjingjishu',css:'animate__zoomIn'},
				{id:'animate_listjingjishu',css:'animate__zoomIn'},
				{id:'animate_newsnews',css:'animate__zoomIn'},
				{id:'msgs',css:'animate__zoomInUp'},
				{id:'friendly',css:'animate__zoomInUp'}
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
      getSystemIntroduction() {
          this.$http.get('systemintro/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.systemIntroductionDetail = res.data.data;
            }
          })
      },
		getNewsList() {
			let data = {
				page: 1,
				limit: 7,
                sort: 'addtime',
				order: 'desc'
			}
			if(this.newsIndex15!=0) {
				data['typename'] = this.newsCategoryList15[this.newsIndex15 - 1].typename
			}
			this.$http.get('news/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
			let autoSortUrl = "";
			let data = {}
          autoSortUrl = "jingjishu/autoSort";
			data = {
				page: 1,
				limit: 4,
			}
			if(this.recommendIndex12jingjishu != 0){
				data.shujileixing = this.recommendList12jingjishu[this.recommendIndex12jingjishu - 1].shujileixing
			}
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.jingjishuRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
			
			data = {
				page: 1,
				limit: 9,
			}
			this.$http.get('jingjishu/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.jingjishuList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {id: item.id}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		// -------- search --------
		.search .select /deep/ .el-input__inner {
			border: 0;
			border-radius: 4px;
			padding: 0 30px 0 10px;
			color: #00AA3A;
			width: 180px;
			font-size: 14px;
			height: 44px;
		}
		
		.search .input /deep/ .el-input__inner {
			border: 10px;
			border-radius: 4px;
			padding: 0 10px;
			color: rgba(64, 158, 255, 1);
			width: 180px;
			font-size: 14px;
			height: 44px;
		}
		// -------- search --------
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: scale(0.96) translate3d(0px, 10px, 0px);
				transition: all 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: scale(0.96) translate3d(0px, 10px, 0px);
				transition: all 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
			}
		}
	}
	


	.home-preview .news .list15 .tab .item {
				cursor: pointer;
				border-radius: 6px;
				padding: 5px 10px;
				margin: 0 10px;
				color: #fff;
				display: flex;
				width: 20%;
				line-height: 44px;
				align-items: center;
			}
	
	.home-preview .news .list15 .tab .item:hover {
				color: #fff;
			}
	
	.home-preview .news .list15 .tab .item.active {
				color: #fff;
			}
	
	.home-preview .news .list15 .tab .more {
				cursor: pointer;
				border-radius: 6px;
				padding: 0 0 0 60px;
				margin: 0 10px;
				color: #fff;
				display: flex;
				line-height: 44px;
				align-items: center;
				position: relative;
			}
	
	.home-preview .news .list15 .tab .more:hover {
			}
	
	.home-preview .news .list15 .content .right .list-item  {
				border: 1px solid #efefef;
				cursor: pointer;
				padding: 0 84px 0 0 ;
				background: #fff;
				display: flex;
				width: 49%;
				justify-content: space-between;
				position: relative;
				height: auto;
			}
	.home-preview .news .list15 .content .right .list-item:hover  {
				border: 1px solid #c7f4d6;
				background: #c7f4d6;
			}
	
	.home-preview .news .list15 .content .right .list-item .date  {
				background-color: #00AA3A;
				padding: 12px 0 ;
				flex-direction: column;
				top: calc(50% - 32px);
				color: #fff;
				display: flex;
				width: 64px;
				justify-content: center;
				align-items: center;
				position: absolute;
				right: 10px;
				height: 64px;
			}
	.home-preview .news .list15 .content .right .list-item:hover .date {
				background-color: #fff;
			}
	.home-preview .news .list15 .content .right .list-item .date .day  {
				color: #fff;
				width: auto;
				font-size: 24px;
				line-height: 24px;
			}
	.home-preview .news .list15 .content .right .list-item:hover .date .day {
				color: #00AA3A;
				border-color: #fff;
			}
	.home-preview .news .list15 .content .right .list-item .date .year  {
				padding: 4px 0 0;
				color: #fff;
				width: auto;
				font-size: 14px;
			}
	.home-preview .news .list15 .content .right .list-item:hover .date .year {
				color: #00AA3A;
			}
	
	.home-preview .news .list15 .content .right .list-item .info .name  {
				padding: 20px 10px 12px;
				overflow: hidden;
				color: #000;
				white-space: nowrap;
				font-weight: 700;
				width: 100%;
				font-size: 18px;
				line-height: 26px;
				text-overflow: ellipsis;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .name {
			}
	
	.home-preview .news .list15 .content .right .list-item .info .desc  {
				padding: 0 10px;
				overflow: hidden;
				color: #666;
				white-space: nowrap;
				width: 100%;
				font-size: 14px;
				line-height: 20px;
				text-overflow: ellipsis;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .desc {
			}
	
	.home-preview .news .list15 .content .right .list-item .info .publisher .icon {
				margin: 0 2px 0 0;
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .publisher .icon {
			}
	.home-preview .news .list15 .content .right .list-item .info .publisher .text {
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .publisher .text {
			}
	
	.home-preview .news .list15 .content .right .list-item .info .like .icon {
				margin: 0 2px 0 0;
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .like .icon {
			}
	.home-preview .news .list15 .content .right .list-item .info .like .text {
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .like .text {
			}
	
	.home-preview .news .list15 .content .right .list-item .info .collect .icon {
				margin: 0 2px 0 0;
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .collect .icon {
			}
	.home-preview .news .list15 .content .right .list-item .info .collect .text {
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .collect .text {
			}
	
	.home-preview .news .list15 .content .right .list-item .info .view .icon {
				margin: 0 2px 0 0;
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .view .icon {
			}
	.home-preview .news .list15 .content .right .list-item .info .view .text {
				color: #666;
				font-size: 12px;
				line-height: 1.5;
			}
	.home-preview .news .list15 .content .right .list-item:hover .info .view .text {
			}





	.home-preview .recommend .list12 .tab .item {
				cursor: pointer;
				border: 0;
				padding: 0 20px;
				margin: 0 10px;
				color: #333;
				font-weight: 600;
				display: flex;
				width: auto;
				font-size: 18px;
				line-height: 44px;
				align-items: center;
			}
	
	.home-preview .recommend .list12 .tab .item:hover {
				color: #00aa3a;
			}
	
	.home-preview .recommend .list12 .tab .item.active {
				color: #00aa3a;
				border-color: #999;
				border-width: 0 0 0px 0;
				border-style: solid;
			}
	
	.home-preview .recommend .list12 .tab .more {
				cursor: pointer;
				padding: 5px 10px;
				margin: 0 10px;
				color: #333;
				background: none;
				display: flex;
				line-height: 44px;
				align-items: center;
			}
	
	.home-preview .recommend .list12 .tab .more:hover {
			}
	
	.home-preview .recommend .list12 .item.active {
	  animation-name: mymove;
	
	  &:nth-of-type(1) {
	    animation-duration: 1s;
	  }
	  &:nth-of-type(2) {
	    animation-duration: 1.2s;
	  }
	  &:nth-of-type(3) {
	    animation-duration: 1.4s;
	  }
	  &:nth-of-type(4) {
	    animation-duration: 1.6s;
	  }
	  &:nth-of-type(5) {
	    animation-duration: 1.8s;
	  }
	  &:nth-of-type(6) {
	    animation-duration: 2s;
	  }
	}
	
	@keyframes mymove
	{
		from {top: 320px;}
		to {top: 0;}
	}



</style>
