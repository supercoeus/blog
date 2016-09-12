package io.biezhi.blog.service;

import com.blade.jdbc.Paginator;
import io.biezhi.blog.model.Post;

/**
 * Created by oushaku on 16/9/10.
 */
public interface PostService {

    Paginator<Post> queryPost(int page, int limit);

    Post query(int id);
}
