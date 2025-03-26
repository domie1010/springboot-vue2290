<template>
<div>
	<div :style='{"width":"100%","padding":"16px calc(50% - 600px)","background":"#ecf2ea"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'/'" :style='{"fontSize":"14px","lineHeight":"1"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index"><a>{{item.name}}</a></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div v-if="centerType" :style='{"width":"100%","padding":"16px calc(50% - 600px)","background":"#ecf2ea"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
	<div class="list-preview" :style='{"width":"100%","padding":"0 10%","margin":"30px auto","position":"relative"}'>
		

	
    <el-form :inline="true" :model="formSearch" class="list-form-pv" :style='{"row-gap":"10px","padding":"24px 0","alignItems":"center","flexWrap":"wrap","display":"flex","width":"100%","height":"auto"}'>
      <el-form-item :style='{"margin":"0 10px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>书名：</div>
        <el-input v-model="formSearch.bookname" placeholder="书名" @keydown.enter.native="getList(1, curFenlei)" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"margin":"0 10px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>书籍类型：</div>
        <el-input v-model="formSearch.shujileixing" placeholder="书籍类型" @keydown.enter.native="getList(1, curFenlei)" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"margin":"0 10px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>出版社：</div>
        <el-input v-model="formSearch.chubanshe" placeholder="出版社" @keydown.enter.native="getList(1, curFenlei)" clearable></el-input>
      </el-form-item>
      <el-form-item :style='{"margin":"0 10px"}'>
	    <div class="lable" v-if="true" :style='{"width":"auto","padding":"0 10px","lineHeight":"42px","display":"inline-block"}'>出版年份：</div>
        <el-input v-model="formSearch.chubanyear" placeholder="出版年份" @keydown.enter.native="getList(1, curFenlei)" clearable></el-input>
      </el-form-item>
	  <el-button v-if=" true " :style='{"cursor":"pointer","border":"1px solid #000","padding":"0px 15px","margin":"0 10px 0 0","outline":"none","color":"#000","borderRadius":"4px","background":"none","width":"auto","fontSize":"14px","lineHeight":"42px","height":"42px"}' type="primary" @click="getList(1, curFenlei)"><i v-if="true" :style='{"color":"#000","margin":"0 10px 0 0","fontSize":"14px"}' class="el-icon-search"></i>查询</el-button>
	  <el-button v-if="btnAuth('tushuguihai','新增')" :style='{"cursor":"pointer","border":"1px solid","padding":"0px 15px","margin":"0 10px 0 0","outline":"none","color":"#000","borderRadius":"4px","background":"none","width":"auto","fontSize":"14px","lineHeight":"42px","height":"42px"}' type="primary" @click="add('/index/tushuguihaiAdd')"><i v-if="true" :style='{"color":"#000","margin":"0 10px 0 0","fontSize":"14px"}' class="el-icon-circle-plus-outline"></i>添加</el-button>
    </el-form>
	<div class="list" :style='{"border-top":"50px solid #00AA3A","margin":"0 0 10px"}'>
		
		<!-- 样式三 -->
		<div class="list3 index-pv1" :style='{"width":"100%","padding":"30px 0 0","flexWrap":"wrap","background":"#ecf2ea","display":"flex","height":"auto"}'>
		  <div v-for="(item, index) in dataList" :key="index" @click.stop="toDetail(item)" class="list-item animation-box">
		    <div :style='{"border":"0px solid red","width":"200px","padding":"0px","overflow":"hidden","height":"200px"}' class="img-box">
				<img @click.stop="imgPreView(item.cover)" :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' v-if="item.cover && item.cover.substr(0,4)=='http'" :src="item.cover" class="image" />
				<img @click.stop="imgPreView(baseUrl + (item.cover?item.cover.split(',')[0]:''))" :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' v-else :src="baseUrl + (item.cover?item.cover.split(',')[0]:'')" class="image" />
			</div>
		    <div :style='{"padding":"0 10px","overflow":"hidden","flex":"1","display":"flex","height":"auto"}' class="item-info">
		      <div :style='{"width":"50%","padding":"0 10px 0 0","color":"#999","flex":"1"}'>
				<div class="title">{{item.bookname}}</div>
				<div v-if="item.price" class="price"><span :style='{"fontSize":"12px"}'>￥</span>{{item.price}}</div>
		        <div :style='{"padding":"0 10px","borderColor":"red","borderStyle":"solid","borderWidth":"0 0 0px 0"}' class="time">
		          <span class="icon iconfont icon-shijian21"></span>
		          <span class="text">{{item.addtime}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","borderColor":"red","borderStyle":"solid","borderWidth":"0 0 0px 0","display":"inline-block"}' class="publisher">
		          <span class="icon iconfont icon-geren16"></span>
		          <span class="text">{{item.zhanghao}}</span>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
	</div>

	
	<el-pagination
	  background
	  id="pagination"
	  class="pagination"
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
      @size-change="sizeChange"
	  @prev-click="prevClick"
	  @next-click="nextClick"
	></el-pagination>

  </div>
  <el-dialog title="预览图" :visible.sync="previewVisible" width="50%">
  	<img :src="previewImg" alt="" style="width: 100%;">
  </el-dialog>
</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
	    layouts: '',
		swiperIndex: -1,
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '图书归还'
          }
        ],
        formSearch: {
          bookname: '',
          shujileixing: '',
          chubanshe: '',
          chubanyear: '',
        },
        fenlei: [],
		feileiColumn: '',
        dataList: [],
        total: 1,
        pageSize: 10,
		pageSizes: [10,20,30,50],
        totalPage: 1,
        curFenlei: '全部',
        isPlain: false,
        indexQueryCondition: '',
        timeRange: [],
		centerType:false,
		previewImg: '',
		previewVisible: false,
      }
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
		this.indexQueryCondition = this.$route.query.indexQueryCondition ? this.$route.query.indexQueryCondition : '';
		this.baseUrl = this.$config.baseUrl;
      this.getFenlei();
      this.getList(1, '全部');
    },
    //方法集合
    methods: {
		add(path) {
			let query = {}
			if(this.centerType){
				query.centerType = 1
			}
			this.$router.push({path: path,query:query});
		},
      getFenlei() {
      },
      getList(page, fenlei, ref = '') {
        let params = {page, limit: this.pageSize};
        let searchWhere = {};
        if (this.formSearch.bookname != '') searchWhere.bookname = '%' + this.formSearch.bookname + '%';
        if (this.formSearch.shujileixing != '') searchWhere.shujileixing = '%' + this.formSearch.shujileixing + '%';
        if (this.formSearch.chubanshe != '') searchWhere.chubanshe = '%' + this.formSearch.chubanshe + '%';
        if (this.formSearch.chubanyear != '') searchWhere.chubanyear = '%' + this.formSearch.chubanyear + '%';
		if(!this.centerType){
			params['sfsh'] = '是';
		}
        this.$http.get(`tushuguihai/${this.centerType?'page':'list'}`, {params: Object.assign(params, searchWhere)}).then(res => {
          if (res.data.code == 0) {
            this.dataList = res.data.data.list;
            this.total = Number(res.data.data.total);
            this.pageSize = Number(res.data.data.pageSize);
            this.totalPage = res.data.data.totalPage;
			
			this.pageSizes = [this.pageSize, this.pageSize*2, this.pageSize*3, this.pageSize*5];
          }
        });
      },
      curChange(page) {
        this.getList(page);
      },
      prevClick(page) {
        this.getList(page);
      },
      sizeChange(size){
        this.pageSize = size
        this.getList(1);
      },
      nextClick(page) {
        this.getList(page);
      },
	  imgPreView(url){
		  this.previewImg = url
		  this.previewVisible = true
	  },
      toDetail(item) {
		  let params = {
			  id: item.id
		  }
		  if(this.centerType){
			  params.centerType = 1
		  }
        this.$router.push({path: '/index/tushuguihaiDetail', query: params});
      },
	btnAuth(tableName,key){
		if(this.centerType){
			return this.isBackAuth(tableName,key)
		}else{
			return this.isAuth(tableName,key)
		}
	},
	backClick() {
		this.$router.push({path: '/index/center'});
	},
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.list-preview .list-form-pv .el-input {
		width: auto;
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
	
	.category-1 .item {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 10px 0 0;
		color: #999;
		background: #efefef;
		width: 72px;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-1 .item:hover {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 10px 0 0;
		color: #999;
		background: #000;
		width: 72px;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-1 .item.active {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 10px 0 0;
		color: #999;
		background: #000;
		width: 72px;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item:hover {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-2 .item.active {
		cursor: pointer;
		border-radius: 4px;
		margin: 0 0 10px 0;
		color: #999;
		background: #efefef;
		width: 100%;
		font-size: 14px;
		line-height: 36px;
		text-align: center;
	}
	
	.category-3 .item {
		cursor: pointer;
		border-radius: 4px;
		padding: 5px 20px;
		margin: 0;
		color: #000000;
		white-space: nowrap;
		background: none;
		display: flex;
		align-items: center;
	}
	
	.category-3 .item:hover {
		margin: 0;
		color: #00AA3A;
		background: none;
	}
	
	.category-3 .item.active {
		margin: 0px;
		color: #00AA3A;
		background: none;
		width: auto;
	}
	
	.list-form-pv .el-input /deep/ .el-input__inner {
		border: 1px solid;
		border-radius: 8px;
		padding: 0 10px;
		margin: 0;
		outline: none;
		color: #333;
		background: #fff;
		width: 140px;
		font-size: 14px;
		line-height: 42px;
		height: 42px;
	}
	
	.list-form-pv .el-select /deep/ .el-input__inner {
	}
	
	.list-form-pv .el-date-editor /deep/ .el-input__inner {
		border: 1px solid;
		border-radius: 8px;
		padding: 0 30px;
		margin: 0;
		outline: none;
		color: #333;
		background: #fff;
		width: 140px;
		font-size: 14px;
		line-height: 42px;
		height: 42px;
	}
	
	.list .index-pv1 .animation-box {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
		z-index: initial;
	}
	
	.list .index-pv1 .animation-box:hover {
		z-index: 1;
	}
	
	.list .index-pv1 .animation-box img {
		transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
	}
	
	.list .index-pv1 .animation-box img:hover {
		transform: scale(1.2);
		transition: 0.3s;
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

	.list3 .list-item {
				cursor: pointer;
				padding: 10px;
				margin: 0 0 30px 2%;
				background: #fff;
				display: flex;
				width: 47%;
				font-size: 0;
				position: relative;
				height: auto;
			}
	
	.list3 .list-item:hover {
				background: #00aa3a;
			}
	
	.list3 .list-item .title {
				padding: 0 10px;
				color: #333;
				font-size: 14px;
				border-color: red;
				border-width: 0 0 0px 0;
				line-height: 24px;
				border-style: solid;
			}
	
	.list3 .list-item:hover .title {
				color: #fff;
			}
	.list3 .list-item .price {
				padding: 0 10px;
				color: #f00;
				font-size: 14px;
				border-color: red;
				border-width: 0 0 0px 0;
				line-height: 24px;
				border-style: solid;
			}
	
	.list3 .list-item:hover .price {
				color: #fff;
			}
	
	.list3 .list-item .time .icon {
				margin: 0 2px 0 0;
				color: inherit;
				font-size: 14px;
				line-height: 28px;
			}
	.list3 .list-item:hover .time .icon {
				color: #fff;
			}
	.list3 .list-item .time .text {
				color: inherit;
				font-size: 14px;
				line-height: 28px;
			}
	.list3 .list-item:hover .time .text {
				color: #fff;
			}
	
	.list3 .list-item .publisher .icon {
				margin: 0 2px 0 0;
				color: inherit;
				font-size: 12px;
				line-height: 28px;
			}
	.list3 .list-item:hover .publisher .icon {
				color: #fff;
			}
	.list3 .list-item .publisher .text {
				color: inherit;
				font-size: 12px;
				line-height: 28px;
			}
	.list3 .list-item:hover .publisher .text {
				color: #fff;
			}
	
	.list3 .list-item .like .icon {
				margin: 0 2px 0 0;
				color: inherit;
				font-size: 12px;
				line-height: 28px;
			}
	.list3 .list-item:hover .like .icon {
				color: #fff;
			}
	.list3 .list-item .like .text {
				color: inherit;
				font-size: 12px;
				line-height: 28px;
			}
	.list3 .list-item:hover .like .text {
				color: #fff;
			}
	
	.list3 .list-item .collect .icon {
				margin: 0 2px 0 0;
				color: inherit;
				font-size: 12px;
				line-height: 28px;
			}
	.list3 .list-item:hover .collect .icon {
				color: #fff;
			}
	.list3 .list-item .collect .text {
				color: inherit;
				font-size: 12px;
				line-height: 28px;
			}
	.list3 .list-item:hover .collect .text {
				color: #fff;
			}
	
	.list3 .list-item .view .icon {
				margin: 0 2px 0 0;
				color: inherit;
				font-size: 12px;
				line-height: 28px;
			}
	.list3 .list-item:hover .view .icon {
				color: #fff;
			}
	.list3 .list-item .view .text {
				color: inherit;
				font-size: 12px;
				line-height: 28px;
			}
	.list3 .list-item:hover .view .text {
				color: #fff;
			}
	
	.list3 .list-item .desc {
				overflow: hidden;
				color: #999;
				background: none;
				width: 50%;
				font-size: 14px;
				line-height: 24px;
				height: 196px;
			}
	.list3 .list-item:hover .desc {
				color: #fff;
			}
	
</style>
