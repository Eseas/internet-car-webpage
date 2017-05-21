package lt.vu.rest;

import lombok.Getter;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Named
@ApplicationScoped
@Path("/blinker")
//@Produces(MediaType.APPLICATION_JSON)
public class BlinkerRestService {

    @Inject private EntityManager em;

    @Getter
//    @Setter
    private Integer interval = 1000;

//    @Getter
//    @Setter
    private Integer throttle = 0;

    @GET
    public String find() {
        return Integer.toString(throttle);
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public void update() {
        System.out.println("something need to be done");
    }

//    @GET
//    @Path("/throttle")
//    public String getThrottle() {
//        return Integer.toString(throttle);
//    }
    public Integer getThrottle() { 
        return throttle;
    }

    public void setThrottle(Integer throttle) {
        this.throttle = throttle;
    }

    public void setValue(int throttle) {
        this.throttle = throttle;
    }

    public void onChange(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "You have selected: " + throttle, null));
    }
}
