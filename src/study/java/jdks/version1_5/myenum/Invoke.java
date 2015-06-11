package study.java.jdks.version1_5.myenum;

/*
 * ö��
 */
public class Invoke {

	public static void main(String[] args) {
		Color red = Color.RED;
		System.out.println(red.toString());
		
		MyColor myred = MyColor.RED;
		System.out.println(myred);
		System.out.println(myred.mytest());
		
		// ����ö��ֵ��ö�����ֵ�˳�����˳�����ö��ֵ������˳�������
		System.out.println(myred.ordinal());
		// Enumʵ����java.lang.Comparable�ӿڣ���˿��ԱȽ�����ָ�������˳��
		// Enum�е�compareTo���ص�������ö��ֵ��˳��֮���Ȼ��ǰ��������ö��ֵ��������ͬһ��ö���࣬������׳�ClassCastException�����쳣
		System.out.println(myred.compareTo(MyColor.BLUE));
		System.out.println(red.compareTo(Color.YELLOW));
		
		// ����ö��ֵ
		Color[] colors = Color.values();
		for(Color color:colors) {
			System.out.println(color);
		}
		
		// valueOf����
		System.out.println(MyColor.valueOf("RED"));
		
		// switch������ж�ö��
		Color color = Color.RED;
		switch(color) {
		case BLUE:System.out.println("it's blue");break;
		case RED:System.out.println("it's red");break;
		case YELLOW:System.out.println("it's yellow");break;
		}
		
	}
}
