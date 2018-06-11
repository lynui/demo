/**
 * 
 */
package self.demo.test;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * @author liufei45
 *
 */
public class WandaMail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String smtpServer = "10.199.84.23";
		String from = "mri@wanda.com.cn";
		String userName = "mri";
		String password = "wanda111";
		String to = "liufei45@wanda.cn";
		String subject = "你好";
		String content = "你好啊";
		HtmlEmail email = new HtmlEmail();
		email.setHostName(smtpServer);// 设置发信的smtp服务器

		try {
			email.setFrom(from);
			email.setAuthentication(userName, password);// 在这里设置帐号、密码
			email.setCharset("UTF-8");
			email.setSubject(subject);
			email.addTo(to);
			email.setHtmlMsg(content);
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Boolean sendReportEmailWithFile(String subject, String msg, List<String> toEmails, String fileUrl)
			throws EmailException {
		HtmlEmail email = getReportHttpEmail();
		String cid = email.embed(fileUrl, "reportImage");
		email.setSubject(subject);
		for (String toEmail : toEmails) {
			email.addTo(toEmail);
		}
		email.setHtmlMsg(msg.replace("{image}", cid));// 设置邮件正文和字符编码
		email.send();
		return true;
	}

	/**
	 * 获取发送邮件对象
	 *
	 * @return
	 */
	private HtmlEmail getReportHttpEmail() throws EmailException {
		HtmlEmail email = new HtmlEmail();
		// email.setHostName(configCenter.getEmailServer());//设置发信的smtp服务器
		// email.setFrom(configCenter.getEmailFullAccount());//设置发信的邮件帐号和发信人
		// email.setAuthentication(configCenter.getEmailAccount(),
		// configCenter.getSendEmailPwd());//在这里设置帐号、密码
		// email.setCharset("UTF-8");
		return email;
	}

}
