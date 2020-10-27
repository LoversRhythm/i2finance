package com.i2finance.lottery;

import java.util.List;
import java.util.Map;

/**
 * @author : main.chu
 * @date : 2018-01-22
 */
public interface LuckyDraw {

    /**
     * 根据传入的抽奖形式得到中奖结果
     * @param teamOrSinger 值为1：抽取团队   值为2：抽取个人
     * @param putOrNotput 是否放回（值为1：放回   值为2：不放回）
     * @return 返回中奖结果的一个集合，把这个集合转化为Json字符串
     */
    List<Map<String, String>> getLuckyResult(int teamOrSinger, int putOrNotput);
}
