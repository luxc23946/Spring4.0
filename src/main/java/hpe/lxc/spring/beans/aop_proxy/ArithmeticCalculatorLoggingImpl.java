package hpe.lxc.spring.beans.aop_proxy;

/**
 * 带日志记录的实现
 *  缺点 
 *     ①代码混乱:越来越多的非业务需求(日志和验证等)加入后, 原有的业务方法急剧膨胀.每个方法在处理核心逻辑的同时还必须兼顾其他多个关注点.
 *     ②代码分散:以日志需求为例,只是为了满足这个单一需求, 就不得不在多个模块（方法）里多次重复相同的日志代码. 如果日志需求发生变化, 必须修改所有模块.
 * @author Administrator
 */
public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		//日志开始
		System.out.println("The method add begins with ["+i+","+j+"]"); 
		
		int result=i+j;
		//日志结束
		System.out.println("The method add ends with "+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		//日志开始
		System.out.println("The method sub begins with ["+i+","+j+"]");
		
		int result=i-j;
		//日志结束
		System.out.println("The method sub ends with "+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		//日志开始
		System.out.println("The method mul begins with ["+i+","+j+"]");
		
		int result=i*j;
		//日志结束
		System.out.println("The method mul ends with "+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		//日志开始
		System.out.println("The method div begins with ["+i+","+j+"]");
		
		int result=i/j;
		//日志结束
		System.out.println("The method div ends with "+result);
		return result;
	}

}
