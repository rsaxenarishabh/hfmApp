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
public class PersonalDetailsFragment extends Fragment {


    public PersonalDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_personal_details, container, false);

          getActivity().setTitle("Detail");
        return v;

    }

}
