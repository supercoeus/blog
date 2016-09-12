package io.biezhi.blog.util;

import com.blade.context.WebContextHolder;
import io.biezhi.blog.config.Constant;
import io.biezhi.blog.model.User;

public final class SessionUtil {

    public static void put(String key, Object value){
        WebContextHolder.session().attribute(key, value);
    }

    public static User getUser(){
        return WebContextHolder.session().attribute(Constant.LOGIN_SESSION_KEY);
    }

    public static void remove(String key) {
        WebContextHolder.session().removeAttribute(key);
    }
}
