package com.javaee.emailsender;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailConfig {

	public Properties getProperties() throws IOException {
		InputStream inputStream = null;
		try {
			Properties properties = new Properties();
			String propertyFile = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile);
 
			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException("File '" + propertyFile + "' not found on classpath");
			}

			return properties;
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return null;
	}
	
	public void sendEmail(Session session, String toEmail, String subject, String body){
		try {
	      MimeMessage message = new MimeMessage(session);
	      message.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      message.addHeader("format", "flowed");
	      message.addHeader("Content-Transfer-Encoding", "8bit");

	      message.setFrom(new InternetAddress("example@gmail.com", "Example"));
	      message.setReplyTo(InternetAddress.parse("example@gmail.com", false));
	      message.setSubject(subject, "UTF-8");
	      message.setText(body, "UTF-8");
	      message.setSentDate(new Date());
	      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      
	      System.out.println("Message ready!");
	      
    	  Transport.send(message);

	      System.out.println("Email sent successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}
