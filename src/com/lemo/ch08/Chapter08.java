package com.lemo.ch08;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
    * @className: Chapter08
    * @description: Java常用功能
    * @author liming
    * @date 2016年12月5日 下午1:06:46
    *
 */
public class Chapter08 {
	
	public static void main(String[] args) {
		test14();
	}
	
	public static void println(String str){
		System.out.println(str);
	}
	
	
	
	/**
	 * 
	    * @Title: test01
	    * @Description: 如何是字符串中包含特殊字符
	    * void    返回类型
	    * @throws
	 */
	public static void test01() {
		
		String str= "\"";
		String str1= "\'";
		String str2= "\\";
		println(str);
		println(str1);
		println(str2);
	}
	/**
	 * 
	    * @Title: test02
	    * @Description: 如何让字符串和整型转化
	    * void    返回类型
	    * @throws
	 */
	public static void test02() {	
		String str1="100";
		Integer parseInt = Integer.parseInt(str1);
		println("int："+parseInt);
	}
	/**
	 * 
	    * @Title: test03
	    * @Description: 如何替换字符串中的字符或子字符串
	    * void    返回类型
	    * @throws
	 */
	public static void test03() {	
		String str = "[kllkklk\\kk\\kllkk]";
		println(str);
		//no different
		String replace = str.replace("kk", "++");
		println(replace);
		String replaceAll = str.replaceAll("kk", "++");
		println(replaceAll);
		// different
		String replace1 = str.replace("\\", "++");
		println(replace1);
		String replaceAll1 = str.replaceAll("\\\\", "++");
		println(replaceAll1);
	}
	
	/**
	 * 
	    * @Title: test04
	    * @Description: 如何过滤字符串前后以及中间出现的空格
	    * void    返回类型
	    * @throws
	 */
	public static void test04() {	
		String str = "H e l l o W o r l d";
		// m1
		String trim = str.trim();//字符串左右
		println(trim);
		// m2
		String replaceAll = str.replaceAll(" ", "");
		println(replaceAll);
	}
	/**
	 * 
	    * @Title: test05
	    * @Description: 截取   
	    * void    返回类型
	    * @throws
	 */
	public static void test05() {	
		String str = "H e l l o W o r l d";
		String substring = str.substring(5);
		String substring2 = str.substring(0, 3);
		println(substring);
		println(substring2);
	}
	/**
	 * 
	    * @Title: test06
	    * @Description: 如何判断一个字符串是否符合数值格式
	    * void    返回类型
	    * @throws
	 */
	public static void test06() {	
		String string = "233";
		Pattern pattern = Pattern.compile("\\d*");
		Matcher matcher  =pattern.matcher(string);
		boolean matches = matcher.matches();
		println(matches+"");
	}
	/**
	 * 
	    * @Title: test07
	    * @Description: 如何实现字符串的切割和查找
	    * void    返回类型
	    * @throws
	 */
	public static void test07() {	
		String string ="javasejavaeejavame";
		String java ="java";
		Matcher matcher = Pattern.compile(java).matcher(string);
		while(matcher.find()){
			String substring = string.substring(matcher.start(),matcher.end());
			println(substring);
		}
	}
	/**
	 * 
	    * @Title: test08
	    * @Description: 如何实现十进制和二进制之间的相互转化
	    * void    返回类型
	    * @throws
	 */
	public static void test08(){
		int i = 100;
		String binaryString = Integer.toBinaryString(i);
		println(binaryString);
		
		int parseInt = Integer.parseInt(binaryString,2);
		println(parseInt+"");
	}
	/**
	 * 
	    * @Title: test09
	    * @Description: 如何将字节流转换为指定编码的字符串
	    * void    返回类型
	    * @throws
	 */
	public static void test09() {
		String str= "中文转码";
		try {
			byte[] bytes = str.getBytes("UTF-8");
			String newString = new String(bytes);
			println(newString);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	    * @Title: test10
	    * @Description: 时间    参数
	    * void    返回类型
	    * @throws
	 */
	public static void test10() {
		SimpleDateFormat sdf = new SimpleDateFormat();
	}
	/**
	 * 
	    * @Title: test11
	    * @Description: 字符串
	    * void    返回类型
	    * @throws
	 */
	public static void test11() {
		String s ="I love you";
		String str ="";
		long start = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			str +=s;
		}
		long end = System.nanoTime();
		println("s\"+\":"+(end-start));
		
		StringBuffer sBuffer = new StringBuffer();
		long start1 = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			sBuffer=sBuffer.append(str);
		}
		long end1 = System.nanoTime();
		println("StringBuffer\"+\":"+(end1-start1));
	}
	/**
	 * 
	    * @Title: test12
	    * @Description: 获取随机数
	    * void    返回类型
	    * @throws
	 */
	public static void test12() {
		long round = Math.round(Math.random()*100);
		println(round+"");
		int nextInt = new Random().nextInt(1000);
		println(nextInt+"");
	}
	/**
	 * 
	    * @Title: test13
	    * @Description: 
	    * void    返回类型
	    * @throws
	 */
	public static void test13() {
		
		//m1
		Class class1 =String.class;
		Method[] methods = class1.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String name = method.getName();
			println(name);
		}
	}
	private static class Student{
		private String id;
		private String name;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + "]";
		}
		
		
		
	}
	public static void test14() {
		Class class1;
		try {
			class1 = Class.forName("com.lemo.ch08.Student");
			Student newInstance = (Student) class1.newInstance();
			newInstance.setId("232");
			newInstance.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
