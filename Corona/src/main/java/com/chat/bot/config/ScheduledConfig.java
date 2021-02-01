package com.chat.bot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

// Spring Boot에서 스케줄러 기능을 사용하기 위해 Class를 만들고
// 설정파일이라는 어노테이션인 Configuration과
// 스케줄러 기능을 사용하기 위한 어노테이션인 EnabledScheduling를 걸어준다.

@Configuration
@EnableScheduling
public class ScheduledConfig {
	
	@Bean
	public TaskScheduler scheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(4);
		return scheduler;
	}

}
