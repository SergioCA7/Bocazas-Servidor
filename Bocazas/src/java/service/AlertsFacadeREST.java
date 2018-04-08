/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Alerts;
import entities.Icons;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author inftel10
 */
@Stateless
@Path("entities.alerts")
public class AlertsFacadeREST extends AbstractFacade<Alerts> {

    @PersistenceContext(unitName = "BocazasPU")
    private EntityManager em;

    public AlertsFacadeREST() {
        super(Alerts.class);
    }

    @POST
    @Override
    @Consumes({ MediaType.APPLICATION_JSON})
    public void create(Alerts entity) {        
        super.create(entity);
    }
    
    
    
     @POST
     @Path("{idIcon}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void createAngular(Alerts entity,@PathParam("idIcon") String idIcon) {       
        Icons icon = new Icons(new BigDecimal(idIcon));
        entity.setIdIcon(icon);
        super.create(entity);
    }
    
    
    
    
    @GET
    @Path("alert/{message}/{verification}/{alertTime}/{idIcon}")
    @Produces({MediaType.APPLICATION_JSON})
    public String createNewAlert(@PathParam("message") String message,@PathParam("verification") String ver,@PathParam("alertTime") String aler,@PathParam("idIcon") String idIcon) {
        Alerts alert = new Alerts();
        alert.setAddress(message);
        alert.setAlertTime(new BigInteger (aler));
        alert.setIdIcon(new Icons(new BigDecimal (idIcon)));
        alert.setVerifications(BigInteger.ZERO);
        super.create(alert);
        System.out.println("PASO");
        return "{\"response\":\"ok\"}";
                
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") BigDecimal id, Alerts entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") BigDecimal id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Alerts find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Alerts> findAll() {
        Query query = em.createQuery("SELECT a FROM Alerts a ORDER BY a.alertTime DESC ");
        return (List<Alerts>) query.getResultList();
        
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Alerts> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("/add/{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public String add(@PathParam("id") BigDecimal id) {
        Alerts alert = this.find(id);
        alert.setVerifications(alert.getVerifications().add(BigInteger.ONE));
        super.edit(alert);
        return "{\"response\":\"ok\"}";
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
