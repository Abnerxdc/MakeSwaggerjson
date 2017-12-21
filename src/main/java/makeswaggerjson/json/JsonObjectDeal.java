package makeswaggerjson.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import makeswaggerjson.core.ConfigManager;
import makeswaggerjson.deport.Result;

/**
 * Created by Administrator on 2017/11/26.
 * @author xudacheng
 */
public class JsonObjectDeal implements Json{
//    static JSONObject resultObj = new JSONObject();

//    static int record = 1 ;
    @Override
    public void dataToSwagger(String data,String key){
        Result.getInstance().setRecord();
        JSONObject tag = new JSONObject();
        tag.put("type","object");
        tag.put("describe"," ");
        JSONObject propertiesObj = new JSONObject();
        JSONObject obj = JSON.parseObject(data);
        for(String curKey : obj.keySet()){
            propertiesObj.put(curKey,analysisJsonObjectDataType(obj,curKey));
        }
        tag.put("properties",propertiesObj);
        Result.getInstance().setResultObj(key,tag);
    }

    /**
     * 处理JSONObject中的各种可能出现的类型
     * @param obj
     * @param key
     * @return
     */
    public JSONObject analysisJsonObjectDataType(JSONObject obj , String key) {
        JSONObject returnObj = new JSONObject();
        String dataType = obj.get(key).getClass().getName();

        if (!dataType.isEmpty() || dataType != null) {
            if (ConfigManager.getInstance().getDateTypeInteger().equals(dataType)) {
                returnObj.put("type","integer");
                returnObj.put("format","int64");
                returnObj.put("example",obj.get(key));
                returnObj.put("describe"," ");
            } else if (ConfigManager.getInstance().getDateTypeDate().equals(dataType)) {
                returnObj.put("type","string");
                returnObj.put("example",obj.getString(key));
                returnObj.put("describe"," ");
            } else if (ConfigManager.getInstance().getDateTypeJSONArray().equals(dataType)) {
                returnObj.put("type","array");
                returnObj.put("$ref","#/definitions/"+key+"_temp_"+Result.getInstance().getRecord());
                JsonArrayDeal dealObj = new JsonArrayDeal();
                Analysis analysis = new Analysis(dealObj);
                analysis.setData(obj.getString(key),key+"_temp_"+(Result.getInstance().getRecord()));
            }else if (ConfigManager.getInstance().getDateTypeJSONObject().equals(dataType)) {
                returnObj.put("$ref","#/definitions/"+key+"_temp_"+Result.getInstance().getRecord());
                JsonObjectDeal dealObj = new JsonObjectDeal();
                Analysis analysis = new Analysis(dealObj);
                analysis.setData(obj.getString(key),key+"_temp_"+(Result.getInstance().getRecord()));
            }else {
                returnObj.put("type","string");
                returnObj.put("example",obj.get(key));
                returnObj.put("describe"," ");
            }
        }
        return returnObj;
    }
}
