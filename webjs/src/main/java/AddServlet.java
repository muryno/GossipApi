import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddServlet extends HttpServlet  {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));

        int k = i+ j;


//        Cookie cok = new Cookie("k",k+"");
//        resp.addCookie(cok);

//        //session
//        HttpSession ses = req.getSession();
//        ses.setAttribute("k",k);

        //responds
       // resp.sendRedirect("sq?k="+k);

//      PrintWriter pr =  resp.getWriter();
//
//        resp.setContentType("text/html");
//      pr.println("Result is " + k );

        String s = "See me";
        req.setAttribute("kr",s);

    RequestDispatcher rw =  req.getRequestDispatcher("index.jsp");


        rw.forward(req,resp);

    }
}
