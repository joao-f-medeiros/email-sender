package com.javaee.emailsender;

import java.io.IOException;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailSender {

	public static void main(String[] args) throws IOException {
		final String fromEmail = "example@gmail.com";
		final String password = "*********";
		final String toEmail = "example@gmail.com";
		
		System.out.println("Initializing email send");
		
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		EmailConfig config = new EmailConfig();
		
		Session session = Session.getInstance(config.getProperties(), auth);
		
		config.sendEmail(session, toEmail, "Subject", "Email Body");
	}

}
