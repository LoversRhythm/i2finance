package utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.*;

/**
 * @author : main.chu
 * @date : 2018-01-15
 */
public class MyUtils {

    public static int ALL_NUMBER;
    public static String XML_PATH;

    /**
     * 随机产生随机数，并处理放回不放回的业务逻辑
     * @param inputNumber 产生随机数的数量
     * @param putOrNotput 是否放回（1，2），处理业务逻辑
     * @return ArrayList<Integer> 返回产生随机数的集合
     */
    public static ArrayList<Integer> randomNum(int inputNumber, int putOrNotput) {
        Random random = new Random();
        ArrayList<Integer> listNum = new ArrayList<>();
        for (int i = 0; i < inputNumber; i++) {
            int randomTemp = random.nextInt(ALL_NUMBER);
            if (putOrNotput == 1) {
                listNum.add(randomTemp);
            }
            if (putOrNotput == 2) {
                if (listNum.contains(randomTemp)) {
                    i--;
                } else {
                    listNum.add(randomTemp);
                }
            }
        }
        return listNum;
    }

    /**
     * XML文档解析，在解析的过程中包含控制台输出结果处理
     * @param listNum 包含随机数的集合
     * @param putOrNotput 是否放回（1，2），处理业务逻辑
     * @return 返回最后抽奖结果的集合
     */
    public static List<Map<String , String>> saxReader(ArrayList<Integer> listNum, int putOrNotput) {
        SAXReader saxReader = new SAXReader();
        ArrayList<String> userInfoList = new ArrayList<>();
        List<Map<String , String>> listMap = null;
        HashMap<Integer, Integer> rePutList = null;
        if (putOrNotput == 1) {
            rePutList = new HashMap<>();
            for (int i : listNum) {
                if (rePutList.containsKey(i)) {
                    rePutList.put(i, rePutList.get(i) + 1);
                } else {
                    rePutList.put(i, 1);
                }
            }
        }
        try {
            Document document = saxReader.read(XML_PATH);
            Element rootElement = document.getRootElement();
            List<Element> list = rootElement.elements();
            for (Element element : list) {
                String name = element.getName();
                String id = element.attributeValue("ID");
                if (listNum.contains(Integer.parseInt(id))) {
                    //创建集合<键值对>，把字符串转化为Json
                    listMap = new ArrayList<>();
                    Map<String, String> map = new HashMap<>();
                    map.put(name, id);
                    List<Element> listInfo = element.elements();
                    String userInfo = name + ": " + id;
                    for (Element elementInfo : listInfo) {
                        String childName = elementInfo.getName();
                        String childValue = elementInfo.getText();
                        userInfo += "\t " + childName + ": " + childValue;
                        map.put(childName, childValue);
                    }
                    if(putOrNotput == 1) {
                        userInfo += "\t 共抽中: " + rePutList.get(Integer.parseInt(id)) + "次";
                        map.put("共抽中", rePutList.get(Integer.parseInt(id)).toString());
                    }
                    userInfoList.add(userInfo);
                    listMap.add(map);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMap;
    }

}
