cd C:\Users\RC_Student_lab\Documents\NetBeansProjects\Login; "JAVA_HOME=C:\\Program Files\\Java\\jdk-21" cmd /c "\"C:\\Program Files\\NetBeans-19\\netbeans\\java\\maven\\bin\\mvn.cmd\" -Dtest=com.mycompany.login.LogInClassTest \"-Dmaven.ext.class.path=C:\\Program Files\\NetBeans-19\\netbeans\\java\\maven-nblib\\netbeans-eventspy.jar\" --no-transfer-progress process-test-classes surefire:test"
Scanning for projects...

------------------------< com.mycompany:Login >-------------------------
Building Login 1.0-SNAPSHOT
  from pom.xml
--------------------------------[ jar ]---------------------------------

--- resources:3.3.1:resources (default-resources) @ Login ---
skip non existing resourceDirectory C:\Users\RC_Student_lab\Documents\NetBeansProjects\Login\src\main\resources

--- compiler:3.11.0:compile (default-compile) @ Login ---
Nothing to compile - all classes are up to date

--- resources:3.3.1:testResources (default-testResources) @ Login ---
skip non existing resourceDirectory C:\Users\RC_Student_lab\Documents\NetBeansProjects\Login\src\test\resources

--- compiler:3.11.0:testCompile (default-testCompile) @ Login ---
Nothing to compile - all classes are up to date

--- surefire:3.1.2:test (default-cli) @ Login ---
Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.mycompany.login.LogInClassTest
Username is not correct.
returnLoginStatus
Login successful.
Welcome John Doe. It's great to see you again!
loginUser
Login successful.
registerUser
checkPasswordComplexity
Password must be at least 8 characters long.
Login failed. Please check your password.
Password must be at least 8 characters long.
Password must be at least 8 characters long.
checkUserName
Tests run: 9, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.132 s -- in com.mycompany.login.LogInClassTest

Results:

Tests run: 9, Failures: 0, Errors: 0, Skipped: 0

------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  2.803 s
Finished at: 2024-09-29T18:47:07+02:00
------------------------------------------------------------------------
