package hfc.com.newhfc.model.adduser;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddUserRequest {

@SerializedName("First_Name")
@Expose
private String firstName;
@SerializedName("Last_Name")
@Expose
private String lastName;
@SerializedName("User_Name")
@Expose
private String userName;
@SerializedName("base64_file")
@Expose
private String base64File;
@SerializedName("Phone_Number")
@Expose
private String phoneNumber;
@SerializedName("Email")
@Expose
private String email;
@SerializedName("Password")
@Expose
private String password;
@SerializedName("Date_of_Birth")
@Expose
private String dateOfBirth;
@SerializedName("Address")
@Expose
private String address;
@SerializedName("Pincode")
@Expose
private String pincode;
@SerializedName("Referal_Code")
@Expose
private String referalCode;

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

public String getUserName() {
return userName;
}

public void setUserName(String userName) {
this.userName = userName;
}

public String getBase64File() {
return base64File;
}

public void setBase64File(String base64File) {
this.base64File = base64File;
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

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
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

public String getReferalCode() {
return referalCode;
}

public void setReferalCode(String referalCode) {
this.referalCode = referalCode;
}

}