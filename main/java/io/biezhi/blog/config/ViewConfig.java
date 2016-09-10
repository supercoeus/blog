package io.biezhi.blog.config;

import com.blade.annotation.Order;
import com.blade.config.ApplicationConfig;
import com.blade.config.BaseConfig;
import com.blade.ioc.annotation.Component;
import com.blade.mvc.view.ViewSettings;
import com.blade.mvc.view.template.JetbrickTemplateEngine;

import io.biezhi.blog.model.Options;

@Component
@Order(sort = 2)
public class ViewConfig implements BaseConfig{

	@Override
	public void config(ApplicationConfig applicationConfig) {
		JetbrickTemplateEngine templateEngine = new JetbrickTemplateEngine();
		
		// 模板引擎
		Constant.VIEW_CONTEXT = templateEngine.getJetEngine().getGlobalContext();

		String site_title = new Options().where("`key`", "site_title").findOne().get("value");

		String site_subtitle = new Options().where("`key`", "site_subtitle").findOne().get("value");

		Constant.VIEW_CONTEXT.set(String.class, "site_title", site_title);
		Constant.VIEW_CONTEXT.set(String.class, "site_subtitle", site_subtitle);

		System.out.println(site_subtitle);

		ViewSettings.$().templateEngine(templateEngine);
	}

}