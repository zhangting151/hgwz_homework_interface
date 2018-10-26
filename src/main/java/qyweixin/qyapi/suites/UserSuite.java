package qyweixin.qyapi.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import qyweixin.qyapi.user.AddUser;
import qyweixin.qyapi.user.SimpleList;
import qyweixin.qyapi.user.UserList;

@RunWith(Suite.class)
@Suite.SuiteClasses({ AddUser.class, SimpleList.class, UserList.class})
public class UserSuite {

}
