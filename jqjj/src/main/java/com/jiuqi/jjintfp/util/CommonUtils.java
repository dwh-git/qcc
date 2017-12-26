package com.jiuqi.jjintfp.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonUtils {
	
	public static final String REQ_KEY = "key";
	public static final String REQ_KEYWORD = "keyword";
	
	/**
	 * 
	 *  List、Map、Set、String、JavaBean判断非空.<br>
	 *
	 * @param obj
	 * @return  boolean
	 */
	public static boolean isNotNullOrEmpty(Object obj) {
		if (obj instanceof List) {
			List list = (List)obj;
			if (list != null && list.size() > 0) {
				return true;
			}
		} else if (obj instanceof Map) {
			Map map = (Map)obj;
			if (map != null && map.size() > 0) {
				return true;
			}
		} else if (obj instanceof Set) {
			Set set = (Set)obj;
			if (set != null && set.size() > 0) {
				return true;
			}
		} else if (obj instanceof String) {
			String str = (String)obj;
			if (str != null && !"".equals(str.trim())) {
				return true;
			}
		} else {
			if (obj != null) {
				return true;
			}
		}
		return false;
	}
}
