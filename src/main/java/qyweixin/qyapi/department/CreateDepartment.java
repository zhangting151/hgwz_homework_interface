package qyweixin.qyapi.department;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import qyweixin.beans.HttpTestStep;
import qyweixin.qyapi.QiYeWeiXin;
import qyweixin.utils.HttpTestRun;
import qyweixin.utils.ReadFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RunWith(Parameterized.class)
public class CreateDepartment extends Department {

    public static String paramsFile = "department/CreateDepartment.yaml";
    public static String paramsFilePath = new File(QiYeWeiXin.class.getResource("../../qyapiCases/" + paramsFile).getFile()).getAbsolutePath();

    @Parameterized.Parameters
    public static List<HttpTestStep> cases() throws IOException {
        return ReadFile.readYamls(paramsFilePath);
    }

    @Parameterized.Parameter
    public HttpTestStep data;

    @Test
    public void test(){
        logger.info("当前测试接口为/department/create ");
        System.out.println(data.description);
        HttpTestRun.runWithToken(data, access_token);
    }
}
