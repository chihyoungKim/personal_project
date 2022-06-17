package utils;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

public class Util {
	public static void main(String[] args) {
		
	}
	
	public static <T> T getParam(HttpServletRequest req, Class<T> c) {
		T t = null;
		
		try {
			t = c.newInstance();
			Method[] methods = c.getMethods();
			for(Method m : methods) {
				String name = m.getName();
				if(name.startsWith("set")) {
					m.invoke(t, req.getParameter((char)(name.charAt(3) + 32) + name.substring(4)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
}
