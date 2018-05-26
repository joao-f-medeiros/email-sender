package com.javaee.emailsender;

public class EmailSender {

	public static void main(String[] args) {
		final String fromEmail = "example@gmail.com";
		final String password = "*********";
		final String toEmail = "example@gmail.com";
		
		System.out.println("Initializing email send");
		
		EmailConfig config = new EmailConfig();
		
		config.sendEmail(fromEmail, password, toEmail, "Subject", "Email Body");
	}

}
