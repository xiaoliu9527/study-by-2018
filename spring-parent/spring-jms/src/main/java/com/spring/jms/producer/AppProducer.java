package com.spring.jms.producer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
		ProducerService producerService = (ProducerService)context.getBean("producerService");
		for (int i = 0; i < 100; i++) {
			producerService.sendMessage("test->"+i);
		}
		context.close();
	}
	
	
	
}
