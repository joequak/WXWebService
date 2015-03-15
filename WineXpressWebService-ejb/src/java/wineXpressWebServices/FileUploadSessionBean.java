/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import javax.ejb.Stateless;

/**
 *
 * @author mac
 */
@Stateless
public class FileUploadSessionBean implements FileUploadSessionBeanLocal {

    @Override
    public Boolean uploadPicture(String url) {
        String newUrl = "./../images/productImg/" + url;
        System.out.println(newUrl);
        return true;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
