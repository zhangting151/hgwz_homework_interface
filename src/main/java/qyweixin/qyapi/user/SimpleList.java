package qyweixin.qyapi.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import qyweixin.beans.HttpTestStep;
import qyweixin.qyapi.QiYeWeiXin;
import qyweixin.qyapi.department.ListDepartment;
import qyweixin.utils.HttpTestRun;
import qyweixin.utils.ReadFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RunWith(Parameterized.class)
public class SimpleList extends User{

    public static String paramsFile = "user/SimpleList.yaml";
    public static String paramsFilePath = new File(QiYeWeiXin.class.getResource("../../qyapiCases/" + paramsFile).getFile()).getAbsolutePath();

    @Parameterized.Parameters
    public static List<HttpTestStep> cases() throws IOException {
        return ReadFile.readYamls(paramsFilePath);
    }

    @Parameterized.Parameter
    public HttpTestStep data;

    @Test
    public void test(){
        logger.info("当前测试接口为 /user/simplelist ");
        HttpTestRun.runWithToken(data, access_token);
    }

}
