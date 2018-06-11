/**
 * 
 */
package self.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import self.demo.controller.service.DomoService;
import self.demo.framework.aop.MointerLog;
import self.demo.model.SurroundHotelRequest;

/**
 * @author fei45
 *
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private DomoService domoService;
	/**
	 * 获取周边酒店信息
	 * @param surroundHotelRequest
	 * @return
	 */
	@RequestMapping(value = "/querySurroundHotel", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> querySurroundHotel( @RequestBody SurroundHotelRequest surroundHotelRequest,String uuid) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		//mointerLogTest();
		domoService.test1();
		return returnMap;
	}
	
	@MointerLog(platform="switch")
	private void mointerLogTest(){
		
	}
}
