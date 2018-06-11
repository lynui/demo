/**
 * 
 */
package self.demo.framework.aop;

import java.lang.reflect.Method;
import java.util.Date;

import net.sf.json.JSONObject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 日志监控
 * @author liufei45
 * 拦截方法的只能有一个参数
 * 拦截方法的返回对象必须为json串或含有属性status、message的对象
 */
@Aspect
@Component
public class MointerLogAOP {
	
	@Pointcut(value = "@annotation(self.demo.framework.aop.MointerLog)")
	private void mointerLog() {
	}
	
	
	@Around(value = "mointerLog()")
	public Object aroundMointerLog(ProceedingJoinPoint joinPoint)
			throws Throwable {
		MethodSignature methodSignature = (MethodSignature) joinPoint
				.getSignature();
		Method method = methodSignature.getMethod();
		Object[] args = joinPoint.getArgs();
		String[] argNames = methodSignature.getParameterNames();
		String platform = method.getAnnotation(MointerLog.class).platform();
		String interfaceName =  method.getAnnotation(MointerLog.class).interfaceName();
		for (int i = 0; i < args.length; i++) {
			String argName = argNames[i];
			if("uuid".equals(argName)){
				if(null==args[i]){
					args[i] = "testuuid";
				}
			}
		}
		System.out.println("desc:"+platform+">> methodName:"+method.getName());
		System.out.println("interfaceName:"+interfaceName);
		
		long startTime=System.currentTimeMillis();   //获取开始时间
		Date curDate = new Date(startTime);
		System.out.println("curDate:"+curDate);
		Object returnObj = joinPoint.proceed(args);
		JSONObject jsonObject = JSONObject.fromObject(returnObj);
		
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		System.out.println(JSONObject.fromObject(returnObj).toString());
		return returnObj;
	}
}
