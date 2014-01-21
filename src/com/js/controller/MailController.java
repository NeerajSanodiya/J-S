package com.js.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.mail.Session;

public class MailController {
	public void sendcontactmail(HttpServletRequest request,HttpServletResponse response){
		final String username = "bllneeraj756@gmail.com";
		final String password = "surabhisammy";
		String contact_title=request.getParameter("contact_title");
		String contact_firstname=request.getParameter("contact_firstname");
		String contact_familyname=request.getParameter("contact_familyname");
		String contact_city=request.getParameter("contact_city");
		String contact_country=request.getParameter("contact_country");
		String contact_phone=request.getParameter("contact_phone");
		String contact_email=request.getParameter("contact_email");
		String contact_description=request.getParameter("contact_description");
		System.out.println("contact_title"+contact_title);
		System.out.println("contact_firstname"+contact_firstname);
		System.out.println("contact_familyname"+contact_familyname);
		System.out.println("contact_city"+contact_city);
		System.out.println("contact_country"+contact_country);
		System.out.println("contact_phone"+contact_phone);
		System.out.println("contact_email"+contact_email);
		System.out.println("contact_description"+contact_description);
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");


		javax.mail.Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(contact_email));
			message.setSubject(contact_familyname);
			message.setText(""+contact_title+"      :     "+contact_firstname+""
					+contact_country+"");
			message.setContent("<h1>Hello World</h1>", "text/html"); 
			message.setContent(contact_email, contact_description);
			
			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
			;
		}
	}
	
}
