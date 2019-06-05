package hfc.com.newhfc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hfc.com.newhfc.R;
import hfc.com.newhfc.adapter.UserListAdaptor;
import hfc.com.newhfc.model.userlist.Datum;
import hfc.com.newhfc.model.userlist.UserListRequest;
import hfc.com.newhfc.model.userlist.UserListResponse;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;

public class UserListActivity extends AppCompatActivity implements UserListAdaptor.OnUserClickCallback {

    List<Datum> userLists = new ArrayList<>();
    RecyclerView recyclerView;
    TextView textView;
    UserListAdaptor userListAdaptor;

    public String referalCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_activiti);
        recyclerView = findViewById(R.id.recyclerview_userlist);
        textView = findViewById(R.id.txt_view);

        if (getIntent().hasExtra("referalCode")) {
            referalCode = getIntent().getStringExtra("referalCode");
        }

        userlistData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        if (userLists != null && userLists.size() >= 3) {
            menu.findItem(R.id.addUser).setVisible(false);
        } else {
            menu.findItem(R.id.addUser).setVisible(true);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addUser:
                Intent intent = new Intent(this, AddUserActivity.class);
                intent.putExtra("referalCode", referalCode);
                startActivity(intent);
                return true;
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        userlistData();
    }

    private void userlistData() {
        if (Utils.isInternetConnected(this)) {
            Utils.showProgressDialog(this);
            final UserListRequest userListRequest = new UserListRequest();
            //userListRequest.setReferalCode(HFMPrefs.getString(UserListActivity.this, Constants.REFERAL));
            //userListRequest.setReferalCode("HFMMOHAN1");
            userListRequest.setReferalCode(referalCode);
            RestClient.userList(userListRequest, new Callback<UserListResponse>() {
                @Override
                public void onResponse(Call<UserListResponse> call, Response<UserListResponse> response) {
                    Utils.dismissProgressDialog();
                    if (response.body() != null) {
                        if (userLists != null) {
                            userLists.clear();
                        }
                        userLists = response.body().getData();
                        if (userLists.size() == 0) {
                            textView.setVisibility(View.VISIBLE);
                            recyclerView.setVisibility(GONE);

                        }/* else if (userLists.size() == 3) {
                            textView.setVisibility(View.VISIBLE);
                            recyclerView.setVisibility(GONE);

                        }*/ else {
                               invalidateOptionsMenu();

                            UserListAdaptor userListAdaptor = new UserListAdaptor(getApplicationContext());
                            userListAdaptor.setDatumList(userLists);
                            userListAdaptor.setListener(UserListActivity.this);
                            recyclerView.setHasFixedSize(true);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
                            recyclerView.setAdapter(userListAdaptor);
                            textView.setVisibility(GONE);
                            recyclerView.setVisibility(View.VISIBLE);
                        }
                    }

                }

                @Override
                public void onFailure(Call<UserListResponse> call, Throwable t) {
                    Utils.dismissProgressDialog();
                    Toast.makeText(UserListActivity.this, R.string.response_failed, Toast.LENGTH_SHORT).show();

                }
            });
        } else {
            Utils.dismissProgressDialog();
            Toast.makeText(UserListActivity.this, R.string.Internet_failed, Toast.LENGTH_SHORT).show();

        }

       /* if (Utils.isInternetConnected(getApplicationContext())) {
            Utils.showProgressDialog(getApplicationContext());
            Intent intent=getIntent();
            int userId=intent.getIntExtra("id",0);
            UserById userById = new UserById();
            userById.setUserId(userId);
            RestClient.getUserList(userById,getString(R.string.bearer) + " " + HFMPrefs.getString(getApplicationContext(), Constants.ACCESS_TOKEN), new Callback<List<UserList>>() {
                @Override
                public void onResponse(Call<List<UserList>> call, Response<List<UserList>> response) {
                    Utils.dismissProgressDialog();
                    if (response.body() != null) {
                        Log.e("UserList Api Response", "" + response.body().size());
                        if (userLists != null) {
                            userLists.clear();
                        }

                        userLists = response.body();
                        userListAdaptor = new UserListAdaptor(userLists, getApplicationContext());
                        userListAdaptor.setListener(UserListActivity.this);
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
                    Utils.dismissProgressDialog();
                    Log.e("UserList Api Response", "" + t.getMessage());
                    Utils.showMessage(getApplicationContext(), getString(R.string.unable_to_get_user));
                }
            });
        } else {
            Utils.showMessage(getApplicationContext(), "Please check internet conection");
        }*/
    }

    @Override
    public void onUserClick(String referalCode) {
        Intent intent = new Intent(this, UserListActivity.class);

        intent.putExtra("referalCode", referalCode);

        startActivity(intent);
    }
}

