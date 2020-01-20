package com.example.puzan.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.puzan.R;
import com.example.puzan.models.RetroPhoto;
import com.example.puzan.models.Tweet;
import com.example.puzan.models.User;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private List<Tweet> tweetList;
    private Context mContext;

    public RecyclerViewAdapter(Context context, List<Tweet> tweetList) {
        this.tweetList = tweetList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load("https://i.redd.it/qn7f9oqu7o501.jpg")
                .into(holder.image);

        holder.username.setText(tweetList.get(position).getUser().getUsername());
        holder.tweet.setText(tweetList.get(position).getTweet());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d(TAG, "onClick: clicked on: " + retroPhotos.get(position).getTitle());

                Toast.makeText(mContext, tweetList.get(position).getUser().getUsername(), Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(mContext, GalleryActivity.class);
//                intent.putExtra("image_url", mImages.get(position));
//                intent.putExtra("image_name", mImageNames.get(position));
//                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView username;
        TextView tweet;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.profile_photo);
            username = itemView.findViewById(R.id.tv_name);
            tweet = itemView.findViewById(R.id.tv_tweet_text);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}


//     welcome page ---> sign up page --->  dashboard page --> logout
//          |       |                          |                   |
//          |       |                          |                   |
//          |       |                          |                   |
//          |     login page ------------------                    |
//          |                                                      |
//          |                                                      |
//          --------------------------------------------------------