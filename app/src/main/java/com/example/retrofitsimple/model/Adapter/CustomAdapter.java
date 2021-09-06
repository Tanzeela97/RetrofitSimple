package com.example.retrofitsimple.model.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitsimple.R;
import com.example.retrofitsimple.databinding.RetrofitPhotoItemLayoutBinding;
import com.example.retrofitsimple.model.Retrofitphoto.RetroPhoto;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    //  ActivityCustomRowBinding customRowBinding;
    RetrofitPhotoItemLayoutBinding retrofitphotobinding;
    private List<RetroPhoto> dataList;
    private Context context;

    public CustomAdapter(Context context, List<RetroPhoto> dataList) {
        this.context = context;
        this.dataList = dataList;
    }


    //data binding
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RetrofitPhotoItemLayoutBinding retrofitphotobinding = RetrofitPhotoItemLayoutBinding.inflate(layoutInflater, parent, false);
        return new CustomViewHolder(retrofitphotobinding);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        RetroPhoto retrophoto = dataList.get(position);
        holder.retrofitphotobindinglayout.setCutomer(retrophoto);

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        // public final View mView;
        public RetrofitPhotoItemLayoutBinding retrofitphotobindinglayout;
        TextView txtTitle;
        private ImageView coverImage;

        CustomViewHolder(RetrofitPhotoItemLayoutBinding retrofitPhotoItemLayoutBinding) {
            super(retrofitPhotoItemLayoutBinding.getRoot());
            retrofitphotobindinglayout = retrofitPhotoItemLayoutBinding;
            txtTitle = retrofitPhotoItemLayoutBinding.txttitle;
            coverImage = retrofitPhotoItemLayoutBinding.coverImage;
        }

    }
}

