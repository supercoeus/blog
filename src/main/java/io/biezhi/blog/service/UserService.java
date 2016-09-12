package io.biezhi.blog.service;

import io.biezhi.blog.model.User;

public interface UserService {

    User signin(String username, String password);

}
