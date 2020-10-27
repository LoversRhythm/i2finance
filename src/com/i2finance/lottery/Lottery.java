package com.i2finance.lottery;

import com.i2finance.utils.ArithmeticUtils;
import com.i2finance.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 白昊天
 * @date 2018/1/20
 **/
public class Lottery {

    private static List<Integer> list = new ArrayList<>();

    /**
     * 不放回抽奖
     *
     * @param studentOrGroup 组或者人
     * @return 返回抽中成员的bean对象
     * @throws SQLException
     */
    public static Object lotteryNotPutback(String studentOrGroup) throws SQLException {
        Object o = null;
        int randomId = 0;
        boolean isExist = false;
        //获得成员个数
        int memberNumber = JDBCUtils.getMemberNumber(studentOrGroup);
        do {
            isExist = false;
            //获得随机数
            randomId = ArithmeticUtils.random(1, memberNumber);
            for (int i : list) {
                if (i == randomId) {
                    isExist = true;
                }
            }
        } while (isExist);
        list.add(randomId);
        //根据随机数从数据库中取得数据
        o = JDBCUtils.queryById(studentOrGroup, randomId);
        return o;
    }

    /**
     * 放回抽奖
     *
     * @param studentOrGroup 组或者人
     * @return 返回抽中成员的bean对象
     * @throws SQLException
     */
    public static Object lotteryPutback(String studentOrGroup) throws SQLException {
        int randomId = 0;
        Object o = null;
        //获得成员个数
        int memberNumber = JDBCUtils.getMemberNumber(studentOrGroup);
        //获得随机数
        randomId = ArithmeticUtils.random(1, memberNumber);
        //根据随机数从数据库中取得数据
        o = JDBCUtils.queryById(studentOrGroup, randomId);
        return o;

    }

    /**
     * 从指定小组抽取学生
     *
     * @param groupName 指定小组
     * @return 随机抽取到的学生
     * @throws SQLException
     */
    private static Object lotteryFromGroup(String groupName) throws SQLException {
        int randomId = 0;
        Object o = null;
        List<Integer> list = null;
        list = JDBCUtils.getIdFromGroup(groupName);
        int idBegin = list.get(0);
        int idEnd = list.get(list.size() - 1);
        randomId = ArithmeticUtils.random(idBegin, idEnd);
        o = JDBCUtils.queryById("student", randomId);

        return o;
    }

    /**
     * 不放回抽奖的list版
     *
     * @param studentOrGroup 组或者人
     * @return 返回抽中成员的信息的map的list
     * @throws SQLException
     */
    public static List<Map<String, String>> lotteryNotPutbackTolist(String studentOrGroup) throws SQLException {
        int randomId = 0;
        boolean isExist = false;
        List<Map<String, String>> list1 = null;
        List<Integer> listRepet = JDBCUtils.queryRepet(studentOrGroup);
        //获得成员个数
        int memberNumber = JDBCUtils.getMemberNumber(studentOrGroup);
        if (listRepet.size() != memberNumber) {
            do {
                isExist = false;
                //获得随机数
                randomId = ArithmeticUtils.random(1, memberNumber);
                    if (listRepet.contains(randomId)) {
                        isExist = true;
                    }
            } while (isExist);
            JDBCUtils.insertRepet(randomId, studentOrGroup);
            //根据随机数从数据库中取得数据
            list1 = JDBCUtils.queryByIdToList(studentOrGroup, randomId);
        }
        return list1;
    }

    /**
     * 放回抽奖的list版
     *
     * @param studentOrGroup 组或者人
     * @return 返回抽中成员的bean对象
     * @throws SQLException
     */
    public static List<Map<String, String>> lotteryPutbackToList(String studentOrGroup) throws SQLException {
        int randomId = 0;
        //获得成员个数
        int memberNumber = JDBCUtils.getMemberNumber(studentOrGroup);
        //获得随机数
        randomId = ArithmeticUtils.random(1, memberNumber);
        //根据随机数从数据库中取得数据
        List<Map<String, String>> list = JDBCUtils.queryByIdToList(studentOrGroup, randomId);
        return list;

    }

}
