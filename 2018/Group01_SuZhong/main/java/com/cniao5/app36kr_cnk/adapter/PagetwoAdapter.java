package com.cniao5.app36kr_cnk.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cniao5.app36kr_cnk.R;
import com.cniao5.app36kr_cnk.application.CNKApplication;
import com.cniao5.app36kr_cnk.entity.PagetwoMenu;
import com.cniao5.app36kr_cnk.utils.PageTwoUtils;

import java.util.List;

public class PagetwoAdapter extends BaseAdapter {
    public LayoutInflater mInflater;
    private List<PagetwoMenu> itemMenus;
    public PagetwoAdapter(){
        mInflater=LayoutInflater.from(CNKApplication.getInstance());
        itemMenus= PageTwoUtils.getItemMenus();
    }
    @Override
    public int getCount() {
        return itemMenus!=null?itemMenus.size():0;
    }
    @Override
    public Object getItem(int position) {
        return itemMenus.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder _Holder=null;
        if(convertView==null){
            _Holder=new Holder();
            convertView=mInflater.inflate(R.layout.pagetwo_item_layout,null);
            _Holder.item_pagetwo_view_title=(TextView)convertView.findViewById(R.id.item_pagetwo_view_title);
            convertView.setTag(_Holder);
        }else{
            _Holder=(Holder)convertView.getTag();
        }
        _Holder.item_pagetwo_view_title.setText(itemMenus.get(position).getTitle());
        return convertView;
    }
    private static class Holder{
        TextView item_pagetwo_view_title;
    }
}