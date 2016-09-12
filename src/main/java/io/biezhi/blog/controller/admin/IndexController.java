package io.biezhi.blog.controller.admin;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.Controller;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.RequestParam;
import com.blade.mvc.annotation.Route;
import com.blade.mvc.http.HttpMethod;
import com.blade.mvc.http.Response;
import com.blade.mvc.view.ModelAndView;
import io.biezhi.blog.config.Constant;
import io.biezhi.blog.model.RestResponse;
import io.biezhi.blog.model.User;
import io.biezhi.blog.service.UserService;
import io.biezhi.blog.util.SessionUtil;

@Controller("admin")
public class IndexController {

    @Inject
    private UserService userService;

    /**
     * 后台首页
     * @param mav
     * @return
     */
    @Route(value = "index", method = HttpMethod.GET)
    public ModelAndView index(ModelAndView mav){
        mav.setView("admin/index");
        return mav;
    }

    /**
     * 登录
     * @param user_name
     * @param pass_word
     * @return
     */
    @Route(value = "signin", method = HttpMethod.POST)
    @JSON
    public RestResponse<String> signin(@RequestParam("user_name") String user_name,
                                       @RequestParam("pass_word") String pass_word){

        RestResponse<String> restResponse = new RestResponse<String>();
        User user = userService.signin(user_name, pass_word);
        if(null == user){
            restResponse.setMsg("用户名或密码错误");
            restResponse.setSuccess(false);
        } else {
            SessionUtil.put(Constant.LOGIN_SESSION_KEY, user);
            restResponse.setSuccess(true);
        }
        return restResponse;
    }

    @Route(value = "logout")
    public void logout(Response response){
        SessionUtil.remove(Constant.LOGIN_SESSION_KEY);
        response.go("/admin/signin");
    }

    /**
     * 登录
     * @param mav
     * @return
     */
    @Route(value = "signin", method = HttpMethod.GET)
    public ModelAndView signinPage(ModelAndView mav){
        mav.setView("admin/signin");
        return mav;
    }

}
