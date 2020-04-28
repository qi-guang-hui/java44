package com.imti.shiroHello;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
/**@�ļ���: shiroHello.java
 * @�๦��˵��: 
 * @����: QiGuangHui
 * @Email: 2304365280@qq.com
 * @����: 2020��3��31������6:42:18
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: QiGuangHui</li> 
 * 	 <li>����: 2020��3��31������6:42:18</li> 
 *	 <li>����: </li>
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
			System.out.println("��֤ͨ����");
			
		} catch (UnknownAccountException e) {
			System.out.println("δ֪�˻���");
		}catch (IncorrectCredentialsException e) {
			System.out.println("�������");
		}catch (Exception e) {
			System.out.println("δ֪����");
		}
		
	}
}
