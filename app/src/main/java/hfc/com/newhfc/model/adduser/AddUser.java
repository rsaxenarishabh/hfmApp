package hfc.com.newhfc.model.adduser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddUser {

    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("EmailAddress")
    @Expose
    private String emailAddress;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("PinCode")
    @Expose
    private String pinCode;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("LoggedInUserId")
    @Expose
    private String loggedInUserId;
    @SerializedName("ReferalCode")
    @Expose
    private String referalCode;


    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeDOB() {
        return nomineeDOB;
    }

    public void setNomineeDOB(String nomineeDOB) {
        this.nomineeDOB = nomineeDOB;
    }

    public String getNomineeAadhar() {
        return nomineeAadhar;
    }

    public void setNomineeAadhar(String nomineeAadhar) {
        this.nomineeAadhar = nomineeAadhar;
    }

    @SerializedName("NomineeName")
    @Expose
    private String nomineeName;
    @SerializedName("NomineeDOB")
    @Expose
    private String nomineeDOB;
    @SerializedName("NomineeAadhar")
    @Expose
    private String nomineeAadhar;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getLoggedInUserId() {
        return loggedInUserId;
    }

    public void setLoggedInUserId(String loggedInUserId) {
        this.loggedInUserId = loggedInUserId;
    }

    public String getReferalCode() {
        return referalCode;
    }

    public void setReferalCode(String referalCode) {
        this.referalCode = referalCode;
    }


}