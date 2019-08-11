/**
 * 
 */
package com.http.testrestfulrpc;

import java.util.Map;


public interface BaseService {

	public Object execute(Map<String, Object> args);
}
