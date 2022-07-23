/*
 * 
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonBuilder implements JsonCustomable, Map<String, Object> {
	private List<String> keys;
	private List<Object> values;
	private String json;
	
	/**
	 * Constructor
	 * @param keys
	 * @param values
	 */
	public JsonBuilder(List<String> keys, List<Object> values) {
		this.keys = keys;
		this.values = values;
		this.json = this.formatList();
	}
	
	/**
	 * Constructor: Default
	 */
	public JsonBuilder() {
		this.keys = new ArrayList<>();
		this.values = new ArrayList<>();
	}
	
	/**
	 * Format local key and value lists into JSON format
	 * @return String - JSON format
	 */
	@Override
	public String formatList() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		for (int i = 0; i < this.size(); i++) {
			sb.append("\t");
			sb.append(formatEntry(this.keys.get(i), this.values.get(i)));
			
			if (i < this.size() - 1)
				sb.append(",\n");
			else
				sb.append("\n");
		}
		
		sb.append("}\n");
		
		return sb.toString();
	}
	
	/**
	 * Format a key and value pair into a single JSON entry
	 * @param key - String
	 * @param value - Object to be value or key
	 * @return String - single formatted String for JSON format
	 */
	@Override
	public String formatEntry(String key, Object value) {
		StringBuilder sb = new StringBuilder();
		sb.append("\"");
		sb.append(key);
		sb.append("\": ");
		
		if (value.getClass() == Integer.class || value.getClass() == Float.class 
				|| value.getClass() == Double.class || value.getClass() == Boolean.class) {
			sb.append(value);
		}
		else {
			sb.append("\"");
			sb.append(value);
			sb.append("\"");
		}
		
		return sb.toString();
	}
	
	/**
	 * Get the String that has been formatted into a JSON format
	 * @return String - JSON format
	 */
	@Override
	public String getJson() {
		return json;
	}

	@Override
	public int size() {
		return this.keys.size();
	}

	@Override
	public boolean isEmpty() {
		return (this.size() == 0);
	}

	@Override
	public boolean containsKey(Object key) {
		for (String s: this.keys) {
			if (s.compareTo((String) key) == 0) return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		for (Object s: this.values) {
			if (((String) s).compareTo((String) value) == 0) return true;
		}
		return false;
	}

	@Override
	public Object get(Object key) {
		if (!this.containsKey(key)) return null;
		
		for (int i = 0; i < this.size(); i++) {
			if (this.keys.get(i).compareTo((String) key) == 0) return this.values.get(i);
		}
		
		return null;
	}


	@Override
	public String remove(Object key) {
		for (int i = 0; i < this.size(); i++) {
			if (this.keys.get(i).compareTo((String) key) == 0) {
				this.keys.remove(i);
				this.values.remove(i);
				return null;
			}
		}
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.keys.clear();
		this.values.clear();
	}

	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Object> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<String, Object>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}
