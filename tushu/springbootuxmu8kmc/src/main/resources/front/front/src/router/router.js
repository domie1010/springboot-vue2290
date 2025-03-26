import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import shujileixingList from '../pages/shujileixing/list'
import shujileixingDetail from '../pages/shujileixing/detail'
import shujileixingAdd from '../pages/shujileixing/add'
import jingjishuList from '../pages/jingjishu/list'
import jingjishuDetail from '../pages/jingjishu/detail'
import jingjishuAdd from '../pages/jingjishu/add'
import tushujieyueList from '../pages/tushujieyue/list'
import tushujieyueDetail from '../pages/tushujieyue/detail'
import tushujieyueAdd from '../pages/tushujieyue/add'
import tushuguihaiList from '../pages/tushuguihai/list'
import tushuguihaiDetail from '../pages/tushuguihai/detail'
import tushuguihaiAdd from '../pages/tushuguihai/add'
import shujirukuList from '../pages/shujiruku/list'
import shujirukuDetail from '../pages/shujiruku/detail'
import shujirukuAdd from '../pages/shujiruku/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import discussjingjishuList from '../pages/discussjingjishu/list'
import discussjingjishuDetail from '../pages/discussjingjishu/detail'
import discussjingjishuAdd from '../pages/discussjingjishu/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'shujileixing',
					component: shujileixingList
				},
				{
					path: 'shujileixingDetail',
					component: shujileixingDetail
				},
				{
					path: 'shujileixingAdd',
					component: shujileixingAdd
				},
				{
					path: 'jingjishu',
					component: jingjishuList
				},
				{
					path: 'jingjishuDetail',
					component: jingjishuDetail
				},
				{
					path: 'jingjishuAdd',
					component: jingjishuAdd
				},
				{
					path: 'tushujieyue',
					component: tushujieyueList
				},
				{
					path: 'tushujieyueDetail',
					component: tushujieyueDetail
				},
				{
					path: 'tushujieyueAdd',
					component: tushujieyueAdd
				},
				{
					path: 'tushuguihai',
					component: tushuguihaiList
				},
				{
					path: 'tushuguihaiDetail',
					component: tushuguihaiDetail
				},
				{
					path: 'tushuguihaiAdd',
					component: tushuguihaiAdd
				},
				{
					path: 'shujiruku',
					component: shujirukuList
				},
				{
					path: 'shujirukuDetail',
					component: shujirukuDetail
				},
				{
					path: 'shujirukuAdd',
					component: shujirukuAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'discussjingjishu',
					component: discussjingjishuList
				},
				{
					path: 'discussjingjishuDetail',
					component: discussjingjishuDetail
				},
				{
					path: 'discussjingjishuAdd',
					component: discussjingjishuAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
