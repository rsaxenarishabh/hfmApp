package hfc.com.newhfc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import hfc.com.newhfc.R;
import hfc.com.newhfc.adapter.UserListAdaptor;
import hfc.com.newhfc.model.UserList;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.retrofit.UserById;
import hfc.com.newhfc.utils.AppUtils;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFCPrefs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListActivity extends AppCompatActivity {

    List<UserList> userLists = new ArrayList<>();
    RecyclerView recyclerView;
    UserListAdaptor userListAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_activiti);
         recyclerView = findViewById(R.id.recyclerview_userlist);


    }
    @Override
    protected void onResume() {
        super.onResume();
        if (AppUtils.isInternetConnected(getApplicationContext())) {
            AppUtils.showProgressDialog(getApplicationContext());
            Intent intent=getIntent();
            int userId=intent.getIntExtra("id",0);
            UserById userById = new UserById();
            userById.setUserId(userId);
            RestClient.getUserList(userById,getString(R.string.bearer) + " " + HFCPrefs.getString(getApplicationContext(), Constants.ACCESS_TOKEN), new Callback<List<UserList>>() {
                @Override
                public void onResponse(Call<List<UserList>> call, Response<List<UserList>> response) {
                    AppUtils.dismissProgressDialog();
                    if (response.body() != null) {
                        Log.e("UserList Api Response", "" + response.body().size());
                        if (userLists != null) {
                            userLists.clear();
                        }
                        userLists = response.body();
                        UserListAdaptor userListAdaptor = new UserListAdaptor(userLists, getApplicationContext());
                        recyclerView.setHasFixedSize(true);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext().getApplicationContext());
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
                        recyclerView.setAdapter(userListAdaptor);
                        //TODO implement Recycler view
                    }

                }

                @Override
                public void onFailure(Call<List<UserList>> call, Throwable t) {
                    AppUtils.dismissProgressDialog();
                    Log.e("UserList Api Response", "" + t.getMessage());
                    AppUtils.showMessage(getApplicationContext(), getString(R.string.unable_to_get_user));
                }
            });
        } else {
            AppUtils.showMessage(getApplicationContext(), "Please check internet conection");
        }
    }

}

