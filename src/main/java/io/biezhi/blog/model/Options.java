package io.biezhi.blog.model;

import com.blade.jdbc.Model;
import com.blade.jdbc.annotation.Table;

@Table(name = "t_options")
public class Options extends Model {
	
	private static final long serialVersionUID = -7008781428345929578L;

	public static Options db = new Options();
}
