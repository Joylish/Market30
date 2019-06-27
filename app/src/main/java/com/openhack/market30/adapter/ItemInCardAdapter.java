package com.openhack.market30.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.openhack.market30.R;
import com.openhack.market30.model.ItemInCard;

import java.util.ArrayList;

public class ItemInCardAdapter extends RecyclerView.Adapter<ItemInCardAdapter.ViewHolder>{

    private Context context;
    private ArrayList<ItemInCard> mItems;

    // Allows to remember the last item shown on screen
    private int lastPosition = -1;

    public ItemInCardAdapter(ArrayList<ItemInCard> items, Context mContext)
    {
        mItems = items;
        context = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_card, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // TODO : image
        // holder.imageView_ITEM_IN_CARD.setImageResource(mItems.get(position).getImage());
        holder.txtView_ITEM_IN_CARD.setText(mItems.get(position).getTitle());
        // setAnimation(holder.layout_ITEM_IN_CARD, position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_ITEM_IN_CARD;
        TextView txtView_ITEM_IN_CARD;
        ConstraintLayout layout_ITEM_IN_CARD;
        ViewHolder(View view) {
            super(view);
            layout_ITEM_IN_CARD = itemView.findViewById(R.id.layout_ITEM_IN_CARD);
            imageView_ITEM_IN_CARD = itemView.findViewById(R.id.imageView_ITEM_IN_CARD);
            txtView_ITEM_IN_CARD = itemView.findViewById(R.id.txtView_ITEM_IN_CARD);
        }
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
