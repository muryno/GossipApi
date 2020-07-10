package main.java.com.muryno;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddServlet extends HttpServlet  {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));

        int k = i+ j;


        Cookie cok = new Cookie("k",k+"");
        resp.addCookie(cok);

//        //session
//        HttpSession ses = req.getSession();
//        ses.setAttribute("k",k);

        //responds
       // resp.sendRedirect("sq?k="+k);

//      PrintWriter pr =  resp.getWriter();
//
//        resp.setContentType("text/html");
//      pr.println("Result is " + k );



    }
}
