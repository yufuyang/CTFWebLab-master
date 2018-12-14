package shiro;


import domian.ActiveUser;
import domian.Logininfo;
import domian.SysPermision;
import mapper.SysPermisionMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import service.LogininfoService;
import service.SystemService;

import java.util.ArrayList;
import java.util.List;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	LogininfoService loginfoservice;

	@Autowired
    SystemService systemService;

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String usercode = (String) token.getPrincipal();

		Logininfo logininfo = loginfoservice.select(Long.valueOf(usercode));

		if (logininfo == null) {
			return null;
		}

		String password = logininfo.getPassword();
		String salt = logininfo.getSalt();
		
		ActiveUser activeUser = new ActiveUser();
		
		activeUser.setIsexp(0);
		activeUser.setLocked(logininfo.getLocked());
		activeUser.setUsercode(usercode);
		activeUser.setUserinfo(logininfo.getUserid());;
		activeUser.setUsername(logininfo.getUsername());
		activeUser.setUsertype(logininfo.getUsertype());
		activeUser.setImg(logininfo.getImg());
		
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(activeUser, password,
				ByteSource.Util.bytes(salt), getName());
		System.out.println("doGetAuthenticationInfo----"+activeUser);
		return simpleAuthenticationInfo;
		
	}

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ActiveUser activeUser =  (ActiveUser) principals.getPrimaryPrincipal();

        List<SysPermision> permissionList = systemService.selectByUserType(activeUser.getUsertype());
        List<String> permissions = new ArrayList<>();
        if(permissionList!=null){
            for(SysPermision sysPermission:permissionList){
				System.out.println(sysPermission);
                permissions.add(sysPermission.getPrecode());
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
	}

}
