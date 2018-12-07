package com.cniao5.app36kr_cnk.entity;

/**
 * 当前类注释:左侧功能菜单 item实体类
 */
public class PagetwoMenu {
    private String title;
    public PagetwoMenu() {
    }

    public PagetwoMenu( String title) {
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
        return "PagetwoMenu{" +
                "title='" + title + '\'' +
                '}';
    }
}