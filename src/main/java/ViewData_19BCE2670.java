import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewData_19BCE2670 extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/akshat","root","");
            Statement stmt=con.createStatement();
            String QuerySt="select * from my_family_info_2_19bce2670";
            ResultSet resSet=stmt.executeQuery(QuerySt);
            out.println("<html>");
            out.println("<head><title>Display and Update Data</title>");
            out.println("<style type=\"text/css\" media=\"screen\">");
            out.println(" body{ background: mediumslateblue; }");
            out.println(" table{ font-size: x-large; }");
            out.println("  th{ color: firebrick; }");
            out.println(" #Update{ font-size: x-large; color: darkolivegreen; }");
            out.println(" div{ background: aquamarine; text-align: center; margin-bottom: 30px;  margin-top: 15.5%; font-size: x-large; padding-bottom: 12px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.print("<div>");
            out.println("<h1><center>Family Members</center></h1>");
            out.println("<table border=\"1\" align=\"center\"><tr> <th>Name</th><th>Age</th><th>Relation with Akshat</th><th>Phone Number</th><th>Action</th></tr>");
            while(resSet.next()){

                out.print("<form method=\"post\" action=\"UpdateData\">");
                String A1=resSet.getObject(1).toString();
                out.print("<tr><td>");
                out.print(A1);
                out.print("</td><td>");
                out.print(resSet.getObject(2).toString());
                out.print("</td><td>");
                out.print(resSet.getObject(3).toString());
                out.print("</td><td>");
                out.print(resSet.getObject(4).toString());
                out.print("</td><td>");
                out.print("<input type=\"hidden\" name=\"pk\" value='"+A1+"'>");
                out.print("<input type=\"submit\" id = \"Update\" value=\"Update\">");
                out.print("</td></tr>");
                out.print("</form>");

            }
            out.print("</div>");
            con.close();
        }
        catch(Exception exe){
            out.println("Exception Caught ");
            out.println(exe);
        }
        out.println("</body>");


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
}
