package makeswaggerjson.deport;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2017/12/11.
 * @author xudacheng
 */
public class Result {
    //ConfigManager实例对象

    private static Result mInstance;
    public static Result getInstance() {
        if (mInstance == null) {
            synchronized (Result.class) {
                if (mInstance == null) {
                    mInstance = new Result();
                }
                return mInstance;
            }
        }
        return mInstance;
    }

    private static JSONObject resultObj = new JSONObject();
    /**
     * 防重复key 处理
     */
    private static int record = 0;
    public JSONObject getResultObj(){
        return resultObj;
    }
    public void setResultObj(String key,Object value){
        resultObj.put(key,value);
    }
    public String getRecord(){
        return record+"";
    }
    public void setRecord(){
        record++;
    }
}
