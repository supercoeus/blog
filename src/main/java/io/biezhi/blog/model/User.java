package io.biezhi.blog.model;

import com.blade.jdbc.Model;
import com.blade.jdbc.annotation.Table;

@Table(name = "t_user")
public class User extends Model {
	
	private static final long serialVersionUID = 2357728701020794948L;
	
	public static User db = new User();
}
