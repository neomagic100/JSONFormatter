/*
 * 
 * Clean input from a List of Strings to convert to JSON format
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
import java.util.List;

public class StringListClean {
	
	/**
	 * Clean an input List for JsonBuilder
	 * @param input List of Strings to format
	 * @return List of objects
	 */
	protected static List<Object> clean(List<String> input) {
		List<Object> output = new ArrayList<>();
		
		for (String s: input) {
			StringBuilder sb = new StringBuilder(); 
			for (int i = 0; i < s.length(); i++) {
				if (Character.isLetterOrDigit(s.charAt(i)) || s.charAt(i) == '-' 
						|| s.charAt(i) == ',') {
					sb.append(s.charAt(i));
				}
			}
			output.add(sb.toString());
		}
		
		
		return splitEntries(output);
		
	}
	
	/**
	 * Split a CSV string into multiple entries
	 * @param output2 String list of entry values
	 * @return Object List of entry values
	 */
	private static List<Object> splitEntries(List<Object> output2) {
		List<Object> output = new ArrayList<>();
			
		for (Object s: output2) {
			String[] t = ((String) s).split(",");
			for (String u: t) {
				output.add(u);
			}
		}
		
		return output;
	}

}
