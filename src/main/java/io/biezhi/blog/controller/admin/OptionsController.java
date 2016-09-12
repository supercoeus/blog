package io.biezhi.blog.controller.admin;

import com.blade.ioc.annotation.Inject;
import com.blade.jdbc.Paginator;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.HttpMethod;
import com.blade.mvc.view.ModelAndView;
import io.biezhi.blog.model.Post;
import io.biezhi.blog.model.RestResponse;
import io.biezhi.blog.service.PostService;
import io.biezhi.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Controller("admin")
public class OptionsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OptionsController.class);

    @Inject
    private UserService userService;

    @Inject
    private PostService postService;


    /**
     * 系统设置
     * @param mav
     * @return
     */
    @Route(value = "options", method = HttpMethod.GET)
    public ModelAndView options(ModelAndView mav){
        mav.setView("admin/options");
        return mav;
    }
    
    /**
     * 保存系统设置
     * @return
     */
    @Route(value = "options", method = HttpMethod.POST)
    @JSON
    public RestResponse<String> saveOptions(){
        RestResponse<String> restResponse = new RestResponse<String>();

        return restResponse;
    }


}