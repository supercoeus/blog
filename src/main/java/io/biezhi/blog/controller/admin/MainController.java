package io.biezhi.blog.controller.admin;

import com.blade.ioc.annotation.Inject;
import com.blade.jdbc.Paginator;
import com.blade.kit.DateKit;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.HttpMethod;
import com.blade.mvc.http.Response;
import com.blade.mvc.view.ModelAndView;
import io.biezhi.blog.config.Constant;
import io.biezhi.blog.model.Post;
import io.biezhi.blog.model.RestResponse;
import io.biezhi.blog.model.User;
import io.biezhi.blog.service.PostService;
import io.biezhi.blog.service.UserService;
import io.biezhi.blog.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.soap.SOAPBinding;
import java.util.Date;

@Controller("admin")
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Inject
    private UserService userService;

    @Inject
    private PostService postService;


    /**
     * 文章列表
     *
     * @param mav
     * @param page
     * @return
     */
    @Route(value = "posts", method = HttpMethod.GET)
    public ModelAndView posts(ModelAndView mav, @RequestParam(value = "p", defaultValue = "1") int page){
        Paginator<Post> pager = postService.queryPost(page, 10);
        mav.add("pager", pager);
        mav.setView("posts");
        return mav;
    }

    /**
     * 文章详情
     *
     * @param mav
     * @param id
     * @return
     */
    @Route(value = "post/:id", method = HttpMethod.GET)
    public ModelAndView post(ModelAndView mav, @PathVariable("id") int id){
        Post post = postService.query(id);
        mav.add("post", post);
        mav.setView("post");
        return mav;
    }

    /**
     * 保存文章
     *
     * @param title
     * @param intro
     * @param tags
     * @param content
     * @return
     */
    @Route(value = "post", method = HttpMethod.POST)
    @JSON
    public RestResponse<String> post(@RequestParam String title,
                                     @RequestParam String intro,
                                     @RequestParam String tags,
                                     @RequestParam String content){
        RestResponse<String> restResponse = new RestResponse<String>();

        try {
            Post post = new Post();
            post.set("title", title);
            post.set("intro", intro);
            post.set("content", content);
            post.set("create_time", new Date());
            int pid = post.save();

            postService.saveTag(pid, tags);

            restResponse.setSuccess(true);
        } catch (Exception e){
            LOGGER.error("保存文章失败", e);
            restResponse.setSuccess(false);
        }
        return restResponse;
    }

    /**
     * 修改文章
     *
     * @param title
     * @param intro
     * @param tags
     * @param content
     * @return
     */
    @Route(value = "post/:id", method = HttpMethod.POST)
    @JSON
    public RestResponse<String> updatePost(
                                    @PathVariable("id") int id,
                                    @RequestParam String title,
                                    @RequestParam String intro,
                                    @RequestParam String tags,
                                    @RequestParam String content){
        RestResponse<String> restResponse = new RestResponse<String>();

        try {
            Post post = new Post();
            post.set("title", title);
            post.set("intro", intro);
            post.set("content", content);
            post.set("create_time", new Date());
            post.where("id", id).update();

            postService.saveTag(id, tags);

            restResponse.setSuccess(true);
        } catch (Exception e){
            LOGGER.error("更新文章失败", e);
            restResponse.setSuccess(false);
        }
        return restResponse;
    }

    /**
     * 删除文章
     * @param id
     * @return
     */
    @Route(value = "post/delete/:id", method = HttpMethod.POST)
    @JSON
    public RestResponse<String> deletePost(
            @PathVariable("id") int id){
        RestResponse<String> restResponse = new RestResponse<String>();

        try {
            Post post = new Post();
            post.set("status", 3);
            post.where("id", id).update();

            restResponse.setSuccess(true);
        } catch (Exception e){
            LOGGER.error("删除文章失败", e);
            restResponse.setSuccess(false);
        }
        return restResponse;
    }

}