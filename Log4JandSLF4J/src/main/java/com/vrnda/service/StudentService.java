package com.vrnda.service;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;

public class StudentService {
	private static Logger logger = Logger.getLogger(StudentService.class);

	static {
		try {
//			SimpleLayout layout = new SimpleLayout();
//			ConsoleAppender appender = new ConsoleAppender(layout);
//			//appender.setLayout(layout);
//			logger.addAppender(appender);
//			logger.setLevel(Level.DEBUG);
//			logger.info("Log4j Setup is ready");
			PropertyConfigurator.configure("src/main/java/com/vrnda/commons/log4j.properties");
			logger.info("Log4j Setup is ready");
		} catch (Exception e) {
			logger.fatal("com.vrnda.service.StudentService:: Problem While Logger Setup Ready");
		}
	}

	public Float getTotal(Integer[] marks) {
		logger.debug("getTotalMethod  Start");
		Float total = 0f;
		try {
			System.out.println(10 / 0);
		} catch (Exception e) {
			logger.error(e);
		}
		for (Integer mark : marks) {
			total = total + mark;
		}
		return total;
	}

	public static void main(String[] args) {
		new StudentService().getTotal(new Integer[] { 10, 10, 20, 30, 40, 50 });
	}
}
