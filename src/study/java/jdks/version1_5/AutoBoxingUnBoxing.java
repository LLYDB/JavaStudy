package study.java.jdks.version1_5;

public class AutoBoxingUnBoxing {
	
	public static void main(String[] args) {
		Integer a = 297;
		Integer b = 297;
		System.out.println(a==b);
		
		//-128~127(FlyWeightģʽ)
		Integer c = 111;
		Integer d = 111;
		System.out.println(c==d);

		
		// �Զ�װ��
		Integer data1 = 10; 
		Integer data2 = 20; 
		// תΪdoubleֵ�ٳ���3 
		System.out.println(data1.doubleValue() / 3); 
		// ��������ֵ�ıȽ� 
		System.out.println(data1.compareTo(data2));
		
		// �Զ�����
		Integer data3 = new Integer(255);
		System.out.println(data3 + 5);
	}

}
