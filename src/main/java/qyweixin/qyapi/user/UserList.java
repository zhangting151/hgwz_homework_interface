package qyweixin.qyapi.user;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import qyweixin.beans.HttpTestStep;
import qyweixin.qyapi.department.ListDepartment;
import qyweixin.utils.HttpTestRun;
import qyweixin.utils.ReadFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RunWith(Parameterized.class)
public class UserList extends User{

    @Parameterized.Parameters
    public static List<HttpTestStep> dataCSV() throws IOException {
        return ReadFile.readYamls(new File(ListDepartment.class.getResource("../../../qyapiCases/user/UserList.yaml").getFile()).getAbsolutePath());
    }

   @Parameterized.Parameter
   public HttpTestStep data;

    @Test
    public void test(){
        logger.info("当前测试接口为 /user/list");
        HttpTestRun.runWithToken(data, access_token);
    }
}
