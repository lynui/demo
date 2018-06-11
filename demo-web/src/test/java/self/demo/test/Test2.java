package self.demo.test;  
  
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
public class Test2  
{  
        public static void main(String[] args) throws Exception  
        {  
                String expr = "A*(C+B/100)";  
                ScriptEngineManager manager = new ScriptEngineManager();  
                ScriptEngine engine = manager.getEngineByName("js"); 
                engine.put("A", 30);
                engine.put("B", 11);  
                engine.put("C", 0);  
                expr = expr.replaceAll("A", "30.0").replaceAll("B", "11.0").replaceAll("C", "11.0");
                Object result = engine.eval(expr);  
                double d = Double.parseDouble(result.toString());
                double d2 = 30.0*(11.00+11.00/100);
               System.out.println(d2+"=="+d+"=="+result);  
        }  
} 