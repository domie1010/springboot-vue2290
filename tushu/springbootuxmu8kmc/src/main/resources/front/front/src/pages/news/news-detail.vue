<template>
	<div :style='{"width":"100%","padding":"20px 10%","margin":"30px auto","position":"relative"}'>
	<div :style='{"width":"100%","padding":"0 0 0 288px","position":"relative"}'>
		<div :style='{"width":"100%","background":"#fff","height":"auto"}'>
			<div :style='{"margin":"10px 0","fontSize":"22px","lineHeight":"54px","color":"#0F672D","textAlign":"center","fontWeight":"600"}'>公告信息</div>
		</div>
		<div :style='{"border":"1px solid #333","padding":"20px","flexWrap":"wrap","borderWidth":"1px 1px 0 1px","display":"flex","width":"100%","position":"relative"}'>
			<div  :style='{"lineHeight":"40px","fontSize":"24px","color":"#333","textAlign":"left","flex":"8","fontWeight":"700"}'>{{detail.title}}</div>
			
			<div :style='{"width":"100%","margin":"20px 0 0","alignItems":"center","display":"flex","order":"3"}'>
			  <div :style='{"padding":"0"}'>
			    <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
			    <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>发布时间：{{detail.addtime}}</span>
			  </div>
			  <div :style='{"padding":"0","margin":"0 0 0 20px"}'>
			    <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
			    <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{detail.name}}</span>
			  </div>
			  <div :style='{"padding":"0","margin":"0 0 0 20px"}'>
			    <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
			    <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{detail.thumbsupnum}}</span>
			  </div>
			  <div :style='{"padding":"0","margin":"0 0 0 20px"}'>
			    <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
			    <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{detail.storeupnum}}</span>
			  </div>
			  <div :style='{"padding":"0","margin":"0 0 0 20px"}'>
			    <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
			    <span :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{detail.clicknum}}</span>
			  </div>
			</div>
			<div class="operate" :style='{"width":"100%","alignItems":"center","flex":"2","justifyContent":"space-between","display":"flex"}'>
				<div @click="zanClick" :style='{"padding":"0 15px","alignItems":"center","justifyContent":"center","display":"flex"}'>
					<span class="icon iconfont icon-guanzhu-zhihui" :style='{"margin":"0 2px 0 0","lineHeight":"40px","fontSize":"14px","color":"#333"}'></span>
					<span :style='{"color":"#333","lineHeight":"40px","fontSize":"14px"}'>{{zanType?'取消赞':'点赞'}}</span>
				</div>
				<div @click="collectClick" :style='{"padding":"0 15px","alignItems":"center","justifyContent":"center","display":"flex"}'>
					<span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"40px","fontSize":"14px","color":"#333"}'></span>
					<span :style='{"color":"#333","lineHeight":"40px","fontSize":"14px"}'>{{collectType?'取消收藏':'收藏'}}</span>
				</div>
			</div>
			
			<div :style='{"width":"100%","margin":"20px 0 0","lineHeight":"1.5","color":"#999","height":"auto","order":"4"}' class="content-detail" v-html="detail.content"></div>
		</div>
		<!-- option -->
		<div :style='{"padding":"0 20px 20px","borderColor":"#333","borderWidth":"0 1px 1px 1px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"space-between","height":"auto"}'>
		  <div :style='{"cursor":"pointer","padding":"0 10px","color":"#fff","borderRadius":"30px","background":"#000","fontSize":"12px","lineHeight":"30px","height":"30px"}' @click="prepDetailClick">上一篇：prev</div>
		  <div :style='{"cursor":"pointer","padding":"0 10px","color":"#fff","borderRadius":"30px","background":"#0f672d","fontSize":"14px","lineHeight":"30px","height":"30px"}' @click="nextDetailClick">下一篇：next</div>
		</div>

		<!-- 热门文章 -->
		<div class="hot" :style='{"border":"1px solid #333","width":"274px","position":"absolute","top":"0","left":"0","height":"auto"}'>
		  <div :style='{"width":"100%","padding":"30px 0 20px","lineHeight":"1em","fontSize":"18px","color":"#343434","textAlign":"center"}'>热门文章</div>
		  <div :style='{"width":"100%","padding":"0 20px","height":"auto"}'>
		    <div v-for="item in hotList" :key="item.id" :style='{"cursor":"pointer","width":"100%","margin":"0 0 20px","height":"90px"}' @click="toDetail(item.id)">
		      <img :style='{"width":"110px","margin":"0 10px 0 0","objectFit":"cover","float":"left","display":"block","height":"100%"}' :src="baseUrl + item.picture" alt="">
		      <div :style='{"padding":"24px 0 0","overflow":"hidden","color":"#343434","white-space":"nowrap","lineHeight":"1","fontSize":"14px","text-overflow":"ellipsis"}'>{{ item.title }}</div>
		      <div :style='{"padding":"10px 0 0","lineHeight":"12px","fontSize":"12px","color":"#999","textAlign":"left"}'>{{item.addtime}}</div>
		    </div>
		  </div>
		</div>
	</div>
	</div>
</template>

<script>
	export default {
		//数据集合
		data() {
			return {
				id: 0,
				detail: {},
				zanType: false,
				zanForm: {},
				collectType:false,
				collectForm: {},
				baseUrl:'',
				hotList: [],
				categoryList: [],
				currentIndex: 0,
				allList: []
			}
		},
		created() {
			this.id = this.$route.query.id
			this.baseUrl = this.$config.baseUrl;
			this.getCategoryList()
			this.getDetail()
			this.getNewsList()
			this.getHotList()
		},
		watch:{
			$route(newValue) {
				this.id = this.$route.query.id
			    this.getDetail()
			}
		},
		methods: {
			getNewsList() {
				let params = {page:1, limit: 100,sort:'addtime',order:'desc'};
				this.$http.get('news/list', {params: params}).then(res => {
					if (res.data.code == 0) {
						for(let x in res.data.data.list){
							if(res.data.data.list[x].id == this.id){
								this.currentIndex = Number(x)
								break
							}
						}
						this.allList = res.data.data.list
					}
				});
			},
			// 上一篇
			prepDetailClick(){
				if(this.currentIndex == 0){
					this.$message.error('已经是第一篇了')
					return false
				}
				this.currentIndex--
				this.$router.push({path: '/index/newsDetail', query: {id: this.allList[this.currentIndex].id}});
			},
			// 下一篇
			nextDetailClick(){
				if(this.currentIndex == this.allList.length - 1){
					this.$message.error('已经是最后一篇了')
					return false
				}
				this.currentIndex++
				this.$router.push({path: '/index/newsDetail', query: {id: this.allList[this.currentIndex].id}});
			},
			getCategoryList(){
				this.$http.get('newstype/list', {}).then(res => {
					if (res.data.code == 0) {
						this.categoryList = res.data.data;
					}
				});
			},
			// 获取热门列表
			getHotList(){
				let params = {page:1, limit: 4,sort:'addtime',order:'desc'};
				this.$http.get('news/autoSort', {params: params}).then(res => {
					if (res.data.code == 0) {
						this.hotList = res.data.data.list;
					}
				});
			},
			// 跳转详情
			toDetail(id){
				this.$router.push({path: '/index/newsDetail', query: {id: id}});
			},
			getDetail(){
				this.$http.get(`news/detail/${this.id}`,{}).then(res=>{
					if(res.data&&res.data.code==0){
						this.detail = res.data.data
						window.scrollTo(0, 100)
						this.getZan()
						this.getCollect()
					}
				})
			},
			getZan() {
				this.$http.get('storeup/list', {
					params: {
						page: 1,
						limit: 1,
						type: 21,
						userid: localStorage.getItem('userid'),
						tablename: 'news',
						refid: this.id
					}
				}).then(res=>{
					if(res.data&&res.data.code==0){
						if(res.data.data.list.length){
							this.zanType = true
							this.zanForm = res.data.data.list[0]
						}else{
							this.zanType = false
						}
					}
				})
			},
			getCollect(){
				this.$http.get('storeup/list', {
					params: {
						page: 1,
						limit: 1,
						type: 1,
						userid: localStorage.getItem('userid'),
						tablename: 'news',
						refid: this.id
					}
				}).then(res=>{
					if(res.data&&res.data.code==0){
						if(res.data.data.list.length){
							this.collectType = true
							this.collectForm = res.data.data.list[0]
						}else{
							this.collectType = false
						}
					}
				})
			},
			zanClick() {
				if(this.zanType){
					this.$http.post('storeup/delete', [this.zanForm.id]).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('取消成功')
							this.detail.thumbsupnum--
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.getZan()
						}
					})
				}else{
					let data = {
						name: this.detail.title,
						picture: this.detail.picture,
						refid: this.detail.id,
						type: 21,
						tablename: 'news',
						userid: localStorage.getItem('userid')
					}
					this.$http.post('storeup/add', data).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('点赞成功')
							this.detail.thumbsupnum++
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.getZan()
						}
					})
				}
			},
			collectClick(){
				if(this.collectType){
					this.$http.post('storeup/delete', [this.collectForm.id]).then(res => {
						if (res.data && res.data.code == 0) {
							this.$message.success('取消成功')
							this.detail.storeupnum--
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.getCollect()
						}
					})
				}else{
					let data = {
						name: this.detail.title,
						picture: this.detail.picture,
						refid: this.detail.id,
						type: 1,
						tablename: 'news',
						userid: localStorage.getItem('userid')
					}
					this.$http.post('storeup/add', data).then(res => {
						if (res.data && res.data.code == 0) {
							this.detail.storeupnum++
							this.$http.post('news/update',this.detail).then(obj=>{})
							this.$message.success('收藏成功')
							this.getCollect()
						}
					})
				}
			},
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.section {
		width: 900px;
		margin: 0 auto;
	}
	.editor /deep/ .avatar-uploader {
		height: 0;
		line-height: 0;
	}
	.section-content {
		margin-top: 30px;
	}
	.content-title {
		text-align: center;
		font-size: 22px;
		font-weight: bold;
	}
	.content-sub-title {
		text-align: center;
		margin-top: 20px;
		color: #888888;
		font-size: 14px;
	}
	.operate{
		display: flex;
		align-items: center;
		justify-content: space-between;
		padding: 0 40px;
	}
</style>