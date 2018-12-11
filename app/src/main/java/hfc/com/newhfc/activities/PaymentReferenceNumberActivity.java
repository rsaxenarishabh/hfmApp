package hfc.com.newhfc.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hfc.com.newhfc.R;

public class PaymentReferenceNumberActivity extends AppCompatActivity {


    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_payment_reference_number);
        ButterKnife.bind((Activity) this);
    }


}
