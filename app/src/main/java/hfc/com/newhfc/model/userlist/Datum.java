package hfc.com.newhfc.model.userlist;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

@SerializedName("Id")
@Expose
private String id;
@SerializedName("First_Name")
@Expose
private String firstName;
@SerializedName("User_Name")
@Expose
private String userName;
@SerializedName("Image")
@Expose
private String image;
@SerializedName("Phone_Number")
@Expose
private String phoneNumber;
@SerializedName("Email")
@Expose
private String email;
@SerializedName("Date-of-Birth")
@Expose
private String dateOfBirth;
@SerializedName("Address")
@Expose
private String address;
@SerializedName("Pincode")
@Expose
private String pincode;
@SerializedName("Status")
@Expose
private String status;
@SerializedName("Referal_code")
@Expose
private String referalCode;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getUserName() {
return userName;
}

public void setUserName(String userName) {
this.userName = userName;
}

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

public String getPhoneNumber() {
return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getDateOfBirth() {
return dateOfBirth;
}

public void setDateOfBirth(String dateOfBirth) {
this.dateOfBirth = dateOfBirth;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getPincode() {
return pincode;
}

public void setPincode(String pincode) {
this.pincode = pincode;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getReferalCode() {
return referalCode;
}

public void setReferalCode(String referalCode) {
this.referalCode = referalCode;
}

}
