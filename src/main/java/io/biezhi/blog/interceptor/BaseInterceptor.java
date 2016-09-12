package io.biezhi.blog.interceptor;

import com.blade.mvc.annotation.Intercept;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.blade.mvc.interceptor.Interceptor;
import io.biezhi.blog.model.User;
import io.biezhi.blog.util.SessionUtil;

@Intercept
public class BaseInterceptor implements Interceptor {

    @Override
    public boolean before(Request request, Response response) {
       /* String uri = request.uri();
        if(uri.startsWith("/admin") && !uri.equals("/admin/signin")){
            User user = SessionUtil.getUser();
            if(null == user){
                response.go("/admin/signin");
                return false;
            }
        }*/
        return true;
    }

    @Override
    public boolean after(Request request, Response response) {
        return true;
    }
}