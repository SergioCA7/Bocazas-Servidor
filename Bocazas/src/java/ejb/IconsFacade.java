/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Icons;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author inftel10
 */
@Stateless
public class IconsFacade extends AbstractFacade<Icons> {

    @PersistenceContext(unitName = "BocazasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IconsFacade() {
        super(Icons.class);
    }
    
}
