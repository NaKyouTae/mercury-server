package com.mercury.util;

import java.util.UUID;

/**
 * @author nkt
 * Create Date : 2020-06-30
 */
public interface UUIDUtil {
	
	
	/**
	 * UUID RANDOM "-" 제외
	 * @return String
	 * 
	 */
	public static String randomString() throws Exception {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
