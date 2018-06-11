/**
 * 
 */
package self.demo.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import self.demo.model.Geo;
import self.demo.model.Page;
import self.demo.model.SurroundHotelRequest;
import self.demo.utils.HttpClientUtil;

/**
 * @author liufei45
 *
 */
public class TestDemoController {
	@Test
	public void testQuerySurroundHotel() {

		String url = "http://127.0.0.1:8080/demo-web/demoService/demo/querySurroundHotel";
		Geo geo = new Geo();
		geo.setLng(191.446014);
		geo.setLat(31.215937);
		geo.setDistance(5000000d);
		Page page = new Page();
		page.setSize(3);
		page.setStartNo(3);
		SurroundHotelRequest surroundHotelRequest = new SurroundHotelRequest();
		surroundHotelRequest.setGeo(geo);
		surroundHotelRequest.setPage(page);
	    //params.put("page", page);
		JSONObject jsonObject = HttpClientUtil.doPost(url, JSONObject.fromObject(surroundHotelRequest));
	    System.out.println("status:"+jsonObject.get("status"));
		System.out.println("message:"+jsonObject.get("message"));
		JSONArray jsonArrays = jsonObject.getJSONArray("data");
		if(jsonArrays!=null){
			for(int i=0;i<jsonArrays.size();i++){  
                JSONObject jsonobject = jsonArrays.getJSONObject(i); 
                System.out.println(jsonobject.toString());
            } 
		}
		
		System.out.println(jsonObject.toString());
	}
}
