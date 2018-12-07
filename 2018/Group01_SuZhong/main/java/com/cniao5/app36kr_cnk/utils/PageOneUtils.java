package com.cniao5.app36kr_cnk.utils;


import com.cniao5.app36kr_cnk.R;
import com.cniao5.app36kr_cnk.entity.PageoneMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释:菜单Item数据构造
 */
public class PageOneUtils {
    public static List<PageoneMenu> getItemMenus(){
        List<PageoneMenu> menus=new ArrayList<PageoneMenu>();
        menus.add(new PageoneMenu("任务四标题"));
        menus.add(new PageoneMenu("任务五标题"));
        menus.add(new PageoneMenu("任务六标题"));
        return  menus;
    }
}