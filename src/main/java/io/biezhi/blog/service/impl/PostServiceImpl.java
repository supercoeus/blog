package io.biezhi.blog.service.impl;

import com.blade.ioc.annotation.Service;
import com.blade.jdbc.Paginator;
import io.biezhi.blog.model.Post;
import io.biezhi.blog.service.PostService;

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
        return new Post().sql("select id, title, intro, tags, create_time from t_post")
                .where("status = ?", 1)
                .order("create_time desc")
                .page(page, limit);
    }

    @Override
    public Post query(int id) {
        return new Post().findById(id);
    }


}
