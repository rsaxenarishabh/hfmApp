package hfc.com.newhfc.model.userlist;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserListRequest {

@SerializedName("Referal_code")
@Expose
private String referalCode;

public String getReferalCode() {
return referalCode;
}

public void setReferalCode(String referalCode) {
this.referalCode = referalCode;
}

}