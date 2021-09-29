import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateData_19BCE2670 extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update Phone Number Page</title>");
            out.println("<style type=\"text/css\" media=\"screen\">");
            out.println(" body{ background: mediumslateblue; }");
            out.println(" a{ color: darkgoldenrod; }");
            out.println(" #highlight{ color: firebrick; }");
            out.println(" div{ background: aquamarine; text-align: center; margin-bottom: 30px;  margin-top: 15.5%; font-size: x-large; padding-bottom: 12px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            String name=request.getParameter("pk");
            out.println("<div>");
            out.println("<h2 ><p>Family whose phone number is to be updated</p></h2><h2 id = \"highlight\"><p>"+name+"</p></h2>");
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/akshat","root","");
                Statement stmt=con.createStatement();
                String a2 = "5555555555";//UPDATING WITH THIS VALUE
                String QuerySt="update my_family_info_2_19bce2670 set phno='"+a2+"'where name='"+name+"';";
                stmt.executeUpdate(QuerySt);
                out.println("<p>Updated successfully</p>");
                con.close();
            }
            catch(Exception exe){}
            out.println("<a href=\"ViewData\">View Data</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}

