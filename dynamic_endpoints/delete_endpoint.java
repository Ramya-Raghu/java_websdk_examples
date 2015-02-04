package web_phne;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.response.GenericResponse;
import com.plivo.helper.exception.PlivoException;

import java.io.IOException;
import java.util.LinkedHashMap;

@WebServlet("/delete")
public class delete extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String auth_id = "Your AUTH_ID";
        String auth_token = "Your AUTH_TOKEN";
        
        // Fetch the endpoint id from the query url
        String end_id = request.getParameter("endpoint_id");
        
        RestAPI api = new RestAPI(auth_id, auth_token, "v1");
        
        // Delete the endpoint
        LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
        parameters.put("endpoint_id", end_id); 
        
        try {
            GenericResponse resp = api.deleteEndpoint(parameters);
            // Print the response
            System.out.println(resp.message);
        }catch (PlivoException e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
