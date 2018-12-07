package com.cniao5.app36kr_cnk.utils;


import com.cniao5.app36kr_cnk.R;
import com.cniao5.app36kr_cnk.entity.HomeItemMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释:菜单Item数据构造
 */
public class MainMenuUtils {
    public static List<HomeItemMenu> getItemMenus(){
        List<HomeItemMenu> menus=new ArrayList<HomeItemMenu>();
        menus.add(new HomeItemMenu("任务一标题"));
        menus.add(new HomeItemMenu("任务二标题"));
        menus.add(new HomeItemMenu("任务三标题"));
        return  menus;
    }
}