import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Welcome_19BCE2670 extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String name = request.getParameter("Name") ;
        String age = request.getParameter("Age");
        String relation = request.getParameter("Relation");
        String phNo = request.getParameter("PhNo");

        out.println("<html>");
        out.println("<head>");
        out.println("<style type=\"text/css\" media=\"screen\">");
        out.println(" body{ background: mediumslateblue; }");
        out.println(" a{ color: darkgoldenrod; }");
        out.println(" div{ background: aquamarine; text-align: center; margin-bottom: 30px; margin-top: 7%; }");
        out.println(" #highlight{ color: firebrick; }");
        out.println(" #submit{ color:darkred; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body><br>");
        out.println("<div>");
        out.println("<h2 id = \"highlight\">Welcome: </h2><h2>" + name + "</h2>");
        out.println("<h2 id = \"highlight\">Your age: </h2><h2>" + age + "</h2>");
        out.println("<h2 id = \"highlight\">Your relation with Akshat: </h2><h2>" + relation + "</h2>");
        out.println("<h2 id = \"highlight\">Your phone number: </h2><h2>" + phNo + "</h2>");
        out.println("<h2 id = \"highlight\">YOUR DATA HAS BEEN STORED IN THE DATABASE!!</h2>");
        out.println("<a href=\"FamilyMembersInfo.html\"><h3>Click here to enter more family details</h3></a>");
        out.println("<a href=\"ViewData\"><h3>Click here to view and update stored data</h3></a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/akshat","root","");
            Statement stmt = con.createStatement();
            String QuerySt = "insert into my_family_info_2_19bce2670 values('" + name + "'," + age + ",'" + relation + "','" + phNo + "');";
            stmt.executeUpdate(QuerySt);
            con.close();
        } catch (ClassNotFoundException | SQLException e2) {
            e2.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }
}
