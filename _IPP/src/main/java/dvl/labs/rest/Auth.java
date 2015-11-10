package dvl.labs.rest;

import dvl.labs.bll.AuthLayer;
import dvl.labs.bll.AuthLayerImpl;
import dvl.labs.common.User;
import org.json.JSONObject;

import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


/**
 * Created by iura on 10/11/15.
 */
@Path("/")
public class Auth {

    AuthLayer layer = new AuthLayerImpl();

    @Path("/register")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String register(@QueryParam("in") String request) {

        User user  = RestValidator.checkUserValidity(request);
        JSONObject result = layer.register(user);

        return result.toString();

    }
    @Path("/login")
    @GET
    public String login(@QueryParam("in") String request) {
        User user  = RestValidator.checkUserValidity(request);
        JSONObject result = layer.login(user);

        return result.toString();
    }

    @Path("/get_last_login")
    @GET
    public String getUserLastLogin(@QueryParam("in") String request) {
        User user  = RestValidator.checkUserValidity(request);
        JSONObject result = layer.getLastEntry(user);

        return result.toString();
    }
    @Path("/test_rest")
    @GET
    public String testGet() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","1");
        return jsonObject.toString();
    }
}
