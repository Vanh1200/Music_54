package com.vanh1200.lovemusic.screen.genre.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vanh1200.lovemusic.R;
import com.vanh1200.lovemusic.base.BaseRecyclerViewAdapter;
import com.vanh1200.lovemusic.data.model.Track;

import java.util.List;

public class GenreTrackAdapter extends BaseRecyclerViewAdapter<Track,
        GenreTrackAdapter.ViewHolder> {
    private List<Track> mTracks;
    private Context mContext;

    public GenreTrackAdapter(List<Track> tracks) {
        super();
        mTracks = tracks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup
                        .getContext())
                .inflate(R.layout.item_detail_genre_track, viewGroup, false);
        mContext = viewGroup.getContext();
        return new ViewHolder(view, mTracks);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(mTracks.get(i));
    }

    @Override
    public int getItemCount() {
        return mTracks == null ? 0 : mTracks.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private static final int NUMBER_OFFSET_ARRAY = 1;
        private TextView mTextSequenceNumber;
        private TextView mTextTitle;
        private TextView mTextArtist;
        private ImageView mImageOption;
        private List<Track> mTracks;

        public ViewHolder(@NonNull View itemView, List<Track> tracks) {
            super(itemView);
            mTracks = tracks;
            initViews(itemView);
        }

        private void initViews(View itemView) {
            mTextSequenceNumber = itemView.findViewById(R.id.text_sequence_number);
            mTextTitle = itemView.findViewById(R.id.text_title);
            mTextArtist = itemView.findViewById(R.id.text_artist);
            mImageOption = itemView.findViewById(R.id.image_option);
        }

        private void bindData(Track track) {
            mTextTitle.setText(track.getTitle());
            mTextArtist.setText(track.getPublisher().getArtist());
            mTextSequenceNumber.setText(String.valueOf(mTracks.indexOf(track) + NUMBER_OFFSET_ARRAY));
        }
    }
}
