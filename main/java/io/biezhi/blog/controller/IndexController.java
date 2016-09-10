package io.biezhi.blog.controller;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.annotation.Controller;
import com.blade.mvc.annotation.PathVariable;
import com.blade.mvc.annotation.RequestParam;
import com.blade.mvc.annotation.Route;
import com.blade.mvc.http.HttpMethod;
import com.blade.mvc.view.ModelAndView;
import io.biezhi.blog.service.PostService;

@Controller
public class IndexController {

    @Inject
    private PostService postService;

    /**
     * 首页
     * @param mav
     * @return
     */
    @Route(value = "/", method = HttpMethod.GET)
    public ModelAndView index(ModelAndView mav,
                              @RequestParam(value = "p", defaultValue = "1") int page){

//        Paginator<Post> pager = postService.queryPost(page, 10);
//        mav.add("pager", pager);
        mav.setView("index");
        return mav;
    }

    /**
     * 文章详情
     * @param mav
     * @param id
     * @return
     */
    @Route(value = "post/:id", method = HttpMethod.GET)
    public ModelAndView post(ModelAndView mav, @PathVariable("id") int id){
//        Post post = postService.query(id);
//        mav.add("post", post);
        mav.setView("post");
        return mav;
    }

    @Route(value = "about", method = HttpMethod.GET)
    public ModelAndView about(ModelAndView mav){
        mav.setView("about");
        return mav;
    }

    @Route(value = "contact", method = HttpMethod.GET)
    public ModelAndView contact(ModelAndView mav){
        mav.setView("contact");
        return mav;
    }

    @Route(value = "blog", method = HttpMethod.GET)
    public ModelAndView blog(ModelAndView mav){
        mav.setView("blog");
        return mav;
    }

}
