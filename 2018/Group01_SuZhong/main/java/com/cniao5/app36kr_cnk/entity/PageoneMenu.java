package com.cniao5.app36kr_cnk.entity;

/**
 * 当前类注释:左侧功能菜单 item实体类
 */
public class PageoneMenu {
    private String title;
    public PageoneMenu() {
    }

    public PageoneMenu( String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PageoneMenu{" +
                "title='" + title + '\'' +
                '}';
    }
}