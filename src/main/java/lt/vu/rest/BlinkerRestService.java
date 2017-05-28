package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Named
@ApplicationScoped
@Path("/blinker")
public class BlinkerRestService {
    @Getter
    @Setter
    private Integer throttle = 0;

    @GET
    public String find() {
        return Integer.toString(throttle);
    }
}
