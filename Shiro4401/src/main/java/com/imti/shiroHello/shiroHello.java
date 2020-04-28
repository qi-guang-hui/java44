package com.imti.shiroHello;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
/**@文件名: shiroHello.java
 * @类功能说明: 
 * @作者: QiGuangHui
 * @Email: 2304365280@qq.com
 * @日期: 2020年3月31日下午6:42:18
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: QiGuangHui</li> 
 * 	 <li>日期: 2020年3月31日下午6:42:18</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class shiroHello {

	public static void main(String[] args) {
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("admin","123456");
		try {
			subject.login(token);
			System.out.println("验证通过！");
			
		} catch (UnknownAccountException e) {
			System.out.println("未知账户！");
		}catch (IncorrectCredentialsException e) {
			System.out.println("密码错误！");
		}catch (Exception e) {
			System.out.println("未知错误！");
		}
		
	}
}
