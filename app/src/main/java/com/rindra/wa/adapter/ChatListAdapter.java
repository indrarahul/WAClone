package com.rindra.wa.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.rindra.wa.R;
import com.rindra.wa.model.ChatList;

import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.Holder> {
    private List<ChatList> mChatLists;
    private Context mContext;

    public ChatListAdapter(List<ChatList> chatLists, Context context) {
        this.mChatLists = chatLists;
        this.mContext = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_chat_list,parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
            ChatList chatList = mChatLists.get(position);

            holder.tvName.setText(chatList.getUserName());
            holder.tvDesc.setText(chatList.getDescription());
            holder.tvDate.setText(chatList.getDate());

            Glide.with(mContext).load(chatList.getUrlProfile()).into(holder.profile);
    }

    @Override
    public int getItemCount() {
        return mChatLists.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        private TextView tvName, tvDesc, tvDate;
        private CircularImageView profile;
        public Holder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tv_date);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvName = itemView.findViewById(R.id.tv_name);
            profile = itemView.findViewById(R.id.profile);

        }

    }
}
