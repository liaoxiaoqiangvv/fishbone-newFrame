package Action;

import DAO.DaoDB;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/loadTable")
public class loadTable extends HttpServlet {
   protected void doPost (HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
//      根据用户名进行查询
      Map<String, String> userInfo = (Map<String, String>) request.getSession().getAttribute("userInfo");
      String userName = userInfo.get("username");
      System.out.println("查询用户名是：" + userName);
      String queryResult = DaoDB.query(userName);
//      返回结果
      queryResult = "{" + "\"data\"" + ":" + queryResult + "}";
      PrintWriter out = response.getWriter();
      out.print(queryResult);
   }

   protected void doGet (HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      this.doPost(request, response);
   }
}