package springboottest.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/11.
 */
@RestController // shorthand for @Controller and @ResponseBody rolled together
@RequestMapping("/test")
public class TestGetData {
    @RequestMapping(value = "/getTaskList")
    public JSONObject getTaskList(@RequestBody String info1){
        JSONObject obj1 = JSON.parseObject(info1);
        System.out.println(obj1);
        return obj1;
    }
}
