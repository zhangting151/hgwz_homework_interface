package qyweixin.qyapi.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import qyweixin.qyapi.department.CreateDepartment;
import qyweixin.qyapi.department.ListDepartment;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CreateDepartment.class, ListDepartment.class})
public class DepartmentSuite {
    
}
