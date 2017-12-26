package com.jiuqi.jjintfp.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jiuqi.jjintfp.model.EnterpriseICInfo;
/**
 * 
 * 企业工商信息mapper层.<br>
 *
 * <p>Copyright: 版权所有 (c) JOIN-CHEER</p>
 *
 * @author dongwenhua
 * @version 2017年12月21日
 */
@Mapper
public interface EnICInfoMapper {
	
	/**
	 * 
	 * 根据关键字查询企业工商信息(公司名).<br>
	 *
	 * @param keyworld
	 * @return  EnterpriseICInfo
	 */
	public EnterpriseICInfo queryEnICInfoByName(String keyword);
	
	/**
	 * 
	 * 根据关键字查询企业工商信息(注册号).<br>
	 *
	 * @param keyworld
	 * @return  EnterpriseICInfo
	 */
	public EnterpriseICInfo queryEnICInfoByNo(String keyword);
	
	/**
	 * 
	 * 根据关键字查询企业工商信息(社会统一信用代码).<br>
	 *
	 * @param keyworld
	 * @return  EnterpriseICInfo
	 */
	public EnterpriseICInfo queryEnICInfoByCode(String keyword);
	
	/**
	 * 
	 * 将企查查 查询到的信息插入到本地库.<br>
	 *
	 * @param enterpriseICInfo
	 * @return  Integer
	 */
	public Integer insertEnICInfo(EnterpriseICInfo enterpriseICInfo) throws Exception;

}
