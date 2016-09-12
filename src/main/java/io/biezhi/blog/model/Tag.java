package io.biezhi.blog.model;

import com.blade.jdbc.Model;
import com.blade.jdbc.annotation.Table;

@Table(name = "t_tag")
public class Tag extends Model {
	
	private static final long serialVersionUID = 2357728701020794948L;
	
	public static Tag db = new Tag();
}
