package com.jiayoo.jdbc.properties;

import java.io.*;
import java.util.Properties;

/**
 * @program: TestProject
 * @description: 读取配置文件一
 * @author: jiayoo
 * @create: 2018-11-18 23:43
 **/
public class Read_Myprop  {
    private String path;
    BufferedReader bufferedReader;
    Properties properties = new Properties();
    public Read_Myprop(String path) throws IOException {
        this.path = path;
        bufferedReader = new BufferedReader(new FileReader(new File(path)));
        properties.load(bufferedReader);
    }

    public Object getValue(String name)  {
        return  properties.getProperty(name);
    }

    @Override
    public String toString() {
        return "Read_Myprop{" +
                "path='" + path + '\'' +
                '}';
    }
}
