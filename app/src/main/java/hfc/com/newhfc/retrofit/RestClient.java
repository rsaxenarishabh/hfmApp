package hfc.com.newhfc.retrofit;


import java.util.List;

import hfc.com.newhfc.model.UserList;
import hfc.com.newhfc.model.adduser.AddUserRequest;
import hfc.com.newhfc.model.adduser.AddUserResponse;
import hfc.com.newhfc.model.bankDetail.BankDetailRequest;
import hfc.com.newhfc.model.bankDetail.BankDetailResponse;
import hfc.com.newhfc.model.login.LoginRequest;
import hfc.com.newhfc.model.login.LoginResponse;
import okhttp3.ResponseBody;
import retrofit2.Callback;

public class RestClient {

    public static void loginUser(LoginRequest loginRequest, Callback<LoginResponse> callback) {
        RetrofitClient.getClient().loginUser(loginRequest).enqueue(callback);
    }


    public static void addUser(AddUserRequest addUserRequest, Callback<AddUserResponse> callback) {
        RetrofitClient.getClient().addUser(addUserRequest).enqueue(callback);
    }


    public static void bankDetailSave(BankDetailRequest bankDetailRequest, Callback<BankDetailResponse> callback) {
        RetrofitClient.getClient().bankDetailSave(bankDetailRequest).enqueue(callback);
    }
/*

    public static void login(LoginRequestModel loginRequestModel, Callback<LoginResponse> callback) {
        RetrofitClient.getClient().login(loginRequestModel).enqueue(callback);

    }
*/

    public static void getUserList(UserById user, String access_token, Callback<List<UserList>> callback) {
        RetrofitClient.getClient().getUserList(user, access_token).enqueue(callback);
    }
/*

    public static void addUser(String access_token, AddUser addUser, Callback<ResponseBody> callback) {
        RetrofitClient.getClient().addUser(access_token, addUser).enqueue(callback);
    }

*/

}



