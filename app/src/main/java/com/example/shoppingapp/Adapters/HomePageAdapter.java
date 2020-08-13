//package com.example.shoppingapp.Adapters;
//
//import android.annotation.SuppressLint;
//import android.os.Handler;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.viewpager.widget.ViewPager;
//
//import com.example.shoppingapp.Model.HomePageModel;
//import com.example.shoppingapp.Model.SliderModel;
//import com.example.shoppingapp.R;
//
//import java.util.List;
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class HomePageAdapter extends RecyclerView.Adapter {
//    private List<HomePageModel> homePageModelList;
//
//    public HomePageAdapter(List<HomePageModel> homePageModelList) {
//        this.homePageModelList = homePageModelList;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        switch (viewType) {
//            case HomePageModel.Banner_slider:
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, parent, false);
//                return new BannerSliderViewHolder(view);
//            default:
//                return null;
//        }
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        switch (homePageModelList.get(position).getType()) {
//            case HomePageModel.Banner_slider:
//                List<SliderModel> sliderModelList = homePageModelList.get(position).getSliderModelList();
//                ((BannerSliderViewHolder) holder).setBannersliderViewPager(sliderModelList);
//                break;
//            default:
//                return;
//
//        }
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return homePageModelList.size();
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        switch (homePageModelList.get(position).getType()) {
//            case 0:
//                return HomePageModel.Banner_slider;
//            default:
//                return -1;
//        }
//    }
//
//    public class BannerSliderViewHolder extends RecyclerView.ViewHolder {
//        private int currentPage = 2;
//        private Timer timer;
//        final private long DELAY_TIME = 3000;
//        final private long PERIOD_TIME = 3000;
//        private ViewPager bannerslider;
//
//
//        public BannerSliderViewHolder(@NonNull View itemView) {
//            super(itemView);
//            bannerslider = itemView.findViewById(R.id.viewpager);
//
//        }
//
//
//        private void setBannersliderViewPager(final List<SliderModel> sliderModelList) {
//
//            SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
//            bannerslider.setAdapter(sliderAdapter);
//            bannerslider.setClipToPadding(false);
//            bannerslider.setPageMargin(20);
//
//            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
//                @Override
//                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//                }
//
//                @Override
//                public void onPageSelected(int position) {
//                    currentPage = position;
//
//                }
//
//                @Override
//                public void onPageScrollStateChanged(int state) {
//                    if (state == ViewPager.SCROLL_STATE_IDLE) {
//                        pageLooper(sliderModelList);
//                    }
//
//                }
//            };
//            bannerslider.addOnPageChangeListener(onPageChangeListener);
//            startBannerSlideshow(sliderModelList);
//            bannerslider.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    pageLooper(sliderModelList);
//                    stopBannerSlideShow();
//                    if (event.getAction() == MotionEvent.ACTION_UP) {
//                        startBannerSlideshow(sliderModelList);
//                    }
//                    return false;
//                }
//            });
//        }
//
//        private void pageLooper(final List<SliderModel> sliderModelList) {
//            if (currentPage == sliderModelList.size() - 2) {
//                currentPage = 2;
//                bannerslider.setCurrentItem(currentPage, false);
//            }
//            if (currentPage == 1) {
//                currentPage = sliderModelList.size() - 3;
//                bannerslider.setCurrentItem(currentPage, false);
//            }
//
//        }
//
//        private void startBannerSlideshow(final List<SliderModel> sliderModelList) {
//            final Handler handler = new Handler();
//            final Runnable update = new Runnable() {
//                @Override
//                public void run() {
//                    if (currentPage >= sliderModelList.size()) {
//                        currentPage = 1;
//                    }
//                    bannerslider.setCurrentItem(currentPage++, true);
//                }
//            };
//            timer = new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    handler.post(update);
//                }
//            }, DELAY_TIME, PERIOD_TIME);
//        }
//
//        private void stopBannerSlideShow() {
//            timer.cancel();
//        }
//    }
//
//}
