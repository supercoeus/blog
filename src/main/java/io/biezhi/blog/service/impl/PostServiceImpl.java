package io.biezhi.blog.service.impl;

import com.blade.ioc.annotation.Service;
import com.blade.jdbc.Paginator;
import com.blade.kit.StringKit;
import io.biezhi.blog.model.Post;
import io.biezhi.blog.model.PostTag;
import io.biezhi.blog.model.Tag;
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
        return Post.db.sql("select id, title, intro, create_time from t_post").where("status = ?", 1).page(page, limit);
    }

    @Override
    public Post query(int id) {
        return Post.db.findById(id);
    }

    @Override
    public void saveTag(int pid, String tags) {
        // 1. 删除pid的tags
        PostTag.db.where("pid", pid).delete();
        // 2. 添加tags
        String[] tagarr = StringKit.split(tags, ",");
        if(null != tagarr && tagarr.length > 0){
            PostTag postTag = new PostTag();
            for(String tag : tagarr){
                Tag tagObj = Tag.db.where("name = ?", tag).findOne();
                if(null != tagObj){
                    postTag.set("pid", pid).set("tid", tagObj.getInt("id")).addToBatch();
                }
            }
            postTag.saveBatch();
        }
    }

}
