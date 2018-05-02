package com.warframe.tmall.search.message;


import com.warframe.tmall.common.exception.TmallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener {

	private final static Logger log= LoggerFactory.getLogger(MyMessageListener.class);

	@Override
	public void onMessage(Message message) {

		//取消息内容
		TextMessage textMessage = (TextMessage) message;
		try {
			String text = textMessage.getText();
			log.info(text);
		} catch (JMSException e) {
			e.printStackTrace();
			throw new TmallException("监听消息失败");
		}
	}

}
