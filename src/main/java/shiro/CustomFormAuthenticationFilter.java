package shiro;

import domian.ActiveUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import util.UserContext;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{
	
	
	/*@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		String randomcode = request.getParameter("randomcode");
		String validateCode = (String) session.getAttribute("randomcode");

		if (randomcode!=null && validateCode!=null) {
			if (!randomcode.equals(validateCode)) {
				request.setAttribute("shiroLoginFailure", "randomCodeError");
				return true; 
			}
		}else if (validateCode == null){
            request.setAttribute("shiroLoginFailure", "randomCodenull");
            return true;
        }
		return super.onAccessDenied(request, response);
	}
*/
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {

		UserContext.putLogininfo((ActiveUser) subject.getPrincipal());
		UserContext.putLogininfo((ActiveUser) SecurityUtils.getSubject().getPrincipal());
		System.out.println("onLonginSuccess----"+subject.getPrincipal());
		System.out.println("onLonginSuccess----"+SecurityUtils.getSubject().getPrincipal());
		System.out.println("onLonginSuccess----"+subject.getSession().getId());
		//WebUtils.getAndClearSavedRequest(request);
		//WebUtils.redirectToSavedRequest(request, response, "/system/v1/logininfo");
		return false;
	}

}
