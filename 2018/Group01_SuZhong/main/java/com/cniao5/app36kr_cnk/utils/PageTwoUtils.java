package com.cniao5.app36kr_cnk.utils;


import com.cniao5.app36kr_cnk.R;
import com.cniao5.app36kr_cnk.entity.PagetwoMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释:菜单Item数据构造
 */
public class PageTwoUtils {
    public static List<PagetwoMenu> getItemMenus(){
        List<PagetwoMenu> menus=new ArrayList<PagetwoMenu>();
        menus.add(new PagetwoMenu("任务七标题"));
        menus.add(new PagetwoMenu("任务八标题"));
        menus.add(new PagetwoMenu("任务九标题"));
        return  menus;
    }
}