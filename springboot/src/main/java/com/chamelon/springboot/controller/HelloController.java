package com.chamelon.springboot.controller;

import com.chamelon.springboot.Bean.HospitalBean;
import com.chamelon.springboot.Util.ComUtilWithDifferTable;
import com.chamelon.springboot.Util.MergeSortUtili;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;

import javax.swing.text.Utilities;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
       String fileDir = "D:\\科研项目\\chameleon\\dataSet\\source_d\\hospital_total.csv";
       File file = new File(fileDir);
       HashMap<String,Object> map = new HashMap<String,Object>();
       String table_1 = "hospital";
       String table_2 = "hospital";
       String dc = "t1.Zipcode>t2.ZipCode&t1.PhoneNumber<t2.PhoneNumber";
       //\.[a-zA-Z]+
        String regx = "\\.[a-zA-z]+[>|<]";
        Pattern r = Pattern.compile(regx);
        Matcher m = r.matcher(dc);
        HashSet<String> set = new HashSet<>();
        HashMap<String,Integer> order = new HashMap<>();
        while(m.find()){
            String temp = m.group();
            if(temp.charAt(temp.length()-1)=='>'){
                //按照属性升序
                order.put(temp.substring(1,temp.length()-1),1);
            }else{// if(temp.charAt(temp.length()-1)=='<'){
                order.put(temp.substring(1,temp.length()-1),2);
            }
        }
       //按照固定格式解析
       List<Object> list = new ArrayList<>();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
            BufferedReader bfReader = new BufferedReader(isr);
            String lineText = null;
            switch (table_1){
                case "hospital":
                    while((lineText=bfReader.readLine())!=null){
                        String arrs[] = lineText.split(",");
                        HospitalBean hospitalBean = new HospitalBean(arrs);
                        list.add(hospitalBean);
                    }
                    break;
                default:
                    break;
            }
            //对初处理的数据 获得
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对list转换成需要的类型
        MergeSortUtili.mergeSort(list,order);
        return ((HospitalBean)list.get(0)).get("EmergencyService");
    }
}
