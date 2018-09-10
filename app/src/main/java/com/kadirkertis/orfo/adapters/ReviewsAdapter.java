package com.kadirkertis.orfo.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.kadirkertis.orfo.R;
import com.kadirkertis.orfo.model.Review;
import com.kadirkertis.domain.utils.Constants;

import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Kadir Kertis on 12.4.2017.
 */

public class ReviewsAdapter extends GenericAdapter<Review,ReviewsAdapter.ViewHolder> {

    private final Typeface mBold ;
    private final Typeface mItalic;
    private final Typeface mLight;
    public ReviewsAdapter(List<Review> data, Context context, int resourceId, Map<String,Typeface> types) {
        super(data, context, resourceId);
        mBold = types.get(Constants.TYPEFACE_COND_BOLD);
        mItalic = types.get(Constants.TYPEFACE_COND_ITALIC);
        mLight = types.get(Constants.TYPEFACE_COND_LIGHT);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_review,parent,false);

        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       Review review = mData.get(position);
        if(review != null){
            holder.reviewerName.setText(review.getUserName());
            holder.rating.setText(Float.toString(review.getRating()));
            holder.reviewTitle.setText(review.getReviewTitle());
            holder.reviewText.setText(review.getReviewText());
        }
        holder.avatar.setContentDescription(review.getUserName());

    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        private final CircleImageView avatar;
        private final TextView reviewerName;
        private final TextView rating;
        private final TextView reviewTitle;
        private final TextView reviewText;


        public ViewHolder(View itemView) {
            super(itemView);

            avatar = itemView.findViewById(R.id.reviewItemImage);
            reviewerName = itemView.findViewById(R.id.reviewItemReviewer);
            reviewerName.setTypeface(mLight);
            rating = itemView.findViewById(R.id.reviewItemRating);
            reviewTitle = itemView.findViewById(R.id.reviewItemReviewTitle);
            reviewTitle.setTypeface(mBold);
            reviewText = itemView.findViewById(R.id.reviewItemReviewText);
            reviewText.setTypeface(mItalic);
        }
    }
}
