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
import hfc.com.newhfc.model.adduser.AccountDetail;
import hfc.com.newhfc.model.adduser.AddUser;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.utils.AppUtils;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFCPrefs;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        editTextFirstname=view.findViewById(R.id.edittext_firstname);
        editTextLastname=view.findViewById(R.id.edittext_lastname);
        editTextPhone=view.findViewById(R.id.edittext_phonenumber);
        editTextEmail=view.findViewById(R.id.edittext_email);
        editTextAddress=view.findViewById(R.id.edittext_address);
        editTextPincode=view.findViewById(R.id.edittext_pincode);
        editTextAadharcard=view.findViewById(R.id.edittext_aadharcard);
        editTextPancard=view.findViewById(R.id.editext_pancard);
        editTextAccountnum=view.findViewById(R.id.edittext_accountnumber);
        editTextIfsccode=view.findViewById(R.id.editext_ifsc);
        editTextBranchname=view.findViewById(R.id.edittext_branch_name);
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
           //TODO add user request

            AddUser addUser = new AddUser();
            addUser.setFirstName(firstname+"Test");
            addUser.setLastName(lastname+"test");
            addUser.setPhoneNumber("57634876538747");
            addUser.setEmailAddress("test12@gmail.com");
            addUser.setAddress("test");
            addUser.setPinCode("656463");
            addUser.setNomineeName("test");
//            addUser.setNomineeAadhar(etNomeneeAdhar.getEditText().getText().toString().trim());
//            addUser.setNomineeDOB(etdob.getEditText().getText().toString().trim());
//            addUser.setReferalCode(HFCPrefs.getString(getActivity(), Constants.REFERRAL_CODE));
             AccountDetail accountDetail= new AccountDetail();
//            accountDetail.setAadharNumber(etAdhaar.getEditText().getText().toString().trim());
//            accountDetail.setPancardNumber(etPanNumber.getEditText().getText().toString().trim());
//            accountDetail.setAccountNumber(etAcountNumber.getEditText().getText().toString().trim());
//            accountDetail.setIFSCCode(etIFSC.getEditText().getText().toString().trim());
//            accountDetail.setAccountHolderName(etAcountHolderName.getEditText().getText().toString().trim());
//            accountDetail.setBranchName(etBranchName.getEditText().getText().toString().trim());
//
//            accountDetail.setCVV(Integer.parseInt(etCVV.getEditText().getText().toString().trim()));

            addUser.setAccountDetail(accountDetail);


            String access_token= HFCPrefs.getString(getActivity(),Constants.ACCESS_TOKEN);
                    AppUtils.showProgressDialog(getActivity());
            RestClient.addUser(access_token, addUser, new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });

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
