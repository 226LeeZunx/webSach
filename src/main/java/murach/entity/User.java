package murach.entity;


public class User {
    private String id;
    private String userAccount;
    private String userPass;
    private String email;
    private String create_date;
    private String userFirstName;
    private String userLastName;
    private Boolean isMale;
    private String role;

    public User(String userAccount, String userPass, String email, String create_date, String userFirstName, String userLastName, Boolean isMale, String role) {
        this.userAccount = userAccount;
        this.userPass = userPass;
        this.email = email;
        this.create_date = create_date;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.isMale = isMale;
        this.role = role;
    }
    public User(String email,String userFirstName, String userLastName, Boolean isMale) {
        this.email = email;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.isMale = isMale;
    }
  
   

    public String getUserAccount() {
        return userAccount;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getEmail() {
        return email;
    }

    public String getCreate_date() {
        return create_date;
    }

    public String getUserFirstName() {
        return userFirstName;
    }
    

    public String getUserLastName() {
        return userLastName;
    }

    public Boolean getIsMale() {
        return isMale;
    }

    public String getRole() {
        return role;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setIsMale(Boolean isMale) {
        this.isMale = isMale;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
