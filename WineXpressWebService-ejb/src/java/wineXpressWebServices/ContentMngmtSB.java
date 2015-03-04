/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ¿.¿.¿
 */
@Stateless
public class ContentMngmtSB implements ContentMngmtSBLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //Entity Manager to read write to DB
    @PersistenceContext
    private EntityManager em;

    public ContentMngmtSB() {
    }
    
    
}
