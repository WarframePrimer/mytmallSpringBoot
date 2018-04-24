package com.warframe.tmall.controller.cms;


import com.warframe.tmall.common.util.StorageFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public StorageFactory storageFactory(){
		return new StorageFactory();
	}
}
