/**
 * 
 */
package self.demo.framework.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liufei45
 *
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
public @interface MointerLog {
	
	/**
	 * 平台
	 * @return
	 */
	String platform() default "";
	
	/**
	 * 接口名称
	 * @return
	 */
	String interfaceName() default "";
}
