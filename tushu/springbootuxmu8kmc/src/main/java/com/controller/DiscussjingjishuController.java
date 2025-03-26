package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussjingjishuEntity;
import com.entity.view.DiscussjingjishuView;

import com.service.DiscussjingjishuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * jingjishu评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-28 09:57:36
 */
@RestController
@RequestMapping("/discussjingjishu")
public class DiscussjingjishuController {
    @Autowired
    private DiscussjingjishuService discussjingjishuService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjingjishuEntity discussjingjishu,
		HttpServletRequest request){
        EntityWrapper<DiscussjingjishuEntity> ew = new EntityWrapper<DiscussjingjishuEntity>();

		PageUtils page = discussjingjishuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjingjishu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjingjishuEntity discussjingjishu, 
		HttpServletRequest request){
        EntityWrapper<DiscussjingjishuEntity> ew = new EntityWrapper<DiscussjingjishuEntity>();

		PageUtils page = discussjingjishuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjingjishu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjingjishuEntity discussjingjishu){
       	EntityWrapper<DiscussjingjishuEntity> ew = new EntityWrapper<DiscussjingjishuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjingjishu, "discussjingjishu")); 
        return R.ok().put("data", discussjingjishuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjingjishuEntity discussjingjishu){
        EntityWrapper< DiscussjingjishuEntity> ew = new EntityWrapper< DiscussjingjishuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjingjishu, "discussjingjishu")); 
		DiscussjingjishuView discussjingjishuView =  discussjingjishuService.selectView(ew);
		return R.ok("查询jingjishu评论表成功").put("data", discussjingjishuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjingjishuEntity discussjingjishu = discussjingjishuService.selectById(id);
        return R.ok().put("data", discussjingjishu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjingjishuEntity discussjingjishu = discussjingjishuService.selectById(id);
        return R.ok().put("data", discussjingjishu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussjingjishuEntity discussjingjishu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjingjishu);
        discussjingjishuService.insert(discussjingjishu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjingjishuEntity discussjingjishu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjingjishu);
        discussjingjishuService.insert(discussjingjishu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussjingjishuEntity discussjingjishu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjingjishu);
        discussjingjishuService.updateById(discussjingjishu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussjingjishuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussjingjishuEntity discussjingjishu, HttpServletRequest request,String pre){
        EntityWrapper<DiscussjingjishuEntity> ew = new EntityWrapper<DiscussjingjishuEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussjingjishuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjingjishu), params), params));
        return R.ok().put("data", page);
    }










}
