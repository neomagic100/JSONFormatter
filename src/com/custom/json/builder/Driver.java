package com.custom.json.builder;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("[\"[1, 1234, Georgia, 2022-07-21]\"");
		l.add("[\"[1, 1234, Georgia, 2022-07-21]\"");
		List<Object> m = StringListClean.clean(l);
		//System.out.println(StringListClean.clean(l));

		String[] n = new String[m.size()];
		List<String> out = new ArrayList<>();
		List<String> lout = new ArrayList<String>();
		for (int i = 0; i < m.size(); i++) {
			
			n = ((String) m.get(i)).split(",");
			for (String s: n) {
				//System.out.println(s);
				out.add(s);
			}
			lout.addAll(out);
		}

		
		List<String> keys = new ArrayList<>();
		keys.add("cid");
		keys.add("NumCalls");
		keys.add("State");
		keys.add("Date");

		
		JsonBuilder j = new JsonBuilder(keys, m);
		System.out.println(j.getJson());

	}

}
