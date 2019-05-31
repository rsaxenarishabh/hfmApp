package hfc.com.newhfc.model.updateUser;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateUserDetail {

    @SerializedName("User_Id")
    @Expose
    private Integer userId;
    @SerializedName("First_Name")
    @Expose
    private String firstName;
    @SerializedName("Last_Name")
    @Expose
    private String lastName;
    @SerializedName("base64_file")
    @Expose
    private String base64File;
    @SerializedName("Phone_Number")
    @Expose
    private String phoneNumber;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Date_of_Birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Pincode")
    @Expose
    private String pincode;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {

        this.userId = userId;
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


}