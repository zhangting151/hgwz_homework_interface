package qyweixin.qyapi.department;

import org.junit.BeforeClass;
import qyweixin.qyapi.QiYeWeiXin;
import java.io.IOException;
import java.util.Date;

public class Department extends QiYeWeiXin{

    @BeforeClass
    public static void createDepartmentBefore() throws IOException {
        logger.info("department before~");
        Date date = new Date();
        Long nowtime = date.getTime()/1000;
        if (nowtime < expired_out){
            System.out.println("token在有效时间内，可以执行用例");
         }else{
            System.out.println("token不在有效时间内，需要重新获取");
        }
    }
}
