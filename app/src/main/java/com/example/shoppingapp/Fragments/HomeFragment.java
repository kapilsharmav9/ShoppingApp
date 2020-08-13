package com.example.shoppingapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.shoppingapp.Adapters.GridProductAdapter;
//import com.example.shoppingapp.Adapters.HomePageAdapter;
import com.example.shoppingapp.Adapters.Horizontalproductadapter;
import com.example.shoppingapp.Adapters.SliderAdapter;
import com.example.shoppingapp.Model.HomePageModel;
import com.example.shoppingapp.Model.HorizontalProductmodel;
import com.example.shoppingapp.Model.SliderModel;
import com.example.shoppingapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private ViewPager bannerslider;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME=3000;
    final private long PERIOD_TIME=3000;
    private TextView deal_of_day;
    private Button viewall;
    private RecyclerView hRecycleview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        bannerslider = view.findViewById(R.id.viewpager);
        sliderModelList = new ArrayList<>();
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher,"#2196F3"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher_round,"#2196F3"));

        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher,"#2196F3"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher_round,"#2196F3"));
        sliderModelList.add(new SliderModel(R.drawable.sweather,"#2196F3"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher_round,"#2196F3"));
        sliderModelList.add(new SliderModel(R.drawable.books,"#2196F3"));
        sliderModelList.add(new SliderModel(R.drawable.bannger,"#2196F3"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher,"#2196F3"));
        sliderModelList.add(new SliderModel(R.drawable.bannger,"#2196F3"));

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerslider.setAdapter(sliderAdapter);
        bannerslider.setClipToPadding(false);
        bannerslider.setPageMargin(20);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state==ViewPager.SCROLL_STATE_IDLE)
                {
                    pageLooper();
                }

            }
        };
        bannerslider.addOnPageChangeListener(onPageChangeListener);
        startBannerSlideshow();
        bannerslider.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideShow();
                if (event.getAction()==MotionEvent.ACTION_UP)
                {
                    startBannerSlideshow();
                }
                return false;
            }
        });
        deal_of_day=view.findViewById(R.id.dealoftheday);
        viewall=view.findViewById(R.id.view_All);
        hRecycleview=view.findViewById(R.id.recycle_viewmore);
        List<HorizontalProductmodel> hpmodelList=new ArrayList<>();
        hpmodelList.add(new HorizontalProductmodel(R.drawable.mobiles,"redmi","snapdragon200","Rs.6000"));
        hpmodelList.add(new HorizontalProductmodel(R.drawable.sweather,"Sweaters","woolen","Rs.6300"));
        hpmodelList.add(new HorizontalProductmodel(R.drawable.glasses,"Glasses","3d","Rs.6600"));
        hpmodelList.add(new HorizontalProductmodel(R.drawable.tshirts,"T-shirts","full selieve","Rs.6400"));
        hpmodelList.add(new HorizontalProductmodel(R.drawable.shoess,"Shoes","leather","Rs.600"));
        hpmodelList.add(new HorizontalProductmodel(R.drawable.watches,"Watches","digital","Rs.300"));
        hpmodelList.add(new HorizontalProductmodel(R.drawable.sports,"Sports","sports","Rs.1000"));
        hpmodelList.add(new HorizontalProductmodel(R.drawable.purses_bags,"Bags","leather bag","Rs.3000"));
        Horizontalproductadapter hadapter=new Horizontalproductadapter(hpmodelList);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        hRecycleview.setLayoutManager(layoutManager);
        hRecycleview.setAdapter(hadapter);
        hadapter.notifyDataSetChanged();
        TextView gtitle=view.findViewById(R.id.grid_titel);
        Button gviewAll=view.findViewById(R.id.grid_view_All);
        GridView gridView=view.findViewById(R.id.grid_layout);
        gridView.setAdapter(new GridProductAdapter(hpmodelList));
       // RecyclerView recyclerViewtesting=view.findViewById(R.id.recycletesting);
//        LinearLayoutManager layoutManager1=new LinearLayoutManager(getContext());
//        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerViewtesting.setLayoutManager(layoutManager1);
//        List<HomePageModel> homePageModelList=new ArrayList<>();
//        homePageModelList.add(new HomePageModel(0,sliderModelList));
//        HomePageAdapter homePageAdapter=new HomePageAdapter(homePageModelList);
//        recyclerViewtesting.setAdapter(homePageAdapter);
//        homePageAdapter.notifyDataSetChanged();
        return view;
    }

    private void pageLooper() {
        if (currentPage == sliderModelList.size() - 2) {
            currentPage = 2;
            bannerslider.setCurrentItem(currentPage, false);
        }
        if (currentPage == 1) {
            currentPage = sliderModelList.size() - 3;
            bannerslider.setCurrentItem(currentPage, false);
        }

    }
    private  void startBannerSlideshow()
    {
        final Handler handler=new Handler();
        final Runnable update=new Runnable() {
            @Override
            public void run() {
                if (currentPage>=sliderModelList.size())
                {
                    currentPage=1;
                }
                bannerslider.setCurrentItem(currentPage++,true);
            }
        };
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME);
    }
    private  void stopBannerSlideShow()
    {
        timer.cancel();
    }
}