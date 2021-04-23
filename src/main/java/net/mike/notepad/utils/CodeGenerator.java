package net.mike.notepad.utils;

import java.util.Random;

public class CodeGenerator {
	//ТУТ НУЖЕН SINGLTON!!!
	private static CodeGenerator instance;
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private CodeGenerator() {
		int length = 16;
		Random r = new Random();
	    String str = r.ints(48, 122)
		            .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
		            .mapToObj(i -> (char) i)
		            .limit(length)
		            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
		            .toString();
	    setCode(str);
	}
	public static synchronized CodeGenerator getInstance() {
		if(instance == null) 
			instance = new CodeGenerator();
		return instance;
	}
}
