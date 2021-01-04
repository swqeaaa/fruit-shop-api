package com.uzi.demo.controller;

import com.uzi.demo.RespEntity;
import com.uzi.demo.RespUser;
import com.uzi.demo.util.UserUtil;
import com.uzi.mapper.UserMapper;
import com.uzi.model.User;
import com.uzi.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LoginController {


    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public String hello() {
        return "cnm!";
    }

    /**
     * 登录
     *
     * @param mp
     * @return
     */
    @PostMapping("/user/login")
//    @ResponseBody
    public RespEntity login(@RequestBody Map<String, Object> mp) {
        String email = (String) mp.get("email");
        String passwd = (String) mp.get("passwd");
        passwd= UserUtil.encodePassword(passwd);
//        System.err.println(email);
//        System.err.println(passwd);
        User user = null;
        try {
            UserExample example = new UserExample();
            example.createCriteria().andEmailEqualTo(email).andPasswdEqualTo(passwd);
            List<User> list = userMapper.selectByExample(example);
            user = list.get(0);
        } catch (Exception e) {
            e.getStackTrace();
        }
        if (user == null) return new RespEntity("err", 400, null);
        else {
            UserExample example2 = new UserExample();
            example2.createCriteria().andUseridEqualTo(user.getUserid());
            user.setIslogin(1);
            userMapper.updateByExampleSelective(user, example2);
            return new RespEntity("ok", 200, new RespUser(user));
        }
    }

    /**
     * 登出
     *
     * @param mp
     * @return
     */
    @PostMapping("/user/logout")
    public RespEntity logout(@RequestBody Map<String, Object> mp) {
        Integer userid = (Integer) mp.get("userid");
        UserExample example = new UserExample();
        example.createCriteria().andUseridEqualTo(userid);
        try {
            List<User> list = userMapper.selectByExample(example);
            if (list.get(0).getIslogin() == 0)// 没登陆, 想退出?
                return new RespEntity("err", 400, null);
        } catch (Exception e) {
            return new RespEntity("err", 401, null);
        }
        User user = new User();
        user.setIslogin(0);
        userMapper.updateByExampleSelective(user, example);
        return new RespEntity("ok", 200, null);
    }

//    @PostMapping("/test")
//    public RespEntity test(@RequestBody Map<String, Object> mp) {
//return new RespEntity("ok", 200, new RespUser(user));
//        //   new RespEntity("err", 400, null);
//    }

    /**
     * 注册
     *
     * @param mp
     * @return
     */
    @PostMapping("/user/signup")
    public RespEntity signUp(@RequestBody Map<String, Object> mp) {
        User user = new User(mp);
        if (mp.isEmpty() || user.partEmpty()) return new RespEntity("不能为空", 400, null);
        if(!UserUtil.checkEmail(user.getEmail()))
            return new RespEntity("邮箱不合法",400,null);
        user.setPasswd(UserUtil.encodePassword(user.getPasswd()));
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo((String) mp.get("email"));
        List<User> list = userMapper.selectByExample(example);
        if (!list.isEmpty()) return new RespEntity("邮箱已注册", 400, null);
        user.setIslogin(1);
        userMapper.insertSelective(user);
        return new RespEntity("ok", 200, null);
    }

    /**
     * 获取用户信息
     * @param mp
     * @return
     */
    @PostMapping("/user/getinfo")
    public RespEntity getinfo(@RequestBody Map<String, Object> mp) {
        if (mp.isEmpty()) return new RespEntity("不能为空", 400, null);
        UserExample example = new UserExample();
        example.createCriteria().andUseridEqualTo((Integer) mp.get("userid"));
        List<User> list = userMapper.selectByExample(example);
        if (list.get(0).getIslogin()==0) return new RespEntity("未登录", 400, null);
        return new RespEntity("ok", 200, new RespUser(list.get(0)));
    }

    /**
     * 修改用户信息
     * @param mp
     * @return
     */
    @PostMapping("/user/modify")
    public RespEntity modifyUser(@RequestBody Map<String, Object> mp) {
        if (mp.isEmpty()) return new RespEntity("不能为空", 400, null);

        User user=new User(mp);
        if(user.partEmpty())return new RespEntity("不能为空", 400, null);
        if(!UserUtil.checkEmail(user.getEmail()))
            return new RespEntity("邮箱不合法",400,null);
        user.setPasswd(UserUtil.encodePassword(user.getPasswd()));

        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo((String) mp.get("email"));
        List<User> list = userMapper.selectByExample(example);
        if(list!=null){
            example.clear();
            list.clear();
            example.createCriteria().andEmailEqualTo((String) mp.get("email")).andUseridEqualTo((Integer)mp.get("userid"));
            list=userMapper.selectByExample(example);
            if(list==null)return new RespEntity("邮箱已注册", 400, null);
        }
        example.clear();
        example.createCriteria().andUseridEqualTo((Integer)mp.get("userid"));
        userMapper.updateByExampleSelective(user,example);
        return new RespEntity("ok", 200, null);
    }
}
