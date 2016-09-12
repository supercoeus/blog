package io.biezhi.blog.model;

import com.blade.jdbc.Model;
import com.blade.jdbc.annotation.Table;

@Table(name = "t_post_tag")
public class PostTag extends Model {
	
	private static final long serialVersionUID = 2357728701020794948L;
	
	public static PostTag db = new PostTag();
}
