package hfc.com.newhfc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLoginAccountDetails {
    @SerializedName("AadharNumber")
    @Expose
    private String aadharNumber;
    @SerializedName("AccountHolderName")
    @Expose
    private String accountHolderName;
    @SerializedName("AccountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("BranchName")
    @Expose
    private String branchName;
    @SerializedName("IFSCCode")
    @Expose
    private String iFSCCode;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("NomineeAadhar")
    @Expose
    private String nomineeAadhar;
    @SerializedName("NomineeDOB")
    @Expose
    private Object nomineeDOB;
    @SerializedName("NomineeName")
    @Expose
    private String nomineeName;
    @SerializedName("PancardNumber")
    @Expose
    private String pancardNumber;
    @SerializedName("UserId")
    @Expose
    private Object userId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public Object getUserId() {
        return this.userId;
    }

    public void setUserId(Object obj) {
        this.userId = obj;
    }

    public String getAadharNumber() {
        return this.aadharNumber;
    }

    public void setAadharNumber(String str) {
        this.aadharNumber = str;
    }

    public String getPancardNumber() {
        return this.pancardNumber;
    }

    public void setPancardNumber(String str) {
        this.pancardNumber = str;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public String getIFSCCode() {
        return this.iFSCCode;
    }

    public void setIFSCCode(String str) {
        this.iFSCCode = str;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public void setAccountHolderName(String str) {
        this.accountHolderName = str;
    }

    public String getBranchName() {
        return this.branchName;
    }

    public void setBranchName(String str) {
        this.branchName = str;
    }

    public String getNomineeName() {
        return this.nomineeName;
    }

    public void setNomineeName(String str) {
        this.nomineeName = str;
    }

    public Object getNomineeDOB() {
        return this.nomineeDOB;
    }

    public void setNomineeDOB(Object obj) {
        this.nomineeDOB = obj;
    }

    public String getNomineeAadhar() {
        return this.nomineeAadhar;
    }

    public void setNomineeAadhar(String str) {
        this.nomineeAadhar = str;
    }
}
