package com.jiuqi.jjintfp.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class RequestUtil {
	private static Logger logger = Logger.getLogger(RequestUtil.class);
	
	public static String getRemoteHost(HttpServletRequest request){
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
	
	public static String doGet(String url, Map<String, String> param) {
		String str = "";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//从连接池获取连接超时时间、和服务器建立连接超时时间、从服务器读取数据超时时间
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(5000).setConnectTimeout(5000).setSocketTimeout(5000).build();
		CloseableHttpResponse response = null;
		try {
			HttpGet httpGet = new HttpGet(buildUrl(url, param));
			httpGet.setConfig(requestConfig);
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			str = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			//记录日志
			logger.error("调用企查查接口 (" + url + ")异常", e);
			return "";
		} finally {
			try {
				httpClient.close();
				if (response != null) {
					response.close();
				}
			} catch (IOException exception) {
				logger.error("调用企查查接口 (" + url + ")异常", exception);
				return "";
			}
		}
		return str;
		
	}
	
	private static String buildUrl(String url, Map<String, String> param) throws UnsupportedEncodingException {
		StringBuffer urlBuffer= new StringBuffer(url);
		if (param != null && param.size() > 0) {
			StringBuffer paramBuffer = new StringBuffer();
			for (Entry<String, String> entry : param.entrySet()) {
				if (paramBuffer.length() > 0) {
					paramBuffer.append("&");
				}
				if (CommonUtils.isNotNullOrEmpty(entry.getKey()) && CommonUtils.isNotNullOrEmpty(entry.getValue())) {
					if (CommonUtils.REQ_KEY.equals(entry.getKey())) {
						paramBuffer.append(entry.getKey()).append("=").append(entry.getValue());
					}
					if (CommonUtils.REQ_KEYWORD.equals(entry.getKey())) {
						paramBuffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8"));
					}
				}
			}
			if (paramBuffer.length() > 0) {
				urlBuffer.append("?").append(paramBuffer);
			}
		}
		return urlBuffer.toString();
	}
	
}
