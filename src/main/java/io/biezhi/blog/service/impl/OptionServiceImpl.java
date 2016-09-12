package io.biezhi.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blade.ioc.annotation.Service;

import io.biezhi.blog.model.Options;
import io.biezhi.blog.service.OptionService;

@Service
public class OptionServiceImpl implements OptionService {

	@Override
	public Map<String, String> getOptions() {
		List<Options> options = Options.db.all();
		Map<String, String> map = new HashMap<String, String>(options.size());
		for(Options option : options){
			map.put(option.getString("key"), option.getString("value"));
		}
		return map;
	}

}
