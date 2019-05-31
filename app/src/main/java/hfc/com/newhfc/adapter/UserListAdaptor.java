package hfc.com.newhfc.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import hfc.com.newhfc.R;
import hfc.com.newhfc.activities.UserListActivity;
import hfc.com.newhfc.model.User;
import hfc.com.newhfc.model.UserList;
import hfc.com.newhfc.model.userlist.Datum;
import hfc.com.newhfc.views.CircleImageView;

import static android.view.View.GONE;

/**
 * Created by rbpatel on 3/16/2017.
 */

public class UserListAdaptor extends RecyclerView.Adapter<UserListAdaptor.ViewHolder> {


    private Context context;


    // boolean isUserSelected;
    // private String color;
    private List<Datum> userList;


    //private List<UserList> userLists;
    OnUserClickCallback onUserClickCallback;
/*

    public UserListAdaptor(List<UserList> userLists, Context context) {
        this.userLists = userLists;
        this.context = context;
        this.color = color;
    }
*/

    public UserListAdaptor(Context context) {
        this.context = context;
    }

    public void setDatumList(List<Datum> datumList) {
        this.userList = datumList;
    }

    public void setOnUserClickCallback(OnUserClickCallback onUserClickCallback) {
        this.onUserClickCallback = onUserClickCallback;
    }

    @Override
    public UserListAdaptor.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = null;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_userlist, viewGroup, false);
        return new UserListAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final UserListAdaptor.ViewHolder holder, int position) {


        final Datum userlist = userList.get(position);
        if (userlist.getFirstName() != null) {
            holder.tvName.setText("" + userlist.getFirstName());
        }
        if (userlist.getStatus().equalsIgnoreCase("1")) {
            holder.activeImage.setImageResource(R.drawable.ic_activated);
        } else {
            holder.activeImage.setImageResource(R.drawable.ic_blocked);
        }

        Picasso.with(context).load(userlist.getImage())
                .error(R.drawable.profile_pictures)
                .into(holder.imageView);
        if (userlist.getStatus().equalsIgnoreCase("1")) {
            holder.activeImage.setImageResource(R.drawable.ic_activated);
            holder.cardViewList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onUserClickCallback != null)
                        onUserClickCallback.onUserClick(userlist.getReferalCode());


                }
            });
        }

       /* if (!TextUtils.isEmpty(userLists.get(holder.getAdapterPosition()).getImage())) {
            Picasso.with(context)
                    .load("" + userLists.get(holder.getAdapterPosition()).getImage())
                    .error(R.drawable.ic_default_image)
                    .into(holder.imageView);

        } else {
            holder.imageView.setImageResource(R.drawable.ic_default_image);
        }

        isUserSelected = userLists.get(holder.getAdapterPosition()).getIsActive();
        if (isUserSelected) {
            holder.activeImage.setImageResource(R.drawable.ic_activated);
        } else {
            holder.activeImage.setImageResource(R.drawable.ic_blocked);
        }
        holder.tvName.setText(userLists.get(holder.getAdapterPosition()).getFirstName());
        holder.tvDesc.setText(userLists.get(holder.getAdapterPosition()).getCreatedOn());
        holder.cardViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onUserClickCallback != null)
                    onUserClickCallback.onUserClick(userLists.get(holder.getAdapterPosition()).getId(), userLists.get(holder.getAdapterPosition()).getReferalCode());


            }
        });*/


    }


    @Override
    public int getItemCount() {
        if (userList != null && userList.size() > 0) {
            return userList.size();
        } else {
            return 0;
        }
    }

    public void setListener(OnUserClickCallback userListActivity) {
        this.onUserClickCallback = userListActivity;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imageView;
        private TextView tvName;
        private TextView tvDesc;
        private ImageView activeImage;
        private CardView cardViewList;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image);
            tvName = view.findViewById(R.id.tvName);
            tvDesc = view.findViewById(R.id.tvDesc);
            activeImage = view.findViewById(R.id.tvDelete);
            cardViewList = view.findViewById(R.id.deviceInfoView);
        }
    }

    public interface OnUserClickCallback {
        public void onUserClick(String referalCode);
    }
}
