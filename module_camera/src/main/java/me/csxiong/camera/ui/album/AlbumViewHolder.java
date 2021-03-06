package me.csxiong.camera.ui.album;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.view.ViewCompat;

import java.util.List;

import me.csxiong.camera.R;
import me.csxiong.camera.album.ImageEntity;
import me.csxiong.camera.databinding.ItemAlbumBinding;
import me.csxiong.camera.ui.imageloader.ImageLoader;
import me.csxiong.library.integration.adapter.XItem;
import me.csxiong.library.integration.adapter.XViewHolder;
import me.csxiong.library.utils.XDisplayUtil;

/**
 * @Desc : 相册ViewHolder
 * @Author : csxiong create on 2019/12/17
 */
public class AlbumViewHolder extends XViewHolder<ItemAlbumBinding, ImageEntity> {

    public AlbumViewHolder(Context context, ViewGroup parent) {
        super(context, parent, R.layout.item_album);
        int width = XDisplayUtil.getScreenWidth();
        View view = mViewBinding.getRoot();
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = width / 3;
        lp.width = lp.height;
        view.setLayoutParams(lp);
    }

    @Override
    public void onBindViewHolder(int position, XItem<ImageEntity> item, List<Object> payloads) {
        super.onBindViewHolder(position, item, payloads);
        ViewCompat.setTransitionName(mViewBinding.iv, item.getEntity().getDisplayPath());

        ImageLoader.url(item.getEntity().getDisplayPath())
                .into(mViewBinding.iv);

        addOnChildClickListener(mViewBinding.iv);
    }
}
