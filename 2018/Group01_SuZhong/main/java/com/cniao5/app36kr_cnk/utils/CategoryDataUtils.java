package com.cniao5.app36kr_cnk.utils;

import com.cniao5.app36kr_cnk.entity.CategoriesBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释
 */
public class CategoryDataUtils {
    public static List<CategoriesBean>  getCategoryBeans(){
        List<CategoriesBean>  beans=new ArrayList<>();
        beans.add(new CategoriesBean("全部任务"));
        beans.add(new CategoriesBean("已发任务"));
        beans.add(new CategoriesBean("已接任务"));
        return beans;
    }
}
