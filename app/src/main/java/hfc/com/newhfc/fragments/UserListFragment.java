package hfc.com.newhfc.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hfc.com.newhfc.R;
import hfc.com.newhfc.model.UserList;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.utils.AppUtils;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFCPrefs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class UserListFragment extends Fragment {
    List<UserList> userLists = new ArrayList<>();

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
        return inflater.inflate(R.layout.fragment_user_list, container, false);
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

    private void getUserListApiCall() {
        if (AppUtils.isInternetConnected(getActivity())) {
            AppUtils.showProgressDialog(getActivity());
            RestClient.getUserList(getString(R.string.bearer)+" "+HFCPrefs.getString(getActivity(), Constants.ACCESS_TOKEN), new Callback<List<UserList>>() {
                @Override
                public void onResponse(Call<List<UserList>> call, Response<List<UserList>> response) {
                  AppUtils.dismissProgressDialog();
                    if (response.body()!=null){
                        Log.e("UserList Api Response", "" + response.body().size());
                        userLists = response.body();
                        //TODO implement Recycler view
                    }

                }

                @Override
                public void onFailure(Call<List<UserList>> call, Throwable t) {
                    AppUtils.dismissProgressDialog();
                    Log.e("UserList Api Response", "" + t.getMessage());
                    AppUtils.showMessage(getActivity(), getString(R.string.unable_to_get_user));

                }
            });
        } else {
            AppUtils.showMessage(getActivity(), "Please check internet conection");
        }
    }

}

