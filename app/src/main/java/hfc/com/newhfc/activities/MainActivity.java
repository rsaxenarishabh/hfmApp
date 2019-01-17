package hfc.com.newhfc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.view.Menu;
import android.view.MenuItem;

import hfc.com.newhfc.R;
import hfc.com.newhfc.fragments.AboutFragment;
import hfc.com.newhfc.fragments.AddUserFragment;
import hfc.com.newhfc.fragments.BankDetailsFragment;
import hfc.com.newhfc.fragments.DashboardFragment;
import hfc.com.newhfc.fragments.ProfileFragment;
import hfc.com.newhfc.fragments.UserListFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       Fragment  fragment =  DashboardFragment.newInstance();
        replaceFragment(fragment);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        switch (id) {
            case R.id.home:
                fragment =  DashboardFragment.newInstance();
                replaceFragment(fragment);
                break;
            case R.id.addUser:
                fragment=AddUserFragment.newInstance();
                replaceFragment(fragment);

                break;
            case R.id.myContacts:
                fragment =  UserListFragment.newInstance();
                replaceFragment(fragment);
                break;
            case R.id.bankDetails:
                fragment =  BankDetailsFragment.newInstance();
                replaceFragment(fragment);
                break;

            case R.id.myProfile:
                fragment = ProfileFragment.newInstance();
                replaceFragment(fragment);
                break;

            case R.id.nav_share:

                Intent share=new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String text="This is Service application ,click below to download\nhttp://www.mediafire.com/file/oan96lui4k7423w/handicraft.apk";
                share.putExtra(Intent.EXTRA_SUBJECT,"Services");
                share.putExtra(Intent.EXTRA_TEXT,text);
                startActivity(Intent.createChooser(share,"share via"));
break;
            case R.id.nav_about:
               fragment= AboutFragment.newInstance();
               replaceFragment(fragment);
               break;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment, "");
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }
    }
}
