package hfc.com.hfcnew.retrofit;


import hfc.com.newhfc.model.LoginRequestModel;
import hfc.com.newhfc.model.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers({
            "Accept: application/vnd.yourapi.v1.full+json",
            "User-Agent: Your-App-Name"
    })

    @POST("api/account/Authenticate")
    Call<LoginResponse> login(@Body LoginRequestModel dataObject);


//    @POST("api/account/register")
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
//    Call<ResponseBody> addUser(@Header("Authorization") String access_token,@Body AddUser dataObject);
//
//
//
//    @POST("api/user/getuserlist")
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
//    Call<List<UserList>> getUserList(@Header("Authorization") String access_token);

//    @GET("/api/users/{deviceId}/trip-url")
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
//    Call<Re> getTripUrl2Share(@Path("deviceId") String deviceId, @Query("ttl") long duration, @Header("X-Authorization-Firebase") String access_token);


//
//    @POST("/api/devices")
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
//    Call<AddDeviceModelResponse> addDevice(@Body DeviceInformation deviceInformation, @Header("X-Authorization-Firebase") String access_token);

}