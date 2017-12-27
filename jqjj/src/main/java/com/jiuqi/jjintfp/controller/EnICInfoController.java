package com.jiuqi.jjintfp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiuqi.jjintfp.service.ICInfoService;
import com.jiuqi.jjintfp.util.RequestUtil;

/**
 * 
 * 查询企业工商信息控制器，返回json.<br>
 *
 * <p>Copyright: 版权所有 (c) JOIN-CHEER</p>
 *
 * @author dongwenhua
 * @version 2017年12月21日
 */
@RestController
public class EnICInfoController {
	
	@Autowired
	private ICInfoService icInfoService;
	
	@RequestMapping("/queryEnICInfo")
	public String getEnterpriseICInfo(HttpServletRequest request, String unit, String key, String keyword) {
		if (unit == null || key == null || keyword == null  || "".equals(key.trim()) || "".equals(keyword.trim()) || "".equals(unit.trim())) {
			return "{'Status':'202','Message':'传入参数不存在或者格式不正确'}";
		}
		return icInfoService.getICInfo(RequestUtil.getRemoteHost(request), unit, key, keyword);
	}
	
}
