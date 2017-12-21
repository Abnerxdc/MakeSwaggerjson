package makeswaggerjson.TestObj;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import makeswaggerjson.core.AppInit;
import makeswaggerjson.deport.Result;
import makeswaggerjson.json.Analysis;
import makeswaggerjson.json.Json;
import makeswaggerjson.json.JsonArrayDeal;
import makeswaggerjson.json.JsonObjectDeal;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/11.
 */
public class TestJsonArr extends TestCase {
    Json json = null;
    Analysis sis = null;
    @Before
    public void setUp()throws Exception{
        super.setUp();
        AppInit.initApp();
        json = new JsonArrayDeal();
        sis = new Analysis(json);
    }
    @Test
    public void testSetArr(){
        JSONArray arr = new JSONArray();
        arr.add(123);

        JSONObject obj = new JSONObject();
        arr.add(obj);
        System.out.println(arr.get(0));
        System.out.println(arr.toString());
    }
    @Test
    public void testCreateJson (){
        JSONArray arr = new JSONArray();
        arr.add(123);
        arr.add(234);
        sis.setData(arr.toString(),"arrxxxx");
        System.out.println(Result.getInstance().getResultObj());
    }
    @Test
    public void testArrayAndObj (){
        JSONObject tagObj = new JSONObject();
        tagObj.put("name","abner");
        tagObj.put("id",24);
        JSONArray arr = new JSONArray();
        arr.add(tagObj);
        sis.setData(arr.toString(),"oarro");
        System.out.println(Result.getInstance().getResultObj());
    }
    @Test
    public void testMoreArrayAndObj (){
        JSONArray arr = new JSONArray();
        arr.add("name");
        arr.add("id");
        JSONObject oo = new JSONObject();
        oo.put("kaka",arr);
        JSONArray more = new JSONArray();
        more.add(oo);
        String a = more.toString();
        sis.setData(a,"more");
        System.out.println(Result.getInstance().getResultObj());
    }
}
