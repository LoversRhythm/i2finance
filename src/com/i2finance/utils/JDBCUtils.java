package com.i2finance.utils;

import com.i2finance.bean.Group;
import com.i2finance.bean.Student;
import com.i2finance.bean.WinLog;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 白昊天
 * @date 2018/1/16
 **/
public class JDBCUtils {

    /**
     * 获得Connection连接
     * @return mysql Connection连接
     */
    private static Connection getConnection(){

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/luckydraw?useUnicode=true&characterEncoding=UTF-8";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }



    /**
     * 通过id查询
     * @param studentOrGroup 查询类型
     * @param id 抽中的id
     * @return  信息的bean对象
     * @throws SQLException
     */
    public static Object queryById(String studentOrGroup, int id) throws SQLException {

        String sql = "SELECT * from "+studentOrGroup+" WHERE id =?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        Object o = null;
        String studentStr = "group";
        String groupStr = "student";
        if(studentStr.equals(studentOrGroup)){
            o = resultStudent(resultSet);
        }else if(groupStr.equals(studentOrGroup)){
            o = resultGroup(resultSet);
        }
        connection.close();
        return o;
    }

    /**
     * 通过名字查询
     * @param studentOrGroup 查询类型
     * @param name 查询的名字
     * @return  查询的bean对象
     * @throws SQLException
     */
    public static Object queryByName(String studentOrGroup,String name) throws SQLException {
//        List<Integer> list = new ArrayList<>();
        //暂未实现重名查询
      /*  if(list.size()<1){
            return "没有所查询的信息";
        }if(list.size()>1){
            for(int i:list){
                Object o = queryById(studentOrGroup, i);
            }
        }*/
        int id = getIdByName(studentOrGroup,name);
        Object o = queryById(studentOrGroup, id);
        return o;
    }

    /**
     * 通过表名和组名或人名获得id
     * @param studentOrGroup 表明
     * @param name 组名或人名
     * @return 组id或人id
     */
    public static int getIdByName(String studentOrGroup,String name) throws SQLException {
        Connection connection = getConnection();
        String sql = "SELECT id FROM ? WHERE name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,studentOrGroup);
        preparedStatement.setString(2,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = 0;
        while (resultSet.next()){
            id = (int) resultSet.getObject("id");
        }
        connection.close();
        return id;
    }

    //获得指定组的成员的id

    /**
     * 通过指定组名获得该小组所有成员的id
     * @param groupName 组名
     * @return 所有该小组的成员id
     * @throws SQLException
     */
    public static List<Integer> getIdFromGroup(String groupName) throws SQLException {
        List<Integer> list = new ArrayList<>();
        int groupId = getIdByName("group", groupName);
        String sql = "SELECT id FROM student WHERE group_id = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,groupId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            list.add((Integer) resultSet.getObject(1));
        }
        connection.close();
        return list;
    }

    /**
     * 接受结果集信息，返回个人信息
     * @param resultSet 结果集
     * @return  个人信息
     * @throws SQLException
     */
    private static Student resultStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        while(resultSet.next()){
            student.setId((Integer) resultSet.getObject("id"));
            student.setName((String) resultSet.getObject("name"));
            student.setBirthday((String) resultSet.getObject("birthday"));
            student.setPhoto((String) resultSet.getObject("photo"));
            student.setGroup_id((Integer) resultSet.getObject("group_id"));
        }
        return student;
    }

    /**
     * 接受结果集，返回小组信息
     * @param resultSet 结果集
     * @return  小组信息
     * @throws SQLException
     */
    private static Group resultGroup(ResultSet resultSet) throws SQLException {
        Group group = new Group();
        while(resultSet.next()){
            group.setId((Integer) resultSet.getObject("id"));
            group.setName((String) resultSet.getObject("name"));
        }
        return group;
    }

    /**
     * 获取表中记录条数
     * @param studentOrGroup 表名
     * @return 表成员个数
     * @throws SQLException
     */
    public static int getMemberNumber(String studentOrGroup) throws SQLException {

        Connection connection = getConnection();
        String sql = "SELECT count(*) FROM "+studentOrGroup;
        int num = 0;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1,studentOrGroup);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            String count = ""+resultSet.getObject(1);
            num = Integer.parseInt(count);
        }
        connection.close();
        return num;
    }

    //查询日志
    //日志表名为  win_log  列名id  winner_id winner_name win_date
    /**
     * 通过中奖编号查询中奖信息
     * @param id 中奖编号
     * @return 日志信息的bean对象
     * @throws SQLException
     */
    public  static WinLog getLogMessageById(int id) throws SQLException {
        WinLog winLog = new WinLog();
        String sql = "SELECT * FROM win_log WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            winLog.setId(id);
            winLog.setWinnerId((Integer) resultSet.getObject("winner_id"));
            winLog.setWinnerName((String) resultSet.getObject("winner_name"));
            winLog.setWinDate((String) resultSet.getObject("win_date"));
        }
        connection.close();

        return winLog;
    }

    /**
     * 根据中奖者姓名获取总中奖次数
     * @param name 中奖者姓名
     * @return 中奖次数
     */
    public static int getWinTimesByName(String name) throws SQLException {
        int times = 0;
        String sql = "SELECT COUNT(*) FROM win_log WHERE name = ?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            times = (int) resultSet.getObject(1);
        }
        connection.close();
        return times;
    }

    /*
        暂未实现查询功能

    //插入日志
    *//*
    public static void insertLog(WinLog winLog) throws SQLException {
        String sql = "INSERT INTO win_log(id,winner_id,winner_name,win_date) VALUES(?,?,?,?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,winLog.getId());
        preparedStatement.setInt(2,winLog.getWinnerId());
        preparedStatement.setString(3,winLog.getWinnerName());
        preparedStatement.setDate(4,winLog.getWinDate());
        preparedStatement.execute();
        connection.close();
    }*/




    public static List<Map<String,String>> queryByIdToList(String studentOrGroup, int id) throws SQLException {

        String sql = "SELECT * from "+studentOrGroup+" WHERE id =?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Map<String, String>> list = resultToList(resultSet);
        connection.close();
        return list;
    }


    private static List<Map<String,String>> resultToList(ResultSet resultSet) throws SQLException {
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();

        String columnName = null;
        String columnValue = null;

        while(resultSet.next()){
            for(int i=1;i<=resultSet.getMetaData().getColumnCount();i++){
                columnName = resultSet.getMetaData().getColumnName(i);
                columnValue = ""+ resultSet.getObject(columnName);
                map.put(columnName,columnValue);
            }
        }
        list.add(map);
        return list;
    }

    //插入中过奖的id
    public static void insertRepet(int id,String studentOrGroup) throws SQLException {
        String sql = "INSERT INTO "+studentOrGroup+"_repet"+" VALUES(?)";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
        connection.close();
    }

    //查询是否有重复
    public static List<Integer> queryRepet(String studentOrGroup) throws SQLException {
        List<Integer> list = new ArrayList<>();
        String sql = "SELECT * FROM "+studentOrGroup+"_repet";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int i = (int) resultSet.getObject(1);
            list.add(i);
        }
        connection.close();
        return list;
    }
    //清空中奖id
    public static void emptyRepet(String studentOrGroup) throws SQLException {
        String sql = "TRUNCATE TABLE "+studentOrGroup+"_repet";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
    }

}


