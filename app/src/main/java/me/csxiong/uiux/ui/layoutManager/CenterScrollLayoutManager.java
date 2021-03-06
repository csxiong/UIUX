package me.csxiong.uiux.ui.layoutManager;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import me.csxiong.library.utils.XDisplayUtil;


public class CenterScrollLayoutManager extends LinearLayoutManager {

    private static final int SPEED_PER_SECOND = XDisplayUtil.dpToPxInt(40);

    @Snap
    private int snap = Snap.CENTER;

    public CenterScrollLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        if (position < 0 || position >= getItemCount()) {
            return;
        }
        CenterSmoothScroller smoothScroller = new CenterSmoothScroller(recyclerView.getContext());
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }

    public void setSnapPreference(@Snap int snap) {
        this.snap = snap;
    }

    private class CenterSmoothScroller extends LinearSmoothScroller {

        CenterSmoothScroller(Context context) {
            super(context);
        }

        @Override
        protected int calculateTimeForScrolling(int dx) {
            return Math.min(250, dx * 250 / SPEED_PER_SECOND);
        }

        @Override
        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
            if (snap == Snap.CENTER) {
                return (boxStart + boxEnd) / 2 - (viewEnd + viewStart) / 2;
            } else if (snap == Snap.LEFT) {
                return boxStart - viewStart;
            } else if (snap == Snap.RIGHT) {
                return boxEnd - viewEnd;
            }
            return 0;
        }
    }
}
