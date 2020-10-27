package utils.jdbcTemplate;

import java.sql.*;

/**
 * @author : main.chu
 * @date : 2018-01-16
 */
public class JdbcUtils {

    private final static String URL = "jdbc:mysql://localhost:3306/luck_draw?useUnicode=true&characterEncoding=UTF-8";
    private final static String USER = "root";
    private final static String PASSWORD = "root";

    private JdbcUtils() {
    }

    static {
        // 1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("注册驱动出错！");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void free(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
