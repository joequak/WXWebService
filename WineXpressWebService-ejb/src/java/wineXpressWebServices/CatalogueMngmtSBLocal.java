/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wineXpressWebServices;

import javax.ejb.Local;

/**
 *
 * @author ¿.¿.¿
 */
@Local
public interface CatalogueMngmtSBLocal {

    Boolean addNewCategory(String name);

    Boolean addNewSubCategori(String cateoryName, String newSubName);


}