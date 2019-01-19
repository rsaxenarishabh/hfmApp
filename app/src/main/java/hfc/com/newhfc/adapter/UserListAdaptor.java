package hfc.com.newhfc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import hfc.com.newhfc.R;
import hfc.com.newhfc.model.UserList;
import hfc.com.newhfc.views.CircleImageView;

import static android.view.View.GONE;

/**
 * Created by rbpatel on 3/16/2017.
 */

public class UserListAdaptor extends RecyclerView.Adapter<UserListAdaptor.ViewHolder> {
    Context context;
    boolean isUserSelected;
    private String color;
    private List<UserList> userLists;

    public UserListAdaptor(List<UserList> userLists, Context context) {
        this.userLists = userLists;
        this.context = context;
        this.color = color;
    }


    @Override
    public UserListAdaptor.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = null;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_userlist, viewGroup, false);
        return new UserListAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final UserListAdaptor.ViewHolder holder, int position) {
       /* Glide.with(context.getApplicationContext()).load(userLists.get(holder.getAdapterPosition()).getImage()).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        }).into(holder.imageView);*/
       Picasso.with(context).load(userLists.get(holder.getAdapterPosition()).getImage()).into(holder.imageView);

       isUserSelected=userLists.get(holder.getAdapterPosition()).getIsActive();
       if(isUserSelected)
       {
       }
        holder.tvName.setText(userLists.get(holder.getAdapterPosition()).getFirstName() );


    }


    @Override
    public int getItemCount() {
        return userLists.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imageView;
        private TextView tvName;
        private TextView tvDesc;
        private ImageView activeImage;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image);
            tvName = view.findViewById(R.id.tvName);
            tvDesc = view.findViewById(R.id.tvDesc);
            activeImage=view.findViewById(R.id.tvDelete);
        }
    }
}
