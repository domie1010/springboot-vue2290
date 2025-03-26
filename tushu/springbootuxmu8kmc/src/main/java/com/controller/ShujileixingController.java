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

import com.entity.ShujileixingEntity;
import com.entity.view.ShujileixingView;

import com.service.ShujileixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 书籍类型
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
@RestController
@RequestMapping("/shujileixing")
public class ShujileixingController {
    @Autowired
    private ShujileixingService shujileixingService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShujileixingEntity shujileixing,
		HttpServletRequest request){
        EntityWrapper<ShujileixingEntity> ew = new EntityWrapper<ShujileixingEntity>();

		PageUtils page = shujileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shujileixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShujileixingEntity shujileixing, 
		HttpServletRequest request){
        EntityWrapper<ShujileixingEntity> ew = new EntityWrapper<ShujileixingEntity>();

		PageUtils page = shujileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shujileixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShujileixingEntity shujileixing){
       	EntityWrapper<ShujileixingEntity> ew = new EntityWrapper<ShujileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shujileixing, "shujileixing")); 
        return R.ok().put("data", shujileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShujileixingEntity shujileixing){
        EntityWrapper< ShujileixingEntity> ew = new EntityWrapper< ShujileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shujileixing, "shujileixing")); 
		ShujileixingView shujileixingView =  shujileixingService.selectView(ew);
		return R.ok("查询书籍类型成功").put("data", shujileixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShujileixingEntity shujileixing = shujileixingService.selectById(id);
        return R.ok().put("data", shujileixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShujileixingEntity shujileixing = shujileixingService.selectById(id);
        return R.ok().put("data", shujileixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShujileixingEntity shujileixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shujileixing);
        shujileixingService.insert(shujileixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShujileixingEntity shujileixing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shujileixing);
        shujileixingService.insert(shujileixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShujileixingEntity shujileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shujileixing);
        shujileixingService.updateById(shujileixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shujileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
