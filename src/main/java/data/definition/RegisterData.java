package data.definition;

public class RegisterData {
    String randomUserName = ""+(int)(Math.random()*Integer.MAX_VALUE);
    String email = "User"+randomUserName+"@example.com";
    String title;
    String firstName1;
    String lastName1;
    String password;
    String dayOfBirth;
    String monthOfBirth;
    String yearOfBirth;
    String firstName2;
    String lastName2;
    String company;
    String address1;
    String address2;
    String city;
    String state;
    String postCode;
    String country;
    String additionInformation;
    String homePhone;
    String mobilePhone;
    String aliasAddress;
    Boolean checkbox1;
    Boolean checkbox2;


    public RegisterData setEmail(String email) {

        this.email = email;
        return this;
    }

    public RegisterData setTitle(String title) {
        this.title = title;
        return this;
    }

    public RegisterData setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
        return this;
    }

    public RegisterData setLastName1(String lastName1) {
        this.lastName1 = lastName1;
        return this;
    }

    public RegisterData setPassword(String password) {
        this.password = password;
        return this;
    }

    public RegisterData setDayOfBirth(String dayOfBitrth) {
        this.dayOfBirth = dayOfBitrth;
        return this;
    }

    public RegisterData setMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
        return this;
    }

    public RegisterData setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    public RegisterData setFirstName2(String firstName2) {
        this.firstName2 = firstName2;
        return this;
    }

    public RegisterData setLasttName2(String lastName2) {
        this.lastName2 = lastName2;
        return this;
    }

    public RegisterData setCompany(String company) {
        this.company = company;
        return this;
    }

    public RegisterData setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public RegisterData setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public RegisterData setCity(String city) {
        this.city = city;
        return this;
    }

    public RegisterData setState(String state) {
        this.state = state;
        return this;
    }

    public RegisterData setCountry(String country) {
        this.country = country;
        return this;
    }

    public RegisterData setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public RegisterData setAddInfo(String addInfo) {
        this.additionInformation = addInfo;
        return this;
    }

    public RegisterData setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public RegisterData setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public RegisterData setAliasAddress(String aliasAddress) {
        this.aliasAddress = aliasAddress;
        return this;
    }

    public RegisterData setCheckbox1(Boolean checkbox1) {
        this.checkbox1 = checkbox1;
        return this;
    }

    public RegisterData setCheckbox2(Boolean checkbox2) {
        this.checkbox2 = checkbox2;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName1() {
        return firstName1;
    }

    public String getLastName1() {
        return lastName1;
    }

    public String getPassword() {
        return password;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getFirstName2() {
        return firstName2;
    }

    public String getLastName2() {
        return lastName2;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public String getAdditionInformation() {
        return additionInformation;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getAliasAddress() {
        return aliasAddress;
    }

    public Boolean getCheckbox1() {
        return checkbox1;
    }

    public Boolean getCheckbox2() {
        return checkbox2;
    }

}
