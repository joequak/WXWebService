package manager;


import entity.CustEnquiry;
import static entity.Customer_.password;
import java.util.Date;
import java.util.Properties;
import javax.ejb.EJBException;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import util.SMTPAuthenticator;

public class EmailManager {

    String emailServerName = "mailauth.comp.nus.edu.sg";
// Replace with your real name and unix email address
    String emailFromAddress = "Ruoxi Yan<a0085264@comp.nus.edu.sg>";
// Replace with your real name and NUSNET email address
    String toEmailAddress = "Ruoxi Yan<yournusnetusername@nus.edu.sg>";
    String mailer = "JavaMailer";

    public EmailManager() {
    }
    
    public void setToEmialAddress(String email){
    toEmailAddress=email;
    }

    public void sendResponse(CustEnquiry enquiry) {
     String  text="Hello "+ enquiry.getEmailAddress() +" \n :" + "This email is resgarding your enquiry "+ enquiry.getSubject()+" with the following content : \n" + enquiry.getContent() +"We sincerely thank you for your help. Our response is as follow : \n" + enquiry.getReply()+" Regards\n Wine Express";

        try {
            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", emailServerName);
            props.put("mail.smtp.port", "25");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.debug", "true");
            javax.mail.Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            session.setDebug(true);
            Message msg = new MimeMessage(session);
            if (msg != null) {
                msg.setFrom(InternetAddress.parse(emailFromAddress, false)[0]);
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailAddress, false));
                msg.setSubject("Setting New Password");
                String messageText = "Greetings from Island Furniture Management System, here is your new password" + text;

                msg.setText(messageText);
                msg.setHeader("X-Mailer", mailer);
                Date timeStamp = new Date();
                msg.setSentDate(timeStamp);
                Transport.send(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EJBException(e.getMessage());
        }
    }
}
