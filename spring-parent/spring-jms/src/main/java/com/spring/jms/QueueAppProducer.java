package com.spring.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class QueueAppProducer {
	
	private final static String url = "tcp://127.0.0.1:61616";
	private final static String queueDestination = "queue-test";
	
	public static void main(String[] args) throws JMSException {
		//1、创建ConnectionFactory
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		//2、创建连接Connection
		Connection connection = connectionFactory.createConnection();
		//3、启动连接
		connection.start();
		//4、创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); //false:是否在事务中处理 Session.AUTO_ACKNOWLEDGE：自动应答
		//5、创建一个目标
		Destination destination = session.createQueue(queueDestination);
		//6、创建一个生产者
		MessageProducer producer = session.createProducer(destination);
		
		for (int i = 0; i < 100; i++) {
			//7、创建消息
			TextMessage textMessage = session.createTextMessage("test:"+i);
			//8、发布消息
			producer.send(textMessage);
			System.out.println("发送消息："+textMessage.getText());
		}
		//9、关闭连接
		connection.close();
	}
}
