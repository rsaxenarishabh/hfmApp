package hfc.com.newhfc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("AccountDetail")
    @Expose
    private UserLoginAccountDetails accountDetail;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("CreatedBy")
    @Expose
    private Object createdBy;
    @SerializedName("CreatedOn")
    @Expose
    private String createdOn;
    @SerializedName("DOB")
    @Expose
    private String dOB;
    @SerializedName("EmailAddress")
    @Expose
    private String emailAddress;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("IsDelete")
    @Expose
    private Boolean isDelete;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("LicCode")
    @Expose
    private String licCode;
    @SerializedName("LoggedInUserId")
    @Expose
    private Integer loggedInUserId;
    @SerializedName("ModifiedBy")
    @Expose
    private Object modifiedBy;
    @SerializedName("ModifiedOn")
    @Expose
    private Object modifiedOn;
    @SerializedName("Password")
    @Expose
    private Object password;
    @SerializedName("PasswordSalt")
    @Expose
    private String passwordSalt;
    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("PinCode")
    @Expose
    private Integer pinCode;
    @SerializedName("ProfileImageName")
    @Expose
    private Object profileImageName;
    @SerializedName("ReferalCode")
    @Expose
    private String referalCode;

    public UserLoginAccountDetails getAccountDetail() {
        return this.accountDetail;
    }

    public void setAccountDetail(UserLoginAccountDetails userLoginAccountDetails) {
        this.accountDetail = userLoginAccountDetails;
    }

    public Integer getLoggedInUserId() {
        return this.loggedInUserId;
    }

    public void setLoggedInUserId(Integer num) {
        this.loggedInUserId = num;
    }

    public Object getPassword() {
        return this.password;
    }

    public void setPassword(Object obj) {
        this.password = obj;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String str) {
        this.emailAddress = str;
    }

    public String getPasswordSalt() {
        return this.passwordSalt;
    }

    public void setPasswordSalt(String str) {
        this.passwordSalt = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public Integer getPinCode() {
        return this.pinCode;
    }

    public void setPinCode(Integer num) {
        this.pinCode = num;
    }

    public String getReferalCode() {
        return this.referalCode;
    }

    public void setReferalCode(String str) {
        this.referalCode = str;
    }

    public Object getProfileImageName() {
        return this.profileImageName;
    }

    public void setProfileImageName(Object obj) {
        this.profileImageName = obj;
    }

    public String getDOB() {
        return this.dOB;
    }

    public void setDOB(String str) {
        this.dOB = str;
    }

    public String getLicCode() {
        return this.licCode;
    }

    public void setLicCode(String str) {
        this.licCode = str;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean bool) {
        this.isActive = bool;
    }

    public Boolean getIsDelete() {
        return this.isDelete;
    }

    public void setIsDelete(Boolean bool) {
        this.isDelete = bool;
    }

    public Object getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Object obj) {
        this.createdBy = obj;
    }

    public String getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(String str) {
        this.createdOn = str;
    }

    public Object getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(Object obj) {
        this.modifiedBy = obj;
    }

    public Object getModifiedOn() {
        return this.modifiedOn;
    }

    public void setModifiedOn(Object obj) {
        this.modifiedOn = obj;
    }
}
