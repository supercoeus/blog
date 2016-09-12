package io.biezhi.blog.service.impl;

import com.blade.ioc.annotation.Service;
import com.blade.jdbc.Paginator;
import io.biezhi.blog.service.PostService;
import io.biezhi.blog.model.Post;

@Service
public class PostServiceImpl implements PostService {

    @Override
    public Paginator<Post> queryPost(int page, int limit) {
        if(page < 1){
            page = 1;
        }
        if(limit < 1 || limit > 20){
            limit = 10;
        }
        return Post.db.sql("select id, title, intro, create_time from t_post").where("status = ?", 1).page(page, limit);
    }

    @Override
    public Post query(int id) {
        return Post.db.findById(id);
    }
}
