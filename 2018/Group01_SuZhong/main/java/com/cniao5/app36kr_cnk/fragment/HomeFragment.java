package com.cniao5.app36kr_cnk.fragment;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.cniao5.app36kr_cnk.R;
import com.cniao5.app36kr_cnk.adapter.HomeItemAdapter;
import com.cniao5.app36kr_cnk.common.DefineView;
import com.cniao5.app36kr_cnk.ui.base.BaseActivity;
import com.nineoldandroids.view.ViewHelper;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.cniao5.adapter.helper.BaseAdapterHelper;
import com.cniao5.adapter.helper.QuickAdapter;
import com.cniao5.app36kr_cnk.R;
import com.cniao5.app36kr_cnk.common.DefineView;
import com.cniao5.app36kr_cnk.entity.CategoriesBean;
import com.cniao5.app36kr_cnk.fragment.base.BaseFragment;
import com.cniao5.cwidgetutils.AutoGallery;
import com.cniao5.cwidgetutils.FlowIndicator;
import com.cniao5.cwidgetutils.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 当前类注释:
 * ProjectName：App36Kr_CNK
 */
public class HomeFragment extends BaseFragment implements DefineView {
    private View mView;
    private static final String KEY="EXTRA";
    private CategoriesBean categoriesBean;
    private PullToRefreshListView home_listview;
    private String[] masks;
    private int[] mask_colors;
    private FrameLayout home_framelayout;
    private ListView home_item_main;
    private LinearLayout loading,empty,error;
    private View headView;
    private LayoutInflater mInflater;
    private AutoGallery headline_image_gallery;
    private FlowIndicator headline_circle_indicator;
    private int gallerySelectedPositon=0;//Gallery索引
    private int circleSelectedPosition = 0; // 默认指示器的圆圈的位置为第一

    public static HomeFragment newInstance(CategoriesBean extra){
        Bundle bundle=new Bundle();
        bundle.putSerializable(KEY,extra);
        HomeFragment fragment=new HomeFragment();
        fragment.setArguments(bundle);
        return  fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null) {
            categoriesBean=(CategoriesBean)bundle.getSerializable(KEY);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView==null){
            mView=inflater.inflate(R.layout.home_fragment_layout,container,false);
            mInflater=LayoutInflater.from(getActivity());
            initView();
            initValidata();
            initListener();
        }
        home_item_main.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
            }

        }) ;
        return mView;
    }

    @Override
    public void initView() {
        home_listview=(PullToRefreshListView)mView.findViewById(R.id.home_listview);
        home_item_main=(ListView)mView.findViewById(R.id.lv_item_main);
        //loading=(LinearLayout)mView.findViewById(R.id.loading);
        //empty=(LinearLayout)mView.findViewById(R.id.empty);
       // error=(LinearLayout)mView.findViewById(R.id.error);

        //获取AutoGallery和FlowIndicator控件
       // headline_image_gallery=(AutoGallery)headView.findViewById(R.id.headline_image_gallery);
        //headline_circle_indicator=(FlowIndicator)headView.findViewById(R.id.headline_circle_indicator);
    }

    @Override
    public void initValidata() {
        home_listview.setVisibility(View.VISIBLE);
        home_item_main.setVisibility(View.VISIBLE);
        home_item_main.setAdapter(new HomeItemAdapter());
        //loading.setVisibility(View.GONE);
        //empty.setVisibility(View.GONE);
        //error.setVisibility(View.GONE);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void bindData() {
        //设置指示器
        headline_circle_indicator.setSeletion(circleSelectedPosition);
        headline_image_gallery.setSelection(gallerySelectedPositon);
        headline_image_gallery.setDelayMillis(4000);
        headline_image_gallery.start();
        headline_image_gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                circleSelectedPosition=position;
                headline_circle_indicator.setSeletion(gallerySelectedPositon);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

   private static class  Holder{
        ImageView item_head_gallery_img;
    }
}
