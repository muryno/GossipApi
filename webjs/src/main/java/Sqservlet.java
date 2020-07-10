import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sq")
public class Sqservlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        Cookie[] coks = req.getCookies();

        for (Cookie co : coks){
            if(co.equals("k")){
                System.out.println("Result is "+ Integer.parseInt( co.getValue()));  ;

            }
        }

        //session
//        HttpSession se = req.getSession();
//       String d = (String)   se.getAttribute("k");




    }
}
