package study.java.jdks.version1_5.generic;

import java.util.ArrayList;

public class MyGenericWildcard {
	public static void main(String[] args) {
		ArrayList<String> as = new ArrayList<String>();
		ArrayList<Object> ao = null;
		// ���뱨��
		// ao = as;
		
		ArrayList<?> ao1 = null;
		ao1 = as;
		
		// ����������ʹ��ͨ���
		//ArrayList<?> xx = new ArrayList<?>();
	}

}
