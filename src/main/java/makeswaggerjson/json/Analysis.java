package makeswaggerjson.json;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/11/26.
 */
public class Analysis {
    private Logger logger = Logger.getLogger(Analysis.class);
    Json json = null;

    public Analysis(Json json){
        this.json = json;
    }

    public void setData(String data,String key){
        json.dataToSwagger(data, key);
    }
}
