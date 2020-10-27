package drawway;

import com.alibaba.fastjson.JSON;
import utils.MyUtils;

import java.util.ArrayList;

/**
 * @author : main.chu
 * @date : 2018-01-15
 */
public class MainSystem {

    private final static int NAME_NUMBER = 8;
    private final static int TEAM_NUMBER = 44;
    private final static String USER_PATH = "H:\\IntelliJ IDEA work space\\i2finance_Web\\i2financeWeb\\src\\xmlsrc\\usersInfo.xml";
    private final static String TEAM_PATH = "H:\\IntelliJ IDEA work space\\i2finance_Web\\i2financeWeb\\src\\xmlsrc\\teamsInfo.xml";

//    public static void main(String[] args) {
//
//        productRandomNumber();
//    }

    public static String productRandomNumber(int teamOrSinger, int putOrNotput, int inputNumber) {
        System.out.println("1.抽取团队   2.抽取个人");
        if (teamOrSinger == 1) {
            MyUtils.ALL_NUMBER = NAME_NUMBER;
            MyUtils.XML_PATH = TEAM_PATH;
        }
        if (teamOrSinger == 2) {
            MyUtils.ALL_NUMBER = TEAM_NUMBER;
            MyUtils.XML_PATH = USER_PATH;
        }
        System.out.println("1.放回抽取   2.不放回抽取");
        if (teamOrSinger == 1) {
            System.out.println("请输入抽取的团队数：（共8支团队）");
        }
        if (teamOrSinger == 2) {
            System.out.println("请输入抽取的个人数：（共有44人）");
        }
        ArrayList<Integer> listNum = MyUtils.randomNum(inputNumber, putOrNotput);
//        for (String str : MyUtils.saxReader(listNum, putOrNotput)) {
//            System.out.println(str + " ");
//        }
        return JSON.toJSONString(MyUtils.saxReader(listNum, putOrNotput));
    }
}