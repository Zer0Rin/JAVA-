import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import gequfenleiList from '../pages/gequfenlei/list'
import gequfenleiDetail from '../pages/gequfenlei/detail'
import gequfenleiAdd from '../pages/gequfenlei/add'
import biaoqianList from '../pages/biaoqian/list'
import biaoqianDetail from '../pages/biaoqian/detail'
import biaoqianAdd from '../pages/biaoqian/add'
import zaixianshitingList from '../pages/zaixianshiting/list'
import zaixianshitingDetail from '../pages/zaixianshiting/detail'
import zaixianshitingAdd from '../pages/zaixianshiting/add'
import yinlegoumaiList from '../pages/yinlegoumai/list'
import yinlegoumaiDetail from '../pages/yinlegoumai/detail'
import yinlegoumaiAdd from '../pages/yinlegoumai/add'
import yinlebofangList from '../pages/yinlebofang/list'
import yinlebofangDetail from '../pages/yinlebofang/detail'
import yinlebofangAdd from '../pages/yinlebofang/add'
import wodegedanList from '../pages/wodegedan/list'
import wodegedanDetail from '../pages/wodegedan/detail'
import wodegedanAdd from '../pages/wodegedan/add'
import yinyuexinxiList from '../pages/yinyuexinxi/list'
import yinyuexinxiDetail from '../pages/yinyuexinxi/detail'
import yinyuexinxiAdd from '../pages/yinyuexinxi/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import discusszaixianshitingList from '../pages/discusszaixianshiting/list'
import discusszaixianshitingDetail from '../pages/discusszaixianshiting/detail'
import discusszaixianshitingAdd from '../pages/discusszaixianshiting/add'
import discussyinyuexinxiList from '../pages/discussyinyuexinxi/list'
import discussyinyuexinxiDetail from '../pages/discussyinyuexinxi/detail'
import discussyinyuexinxiAdd from '../pages/discussyinyuexinxi/add'

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
					path: 'messages',
					component: Messages
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
					path: 'gequfenlei',
					component: gequfenleiList
				},
				{
					path: 'gequfenleiDetail',
					component: gequfenleiDetail
				},
				{
					path: 'gequfenleiAdd',
					component: gequfenleiAdd
				},
				{
					path: 'biaoqian',
					component: biaoqianList
				},
				{
					path: 'biaoqianDetail',
					component: biaoqianDetail
				},
				{
					path: 'biaoqianAdd',
					component: biaoqianAdd
				},
				{
					path: 'zaixianshiting',
					component: zaixianshitingList
				},
				{
					path: 'zaixianshitingDetail',
					component: zaixianshitingDetail
				},
				{
					path: 'zaixianshitingAdd',
					component: zaixianshitingAdd
				},
				{
					path: 'yinlegoumai',
					component: yinlegoumaiList
				},
				{
					path: 'yinlegoumaiDetail',
					component: yinlegoumaiDetail
				},
				{
					path: 'yinlegoumaiAdd',
					component: yinlegoumaiAdd
				},
				{
					path: 'yinlebofang',
					component: yinlebofangList
				},
				{
					path: 'yinlebofangDetail',
					component: yinlebofangDetail
				},
				{
					path: 'yinlebofangAdd',
					component: yinlebofangAdd
				},
				{
					path: 'wodegedan',
					component: wodegedanList
				},
				{
					path: 'wodegedanDetail',
					component: wodegedanDetail
				},
				{
					path: 'wodegedanAdd',
					component: wodegedanAdd
				},
				{
					path: 'yinyuexinxi',
					component: yinyuexinxiList
				},
				{
					path: 'yinyuexinxiDetail',
					component: yinyuexinxiDetail
				},
				{
					path: 'yinyuexinxiAdd',
					component: yinyuexinxiAdd
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
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
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
					path: 'discusszaixianshiting',
					component: discusszaixianshitingList
				},
				{
					path: 'discusszaixianshitingDetail',
					component: discusszaixianshitingDetail
				},
				{
					path: 'discusszaixianshitingAdd',
					component: discusszaixianshitingAdd
				},
				{
					path: 'discussyinyuexinxi',
					component: discussyinyuexinxiList
				},
				{
					path: 'discussyinyuexinxiDetail',
					component: discussyinyuexinxiDetail
				},
				{
					path: 'discussyinyuexinxiAdd',
					component: discussyinyuexinxiAdd
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
