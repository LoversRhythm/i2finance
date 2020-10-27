package utils.jdbcTemplate;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author : main.chu
 * @date : 2018-01-16
 */
public class JdbcTemplate {

    public static void create(int id, String name, Date birthday) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 2.建立连接
            conn = JdbcUtils.getConnection();
            // 3.创建语句
            String sql = "insert into users(ID, Name, Birthday) values(?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDate(3, birthday);
            // 4.执行语句
            int i = ps.executeUpdate();
            // 5.处理结果
            if (i == 0) {
                System.out.println("插入失败，数据库条目没有发生修改，请检查SQL语句！");
            } else {
                System.out.println("插入成功，" + i + "条数据已增加！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
    }

    public static void read(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 2.建立连接
            conn = JdbcUtils.getConnection();
            // 3.创建语句
            String sql = "select * from users";
            ps = conn.prepareStatement(sql);
            // 4.执行语句
            rs = ps.executeQuery();
            /* 5.处理结果 */
            while (rs.next()) {
                StringBuffer strTemp = new StringBuffer("");
                for (int i = 1; i < rs.getMetaData().getColumnCount()+1; i++) {
                    strTemp.append("\t").append(rs.getObject(i));
                }
                System.out.println(strTemp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
    }

    public static void update(int id, String name, Date birthday) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 2.建立连接
            conn = JdbcUtils.getConnection();
            // 3.创建语句
            String sql = "UPDATE users SET NAME = ?, Birthday = ? WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(3, id);
            ps.setString(1, name);
            ps.setDate(2, birthday);
            // 4.执行语句
            int i = ps.executeUpdate();
            // 5.处理结果
            if (i == 0) {
                System.out.println("更新失败，数据库条目没有发生修改，请检查SQL语句！");
            } else {
                System.out.println("ID<" + id + ">的数据更新成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
    }

    public static void delete(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 2.建立连接
            conn = JdbcUtils.getConnection();
            // 3.创建语句
            String sql = "delete from users where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            // 4.执行语句
            int i = ps.executeUpdate();
            // 5.处理结果
            if (i == 0) {
                System.out.println("删除失败，数据库条目没有发生修改，请检查SQL语句！");
            } else {
                System.out.println("ID<" + id + ">的数据删除成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
    }
}
