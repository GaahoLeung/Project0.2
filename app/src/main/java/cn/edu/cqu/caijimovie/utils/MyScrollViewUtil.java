package cn.edu.cqu.caijimovie.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;


public class MyScrollViewUtil extends ScrollView {
    public MyScrollViewUtil(Context context) {
        super(context);
    }

    public MyScrollViewUtil(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollViewUtil(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private boolean mCanScroll = true;
    private float mDownY;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int scrollY = getScrollY();
                //滑到顶部或底部
                if ((scrollY == 0 && mDownY <= ev.getY())
                        || (getChildAt(0).getMeasuredHeight() == (scrollY + getHeight()) && mDownY >= ev.getY())) {
                    mCanScroll = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                mCanScroll = true;
                break;
            case MotionEvent.ACTION_CANCEL:
                mCanScroll = true;
                break;
        }
        if (mCanScroll) { //通知ViewPager不要干扰自身的操作
            getParent().requestDisallowInterceptTouchEvent(true);
            return super.onTouchEvent(ev);
        } else {
            getParent().requestDisallowInterceptTouchEvent(false);
            return false;
        }
    }
}