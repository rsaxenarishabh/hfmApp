package hfc.com.newhfc.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hfc.com.newhfc.R;
import hfc.com.newhfc.activities.UserListActivity;
import hfc.com.newhfc.adapter.UserListAdaptor;
import hfc.com.newhfc.model.userlist.Datum;
import hfc.com.newhfc.model.userlist.UserListRequest;
import hfc.com.newhfc.model.userlist.UserListResponse;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.utils.Utils;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFMPrefs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class UserListFragment extends Fragment implements UserListAdaptor.OnUserClickCallback {
    //List<UserList> userLists = new ArrayList<>();
    List<Datum> userLists = new ArrayList<>();
    // UserListResponse userLists;
    RecyclerView recyclerView;

    TextView textView;

    public UserListFragment() {
        // Required empty public constructor
    }

    public static UserListFragment newInstance() {
        UserListFragment userListFragment = new UserListFragment();
        return userListFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity().setTitle("My Contacts");
        getActivity().setTitleColor(R.color.white);
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        textView = view.findViewById(R.id.user);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getUserListApiCall();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        getUserListApiCall();
    }

    private void getUserListApiCall() {
        if (Utils.isInternetConnected(getActivity())) {
            Utils.showProgressDialog(getActivity());
            final UserListRequest userListRequest = new UserListRequest();
            String referalCode = HFMPrefs.getString(getActivity(), Constants.REFERAL);
            userListRequest.setReferalCode("" + referalCode);
            // userListRequest.setReferalCode("HFMMOHAN1");
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
                            recyclerView.setVisibility(View.GONE);
                            textView.setVisibility(View.VISIBLE);

                        } else {
                            if(getActivity()!=null) {
                                getActivity().invalidateOptionsMenu();
                            }
                            UserListAdaptor userListAdaptor = new UserListAdaptor(getActivity());
                            userListAdaptor.setDatumList(userLists);
                            recyclerView.setHasFixedSize(true);
                            userListAdaptor.setListener(UserListFragment.this);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                            recyclerView.setAdapter(userListAdaptor);
                            recyclerView.setVisibility(View.VISIBLE);
                            textView.setVisibility(View.GONE);
                        }
                    }

                }

                @Override
                public void onFailure(Call<UserListResponse> call, Throwable t) {
                    Utils.dismissProgressDialog();
                    Toast.makeText(getActivity(), R.string.response_failed, Toast.LENGTH_SHORT).show();

                }
            });
        } else {
            Utils.dismissProgressDialog();
            Toast.makeText(getActivity(), R.string.Internet_failed, Toast.LENGTH_SHORT).show();
        }

    }

  /*  private void getUserListApiCall() {
        if (Utils.isInternetConnected(getActivity())) {
            Utils.showProgressDialog(getActivity());
            UserById userById = new UserById();
            userById.setUserId(HFMPrefs.getInt(getActivity(), Constants.LOGGED_IN_USER_ID, 0));
            RestClient.getUserList(userById,getString(R.string.bearer) + " " + HFMPrefs.getString(getActivity(), Constants.ACCESS_TOKEN), new Callback<List<UserList>>() {
                        @Override
                        public void onResponse(Call<List<UserList>> call, Response<List<UserList>> response) {
                            Utils.dismissProgressDialog();
                            if (response.body() != null) {
                                Log.e("UserList Api Response", "" + response.body().size());
                                if (userLists != null) {
                                    userLists.clear();
                                }
                                userLists = response.body();
                                UserListAdaptor userListAdaptor = new UserListAdaptor(userLists, getActivity());
                                recyclerView.setHasFixedSize(true);
                                userListAdaptor.setListener(UserListFragment.this);
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                                recyclerView.setLayoutManager(layoutManager);
                                recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                                recyclerView.setAdapter(userListAdaptor);
                                //TODO implement Recycler view
                            }

                        }

                        @Override
                        public void onFailure(Call<List<UserList>> call, Throwable t) {
                            Utils.dismissProgressDialog();
                            Log.e("UserList Api Response", "" + t.getMessage());
                            Utils.showMessage(getActivity(), getString(R.string.unable_to_get_user));

                        }
                    });
        } else {
            Utils.showMessage(getActivity(), "Please check internet conection");
        }
    }*/

    @Override
    public void onUserClick(String referalCode) {
        Intent intent = new Intent(getActivity(), UserListActivity.class);
        //intent.putExtra("id", id);
        intent.putExtra("referalCode", referalCode);

        startActivity(intent);
    }

}

