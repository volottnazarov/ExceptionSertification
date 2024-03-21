package Data;

public class UserData {
    String surName;
    String name;
    String lastName;
    String birthDay;
    Long phoneNumber;
    String gender;

    public UserData(String surName, String name, String lastName, String birthDay,
                    Long phoneNumber, String gender) {
        this.surName = surName;
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "<" + surName + ">" +
                "<" + name + ">" +
                "<" + lastName + ">" +
                "<" + birthDay + ">" +
                "<" + phoneNumber + ">" +
                "<" + gender + ">";
    }
}
