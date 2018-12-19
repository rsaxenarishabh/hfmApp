package hfc.com.newhfc.retrofit;


import java.util.List;

import hfc.com.newhfc.model.LoginRequestModel;
import hfc.com.newhfc.model.LoginResponse;
import hfc.com.newhfc.model.UserList;
import hfc.com.newhfc.model.adduser.AddUser;
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

    @POST("api/account/Authenticate")
    Call<LoginResponse> login(@Body LoginRequestModel requestModel);


    @POST("api/account/register")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<ResponseBody> addUser(@Header("Authorization") String access_token, @Body AddUser addUser);



    @POST("api/user/getuserlist")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<List<UserList>> getUserList(@Header("Authorization") String access_token);


}