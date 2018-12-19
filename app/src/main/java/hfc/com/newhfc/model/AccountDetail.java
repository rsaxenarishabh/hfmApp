package hfc.com.newhfc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountDetail {

@SerializedName("Id")
@Expose
private Integer id;
@SerializedName("UserId")
@Expose
private Object userId;
@SerializedName("AadharNumber")
@Expose
private String aadharNumber;
@SerializedName("PancardNumber")
@Expose
private String pancardNumber;
@SerializedName("AccountNumber")
@Expose
private String accountNumber;
@SerializedName("IFSCCode")
@Expose
private String iFSCCode;
@SerializedName("AccountHolderName")
@Expose
private String accountHolderName;
@SerializedName("BranchName")
@Expose
private String branchName;
@SerializedName("NomineeName")
@Expose
private String nomineeName;
@SerializedName("NomineeDOB")
@Expose
private Object nomineeDOB;
@SerializedName("NomineeAadhar")
@Expose
private String nomineeAadhar;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public Object getUserId() {
return userId;
}

public void setUserId(Object userId) {
this.userId = userId;
}

public String getAadharNumber() {
return aadharNumber;
}

public void setAadharNumber(String aadharNumber) {
this.aadharNumber = aadharNumber;
}

public String getPancardNumber() {
return pancardNumber;
}

public void setPancardNumber(String pancardNumber) {
this.pancardNumber = pancardNumber;
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

public Object getNomineeDOB() {
return nomineeDOB;
}

public void setNomineeDOB(Object nomineeDOB) {
this.nomineeDOB = nomineeDOB;
}

public String getNomineeAadhar() {
return nomineeAadhar;
}

public void setNomineeAadhar(String nomineeAadhar) {
this.nomineeAadhar = nomineeAadhar;
}

}
