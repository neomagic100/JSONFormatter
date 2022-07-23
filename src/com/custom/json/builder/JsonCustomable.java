/*
 * Interface for:
 * Format a List of Strings into a single String in JSON format
 * 
 * Note: The JSON String being returned can only return JSONs with keys that are one of the following types:
 * 			String, Integer, Float, Double, Boolean
 * 
 * 			This excludes values that contain any type of list, array, map, etc.
 *
 * @author Michael Bernhardt
 */

package com.custom.json.builder;

import java.util.List;

public interface JsonCustomable {
	public static final List<String> keys = null;
	public static final List<String> values = null;
	public static final String json = "";
	
	public String formatEntry(String key, Object value);
	public String formatList();
	public String getJson();
	
}
