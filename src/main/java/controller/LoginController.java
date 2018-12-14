package controller;

import domian.ActiveUser;
import domian.Logininfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;
import util.MD5Util;
import util.ResultJSON;
import util.UserContext;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

@Api(value = "/system", tags = "系统相关接口")
@Controller
@ResponseBody
@RequestMapping("/system")
public class LoginController {

	private static final Logger log = Logger.getLogger(LoginController.class);

  /*  @ApiOperation(value = "登录接口", notes = "根据用户名密码判断登录，验证码功能暂时不完善", httpMethod = "POST")
	@RequestMapping(value = "/v1/login")
	public ResultJSON login(HttpServletRequest request, String username, String password) {
		ResultJSON json = new ResultJSON();
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if (exceptionClassName != null) {
            request.getSession().removeAttribute("randomcode");
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				json.failure("用户名/密码错误");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				json.failure("用户名/密码错误");
			} else if ("randomCodeError".equals(exceptionClassName)) {
				json.failure("验证码错误");
			} else if ("randomCodenull".equals(exceptionClassName)) {
                json.failure("请重新获取验证码");
            } else {
				System.out.println(request.getAttribute("shiroLoginFailure"));
				json.failure("未知错误");
			}
		} else {
			if (UserContext.getCurrent() != null) {
			    HashMap<String,ActiveUser> map = new HashMap<>();
			    map.put("Logininfo",UserContext.getCurrent());
				json.success(map);
			}else{
				json.failure("用户未登录");
			}
		}
		return json;
	}*/

    @ApiOperation(value = "登录接口", notes = "根据用户名密码判断登录，验证码功能暂时不完善", httpMethod = "POST")
    @RequestMapping(value = "/v1/login", method = RequestMethod.POST)
    public ResultJSON ajaxLogin(@RequestBody Logininfo logininfo) {
        ResultJSON json = new ResultJSON();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(logininfo.getUsername(), logininfo.getPassword());
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
        try {
            subject.login(token);
            ActiveUser activeUser =(ActiveUser) subject.getPrincipal();
            UserContext.putLogininfo(activeUser);
            HashMap<String,String> map= new HashMap<>();
            map.put("token",subject.getSession().getId().toString());
            json.success(map);
        } catch (IncorrectCredentialsException e) {
            json.failure("用户账号/密码错误");
        } catch (UnknownAccountException e) {
            json.failure("用户账号/密码错误");
        } catch (AuthenticationException e) {
            e.fillInStackTrace().printStackTrace(printWriter);
            log.info(logininfo.getUsername()+"用户 AuthenticationException------"+result.toString());
            json.failure("认证失败");
        } catch (Exception e) {
            e.fillInStackTrace().printStackTrace(printWriter);
            log.info(logininfo.getUsername()+"用户 Exception------"+result.toString());
        }
        log.info("用户返回 "+json.getData()+"");
        return json;
    }

	@ApiOperation(value = "登出接口", notes = "登出用户，清空服务器session", httpMethod = "GET")
	@RequestMapping("/v1/logout")
	public ResultJSON logout() {
		ResultJSON json = new ResultJSON();
		if (UserContext.getCurrent()==null) {
			json.success("用户退出成功");
		}
		return json;
	}

	@ApiIgnore
	@RequestMapping(value = "/v1/unauthorized", method = RequestMethod.GET)
	public ResultJSON authorizationFail() {
		ResultJSON json = new ResultJSON();
		json.failure("该用户没有权限");
		return json;
	}

	@ApiIgnore
	@RequestMapping(value = "/v1/unauthenticated", method = RequestMethod.GET)
	public ResultJSON authenticationFail() {
		ResultJSON json = new ResultJSON();
		json.failure("用户未登录");
		return json;
	}

	@ApiOperation(value = "获取当前用户登录信息", notes = "获取用户登录信息，包括昵称和用户类型 0为学生，1为老师", httpMethod = "GET")
	@RequestMapping(value = "/v1/logininfo", method = RequestMethod.GET)
	public ResultJSON getlogininfo() {
        ResultJSON json =new ResultJSON();
        HashMap<String,ActiveUser> map = new HashMap<>();
        map.put("Logininfo",UserContext.getCurrent());
        json.success(map);
		return json;
	}

	@ApiIgnore
	@ApiOperation(value = "获取验证码", notes = "获取验证码，在验证登录时使用", httpMethod = "GET")
	@RequestMapping(value = "/v1/randomcode", method = RequestMethod.GET)
	public ResultJSON getrandomcode(HttpServletRequest request) {
		ResultJSON json =new ResultJSON();
		String randomcode = MD5Util.getStringRandom(4);
		request.getSession().setAttribute("randomcode",randomcode);
		HashMap<String, String> map = new HashMap<>();
		map.put("randomcode",randomcode);
		json.success(map);
		return json;
	}

}
