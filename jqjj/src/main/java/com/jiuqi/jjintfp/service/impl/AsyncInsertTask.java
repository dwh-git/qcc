package com.jiuqi.jjintfp.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.jiuqi.jjintfp.mapper.EnICInfoMapper;
import com.jiuqi.jjintfp.model.EnterpriseICInfo;
import com.jiuqi.jjintfp.util.CommonUtils;

@Component
public class AsyncInsertTask {
	@Resource
	private EnICInfoMapper enICInfoMapper;
	
	private Logger logger = Logger.getLogger(AsyncInsertTask.class);
	
	@Async
	public void insertEnICInfo(EnterpriseICInfo icInfo) {
		if (CommonUtils.isNotNullOrEmpty(icInfo)) {
			try {
				enICInfoMapper.insertEnICInfo(icInfo);
			} catch (Exception e) {
				logger.error("插入数据库异常,需要插入的信息：" + icInfo, e);
			}
		}
	}
}
