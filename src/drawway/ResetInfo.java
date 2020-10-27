package drawway;

import com.i2finance.lottery.LuckyDrawImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : main.chu
 * @date : 2018-01-24
 */
@WebServlet(name = "ResetInfo")
public class ResetInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LuckyDrawImpl luckyDraw = new LuckyDrawImpl();
        System.out.println(request.getParameter("resetInfo"));
        luckyDraw.resetInfo(Integer.parseInt(request.getParameter("resetInfo")));
    }
}
