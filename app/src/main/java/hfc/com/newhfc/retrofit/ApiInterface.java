package hfc.com.newhfc.retrofit;


import java.util.List;

import hfc.com.newhfc.model.UserList;
import hfc.com.newhfc.model.adduser.AddUserRequest;
import hfc.com.newhfc.model.adduser.AddUserResponse;
import hfc.com.newhfc.model.bankDetail.BankDetailRequest;
import hfc.com.newhfc.model.bankDetail.BankDetailResponse;
import hfc.com.newhfc.model.login.LoginRequest;
import hfc.com.newhfc.model.login.LoginResponse;
import hfc.com.newhfc.model.updateUser.UpdateUserDetail;
import hfc.com.newhfc.model.updateUser.UpdateUserResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers({
            "Accept: application/vnd.yourapi.v1.full+json",
            "User-Agent: Your-App-Name"
    })

    @POST("http://vrok.in/hfm_api/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);
/*

    @POST("api/account/Authenticate")
    Call<LoginResponse> login(@Body LoginRequestModel requestModel);*/


    @POST("http://vrok.in/hfm_api/signup")
    Call<AddUserResponse> addUser(@Body AddUserRequest addUserRequest);


    @POST("http://vrok.in/hfm_api/add_bank")
    Call<BankDetailResponse> bankDetailSave(@Body BankDetailRequest bankDetailRequest);


    @POST("http://vrok.in/hfm_api/update")
    Call<UpdateUserResponse> updateUser(@Body UpdateUserDetail updateUserDetail);



    /*@POST("api/account/register")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<ResponseBody> addUser(@Header("Authorization") String access_token, @Body AddUser addUser);

*/
    @POST("api/user/getusersbyuserid")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<List<UserList>> getUserList(@Body() UserById userById, @Header("Authorization") String access_token);


}