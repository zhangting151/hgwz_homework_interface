package qyweixin.qyapi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import java.util.Date;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

public class QiYeWeiXin {

    public static String corpid = "ww9662399a44a04905";
    public static int parentid = 1;
    //通讯录同步助手  2mlog92suOsfZCmbPhGb4wcm6ogZWGCdgABmOPKQuYg
    public static String secret = "2mlog92suOsfZCmbPhGb4wcm6ogZWGCdgABmOPKQuYg"; //"A0_c0_i1gSbFzYllEtqogfJenJhFae12VTbAUSLOp-g";
    public static String getTokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+ corpid +"&corpsecret=" + secret;
    public static String access_token = "";
    public static Long expired_out = 0L;

    public static Logger logger = LogManager.getLogger("QiYeWeiXin");

    @BeforeClass
    public static void getToken(){

        logger.info("QiYeWeiXin before ~");
        Date date = new Date();
        Long nowTime = date.getTime()/1000;

        String res = given().
                get(getTokenUrl).
                then().log().all().
                extract().response().asString();

        int expired_in = from(res).getInt("expires_in");
        access_token = from(res).getString("access_token");
       // int expired_in = 7000;
      //  access_token = "JSawzYvgP7Owb5diWE4ots4qQmjx3nh04a6qH1sF4jAWi_gX4bxjgm-DBPsTH-ztnJ3VWnqAT5j67tN_WUoSrMy3an06vc3dOyRPGF6BxRdZ-L7_p0W4U8ZKEF1k0LuOX3VPo0lic_YeNx4jZG-gE7s_0sPBBjVYtU5uXcxY2Q2aCKFnq_eknnBkaNjykv-JUiJxedFpMKWSbvdNjc9DQQ";
        expired_out = nowTime + expired_in;
        logger.info("access_token:" + access_token);


    }

}
