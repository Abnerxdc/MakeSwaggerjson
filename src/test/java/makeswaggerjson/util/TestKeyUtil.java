package makeswaggerjson.util;

import junit.framework.TestCase;
import makeswaggerjson.core.AppInit;
import makeswaggerjson.json.Analysis;
import makeswaggerjson.json.Json;
import makeswaggerjson.json.JsonObjectDeal;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/11.
 */
public class TestKeyUtil extends TestCase{
    Json json = null;
    Analysis sis = null;
    @Before
    public void setUp()throws Exception{
        super.setUp();
        AppInit.initApp();
        json = new JsonObjectDeal();
        sis = new Analysis(json);
    }

    @Test
    public void testGetOldKey(){
        String newKey = "aaa_temp_12";
        System.out.println(KeyUtil.getOldKey(newKey));
        String newKey1 = "aaa_bbb_ccc_temp_113451";
        System.out.println(KeyUtil.getOldKey(newKey1));
    }
}
