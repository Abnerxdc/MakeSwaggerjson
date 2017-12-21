package makeswaggerjson;

import makeswaggerjson.service.StringToSwaggerJson;

/**
 * Created by Administrator on 2017/11/26.
 * @author xudacheng
 */
public class Main {
    //程序入口在 StringToSwaggerJson
    //使用方法如下：
    // todo
    public static void main(String[] args){
        StringToSwaggerJson ssj = new StringToSwaggerJson();
        //传入数据
        ssj.startAnalysis("传入数据");
        //获取值
        System.out.println(ssj.getEndJson());
    }
}
