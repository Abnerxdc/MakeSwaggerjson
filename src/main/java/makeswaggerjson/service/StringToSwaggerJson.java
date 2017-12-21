package makeswaggerjson.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import makeswaggerjson.core.AppInit;
import makeswaggerjson.core.ConfigManager;
import makeswaggerjson.deport.Result;
import makeswaggerjson.json.Analysis;
import makeswaggerjson.json.Json;
import makeswaggerjson.json.JsonArrayDeal;
import makeswaggerjson.json.JsonObjectDeal;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/12/11.
 */
public class StringToSwaggerJson {
    /**
     * 程序入口函数
     * @param data
     */
    public void startAnalysis(String data){
        try{
            AppInit.initApp();
        }catch (Exception e){
            System.out.println("程序初始化失败，异常退出！");
            e.printStackTrace();
        }

        Json json = null;
        Logger logger = Logger.getLogger(StringToSwaggerJson.class);
        if(data.startsWith("[")&&data.endsWith("]")){
            try{
                logger.info("analysis input is a array...");
                JSONArray arr = JSON.parseArray(data);
                json = new JsonArrayDeal();
                Analysis analysis = new Analysis(json);
                analysis.setData(data, ConfigManager.getInstance().getStartKey());
            }catch (Exception e){
                logger.error("暂不提供传入参数是个list的支持");
            }
        }else if(data.startsWith("{")&&data.endsWith("}")){
            try{
                logger.info("analysis input is a object...");
                JSONObject obj = JSON.parseObject(data);
                json = new JsonObjectDeal();
                Analysis analysis = new Analysis(json);
                analysis.setData(data, ConfigManager.getInstance().getStartKey());
            }catch (Exception e){
                logger.error("暂不提供传入参数是个map的支持");
            }
        }
    }

    /**
     * 程序结果函数
     * @return
     */
    public JSONObject getEndJson(){
        JSONObject obj = Result.getInstance().getResultObj();
        return obj;
    }
}
