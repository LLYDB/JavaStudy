package study.java.jdks.version1_5.foreach;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * ��forѭ��
 * @author hadoop2
 *
 */
public class ForEach {
	
	public static void main(String[] args) {
		
		//���������ʵ����Iterator�ӿڵ�
		
		
		// ��������
		String[] names = new String[]{"zhangsan","lisi","wangwu","zhaoliu"};
		
		// ��Ҫ�ڴ��ܸı�����Ԫ�ص�ֵ
		for(String name:names) {
			name="fucheng";
		}
		System.out.println(names[0]);
		
		
		// ����Set
		Set<String> set = new TreeSet<String>();
		set.add("e1");
		set.add("e2");
		set.add("e3");
		
		for(String s:set) {
			System.out.println(s);
		}
		
		// ����Map
		Map<String,String> map = new HashMap<String,String>();
		map.put("k1", "value1");
		map.put("k2", "value2");
		map.put("k3", "value3");
		for(Map.Entry<String, String> entry:map.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			
		}
		
		//ʹ��ǰ�����ж��Ƿ�Ϊnull
		int[] ages=null;
		for(int age:ages){
			System.out.println(age);
		}
		
		
	}

}
