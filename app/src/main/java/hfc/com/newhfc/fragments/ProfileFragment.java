package hfc.com.newhfc.fragments;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hfc.com.newhfc.R;
import hfc.com.newhfc.model.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private TabLayout tableLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;





    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment profileFragment=new ProfileFragment();
        return  profileFragment;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);

        tableLayout=v.findViewById(R.id.tabmode);
        appBarLayout=v.findViewById(R.id.appbarid);
        viewPager=v.findViewById(R.id.viewpager);





        ViewPagerAdapter adapter=new ViewPagerAdapter(getFragmentManager());
        adapter.AddFragment(new PersonalDetailsFragment(),"Personal Detail");
        adapter.AddFragment(new ProfileAccountDetail(),"Account Detail");


        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager);



        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

