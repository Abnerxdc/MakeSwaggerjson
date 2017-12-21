package makeswaggerjson;

import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import makeswaggerjson.service.StringToSwaggerJson;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/20.
 */
public class TestStringToSwaggerJson extends TestCase{
    @Test
    public void testStringToSwaggerJson(){
        StringToSwaggerJson ssj = new StringToSwaggerJson();
        JSONObject tagObj = new JSONObject();
        tagObj.put("name","abner");
        tagObj.put("id",24);
        JSONObject oo = new JSONObject();
        oo.put("kaka",tagObj);
        JSONObject more = new JSONObject();
        more.put("kaka",oo);
        ssj.startAnalysis(more.toString());
        System.out.println(ssj.getEndJson());
    }
}
