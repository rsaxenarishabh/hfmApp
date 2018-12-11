package hfc.com.newhfc.retrofit;


import hfc.com.newhfc.model.LoginRequestModel;
import hfc.com.newhfc.model.LoginResponse;
import retrofit2.Callback;

public class RestClient {


    public static void login(LoginRequestModel loginRequestModel, Callback<LoginResponse> callback) {
        RetrofitClient.getClient().login(loginRequestModel).enqueue(callback);
    }

//    public static void getUserList(String access_token, Callback<List<UserList>> callback) {
//        RetrofitClient.getClient().getUserList(access_token).enqueue(callback);
//    }
//
//    public static void addUser(String access_token, AddUser addUser, Callback<ResponseBody> callback) {
//        RetrofitClient.getClient().addUser(access_token,addUser).enqueue(callback);
//    }


}



