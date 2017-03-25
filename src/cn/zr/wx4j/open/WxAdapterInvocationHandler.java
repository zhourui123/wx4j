package cn.zr.wx4j.open;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class WxAdapterInvocationHandler implements InvocationHandler {
	private Object proxied;

	public WxAdapterInvocationHandler(Object proxied) {
		this.proxied = proxied;

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Object result = null;
		if (method.getName().contains("send")) {
			// 获得参数，处理加密

			System.out.println("调用前" + method.getName() + "！！！");
			Arrays.toString(args);
			result = method.invoke(proxied, args);
			System.out.println("调用后！！！");
		} else {
			System.out.println("代理执行:"+method.getName());
			result = method.invoke(proxied, args);
		}

		return result;
	}

}
