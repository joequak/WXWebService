/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import entity.Comment;
import entity.Customer;
import entity.Product;
import javax.ejb.Local;

/**
 *
 * @author ¿.¿.¿
 */
@Local
public interface ContentMngmtSBLocal {

    void rateProduct(Customer cus,Product myProduct, int myRate);

    void makeComment(Product myProduct, String newComment, Customer cus);

    void deleteComment(Comment myComment);
    
}
