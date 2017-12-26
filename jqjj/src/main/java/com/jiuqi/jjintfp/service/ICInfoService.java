package com.jiuqi.jjintfp.service;

/**
 * 
 * 企业工商信息服务.<br>
 *<p>包括拽取企查查信息到库以及查库等操作</p>
 *
 * <p>Copyright: 版权所有 (c) JOIN-CHEER</p>
 *
 * @author dongwenhua
 * @version 2017年12月21日
 */
public interface ICInfoService {
	
	/**
	 * 
	 * 根据搜索关键字（公司名、注册号、社会统一信用代码）查询企业工商信息.<br>
	 *
	 * @param requestIp
	 * @param unit
	 * @param key
	 * @param keyword
	 * @return  String
	 */
	public String getICInfo(String requestIp, String unit, String key, String keyword);

}
