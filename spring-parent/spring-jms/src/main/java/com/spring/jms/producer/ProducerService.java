package com.spring.jms.producer;
/**
 * 生产者接口
 * @author wangzhanli
 *
 */
public interface ProducerService {
	void sendMessage(String message);
}
