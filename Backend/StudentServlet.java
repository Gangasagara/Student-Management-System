import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students(name,email,course) VALUES(?,?,?)"
            );
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.executeUpdate();
            res.getWriter().print("Student Added Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
