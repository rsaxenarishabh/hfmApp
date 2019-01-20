package hfc.com.newhfc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hfc.com.newhfc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileAccountDetail extends Fragment {


    public ProfileAccountDetail() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Profile Detail");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profilaccountdetail, container, false);
    }

}
