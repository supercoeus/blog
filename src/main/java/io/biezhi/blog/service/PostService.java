package io.biezhi.blog.service;

import com.blade.jdbc.Paginator;
import io.biezhi.blog.model.Post;

public interface PostService {

    Paginator<Post> queryPost(int page, int limit);

    Post query(int id);

}
