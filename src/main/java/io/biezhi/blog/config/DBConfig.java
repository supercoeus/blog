package io.biezhi.blog.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.blade.annotation.Order;
import com.blade.config.ApplicationConfig;
import com.blade.config.BaseConfig;
import com.blade.ioc.annotation.Component;
import com.blade.jdbc.Base;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

@Component
@Order(sort = 1)
public class DBConfig implements BaseConfig{

	@Override
	public void config(ApplicationConfig applicationConfig) {
		try {
			InputStream in = DBConfig.class.getClassLoader().getResourceAsStream("druid.properties");
			Properties props = new Properties();
			props.load(in);
			DataSource dataSource = DruidDataSourceFactory.createDataSource(props);
			Base.open(dataSource);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}