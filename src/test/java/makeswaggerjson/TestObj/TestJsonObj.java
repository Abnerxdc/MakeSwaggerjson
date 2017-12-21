package makeswaggerjson.TestObj;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import makeswaggerjson.core.AppInit;
import makeswaggerjson.deport.Result;
import makeswaggerjson.json.Analysis;
import makeswaggerjson.json.Json;
import makeswaggerjson.json.JsonObjectDeal;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/8.
 */
public class TestJsonObj extends TestCase{
    Json json = null;
    Analysis sis = null;
    @Before
    public void setUp()throws Exception{
        super.setUp();
        AppInit.initApp();
        json = new JsonObjectDeal();
        sis = new Analysis(json);
    }
    @Test
    public void testCreateJson (){
        JSONObject tagObj = new JSONObject();
        tagObj.put("name","abner");
        tagObj.put("id",24);
        System.out.println(tagObj.toString());
//        System.out.println(sis.setData(tagObj.toString(),"Tag"));
    }
    @Test
    public void testCreateMoreJson (){
        JSONObject tagObj = new JSONObject();
        tagObj.put("name","abner");
        tagObj.put("id",24);
        JSONObject oo = new JSONObject();
        oo.put("kaka",tagObj);
//        System.out.println(sis.setData(oo.toString(),"oo"));
    }
    @Test
    public void testCreateMoreEastJson (){
        JSONObject tagObj = new JSONObject();
        tagObj.put("name","abner");
        tagObj.put("id",24);
        JSONObject oo = new JSONObject();
        oo.put("kaka",tagObj);
        JSONObject more = new JSONObject();
        more.put("kaka",oo);
        String a = more.toString();
        sis.setData(a,"more");
        System.out.println(Result.getInstance().getResultObj());
    }
    @Test
    public void testArrayAndObject (){
        JSONArray arr = new JSONArray();
        arr.add("1234");
        arr.add("id");
        JSONObject oo = new JSONObject();
        oo.put("kaka",arr);
        sis.setData(oo.toString(),"oo");
        System.out.println(Result.getInstance().getResultObj());
    }
    @Test
    public void testMoreArrayAndObject (){
        JSONObject obj = new JSONObject();
        obj.put("aa","bb");
        JSONArray arr = new JSONArray();
        arr.add(obj);
        JSONObject oo = new JSONObject();
        oo.put("kaka",arr);
        sis.setData(oo.toString(),"oo");
        System.out.println(Result.getInstance().getResultObj());
    }
}
