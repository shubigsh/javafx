package application;

public class Customer {

	

private int cust_id;
private String user_name;
private String password;
private String f_name;
private String l_name;
private String mobile_no;
private String email;
private String street;
private String city;
private String country;
private String license_no;



public Customer(int cust_id, String user_name, String password, String f_name, String l_name,
                String mobile_no, String email, String street, String city, String country, String license_no) {
    this.cust_id = cust_id;
    this.user_name = user_name;
    this.password = password;
    this.f_name = f_name;
    this.l_name = l_name;
    this.mobile_no = mobile_no;
    this.email = email;
    this.street = street;
    this.city = city;
    this.country = country;
    this.license_no = license_no;
}



public int getCust_id() {
    return cust_id;
}
public String getPassword() {
    return password;
}

public String getF_name() {
    return f_name;
}


public String getUser_name() {
    return user_name;
}

public String getL_name() {
    return l_name;
}

public String getMobile_no() {
    return mobile_no;
}

public String getEmail() {
    return email;
}

public String getStreet() {
    return street;
}

public String getCity() {
    return city;
}

public String getCountry() {
    return country;
}

public String getLicense_no() {
    return license_no;
}

public void setCust_id(int cust_id) {
    this.cust_id = cust_id;
}

public void setUser_name(String user_name) {
    this.user_name = user_name;
}

public void setPassword(String password) {
    this.password = password;
}

public void setF_name(String f_name) {
    this.f_name = f_name;
}

public void setL_name(String l_name) {
    this.l_name = l_name;
}

public void setMobile_no(String mobile_no) {
    this.mobile_no = mobile_no;
}

public void setEmail(String email) {
    this.email = email;
}

public void setStreet(String street) {
    this.street = street;
}

public void setCity(String city) {
    this.city = city;
}

public void setCountry(String country) {
    this.country = country;
}

public void setLicense_no(String license_no) {
    this.license_no = license_no;
}

}