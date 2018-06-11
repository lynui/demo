package self.demo.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;




public class HttpClientUtil {

  public static void main(String arg[]) throws Exception {
    String url = "test.com";
    JSONObject params = new JSONObject();
    params.put("SRC_STM_CODE", "wsf");
    params.put("TENANT_ID", "123");
    params.put("NM", "张三");
    params.put("BRTH_DT", "1983-01-20");
    params.put("GND_CODE", "1");
    JSONArray params2 = new JSONArray();
    JSONObject param3 = new JSONObject();
    param3.put("DOC_TP_CODE", "10100");
    param3.put("DOC_NBR", "100200198301202210");
    param3.put("DOC_CUST_NM", "test");
    params2.add(param3);
    params.put("DOCS", params2);
    String ret = doPost(url, params).toString();
    System.out.println(ret);
  }

  /**
   * post请求
   * @param url
   * @param json
   * @return
   */
  
  public static JSONObject doPost(String url,JSONObject json){
	  HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost(url);
    JSONObject response = null;
    try {
      StringEntity s = new StringEntity(json.toString());
      s.setContentEncoding("utf-8");
      s.setContentType("application/json");//发送json数据需要设置contentType
      post.setEntity(s);
      HttpResponse res = client.execute(post);
      if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
        HttpEntity entity = res.getEntity();
        String result = EntityUtils.toString(res.getEntity());// 返回json格式：
        response = JSONObject.fromObject(result);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return response;
  }


}