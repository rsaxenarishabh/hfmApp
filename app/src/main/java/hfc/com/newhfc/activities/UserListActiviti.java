package hfc.com.newhfc.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import hfc.com.newhfc.R;

public class UserListActiviti extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_activiti);


       /* RecyclerView recyclerView=findViewById(R.id.recycler_userlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
*/

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.home)
        {
            finish();


        }
        return super.onOptionsItemSelected(item);
    }

}