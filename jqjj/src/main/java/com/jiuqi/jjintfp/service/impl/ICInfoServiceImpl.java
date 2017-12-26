package com.jiuqi.jjintfp.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiuqi.jjintfp.mapper.EnICInfoMapper;
import com.jiuqi.jjintfp.model.EnterpriseICInfo;
import com.jiuqi.jjintfp.model.AppAuthMapping;
import com.jiuqi.jjintfp.service.ICInfoService;
import com.jiuqi.jjintfp.util.CommonUtils;
import com.jiuqi.jjintfp.util.RequestUtil;

@Service("ICInfoService")
public class ICInfoServiceImpl implements ICInfoService {
	
	private Logger logger = Logger.getLogger(ICInfoServiceImpl.class);
	
	@Resource
	private EnICInfoMapper enICInfoMapper;
	
	@Autowired
	private AsyncInsertTask insertTask;
	
	@Autowired
	private AppAuthMapping authMapping;
	
	private final String[] array = {"KeyNo", "Name", "No", "BelongOrg", "OperName", "StartDate", "EndDate", "Status", "Province", 
			"UpdatedDate", "CreditCode", "RegistCapi", "EconKind", "Address", "Scope", "TermStart", "TeamEnd", "CheckDate", 
			"OrgNo", "IsOnStock", "StockNumber", "StockType"};

	@Override
	public String getICInfo(String requestIp, String unit, String key, String keyword) {
		JSONObject jsonObj = new JSONObject();
		Map<String, String> unitKeyMap = authMapping.getMapProps();
		if (!unitKeyMap.containsKey(unit)) {
			jsonObj.put("Status", "203");
			jsonObj.put("Message", "该组织机构没有权限");
			return jsonObj.toString();
		} else if (unitKeyMap.containsKey(unit) && !unitKeyMap.get(unit).toString().equals(key)) {
			jsonObj.put("Status", "203");
			jsonObj.put("Message", "该组织机构没有权限");
			return jsonObj.toString();
		}
		EnterpriseICInfo enICInfo = null;
		enICInfo = enICInfoMapper.queryEnICInfoByName(keyword);
		if (enICInfo == null) {
			enICInfo = enICInfoMapper.queryEnICInfoByNo(keyword);
			if (enICInfo == null) {
				enICInfo = enICInfoMapper.queryEnICInfoByCode(keyword);
			}
		}
		if (enICInfo != null) {
			jsonObj = (JSONObject)JSON.toJSON(enICInfo);
			jsonObj.put("Status", "200");
			jsonObj.put("Message", "查询成功");
			logger.info("ip:" + requestIp + ",查询企业工商信息成功");
			return jsonObj.toString();
		}
		Map<String, String> param = new LinkedHashMap<String, String>();
		param.put(CommonUtils.REQ_KEY, authMapping.getAppKey());
		param.put(CommonUtils.REQ_KEYWORD, keyword);
		String rtnStr = RequestUtil.doGet(authMapping.getAddress(), param);
		if (!"".equals(rtnStr)) {//""为异常
			JSONObject jsonObject = JSON.parseObject(rtnStr); 
			if (!("200").equals(jsonObject.get("Status"))) {
				logger.info("ip:" + requestIp + ",没有查询到企业工商信息");
				return rtnStr;//{"Status":"201","Message":"查询无结果","OrderNumber":null,"Result":null}
			}
			String result = jsonObject.get("Result").toString();
			JSONObject resultJson = JSON.parseObject(result);
			EnterpriseICInfo icInfo = JSON.parseObject(resultJson.toJSONString(), EnterpriseICInfo.class);
			for (int i = 0; i < array.length; i ++) {
				resultJson.remove(array[i]);
			}
			icInfo.setOther(resultJson.toJSONString());
			insertTask.insertEnICInfo(icInfo);
			logger.info("ip:" + requestIp + ",查询企业工商信息成功");
			jsonObj = (JSONObject)JSON.toJSON(icInfo);
			jsonObj.put("Status", "200");
			jsonObj.put("Message", "查询成功");
			return jsonObj.toJSONString();
		}
		jsonObj.put("Status", "500");
		jsonObj.put("Message", "系统异常");
		return jsonObj.toJSONString();
	}
}
