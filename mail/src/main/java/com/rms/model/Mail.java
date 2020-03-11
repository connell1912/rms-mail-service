package com.rms.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Mail {

	// Replace sender@example.com with your "From" address.
	// This address must be verified.
	private static final  String FROM = "project3.1912@gmail.com";
	private static final String FROMNAME = "Revature RMS";

	// Replace recipient@example.com with a "To" address. If your account
	// is still in the sandbox, this address must be verified.
	private String to;

	// Replace smtp_username with your Amazon SES SMTP user name.
	private static final String SMTP_USERNAME = "AKIAR5NF4UGVRMYTFHKE";

	// Replace smtp_password with your Amazon SES SMTP password.
	private static final String SMTP_PASSWORD = "BK7fA59x972H7MF2x3ux6n9T0RbZnIrAMvrNYCVT6+Dh";

	// Amazon SES SMTP host name. This example uses the US West (Oregon) region.
	// See
	// https://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
	// for more information.
	private static final String HOST = "email-smtp.us-east-1.amazonaws.com";

	// The port you will connect to on the Amazon SES SMTP endpoint.
	private static final int PORT = 587;

	// The subject line for the email.
	private static final String SUBJECT = "Password Reset";
	
	// The HTML body for the email.
	private static final String BODY = String.join(System.getProperty("line.separator"), "<h1>Password Reset</h1>",
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
	public String getSMTPUSERNAME() {
		return SMTP_USERNAME;
	}
	public String getSMTPPASSWORD() {
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