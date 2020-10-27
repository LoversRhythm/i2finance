package com.i2finance;/*
package com.i2finance;

import javax.xml.bind.JAXBException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

*/
/**
 * @author 白昊天
 * @date 2018/1/15
 **//*

public class Test {

    public static void main(String[] args) throws JAXBException {

        String xmlPath = "src/lottery/file/namelist.xml";
        NameList nameList = null;
        List<Group> groups = null;
        List<Member> members = null;
        int randomGroup = 0;
        int randomMember = 0;
        int allMembers = 0;

        XmlToBean xmlToBean = new XmlToBean();
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();

        boolean putback = true;
        boolean isContinue = true;

        for(;;){    //是否放回
            System.out.print("是否放回：(是/否)");
            String s = sc.nextLine();
            if("是".equals(s)){
                putback = true;
                break;
            }else if("否".equals(s)){
                putback = false;
                break;
            }else {
                System.out.println("输入错误，重新输入");
            }
        }

        //记录总人数
        nameList = xmlToBean.xmlToBean(xmlPath);
        groups = nameList.getGroups();
        for(Group group:groups){
            members = group.getMembers();
            allMembers += members.size();
        }
        //进行随机抽奖
        //标记outfor
        outfor:
        for(;;) {
            //随机组
            randomGroup = (int) (Math.random() * groups.size() + 1);
            //标记into
            into:
            //遍历组
            for (Group group : groups) {
                //随机选择到的组
                if (group.getGroupId() == randomGroup) {
                    members = group.getMembers();
                    //随机组员
                    randomMember = (int) (Math.random() * members.size() + 1);
                    for (Member member : members) {
                        if (member.getId() == randomMember) {
                            //如果选择的是不放回
                            if(!putback){
                                //set里存着所有被选择过的成员
                                for(String s:set){
                                    //如果此次选择的成员被选择过，则返回标记点into重新选择
                                    if(s.equals(member.getName())){
                                        continue into;
                                    }
                                }
                            }
                            StringBuffer str = new StringBuffer();
                            str.append(group.getGroupName());
                            str.append("--");
                            str.append(member.getName());
                            String ss = new String(str);
                            System.out.println(ss);
                            //将选择过的成员存到set
                            set.add(member.getName());
                            //如果所有成员都被遍历过，则直接退出抽奖循环
                            if(set.size()==allMembers){
                                System.out.println("所有成员都被选中过");
                                break outfor;
                            }
                            //每抽中一个人选择是否继续
                            for(;;){
                                System.out.print("是否继续：(是/否)");
                                String s2 = sc.nextLine();
                                if("是".equals(s2)){
                                    isContinue = true;
                                    break;
                                }else if("否".equals(s2)){
                                    isContinue = false;
                                    break outfor;
                                }else {
                                    System.out.println("输入错误，重新输入");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
*/
