package makeswaggerjson.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import makeswaggerjson.core.ConfigManager;
import makeswaggerjson.deport.Result;
import makeswaggerjson.util.KeyUtil;
import org.apache.log4j.Logger;


/**
 * Created by Administrator on 2017/11/26.
 * @author xudacheng
 */
public class JsonArrayDeal implements Json{
    Logger logger = Logger.getLogger(JsonArrayDeal.class);
    @Override
    public void dataToSwagger(String data,String key){
        JSONObject resultObj = new JSONObject();
        JSONArray arr = JSON.parseArray(data);
        JSONObject tag = new JSONObject();
        tag.put("type","array");
        tag.put("describe"," ");
        if(analysisArrIsOneType(data)){
            tag.put("items", analysisArrayObjectDataType(data, KeyUtil.getOldKey(key)));
        }else {
            logger.error("array 里面多种数据类型的暂不提供服务");
        }
        Result.getInstance().setResultObj(key,tag);
    }
    /**
     * 处理JSONArray中的各种可能出现的类型
     * @param data
     * @param key
     * @return
     */
    public JSONObject analysisArrayObjectDataType(String data, String key){
        JSONObject returnObj = new JSONObject();
        JSONArray arr = JSON.parseArray(data);
        String dataType = arr.get(0).getClass().getName();

        if (!dataType.isEmpty() || dataType != null) {
            if (ConfigManager.getInstance().getDateTypeInteger().equals(dataType)) {
                returnObj.put("type","integer");
                returnObj.put("format","int64");
                returnObj.put("enum",arr.toString());
            } else if (ConfigManager.getInstance().getDateTypeDate().equals(dataType)) {
                returnObj.put("type","string");
                returnObj.put("enum",arr.toString());
            } else if (ConfigManager.getInstance().getDateTypeJSONArray().equals(dataType)) {
                logger.error("暂不支持Array里面是Array");
            }else if (ConfigManager.getInstance().getDateTypeJSONObject().equals(dataType)) {
                for(Object ss : arr){
                    Result.getInstance().setRecord();
                    returnObj.put("$ref","#/definitions/"+key+"_array_temp_"+Result.getInstance().getRecord());
                    JsonObjectDeal dealObj = new JsonObjectDeal();
                    Analysis analysis = new Analysis(dealObj);
                    analysis.setData(ss.toString(),key+"_array_temp_"+(Result.getInstance().getRecord()));
                }
            }else {
                returnObj.put("type","string");
                returnObj.put("enum",arr);
            }
        }
        return returnObj;
    }
    /**
     * 检测array里面是否为单一数据类型
     * @param data
     * @return
     */
    public boolean analysisArrIsOneType(String data){
        JSONArray arr = JSON.parseArray(data);
        boolean result = true;
        if(arr.size()>0){
            arr.get(0);
            String dataType = arr.get(0).getClass().getName();
            for (int i=0;i<arr.size();i++) {
                String curDataType = arr.get(i).getClass().getName();
                if(!dataType.equals(curDataType)){
                    result = false;
                }
            }
        }else {
            logger.error("array can not be empty!");
        }
        return result;
    }
}
