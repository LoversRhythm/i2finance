package drawway;

import com.alibaba.fastjson.JSON;
import com.i2finance.lottery.LuckyDraw;
import com.i2finance.lottery.LuckyDrawImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : main.chu
 * @date : 2018-01-21
 */
@javax.servlet.annotation.WebServlet(name = "DrawWayServlet")
public class DrawWayServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        String str = "[ {\"id\": \"\",\"name\": \"smith\" }, {\"id\": \"23\",\"name\": \"e\" }]";
//        response.getWriter().write(str);
//        System.out.println(request.getParameter("drawWay"));
//        列表创建Json数据
//        List<Map<Integer, String>> listMap = new ArrayList<>();
//        Map<Integer, String> map = new HashMap<>();
//        map.put(id, 21);
//        listMap.add(map);
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        LuckyDrawImpl luckyDraw = new LuckyDrawImpl();
        String str = JSON.toJSONString(luckyDraw.getLuckyResult(Integer.parseInt(request.getParameter("teamOrSinger")),
                Integer.parseInt(request.getParameter("putOrNotput"))));
        System.out.println(str);
        response.getWriter().write(str);
    }

}
