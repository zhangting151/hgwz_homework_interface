package qyweixin.qyapi.user;

import org.junit.BeforeClass;
import org.junit.Test;
import qyweixin.qyapi.QiYeWeiXin;

import java.io.IOException;
import java.util.Date;

public class User extends QiYeWeiXin {

    @BeforeClass
    public static void createDepartmentBefore() throws IOException {
        logger.info("User before~");
        Date date = new Date();
        Long nowtime = date.getTime()/1000;
        if (nowtime < expired_out){
            logger.info("token在有效时间内，可以执行用例");
        }else{
            logger.info("token不在有效时间内，需要重新获取");
        }
    }

}
