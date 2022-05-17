package com.example.nationinfo;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ScrollListenr extends RecyclerView.OnScrollListener {
    private LinearLayoutManager linearLayoutManager;

    public ScrollListenr(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int visibleItemCount =  linearLayoutManager.getChildCount();
        int totalItemCount = linearLayoutManager.getItemCount();
        int fistVisibleImtemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (isloading() || isLastPage()) return;
        if (fistVisibleImtemPosition >= 0 && (visibleItemCount+fistVisibleImtemPosition) >= totalItemCount ) loadMoreItem();

    }
    public abstract void loadMoreItem();
    public abstract boolean isloading();
    public abstract boolean isLastPage();

}
