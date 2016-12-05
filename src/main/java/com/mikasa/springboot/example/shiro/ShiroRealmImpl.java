package com.mikasa.springboot.example.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by sherlock on 2016/12/5.
 */

@Service
public class ShiroRealmImpl extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(ShiroRealmImpl.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        /*ShiroUser shiroUser = (ShiroUser) principalCollection.getPrimaryPrincipal();
        List<Role> roleList = roleService.selectRoleByUserId(shiroUser.getId());
        Set<String> roleSet = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        for (Role role : roleList) {
            roleSet.add(role.getRoleKey());
            if(role != null){
                List<Resource> _resource = resourceService.findByRoleId(role.getId());
                for(Resource resource : _resource){
                    if(resource != null && !"".equals(resource.getPermission())){
                        permissions.add(resource.getPermission());
                    }
                }

            }
        }
        if(roleSet!=null && roleSet.size()>0){
            shiroUser.setRoleSet(roleSet);
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleSet);
        info.addStringPermissions(permissions);
        return info;*/
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /*Long mobile = Long.parseLong(authenticationToken.getPrincipal().toString());
        User user = userService.selectByMobile(mobile);
        if (user==null){
            log.error(mobile+" : 用户不存在!");
            throw new UnknownAccountException();//没找到帐号
        }
        UserInfo userInfo = userService.selectById(user.getId());
        List<Role> roleList = roleService.selectRoleByUserId(user.getId());

        //判断是否是超级管理员或者社长权限-只有这个角色才能登陆后台。
        //TODD 需要修改
        if (roleList==null || roleList.size()==0){
            log.error(mobile+" : 用户不是管理员或者社长!");
            //没有登陆权限
            throw new NoLoginAuthorException();
        }
        Set<String> roleSet = new HashSet<>();
        for (Role role : roleList) {
            roleSet.add(role.getRoleKey());
        }

        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setId(user.getId());
        shiroUser.setMobile(user.getMobile());
        shiroUser.setNickName(userInfo.getNickName());
        shiroUser.setRealName(userInfo.getRealName());
        shiroUser.setIsPresident(userInfo.getIsPresident());
        shiroUser.setAvatarUrl(userInfo.getAvatarUrl());
        if(roleSet!=null && roleSet.size()>0){
            shiroUser.setRoleSet(roleSet);
        }
        // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, user.getPassword().toCharArray(), getName());*/

        return null;
    }
}
