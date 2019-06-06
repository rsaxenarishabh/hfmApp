package hfc.com.newhfc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import hfc.com.newhfc.R;
import hfc.com.newhfc.fragments.AboutFragment;
import hfc.com.newhfc.fragments.AddBankDetailFragment;
import hfc.com.newhfc.fragments.AddBankDetailFragment;
import hfc.com.newhfc.fragments.AddUserFragment;
import hfc.com.newhfc.fragments.CompanyDetail;
import hfc.com.newhfc.fragments.DashboardFragment;
import hfc.com.newhfc.fragments.ProfileFragment;
import hfc.com.newhfc.fragments.UserListFragment;
import hfc.com.newhfc.model.login.LoginResponse;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFMPrefs;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private CircleImageView pro_img;
    private TextView user;
    NavigationView navigationView;

    CircleImageView circleImageView;
    TextView tvName;
    TextView tvEmail;

    LoginResponse loginResponse;

    public String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Fragment fragment = DashboardFragment.newInstance();
        replaceFragment(fragment);

        String data = HFMPrefs.getString(getApplicationContext(), Constants.LOGIN_DATA);
        loginResponse = new Gson().fromJson(data, LoginResponse.class);
        // loginResponse = new Gson().fromJson(data, LoginResponse.class);

        navigationView = findViewById(R.id.nav_view);

        View headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        tvName = headerView.findViewById(R.id.userName);
        tvEmail = headerView.findViewById(R.id.email);
        circleImageView = headerView.findViewById(R.id.profile_header_image);

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();


            }
        });

        Intent incoming = getIntent();
        if (getIntent().hasExtra("date")) {
            date = incoming.getStringExtra("date");
        }
        if (loginResponse.getUserName() != null) {
            tvName.setText("" + loginResponse.getUserName());
        }
        if (loginResponse.getEmail() != null) {
            tvEmail.setText("" + loginResponse.getEmail());
        }
        Picasso.with(this).load(loginResponse.getImage()).error(R.drawable.profile_pictures).into(circleImageView);


   /*     tvName.setText(loginResponse.getUser().getFirstName() + " " + loginResponse.getUser().getLastName());
        tvEmail.setText(loginResponse.getUser().getEmailAddress());
        Picasso.with(this).load(loginResponse.getUser().getImage()).into(circleImageView);
       /*
        RequestOptions requestOptions = RequestOptions.circleCropTransform().placeholder(R.drawable.user).error(R.drawable.user);

        Glide.with(this).load(loginResponse.getUser().getImage()).apply(requestOptions).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {

                return true;
            }
        }).into(circleImageView);*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        switch (id) {
            case R.id.home:
                fragment = DashboardFragment.newInstance();
                replaceFragment(fragment);
                break;
            case R.id.addUser:
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(intent);
                break;

            case R.id.addBankDetail:
                fragment = AddBankDetailFragment.newInstance();
                replaceFragment(fragment);
                break;

            case R.id.myContacts:
                fragment = UserListFragment.newInstance();
                replaceFragment(fragment);
                break;
            case R.id.bankDetails:
                fragment = CompanyDetail.newInstance();
                replaceFragment(fragment);
                break;

            case R.id.myProfile:
                fragment = ProfileFragment.newInstance();
                replaceFragment(fragment);
                break;

            case R.id.nav_share:
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String text = "Join Hurry Founder Marketing Private Limited ,click below to download\nhttps://play.google.com/store/apps/details?id=hfc.com.newhfc&hl=en";
                share.putExtra(Intent.EXTRA_SUBJECT, "HFM");
                share.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(Intent.createChooser(share, "share via"));
                break;
            case R.id.nav_about:
                fragment = AboutFragment.newInstance();
                replaceFragment(fragment);
                break;
            case R.id.nav_document:
                Intent intent1=new Intent(MainActivity.this,DocumentActivity.class);
                startActivity(intent1);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment, "");
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }
    }
}
