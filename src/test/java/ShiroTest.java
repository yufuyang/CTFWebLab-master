import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;


public class ShiroTest {

	@Test
	public void StringTest(){
		System.out.println(2222);
	}
	
	@Test
	public void Md5Test(){
		//原始 密码 
		String source = "123";
		//盐
		String salt = "hDM1Or";
		//散列次数
		int hashIterations = 2;
		//上边散列1次：f3694f162729b7d0254c6e40260bf15c
		//上边散列2次：36f2dfa24d0a9fa97276abbe13e596fc
		
		
		//构造方法中：
		//第一个参数：明文，原始密码 
		//第二个参数：盐，通过使用随机数
		//第三个参数：散列的次数，比如散列两次，相当 于md5(md5(''))
		
	/*	Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
		String password_md5 =  md5Hash.toString();
		System.out.println(password_md5);*/
		
		//第一个参数：散列算法 
		SimpleHash simpleHash = new SimpleHash("md5", source, salt, hashIterations);
		System.out.println(simpleHash.toString());
		
		
	}
	
	@Test
	public void TestLoginLogout() {
		// 构建SecurityManager工厂，IniSecurityManagerFactory可以从ini文件中初始化SecurityManager环境
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

		// 通过工厂创建SecurityManager
		SecurityManager securityManager = (SecurityManager) factory.getInstance();

		// 将securityManager设置到运行环境中
		SecurityUtils.setSecurityManager(securityManager);

		// 创建一个Subject实例，该实例认证要使用上边创建的securityManager进行
		Subject subject = SecurityUtils.getSubject();
		// 创建token令牌，记录用户认证的身份和凭证即账号和密码 
				UsernamePasswordToken token = new UsernamePasswordToken("201635560210", "201635560210");

				// 用户登陆
				subject.login(token);

				// 用户认证状态

				Boolean isAuthenticated = subject.isAuthenticated();

				System.out.println("用户认证状态：" + isAuthenticated);

				// 用户退出

				/*subject.logout();

				isAuthenticated = subject.isAuthenticated();

				System.out.println("用户认证状态：" + isAuthenticated);*/

			}
	}

