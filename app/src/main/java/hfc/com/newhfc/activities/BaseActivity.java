package hfc.com.newhfc.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


public class BaseActivity extends AppCompatActivity {

    /*open new activity*/
    public void activityIn() {
        //calling to predefine method
    }
    /*come to back activity*/
    public void backIn()
    {
        Log.e("backIn","isCalling");
    }

    /*
     * This methos is displaying long message
     *
     * */
    public void showLongMessage(Context context, String message)
    {
        Toast.makeText(context,""+message, Toast.LENGTH_LONG).show();
    }

    /*
     * This method is displaying short message
     *
     * */
    public void showShortMessage(Context context, String message)
    {
        Toast.makeText(context,""+message, Toast.LENGTH_LONG).show();
    }

}
