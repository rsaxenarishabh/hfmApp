package hfc.com.newhfc.fragments;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hfc.com.newhfc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText editTextLIC,editTextFirstname,editTextLastname,editTextPhone,editTextEmail,editTextDate,editTextAddress,editTextPincode
            ,editTextAadharcard,editTextPancard,editTextAccountnum,editTextIfsccode,editTextAccountholder,editTextBranchname,editTextAdharNominee
            ,editTextDateNominee
            ,editTextNomineename,editTextJoiningfee;
    private Button buttonSubmit;



    public AddUserFragment() {
        // Required empty public constructor
    }

    public static AddUserFragment newInstance() {
        AddUserFragment fragment = new AddUserFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_user, container, false);

        editTextLIC=view.findViewById(R.id.edittext_liccode);
        editTextFirstname=view.findViewById(R.id.edittext_firstname);
        editTextLastname=view.findViewById(R.id.edittext_lastname);
        editTextPhone=view.findViewById(R.id.edittext_phonenumber);
        editTextEmail=view.findViewById(R.id.edittext_email);
        editTextDate=view.findViewById(R.id.edittext_date);
        editTextAddress=view.findViewById(R.id.edittext_address);
        editTextPincode=view.findViewById(R.id.edittext_pincode);
        editTextAadharcard=view.findViewById(R.id.edittext_aadharcard);
        editTextPancard=view.findViewById(R.id.editext_pancard);
        editTextAccountnum=view.findViewById(R.id.edittext_accountnumber);
        editTextIfsccode=view.findViewById(R.id.editext_ifsc);
        editTextBranchname=view.findViewById(R.id.edittext_branch_name);
        editTextDateNominee=view.findViewById(R.id.edittext_date1);
        editTextNomineename=view.findViewById(R.id.edittext_nominee);
        editTextJoiningfee=view.findViewById(R.id.edittext_joiningfee);
        editTextAdharNominee=view.findViewById(R.id.edittext_aadharno);
        editTextAccountholder=view.findViewById(R.id.edittext_accountholder);
        buttonSubmit=view.findViewById(R.id.button);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();
            }
        });


        return view;
    }


    private void Validation()
    {

        boolean check=true;
        String Licreg=editTextLIC.getText().toString().trim();
        String firstname=editTextFirstname.getText().toString().trim();
        String lastname=editTextLastname.getText().toString().trim();
        String phone=editTextPhone.getText().toString().trim();
        String email=editTextEmail.getText().toString().trim();
        String date=editTextDate.getText().toString().trim();
        String address=editTextAddress.getText().toString().trim();
        String pincode=editTextPincode.getText().toString().trim();
        String aadharNumber=editTextAadharcard.getText().toString().trim();
        String pancard=editTextPancard.getText().toString().trim();
        String accountnum=editTextAccountnum.getText().toString().trim();
        String ifsccode=editTextIfsccode.getText().toString().trim();
        String accountholdername=editTextAccountholder.getText().toString().trim();
        String branchname=editTextBranchname.getText().toString().trim();
        String aadharcardnumber=editTextAdharNominee.getText().toString().trim();
        String nomineedate=editTextDateNominee.getText().toString().trim();
        String nomineename=editTextNomineename.getText().toString().trim();
        String joiningfees=editTextJoiningfee.getText().toString().trim();

        if(Licreg.isEmpty())
        {
            editTextLIC.setError("Field can't be empty");
            check=false;
        }
        if(firstname.isEmpty())
        {
            editTextFirstname.setError("Field can't be empty");
            check=false;

        }

        if(lastname.isEmpty())
        {
            editTextLastname.setError("Field can't be empty");
            check=false;

        }

        if(phone.isEmpty())
        {
            editTextPhone.setError("Field can't be empty");
            check=false;

        }


        if(date.isEmpty())
        {
            editTextDate.setError("Field can't be empty");
            check=false;

        }

        if(address.isEmpty())
        {
            editTextAddress.setError("Field can't be empty");
            check=false;

        }
        if(pincode.isEmpty())
        {
            editTextPincode.setError("Field can't be empty");
            check=false;

        }
        if(aadharNumber.isEmpty())
        {
            editTextAccountnum.setError("Field can't be empty");
            check=false;

        }
        if(pancard.isEmpty())
        {
            editTextPancard.setError("Field can't be empty");
            check=false;

        }
        if(accountnum.isEmpty())
        {
            editTextAccountnum.setError("Field can't be empty");
            check=false;

        }
        if(ifsccode.isEmpty())
        {
            editTextIfsccode.setError("Field can't be empty");
            check=false;

        }
        if(accountholdername.isEmpty())
        {
            editTextAccountholder.setError("Field can't be empty");
            check=false;

        }
        if(branchname.isEmpty())
        {
            editTextBranchname.setError("Field can't be empty");
            check=false;

        }
        if(aadharcardnumber.isEmpty())
        {
            editTextAdharNominee.setError("Field can't be empty");
            check=false;

        }
        if(nomineedate.isEmpty())
        {
            editTextDateNominee.setError("Field can't be empty");
            check=false;

        }
        if(nomineename.isEmpty())
        {
            editTextNomineename.setError("Field can't be empty");
            check=false;

        }
        if(joiningfees.isEmpty())
        {
            editTextJoiningfee.setError("Field can't be empty");
            check=false;

        }

        if(check==true)
        {
            //startActivity(new Intent(getContext(),));
            Toast.makeText(getContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();


        }
        else
        {
            Toast.makeText(getActivity(), "Please Fill All Data completed", Toast.LENGTH_SHORT).show();
        }













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
