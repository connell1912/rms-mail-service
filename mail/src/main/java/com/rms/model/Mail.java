package com.rms.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Mail {

	// Replace sender@example.com with your "From" address.
	// This address must be verified.
	final private String FROM = "project3.1912@gmail.com";
	final private String FROMNAME = "Revature RMS";

	// Replace recipient@example.com with a "To" address. If your account
	// is still in the sandbox, this address must be verified.
	private String to;

	// Replace smtp_username with your Amazon SES SMTP user name.
	final private String SMTP_USERNAME = "";

	// Replace smtp_password with your Amazon SES SMTP password.
	private final String SMTP_PASSWORD = "";

	// The name of the Configuration Set to use for this message.
	// If you comment out or remove this variable, you will also need to
	// comment out or remove the header below.
//	    static final String CONFIGSET = "ConfigSet";

	// Amazon SES SMTP host name. This example uses the US West (Oregon) region.
	// See
	// https://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
	// for more information.
	private final String HOST = "email-smtp.us-east-1.amazonaws.com";

	// The port you will connect to on the Amazon SES SMTP endpoint.
	private final int PORT = 587;

	// The subject line for the email.
	private final String SUBJECT = "Password Reset";
	//TODO: fix this
	// The HTML body for the email.
	private final String BODY = String.join(System.getProperty("line.separator"), "<h1>Password Reset</h1>",
			"<p>Reset your password at ",
			"<a href='http://localhost:3000/passchange'>RMS Reset Password</a>");
			
	@Override
	public String toString() {
		return "Mail [FROM=" + FROM + ", FROMNAME=" + FROMNAME + ", to=" + to + ", SMTP_USERNAME=" + SMTP_USERNAME
				+ ", SMTP_PASSWORD=" + SMTP_PASSWORD + ", HOST=" + HOST + ", PORT=" + PORT + ", SUBJECT=" + SUBJECT
				+ ", BODY=" + BODY + "]";
	}
	public Mail() {
		super();
	}
	public Mail(String to) {
		super();
		this.to = to;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFROM() {
		return FROM;
	}
	public String getFROMNAME() {
		return FROMNAME;
	}
	public String getSMTP_USERNAME() {
		return SMTP_USERNAME;
	}
	public String getSMTP_PASSWORD() {
		return SMTP_PASSWORD;
	}
	public String getHOST() {
		return HOST;
	}
	public int getPORT() {
		return PORT;
	}
	public String getSUBJECT() {
		return SUBJECT;
	}
	public String getBODY() {
		return BODY;
	}
}