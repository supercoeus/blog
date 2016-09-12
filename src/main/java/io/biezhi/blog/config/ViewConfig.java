package io.biezhi.blog.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blade.annotation.Order;
import com.blade.config.ApplicationConfig;
import com.blade.config.BaseConfig;
import com.blade.ioc.annotation.Component;
import com.blade.ioc.annotation.Inject;
import com.blade.mvc.view.ViewSettings;
import com.blade.mvc.view.template.JetbrickTemplateEngine;

import io.biezhi.blog.model.Options;
import io.biezhi.blog.service.OptionService;

@Component
@Order(sort = 2)
public class ViewConfig implements BaseConfig{

	@Inject
	private OptionService optionService;
	
	@Override
	public void config(ApplicationConfig applicationConfig) {
		JetbrickTemplateEngine templateEngine = new JetbrickTemplateEngine();
		
		// 模板引擎
		Constant.VIEW_CONTEXT = templateEngine.getJetEngine().getGlobalContext();
		
		List<Options> options = new Options().all();
		Map<String, String> sysInfo = new HashMap<String, String>(options.size());
		for(Options option : options){
			sysInfo.put(option.getString("key"), option.getString("value"));
		}
		Constant.VIEW_CONTEXT.set(Map.class, "sys_info", sysInfo);
		
		ViewSettings.$().templateEngine(templateEngine);
	}

}