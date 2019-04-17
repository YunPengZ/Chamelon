package com.chamelon.springboot.Util;

import com.chamelon.springboot.Bean.HospitalBean;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ComUtilWithDifferTable<T> {
    private List<T> list = new ArrayList<T>();
    private String table;

    public  void initList(List<String> list){
        for (String str:list){
            String[] arrs = str.split(",");
        }

    }
}
