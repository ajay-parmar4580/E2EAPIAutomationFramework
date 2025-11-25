package com.api.models.request;

public class UpdateProfileRequest {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;


    private UpdateProfileRequest(int id,String username,String firstName, String lastName, String email, String mobileNumber) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public static class Builder{
        private int id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String mobileNumber;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder mobileNumber(String mobileNumber){
            this.mobileNumber = mobileNumber;
            return this;
        }

        public UpdateProfileRequest build(){
            UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest(id,username,firstName,lastName,email,mobileNumber);
            return updateProfileRequest;
        }
    }
}
