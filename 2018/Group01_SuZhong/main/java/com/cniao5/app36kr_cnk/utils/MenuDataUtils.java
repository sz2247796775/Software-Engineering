package com.cniao5.app36kr_cnk.utils;


import com.cniao5.app36kr_cnk.R;
import com.cniao5.app36kr_cnk.entity.LeftItemMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释:左侧菜单Item数据构造
 */
public class MenuDataUtils {
    public static List<LeftItemMenu> getItemMenus(){
        List<LeftItemMenu> menus=new ArrayList<LeftItemMenu>();
        menus.add(new LeftItemMenu(R.drawable.icon_zhanghaoxinxi,"账号修改"));
        menus.add(new LeftItemMenu(R.drawable.icon_wodeguanzhu,"发布任务"));
        menus.add(new LeftItemMenu(R.drawable.icon_shoucang,"给予回馈"));
        return  menus;
    }

}
