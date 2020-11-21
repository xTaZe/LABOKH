/**
 *
 */
package com.fr.adaming.jsfapp.sendMail;

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
 * @author mboumallouga
 *
 */
public class EnvoiMailUtil {
	private static final String MAIL_TRANSPORT_PROTOCOL = "smtp";

	// private static final String MAIL_HOST = "mail.italcar-sa.com";

	private static final String MAIL_SMTP_STARTTLS_ENABLE = "true";

	private static final String MAIL_SMTP_AUTH = "true";

	private static final String MAIL_DEBUG = "true";

	public static final String USERNAME = "blocker@italcar-sa.com";

	private static final String PASSWORD = "Bl0c£er";

	// private static final String MAIL_TRANSPORT_PROTOCOL = "smtp";
	//
	// private static final String MAIL_HOST = "smtpauth.online.net";
	//
	// private static final String MAIL_SMTP_STARTTLS_ENABLE = "true";
	//
	// private static final String MAIL_SMTP_AUTH = "true";
	//
	// private static final String MAIL_DEBUG = "true";
	//
	// public static final String USERNAME = "fidelitetest@adaming.fr";
	//
	// private static final String PASSWORD = "jWjj00vy";

	/**
	 * permet d'envoyer
	 *
	 * @param destinataire
	 * @throws MessagingException
	 */
	public static void envoiMail(String destinataire, String titreMail, String titreContentMail, String bodyContentMail)
			throws MessagingException {

		/**
		 * *********************************************************************
		 * ********** initialisation des proprietes necessaires
		 * *****************
		 * **************************************************************
		 */
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", MAIL_TRANSPORT_PROTOCOL);
		// props.setProperty("mail.host", paramMail.getHost());
		props.put("mail.smtp.starttls.enable", MAIL_SMTP_STARTTLS_ENABLE);
		props.put("mail.smtp.auth", MAIL_SMTP_AUTH);
		props.put("mail.debug", MAIL_DEBUG);
		props.put("mail.smtp.starttls.enable", "true");

		/**
		 * *********************************************************************
		 * ********** préparation de l'emetteur
		 * *********************************
		 * **********************************************
		 */
		Session mailSession = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return null;
				// return new PasswordAuthentication(paramMail.getLogin(),
				// paramMail.getMotDePasse());
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

		// String templateMail1 =
		// "<div id=\"content\" style=\"width:100%;margin-bottom:
		// -20px;float:left\">"
		// +
		// "<div id=\"logo\" style=\"background-color: #EEEEEE;
		// width:100%;float:left\">"
		// + "<div style=\"width:80%;float:left;\">"
		// +
		// "<div style=\"width: 50%;margin: 50px 0px 20px 10px; font-size:
		// 25px;font-weight: bold;font-family: Arial, Helvetica,
		// sans-serif;color:#E30521\">ITALCAR</div>"
		// + "</div>"
		// + "</div>"
		// +
		// "<div id=\"title\" style=\"background-color: #FFFFFF;
		// width:100%;overflow: auto;height: 200px;\">"
		// +
		//
		// "<p align=\"left\" style=\"font-size: 18px; line-height:24px; color:
		// #0a0a0a; font-weight:bold; margin-top:15px; margin-bottom:18px;
		// font-family: 'Helvetica Neue', Arial, Helvetica, Geneva, sans-serif;
		// margin-left: 15px\"> "
		// + titreContentMail + "</p>" + bodyContentMail;
		String templateMail1 = "<style type='text/css'>body {margin: 0;padding: 0;min-width: 100% !important;}img {height: auto;}.content {width: 100%;max-width: 800px;}.header {padding: 40px 30px 20px 30px;}.innerpadding {padding: 30px 30px 30px 30px;}.borderbottom {border-bottom: 10px solid #44525f;}.subhead {font-size: 15px;color: #ffffff;font-family: sans-serif;letter-spacing: 10px;}.h1, .h2, .bodycopy {color: #153643;font-family: sans-serif;}.h1 {font-size: 33px;line-height: 38px;font-weight: bold;}.h2 {padding: 0 0 15px 0;font-size: 24px;line-height: 28px;font-weight: bold;}.bodycopy {font-size: 16px;line-height: 22px;}.button {text-align: center;font-size: 18px;font-family: sans-serif;font-weight: bold;padding: 0 30px 0 30px;}.button a {color: #ffffff;text-decoration: none;}.footer {padding: 20px 30px 15px 30px;}.footercopy {font-family: sans-serif;font-size: 14px;color: #ffffff;}.footercopy a {color: #ffffff;text-decoration: underline;}@media only screen and (max-width: 550px), screen and (max-device-width: 550px) {body[yahoo] .hide {display: none !important;}body[yahoo] .buttonwrapper {background-color: transparent !important;}body[yahoo] .button {padding: 0px !important;}body[yahoo] .button a {background-color: #e05443;padding: 15px 15px 13px !important;}body[yahoo] .unsubscribe {display: block;margin-top: 20px;padding: 10px 50px;background: #2f3942;border-radius: 5px;text-decoration: none !important;font-weight: bold;}}"
				+ "/*@media only screen and (min-device-width: 601px) {.content {width: 600px !important;}.col425 {width: 425px!important;}.col380 {width: 380px!important;}}*/</style><table width='100%' bgcolor='#f6f8f1' border='0' cellpadding='0' cellspacing='0'><tr><td><!--[if (gte mso 9)|(IE)]><table width='600' align='center' cellpadding='0' cellspacing='0' border='0'><tr><td><![endif]--><table bgcolor='#ffffff' class='content' align='center' cellpadding='0' cellspacing='0' border='0'><tr><td bgcolor='#44525f' class='header'><!--[if (gte mso 9)|(IE)]><table width='425' align='left' cellpadding='0' cellspacing='0' border='0'><tr><td><![endif]--><table class='col425' align='left' border='0' cellpadding='0' cellspacing='0'   style='width: 100%; max-width: 425px;'><tr><td height='70'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td class='subhead' style='padding: 0 0 0 3px;'>ITALCAR FIDELITE</td></tr></table></td></tr></table><!--[if (gte mso 9)|(IE)]></td></tr></table><![endif]--></td></tr><tr><td class='innerpadding borderbottom'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td class='h2'>"
				+ titreContentMail + "</td></tr><tr><td class='bodycopy' style='padding: 0 0 0 5px'>" + bodyContentMail
				+ "</td></tr></table></td></tr></tr></table><!--[if (gte mso 9)|(IE)]></td></tr></table><![endif]-->  </td></tr></table>";

		messageBodyPart.setContent(templateMail1, "text/html; charset=utf-8");

		/**
		 * ajout du body
		 */
		multipart.addBodyPart(messageBodyPart);

		/**
		 * 2er : préparation des images embarqués
		 */

		/**
		 * LOGO Profil job
		 */
		/*
		 * messageBodyPart = new MimeBodyPart(); String profilJobLogo =
		 * EnvoiMailUtil.class.getResource( "/img/logo_clearing.png").getPath();
		 * DataSource fds = new FileDataSource(profilJobLogo);
		 * messageBodyPart.setDataHandler(new DataHandler(fds));
		 * messageBodyPart.setHeader("Content-ID", "<image>");
		 * multipart.addBodyPart(messageBodyPart);
		 */

		/**
		 * Ajout de contenu et de l'entete
		 */
		MimeMessage message = new MimeMessage(mailSession);
		message.setContent(multipart);
		message.setSubject(titreMail);

		/**
		 * ***********************************************************
		 * préparation du destinataire
		 * ***********************************************************
		 */
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinataire));

		/**
		 * *********************************************************** ENVOI
		 * ***********************************************************
		 */
		Transport transport = mailSession.getTransport();
		transport.connect();
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		System.out.println("MAIL SENT SUCCESSFULLY");
		transport.close();

	}

	public static String getUsername() {
		return USERNAME;
	}

	public static String getPassword() {
		return PASSWORD;
	}
}
