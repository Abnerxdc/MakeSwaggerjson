package makeswaggerjson.ListOrMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import makeswaggerjson.core.AppInit;
import makeswaggerjson.json.Analysis;
import makeswaggerjson.json.Json;
import makeswaggerjson.json.JsonArrayDeal;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/11.
 */
public class TestList extends TestCase {
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
    public void testList(){
        List list = new ArrayList();
        list.add("asd");
        list.add("123");
        JSONObject obj = new JSONObject();
        obj.put("123",list);
        String s = obj.toString();
        JSONObject re = JSON.parseObject(s);
        System.out.println(re.get("123").getClass().getName());
    }
    @Test
    public void testMap(){
        Map map = new HashMap<String,String>();
        map.put("asd","sdf");
        System.out.println(map);
        JSONObject obj = new JSONObject();
        obj.put("123",map);
        String s = obj.toString();
        System.out.println(s);
        JSONObject re = JSON.parseObject(s);
        System.out.println(re);
        System.out.println(re.get("123").getClass().getName());
    }

    @Test
    public void testListToArr(){
        List list = new ArrayList();
        list.add("asd");
        list.add("123");
        String s = list.toString();
        JSONArray arr = new JSONArray();
        arr.add(123);
        JSONObject obj = new JSONObject();
        obj.put("asd",s);
        obj.put("arr",arr.toString());
        System.out.println(s);
//        System.out.println(JSON.parseArray(obj.get("asd").toString()));
        String ss = obj.toString();
        JSONObject aa = JSON.parseObject(ss);
        System.out.println(aa.get("arr").getClass().getName());
        System.out.println(JSON.parseArray(aa.get("asd").toString()));
    }
    @Test
    public void testObj(){
        String a = "{\n" +
                "    \"describe\": \" \",\n" +
                "    \"type\": \"object\",\n" +
                "    \"properties\": {\n" +
                "      \"kaka\": {\n" +
                "        \"type\": \"array\",\n" +
                "        \"$ref\": \"#/definitions/kaka_temp_1\"\n" +
                "      }\n" +
                "    }\n" +
                "  }";
        JSONObject obj = JSON.parseObject(a);
        System.out.println(obj.get("properties").getClass().getName());
    }
}
