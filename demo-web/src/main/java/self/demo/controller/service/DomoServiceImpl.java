/**
 * 
 */
package self.demo.controller.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

import self.demo.framework.aop.MointerLog;

/**
 * @author liufei45
 *
 */
@Component("domoService")
public class DomoServiceImpl implements DomoService{
	
	
	public int test1(){
		if(null != AopContext.currentProxy()){  
            ((DomoService)AopContext.currentProxy()).test2();  
        }else{  
        	test2();  
        } 
		return 0;
	}

	@MointerLog(platform="switch")
	public int test2(){
		return 0;
	}
}
