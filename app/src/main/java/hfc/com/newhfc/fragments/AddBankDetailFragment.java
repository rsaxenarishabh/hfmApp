package hfc.com.newhfc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hfc.com.newhfc.R;

public class AddBankDetailFragment extends Fragment {



    public static AddBankDetailFragment newInstance() {
        AddBankDetailFragment fragment = new AddBankDetailFragment();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bank_detail, container, false);
       // img_profile = view.findViewById(R.id.img_profile);

        return view;

    }

}
