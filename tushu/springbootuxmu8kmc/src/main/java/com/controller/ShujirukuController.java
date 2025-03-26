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

import com.entity.ShujirukuEntity;
import com.entity.view.ShujirukuView;

import com.service.ShujirukuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 书籍入库
 * 后端接口
 * @author 
 * @email 
 * @date 2023-11-28 09:57:35
 */
@RestController
@RequestMapping("/shujiruku")
public class ShujirukuController {
    @Autowired
    private ShujirukuService shujirukuService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShujirukuEntity shujiruku,
		HttpServletRequest request){
        EntityWrapper<ShujirukuEntity> ew = new EntityWrapper<ShujirukuEntity>();

		PageUtils page = shujirukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shujiruku), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShujirukuEntity shujiruku, 
		HttpServletRequest request){
        EntityWrapper<ShujirukuEntity> ew = new EntityWrapper<ShujirukuEntity>();

		PageUtils page = shujirukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shujiruku), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShujirukuEntity shujiruku){
       	EntityWrapper<ShujirukuEntity> ew = new EntityWrapper<ShujirukuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shujiruku, "shujiruku")); 
        return R.ok().put("data", shujirukuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShujirukuEntity shujiruku){
        EntityWrapper< ShujirukuEntity> ew = new EntityWrapper< ShujirukuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shujiruku, "shujiruku")); 
		ShujirukuView shujirukuView =  shujirukuService.selectView(ew);
		return R.ok("查询书籍入库成功").put("data", shujirukuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShujirukuEntity shujiruku = shujirukuService.selectById(id);
        return R.ok().put("data", shujiruku);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShujirukuEntity shujiruku = shujirukuService.selectById(id);
        return R.ok().put("data", shujiruku);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShujirukuEntity shujiruku, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shujiruku);
        shujirukuService.insert(shujiruku);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShujirukuEntity shujiruku, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shujiruku);
        shujirukuService.insert(shujiruku);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShujirukuEntity shujiruku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shujiruku);
        shujirukuService.updateById(shujiruku);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shujirukuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
