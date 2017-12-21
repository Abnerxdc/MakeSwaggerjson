package makeswaggerjson.core;


import makeswaggerjson.util.PropertiesUtil;
import org.apache.log4j.Logger;


import java.util.Properties;

/**
 * Created by Administrator on 2017/6/16.
 */
public class ConfigManager {
    private static Logger logger = Logger.getLogger(ConfigManager.class);

    //配置文件全路径
    private static String mConfPath = "";

    //ConfigManager实例对象
    private static ConfigManager mInstance;

    //c3p0.properties配置文件解析
    private Properties mAppProps;

    //application.properties配置文件解析
    private Properties mBppProps;

    /**
     * 获取配置文件路径
     * @return String
     */
    public static void setConfPath(String iConfPath){
        mConfPath = iConfPath;
    }
    /**
     * 获取ConfigManager单例对象
     *
     * @return ConfigManager
     */
    public static ConfigManager getInstance() {
        if (mInstance == null) {
            synchronized (ConfigManager.class) {
                if (mInstance == null) {
                    mInstance = new ConfigManager();
                }
                return mInstance;
            }
        }
        return mInstance;
    }
    /**
     * 构造ConfigManager，解析读取相关properties配置文件
     */
    private ConfigManager(){
        logger.info("start init ConfigManager.");
        try{
            mBppProps = PropertiesUtil.loadPropsFile(mConfPath+"/application.properties");
        }catch (Exception e){
            logger.error("init ConfigManager failed! "+e.getMessage());
        }
    }
    public Properties getmAppProps(){
        return mAppProps;
    }

    /**
     * 从配置文件读取几种数据类型 以下几种
     * @return
     */
    public String getDateTypeDate(){
        String dateTypeDate = mBppProps.getProperty("dateTypeDate").toString();
        return dateTypeDate;
    }
    public String getDateTypeInteger(){
        String dateTypeInteger = mBppProps.getProperty("dateTypeInteger").toString();
        return dateTypeInteger;
    }
    public String getDateTypeJSONArray(){
        String dateTypeJSONArray = mBppProps.getProperty("dateTypeJSONArray").toString();
        return dateTypeJSONArray;
    }
    public String getDateTypeJSONObject(){
        String dateTypeJSONObject = mBppProps.getProperty("dateTypeJSONObject").toString();
        return dateTypeJSONObject;
    }
    public String getStartKey(){
        String startKey = mBppProps.getProperty("startKey").toString();
        return startKey;
    }
    /**
     *
     * @return
     */
    public String getStartId(){
        String startId = mBppProps.getProperty("startId").toString();
        return startId;
    }

    public String getEndId(){
        String endId = mBppProps.getProperty("endId").toString();
        return endId;
    }
}
