package com.jiuqi.jjintfp.model;

import java.util.Date;

public class EnterpriseICInfo {
	private int id;
	private String keyNo;//内部KeyNo
	private String name;//公司名称
	private String no;//注册号
	private String belongOrg;//登记机关
	private String operName;//法人名
	private Date startDate;//成立日期
	private Date endDate;//吊销日期
	private String status;//企业状态
	private String province;//省份
	private Date updatedDate;//更新日期
	private String creditCode;//社会统一代码
	private String registCapi;//注册资本
	private String econKind;//企业类型
	private String address;//地址
	private String scope;//经营范围
	private Date termStart;//营业开始日期
	private Date teamEnd;//营业结束日期
	private Date checkDate;//发照日期
	private String orgNo;//组织机构代码
	private int isOnStock;//是否上市
	private String stockNumber;//上市公司代码
	private String stockType;//上市类型
	private String other;//其他信息
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeyNo() {
		return keyNo;
	}
	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getBelongOrg() {
		return belongOrg;
	}
	public void setBelongOrg(String belongOrg) {
		this.belongOrg = belongOrg;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getCreditCode() {
		return creditCode;
	}
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	public String getRegistCapi() {
		return registCapi;
	}
	public void setRegistCapi(String registCapi) {
		this.registCapi = registCapi;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public Date getTermStart() {
		return termStart;
	}
	public void setTermStart(Date termStart) {
		this.termStart = termStart;
	}
	public Date getTeamEnd() {
		return teamEnd;
	}
	public void setTeamEnd(Date teamEnd) {
		this.teamEnd = teamEnd;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public String getOrgNo() {
		return orgNo;
	}
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
	public int getIsOnStock() {
		return isOnStock;
	}
	public void setIsOnStock(int isOnStock) {
		this.isOnStock = isOnStock;
	}
	public String getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getEconKind() {
		return econKind;
	}
	public void setEconKind(String econKind) {
		this.econKind = econKind;
	}
	@Override
	public String toString() {
		return "EnterpriseICInfo [id=" + id + ", keyNo=" + keyNo + ", name=" + name + ", no=" + no + ", belongOrg="
				+ belongOrg + ", operName=" + operName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", status=" + status + ", province=" + province + ", updatedDate=" + updatedDate + ", creditCode="
				+ creditCode + ", registCapi=" + registCapi + ", econKind=" + econKind + ", address=" + address
				+ ", scope=" + scope + ", termStart=" + termStart + ", teamEnd=" + teamEnd + ", checkDate=" + checkDate
				+ ", orgNo=" + orgNo + ", isOnStock=" + isOnStock + ", stockNumber=" + stockNumber + ", stockType="
				+ stockType + ", other=" + other + "]";
	}
	
}
