package study.java.hanyx.rpn.crmPatternExp;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Asiainfo-Linkage
 * 
 * @desc: 模式匹配扩展
 * @version: v1.0
 * @author: lvyh
 * @date: 2011.02.20
 */
public class ExtPatternMatch {
	// 计算表达式结果
	public static boolean processExp(String billId, String exp) throws Exception {
		Stack stack = new Stack();// [false, ||, true, &&, false]
		// [false, &&, true, ||,false]
		List list = ExtPatternMatch.getResultList(billId, exp);

		// 将list转换成stack进行计算,方便逆序出栈运算
		boolean flag = false;
		for (int i = list.size() - 1; i >= 0; i--) {
			String temp = (String) list.get(i);
			stack.push(temp);
		}

		while (!stack.isEmpty()) {
			stack = ExtPatternMatch.processStack(stack);
			if (stack.size() == 1) {
				String str = stack.pop();
				flag = ExtPatternMatch.processBoolVar(str);
				break;
			}
		}
		return flag;
	}

	public static Stack processStack(Stack stack) throws Exception {
		String c = stack.pop();
		boolean flag = false;
		if (ExtPatternMatch.isBooleanVar(c)) {
			flag = ExtPatternMatch.computeResult(c, stack.pop(), stack.pop());
			stack.push("" + flag);
		}
		return stack;
	}

	// 获取结果列表
	public static List getResultList(String billId, String exp) throws Exception {
		if (!exp.startsWith("(")) {
			return null;
		}

		List list = new ArrayList();
		int index = 0;
		String operChar = null;
		boolean rst = false;
		
		//处理特殊情况的嵌套)||(表达式
		if (exp.contains(")||(")&&!exp.contains(")&&(")){
			List tempList = new ArrayList();
			String[] temp=exp.split("\\)\\|\\|\\(");
			String tempExp=null;
			for(int i=0;i<temp.length;i++){
				if(i==0){
					tempExp=temp[i].substring(1, temp[i].length());
				}else if(i==temp.length-1){
					tempExp=temp[i].substring(0, temp[i].length()-1);
				}else{
					tempExp=temp[i];
				}
				rst = PatternMatch.processExp(billId, tempExp);
				tempList.add("" + rst);
				if(i!=temp.length-1){
					tempList.add("||");
				}
			}
			
			return tempList;
		}
		
		// new-add
		index = exp.indexOf(")&&(");
		String frontExp = exp.substring(1, index);
		operChar = exp.substring(index + 1, index + 3);
		String behindExp = exp.substring(index + 4, exp.length() - 1);
		
		//处理特殊情况的嵌套)&&(和)||(表达式
		if (PatternMatch.isSpecialExp(frontExp)) {
			rst=ExtPatternMatch.processExp(billId, frontExp);
		}else{
			rst = PatternMatch.processExp(billId, frontExp);
		}
		
		
		list.add("" + rst);
		list.add(operChar);
		
		//防止嵌套)&&(和)||(
		//exp="(S(v,L(v)-1,1)!='4')&&((S(v,L(v)-4,1)=='4'&&S(v,L(v)-3,1)!='4')||(S(v,L(v)-4,1)!='4'&&S(v,L(v)-3,1)!='4'))";
		if (PatternMatch.isSpecialExp(behindExp)) {
			//behindExp=(S(v,L(v)-4,1)=='4'&&S(v,L(v)-3,1)!='4')||(S(v,L(v)-4,1)!='4'&&S(v,L(v)-3,1)!='4')
			rst=ExtPatternMatch.processExp(billId, behindExp);
		}else{
			rst = PatternMatch.processExp(billId, behindExp);
		}
		
		list.add("" + rst);

		// (S(v,L(v)-3,1)=='4'||S(v,L(v)-2,1)=='4')&&(S(v,L(v)-3,3)!='678')
		// index = ExtPatternMatch.getSplitIndex(exp);// 第一次分割位置

		// while (index != 0) {
		// str = exp.substring(1, index);
		// operChar = exp.substring(index + 1, index + 3);
		// rst = PatternMatch.processExp(billId, str);
		// exp = exp.substring(index + 3, exp.length());
		// list.add("" + rst);
		// list.add(operChar);
		// index = ExtPatternMatch.getSplitIndex(exp);
		// }

		// if (index == 0) {
		// rst = PatternMatch.processExp(billId, exp);
		// list.add("" + rst);
		// //System.out.println("分割完毕！");
		// }
		return list;
	}

	// 获取分割表达式的索引位置
	public static int getSplitIndex(String exp) {
		if (exp.contains("&&") || exp.contains("||")) {
			for (int i = 0; i < exp.length(); i++) {
				char c1 = exp.charAt(i);
				char c2 = exp.charAt(i + 1);
				if (c1 == ')' && c2 == '&') {
					return i;
				} else if (c1 == ')' && c2 == '|') {
					return i;
				}
			}
		}
		return 0;
	}

	// 计算结果
	public static boolean computeResult(String v1, String oper, String v2) throws Exception {
		if ("&&".equals(oper)) {
			if ("true".equals(v1) && "true".equals(v2))
				return true;
			else
				return false;
		} else if ("||".equals(oper)) {
			if ("false".equals(v1) && "false".equals(v2))
				return false;
			else
				return true;
		}
		return false;
	}

	public static boolean processBoolVar(String str) throws Exception {
		if ("false".equals(str)) {
			return false;
		} else if ("true".equals(str))
			return true;
		return false;
	}

	public static boolean isBooleanVar(String c) throws Exception {
		if ("false".equals(c) || "true".equals(c))
			return true;
		return false;
	}

	public static boolean isLogicOperator(String c) throws Exception {
		if ("&&".equals(c) || "||".equals(c))
			return true;
		return false;
	}
}
