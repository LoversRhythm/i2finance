package com.i2finance.lottery;

import com.alibaba.fastjson.JSON;
import com.i2finance.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author 白昊天
 * @date 2018/1/22
 **/
public class LuckyDrawImpl implements LuckyDraw {

    /**
     * 根据传入的抽奖形式得到中奖结果
     * 本程序健壮性极差
     * @param teamOrSinger 值为1：抽取团队   值为2：抽取个人
     * @param putOrNotput 是否放回（值为1：放回   值为2：不放回）
     * @return 返回中奖结果的一个集合，把这个集合转化为Json字符串
     */
    @Override
    public List<Map<String, String>> getLuckyResult(int teamOrSinger, int putOrNotput) {

        List<Map<String, String>> list = null;
        String studentOrGroup = null;
        if(teamOrSinger==1){
            studentOrGroup = "lottery_group";
        }else if(teamOrSinger==2){
            studentOrGroup = "lottery_user";
        }
        try{
            if(putOrNotput==1){//放回
                list = Lottery.lotteryPutbackToList(studentOrGroup);
            }else if(putOrNotput==2){//不放回
                list = Lottery.lotteryNotPutbackTolist(studentOrGroup);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 重置中奖记录，以便重新抽奖
     * @param teamOrSinger 清空组或者清空人
     */
    public void resetInfo(int teamOrSinger){
        String studentOrGroup = null;
        if(teamOrSinger==1){
            studentOrGroup = "lottery_group";
        }else if(teamOrSinger==2){
            studentOrGroup = "lottery_user";
        }
        try {
            JDBCUtils.emptyRepet(studentOrGroup);
            System.out.println(studentOrGroup+"重置成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//
//    public static void main(String[] args) throws InterruptedException {
//        int teamOrSinger = 1;
//        int putOrNotput = 2;
//        for(int i=0;i<5;i++) {
//            List<Map<String, String>> luckyResult = new LuckyDrawImpl().getLuckyResult(teamOrSinger, putOrNotput);
//        System.out.println(JSON.toJSONString(luckyResult));
////            System.out.println(luckyResult);
//            Thread.sleep(1000);
//        }
//        new LuckyDrawImpl().resetInfo(teamOrSinger);
//    }

}
