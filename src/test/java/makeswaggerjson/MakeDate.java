package makeswaggerjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * Created by Administrator on 2017/11/26.
 */
public class MakeDate {
    @Test
    public void makeData(){
        JSONObject object = new JSONObject();
        object.put("username","abner");
        JSONArray arr = new JSONArray();
        arr.add("age");
        arr.add("sex");
        object.put("arr",arr);
        System.out.println(object.toJSONString());
        System.out.println(object.get("arr"));
        System.out.println(arr);
        List list = new ArrayList<String>();
        list.add("aaaa");
        list.add("bbbb");
        object.put("list",list);
//        JSONArray listArr = JSONArray.parseArray(list.toString());
        System.out.println(list);
        System.out.println(object);
        System.out.println(object.get("list"));
//        System.out.println(listArr);
    }

    @Test
    public void testSubString(){
        String data = "[aaaa, bbbb]";
        System.out.println(data.substring(1));
        System.out.println(data.substring(1,data.length()-1));

        JSONArray arr = new JSONArray();
        arr.add("age");
        arr.add("sex");
        System.out.println(arr);
        if(arr.toString().substring(1).startsWith("\"")&&arr.toString().substring(arr.toString().length()-2,arr.toString().length()-1).equals("\"")){
            System.out.println("this is array");
        }

        JSONArray intArr = new JSONArray();
        intArr.add(12);
        intArr.add("aaa");
        System.out.println(intArr);
    }

    @Test
    public void testListObject(){
        List list = new ArrayList();
        Map map = new HashMap<String,String>();
        map.put("name","Abner");
        list.add(map);
        JSONObject obj = new JSONObject();
        obj.put("age","21");
        list.add(obj);
        List list1 = new ArrayList();
        list1.add("aaa");
        list1.add("bbb");
        list.add(list1);
        System.out.println(list);
    }
    @Test
    public void testAAA(){
        JSONObject obj = new JSONObject();
        obj.put("aaa",123);
        JSONArray arr = new JSONArray();
        obj.put("aaa",arr);
        System.out.println(obj.get("aaa").getClass().getName());
        System.out.println(obj);
        arr.add(123);
        for(Object obj2 : arr){
            System.out.println(obj2.getClass().getName());
        }
    }
}
