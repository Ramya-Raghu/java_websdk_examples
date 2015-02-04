package web_phne;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import com.plivo.helper.api.client.RestAPI;
import com.plivo.helper.api.response.endpoint.Endpoint;
import com.plivo.helper.exception.PlivoException;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Random;

@WebServlet("/plivo")
public class phone extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String auth_id = "Your AUTH_ID";
        String auth_token = "Your AUUTH_TOKEN";

        char username, password;
        String uname = "";
        String end_id = "";
        
        // Generate a random usernam and password
        Random r = new Random();
        StringBuffer randStr = new StringBuffer();
        StringBuffer randString = new StringBuffer();
        for(int i=0; i<6; i++){
            username = (char)(r.nextInt(26) + 'a');
            password = (char)(r.nextInt(26) + 'a');
            randStr.append(username);
            randString.append(password);
        }
        String finalUsername = randStr.toString();
        String finalPassword = randString.toString();
        //System.out.println(finalUsername);
        //System.out.println(finalPassword);
        
        RestAPI api = new RestAPI(auth_id, auth_token, "v1");
        
        // Create an Endpoint
        LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
        parameters.put("username", finalUsername);
        parameters.put("password", finalPassword);
        parameters.put("alias", finalUsername);
        
        try {
            Endpoint resp = api.createEndpoint(parameters);
            // Get the created Endpoint ID and username
            end_id = resp.endpointId.toString();
            uname = resp.username.toString();
            System.out.println(uname);
        }catch (PlivoException e){
            System.out.println(e.getLocalizedMessage());
        }
        
        // Forward the username, password and endpoint id information to a JSP view
        response.setContentType("text/html");
        request.setAttribute("username", uname);
        request.setAttribute("password", finalPassword);
        request.setAttribute("endpoint_id", end_id);
        RequestDispatcher view = request.getRequestDispatcher("phone.jsp");
        view.forward(request, response);
    }
}
