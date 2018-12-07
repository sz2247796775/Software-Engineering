package com.cniao5.app36kr_cnk.entity;

/**
 * 当前类注释:左侧功能菜单 item实体类
 */
public class HomeItemMenu {
    private String title;
    public HomeItemMenu() {
    }

    public HomeItemMenu( String title) {
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
        return "HomeItemMenu{" +
                "title='" + title + '\'' +
                '}';
    }
}
