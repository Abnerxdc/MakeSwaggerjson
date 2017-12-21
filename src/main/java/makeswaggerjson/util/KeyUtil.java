package makeswaggerjson.util;

/**
 * Created by Administrator on 2017/12/11.
 */
public class KeyUtil {
    public static String getOldKey(String newKey){
        String oldKey = "";
        String[] ss = newKey.split("_");
        if(ss.length>2){
            String record = ss[ss.length-1];
            String temp = ss[ss.length-2];
            int size = record.length()+temp.length()+2;
            oldKey = newKey.substring(0,newKey.length()-size);
        }else {
            oldKey = newKey;
        }
        return oldKey;
    }
}
