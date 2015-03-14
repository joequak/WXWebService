/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.CustEnquiry;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ¿.¿.¿
 */
@Local
public interface CustSupportSBLocal {

    public boolean creatEnquiry(CustEnquiry enquiry);

    public List<CustEnquiry> getNewEnquiry();

    public boolean sendResponse(Long id, String response);

    public boolean sendEmail(String toEmail, String subject, String content);

    public String generatePassword();
}
