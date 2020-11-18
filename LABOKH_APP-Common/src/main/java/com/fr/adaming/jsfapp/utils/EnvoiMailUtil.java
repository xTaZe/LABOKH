/**
 *
 */
package com.fr.adaming.jsfapp.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author cdridi
 *
 */
public class EnvoiMailUtil {
	private static final String MAIL_TRANSPORT_PROTOCOL = "smtp";

	private static final String MAIL_HOST = "smtp.gmail.com";

	private static final String MAIL_SMTP_STARTTLS_ENABLE = "true";

	private static final String MAIL_SMTP_AUTH = "true";

	private static final String MAIL_DEBUG = "true";

	public static final String USERNAME = "enajib.contact@gmail.com";

	private static final String PASSWORD = "adamingadaming";

	/**
	 * permet d'envoyer
	 *
	 * @param destinataire
	 * @throws MessagingException
	 */
	public static final void envoiMail(String destinataire, String titreMail, String titreContentMail,
			String bodyContentMail) throws MessagingException {

		/**
		 * *********************************************************************
		 * ********** initialisation des proprietes necessaires
		 * *****************
		 * **************************************************************
		 */
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", MAIL_TRANSPORT_PROTOCOL);
		props.setProperty("mail.host", MAIL_HOST);
		props.put("mail.smtp.starttls.enable", MAIL_SMTP_STARTTLS_ENABLE);
		props.put("mail.smtp.auth", MAIL_SMTP_AUTH);
		props.put("mail.debug", MAIL_DEBUG);

		/**
		 * *********************************************************************
		 * ********** préparation de l'emetteur
		 * *********************************
		 * **********************************************
		 */
		Session mailSession = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});

		/**
		 * *********************************************************************
		 * ********** préparation du mail
		 * ***************************************
		 * ****************************************
		 */

		/**
		 * le mail HTML a besoin de deux partie le BODY et les images embarqués
		 */

		MimeMultipart multipart = new MimeMultipart("related");

		/**
		 * 1er : préparation de du BODY
		 */
		BodyPart messageBodyPart = new MimeBodyPart();

		String templateMail1 = "<div id=\"content\" style=\"width:100%;margin-bottom: -20px;float:left\">"
				+ "<div id=\"logo\" style=\"background-color: #EEEEEE; width:100%;float:left\">"
				+ "<div style=\"width:80%;float:center;\">"
				+ "<div  style=\"width: 50%;margin: 50px 0px 20px 10px; font-size: 25px;font-center: bold;font-family: Arial, Helvetica, sans-serif;color:#6495ED\">ITALCAR"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<div id=\"title\" style=\"background-color: #FFFFFF; width:100%;overflow: auto;height: 200px;\">"
				+

				"<p align=\"left\" style=\"font-size: 18px; line-height:24px; color: #0a0a0a; font-weight:bold; margin-top:15px; margin-bottom:18px; font-family: 'Helvetica Neue', Arial, Helvetica, Geneva, sans-serif; margin-left: 15px\"> "
				+ titreContentMail + "</p>" + bodyContentMail;

		messageBodyPart.setContent(templateMail1, "text/html; charset=utf-8");

		/**
		 * ajout du body
		 */
		multipart.addBodyPart(messageBodyPart);

		/**
		 * Ajout de contenu et de l'entete
		 */
		MimeMessage message = new MimeMessage(mailSession);
		message.setContent(multipart);
		message.setSubject(titreMail);

		/**
		 * *********************************************************************
		 * ********** préparation du destinataire
		 * *******************************
		 * ************************************************
		 */
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinataire));

		/**
		 * *********************************************************************
		 * ********** ENVOI
		 * *****************************************************
		 * **************************
		 */
		Transport transport = mailSession.getTransport();
		transport.connect();
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();

	}

	public static String getUsername() {
		return USERNAME;
	}
}
