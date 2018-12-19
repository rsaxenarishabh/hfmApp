package hfc.com.newhfc.model.adduser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountDetail {

@SerializedName("AadharNumber")
@Expose
private String aadharNumber;
@SerializedName("AccountNumber")
@Expose
private String accountNumber;
@SerializedName("AccountHolderName")
@Expose
private String accountHolderName;
@SerializedName("CVV")
@Expose
private Integer cVV;
@SerializedName("IFSCCode")
@Expose
private String iFSCCode;
@SerializedName("PancardNumber")
@Expose
private String pancardNumber;
@SerializedName("BranchName")
@Expose
private String branchName;

public String getAadharNumber() {
return aadharNumber;
}

public void setAadharNumber(String aadharNumber) {
this.aadharNumber = aadharNumber;
}

public String getAccountNumber() {
return accountNumber;
}

public void setAccountNumber(String accountNumber) {
this.accountNumber = accountNumber;
}

public String getAccountHolderName() {
return accountHolderName;
}

public void setAccountHolderName(String accountHolderName) {
this.accountHolderName = accountHolderName;
}

public Integer getCVV() {
return cVV;
}

public void setCVV(Integer cVV) {
this.cVV = cVV;
}

public String getIFSCCode() {
return iFSCCode;
}

public void setIFSCCode(String iFSCCode) {
this.iFSCCode = iFSCCode;
}

public String getPancardNumber() {
return pancardNumber;
}

public void setPancardNumber(String pancardNumber) {
this.pancardNumber = pancardNumber;
}

public String getBranchName() {
return branchName;
}

public void setBranchName(String branchName) {
this.branchName = branchName;
}

}
