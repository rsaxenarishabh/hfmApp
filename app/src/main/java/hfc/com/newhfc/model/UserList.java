package hfc.com.newhfc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserList {

@SerializedName("AccountDetail")
@Expose
private AccountDetail accountDetail;
@SerializedName("LoggedInUserId")
@Expose
private Integer loggedInUserId;
@SerializedName("Password")
@Expose
private Object password;
@SerializedName("Image")
@Expose
private String image;
@SerializedName("TotalCount")
@Expose
private Integer totalCount;
@SerializedName("ParentName")
@Expose
private Object parentName;
@SerializedName("ParentCode")
@Expose
private Object parentCode;
@SerializedName("Id")
@Expose
private Integer id;
@SerializedName("FirstName")
@Expose
private String firstName;
@SerializedName("LastName")
@Expose
private String lastName;
@SerializedName("PhoneNumber")
@Expose
private String phoneNumber;
@SerializedName("EmailAddress")
@Expose
private String emailAddress;
@SerializedName("PasswordSalt")
@Expose
private String passwordSalt;
@SerializedName("Address")
@Expose
private String address;
@SerializedName("PinCode")
@Expose
private Integer pinCode;
@SerializedName("ReferalCode")
@Expose
private String referalCode;
@SerializedName("ProfileImageName")
@Expose
private Object profileImageName;
@SerializedName("DOB")
@Expose
private String dOB;
@SerializedName("LicCode")
@Expose
private String licCode;
@SerializedName("ExpiryDate")
@Expose
private String expiryDate;
@SerializedName("IsActive")
@Expose
private Boolean isActive;
@SerializedName("IsDelete")
@Expose
private Boolean isDelete;
@SerializedName("CreatedBy")
@Expose
private Object createdBy;
@SerializedName("CreatedOn")
@Expose
private String createdOn;
@SerializedName("ModifiedBy")
@Expose
private Object modifiedBy;
@SerializedName("ModifiedOn")
@Expose
private Object modifiedOn;

public AccountDetail getAccountDetail() {
return accountDetail;
}

public void setAccountDetail(AccountDetail accountDetail) {
this.accountDetail = accountDetail;
}

public Integer getLoggedInUserId() {
return loggedInUserId;
}

public void setLoggedInUserId(Integer loggedInUserId) {
this.loggedInUserId = loggedInUserId;
}

public Object getPassword() {
return password;
}

public void setPassword(Object password) {
this.password = password;
}

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

public Integer getTotalCount() {
return totalCount;
}

public void setTotalCount(Integer totalCount) {
this.totalCount = totalCount;
}

public Object getParentName() {
return parentName;
}

public void setParentName(Object parentName) {
this.parentName = parentName;
}

public Object getParentCode() {
return parentCode;
}

public void setParentCode(Object parentCode) {
this.parentCode = parentCode;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

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

public String getPhoneNumber() {
return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}

public String getEmailAddress() {
return emailAddress;
}

public void setEmailAddress(String emailAddress) {
this.emailAddress = emailAddress;
}

public String getPasswordSalt() {
return passwordSalt;
}

public void setPasswordSalt(String passwordSalt) {
this.passwordSalt = passwordSalt;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public Integer getPinCode() {
return pinCode;
}

public void setPinCode(Integer pinCode) {
this.pinCode = pinCode;
}

public String getReferalCode() {
return referalCode;
}

public void setReferalCode(String referalCode) {
this.referalCode = referalCode;
}

public Object getProfileImageName() {
return profileImageName;
}

public void setProfileImageName(Object profileImageName) {
this.profileImageName = profileImageName;
}

public String getDOB() {
return dOB;
}

public void setDOB(String dOB) {
this.dOB = dOB;
}

public String getLicCode() {
return licCode;
}

public void setLicCode(String licCode) {
this.licCode = licCode;
}

public String getExpiryDate() {
return expiryDate;
}

public void setExpiryDate(String expiryDate) {
this.expiryDate = expiryDate;
}

public Boolean getIsActive() {
return isActive;
}

public void setIsActive(Boolean isActive) {
this.isActive = isActive;
}

public Boolean getIsDelete() {
return isDelete;
}

public void setIsDelete(Boolean isDelete) {
this.isDelete = isDelete;
}

public Object getCreatedBy() {
return createdBy;
}

public void setCreatedBy(Object createdBy) {
this.createdBy = createdBy;
}

public String getCreatedOn() {
return createdOn;
}

public void setCreatedOn(String createdOn) {
this.createdOn = createdOn;
}

public Object getModifiedBy() {
return modifiedBy;
}

public void setModifiedBy(Object modifiedBy) {
this.modifiedBy = modifiedBy;
}

public Object getModifiedOn() {
return modifiedOn;
}

public void setModifiedOn(Object modifiedOn) {
this.modifiedOn = modifiedOn;
}

}