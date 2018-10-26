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
import java.util.List;

import static qyweixin.qyapi.QiYeWeiXin.expired_out;

@RunWith(Parameterized.class)
public class ListDepartment extends Department {

    public static String paramsFile = "department/ListDepartment.yaml";
    public static String paramsFilePath = new File(QiYeWeiXin.class.getResource("../../qyapiCases/" + paramsFile).getFile()).getAbsolutePath();

    @Parameterized.Parameters
    public static List<HttpTestStep> cases() throws IOException {
        return ReadFile.readYamls(paramsFilePath);
    }

    @Parameterized.Parameter
    public HttpTestStep data;

    @Test
    public void test(){
        logger.info("当前测试接口为/department/list");
        HttpTestRun.runWithToken(data, access_token);
    }
    /*
    static List<HttpTestStep> testcase;

    @BeforeClass
    public static void createDepartmentBefore() throws IOException {
        testcase = ReadFile.readYamls(new File(ListDepartment.class.getResource("../../../qyapiCases/department/ListDepartment.yaml").getFile()).getAbsolutePath());

    }

    @Test
    public void tt() {
         HttpTestRun.runWithToken(testcase,access_token);
    }  */
}
