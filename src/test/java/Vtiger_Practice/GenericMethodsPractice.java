package Vtiger_Practice;

public class GenericMethodsPractice {
	public static void main(String[] args) {
		int c=add(10,30);
		System.out.println(c);
		int e=sub(34,56);
		System.out.println(e);
		
	}
	public static int add(int a,int b) {
		int c = a+b;
		return c;
				
	}
	public static int sub(int c,int d) {
		int e=c-d;
		return e;
	}
	public static int mul(int w,int f) {
		int s = w*f;
		return s;
	}

}
