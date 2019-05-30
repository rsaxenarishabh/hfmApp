package hfc.com.newhfc.model.bankDetail;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankDetailRequest {

@SerializedName("User_Id")
@Expose
private Integer userId;
@SerializedName("Aadhar_Number")
@Expose
private String aadharNumber;
@SerializedName("Pan_Number")
@Expose
private String panNumber;
@SerializedName("Account_Number")
@Expose
private String accountNumber;
@SerializedName("IFSC_Code")
@Expose
private String iFSCCode;
@SerializedName("Account_Holder_Name")
@Expose
private String accountHolderName;
@SerializedName("Branch_Name")
@Expose
private String branchName;
@SerializedName("Nominee_Name")
@Expose
private String nomineeName;

public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}

public String getAadharNumber() {
return aadharNumber;
}

public void setAadharNumber(String aadharNumber) {
this.aadharNumber = aadharNumber;
}

public String getPanNumber() {
return panNumber;
}

public void setPanNumber(String panNumber) {
this.panNumber = panNumber;
}

public String getAccountNumber() {
return accountNumber;
}

public void setAccountNumber(String accountNumber) {
this.accountNumber = accountNumber;
}

public String getIFSCCode() {
return iFSCCode;
}

public void setIFSCCode(String iFSCCode) {
this.iFSCCode = iFSCCode;
}

public String getAccountHolderName() {
return accountHolderName;
}

public void setAccountHolderName(String accountHolderName) {
this.accountHolderName = accountHolderName;
}

public String getBranchName() {
return branchName;
}

public void setBranchName(String branchName) {
this.branchName = branchName;
}

public String getNomineeName() {
return nomineeName;
}

public void setNomineeName(String nomineeName) {
this.nomineeName = nomineeName;
}

}