package io.biezhi.blog.service.impl;

import com.blade.ioc.annotation.Service;
import com.blade.kit.EncrypKit;
import io.biezhi.blog.model.User;
import io.biezhi.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User signin(String username, String password) {
        password = EncrypKit.md5(username + password);
        return User.db.where("user_name = ? and pass_word = ? and status = ?", username, password, 1).findOne();
    }
}
