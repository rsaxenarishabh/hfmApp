package hfc.com.newhfc.model;

public class LoginRequestModel {
    String EmailAddress;
    String Password;

    public String getEmailAddress() {
        return this.EmailAddress;
    }

    public void setEmailAddress(String str) {
        this.EmailAddress = str;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String str) {
        this.Password = str;
    }
}
