package hfc.com.newhfc.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import hfc.com.newhfc.R;

public class AddBankDetailFragment extends Fragment {


    private EditText editTextAddhar,editTextPanCard,editTextAccountNumber,editTextIfsc,
             editTextAccountholderName,editTextBranchName,editTextNominee;

    String aadhar,panCard,accountNumber,ifsc,accountHolder,branchName,nominee;
    String userId;
    Button btnAdd;


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
        editTextAddhar=view.findViewById(R.id.edittext_aadhar);
        editTextPanCard=view.findViewById(R.id.edittext_pancard);
        editTextIfsc=view.findViewById(R.id.edittext_ifsc);
        editTextAccountholderName=view.findViewById(R.id.edittext_accountholder);
        editTextNominee=view.findViewById(R.id.edittext_nominee);
        editTextBranchName=view.findViewById(R.id.edittext_branch);
        editTextAccountNumber=view.findViewById(R.id.edittext_account);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDetail();
            }
        });





        return view;

    }

    private void saveDetail() {

        boolean check=true;
        aadhar=editTextAddhar.getText().toString().trim();
        panCard=editTextPanCard.getText().toString().trim();
        accountNumber=editTextAccountNumber.getText().toString().trim();
        ifsc=editTextIfsc.getText().toString().trim();
        accountHolder=editTextAccountholderName.getText().toString().trim();
        branchName=editTextBranchName.getText().toString().trim();
        nominee=editTextNominee.getText().toString().trim();


        if (aadhar.isEmpty()) {
            editTextAddhar.setError("Field can't be empty");
            check = false;

        }

        if (panCard.isEmpty()) {
            editTextPanCard.setError("Field can't be empty");
            check = false;

        }

        if (accountNumber.isEmpty()) {
            editTextAccountNumber.setError("Field can't be empty");
            check = false;

        }


        if (ifsc.isEmpty()) {
            editTextIfsc.setError("Field can't be empty");
            check = false;

        }

        if (nominee.isEmpty()) {
            editTextNominee.setError("Field can't be empty");
            check = false;

        }
        if (accountHolder.isEmpty()) {
            editTextAccountholderName.setError("Field can't be empty");
            check = false;

        }
        if (branchName.isEmpty()) {
            editTextBranchName.setError("Field can't be empty");
            check = false;

        }

        if(check==true)
        {


        }

    }

}
