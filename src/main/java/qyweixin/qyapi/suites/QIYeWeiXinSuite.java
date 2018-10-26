package qyweixin.qyapi.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import qyweixin.qyapi.suites.DepartmentSuite;
import qyweixin.qyapi.suites.UserSuite;
import qyweixin.qyapi.user.AddUser;
import qyweixin.qyapi.user.SimpleList;
import qyweixin.qyapi.user.UserList;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DepartmentSuite.class, UserSuite.class})
public class QIYeWeiXinSuite {

}
