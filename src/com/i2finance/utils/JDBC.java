package com.i2finance.utils;

import com.i2finance.bean.MyModule;

/**
 * @author 白昊天
 * @date 2018/1/23
 **/
public interface JDBC {

    /**
     * 给数据库中插入数据
     * @param module 要插入的表的bean对象
     * @return 成功插入则返回true，否则返回false
     */
    public boolean insert(MyModule module);

    /**
     * 从数据库中删除数据
     * @param module 要删除的表的bean对象
     * @return 成功删除则返回true，否则返回false
     */
    public boolean delete(MyModule module);

    /**
     * 从数据库中修改数据
     * @param oldId 要修改的旧记录的id
     * @param module 要修改的表的bean对象
     * @return 成功修改则返回true，否则返回false
     */
    public boolean update(int oldId, MyModule module);

    /**
     * 从数据库中查询数据
     * @param id 要查询的记录的id
     * @param module 要查询的记录的表
     * @return
     */
    public MyModule query(MyModule module, int id);

}
