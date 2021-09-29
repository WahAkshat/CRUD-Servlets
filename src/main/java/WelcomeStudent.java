import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WelcomeStudent")
public class WelcomeStudent extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String name = request.getParameter("Name") ;
        String email = request.getParameter("Email");
        String gender = request.getParameter("Gender");
        String hobbies[] = request.getParameterValues("Hobbies");
        String city = request.getParameter("City") ;
        String address = request.getParameter("Address");

        System.out.println(name+"\n"+email+"\n"+gender+"\n"+city+"\n"+address+"\n");
        for(String a: hobbies)
            System.out.println(a);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
