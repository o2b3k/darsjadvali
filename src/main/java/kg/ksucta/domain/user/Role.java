package kg.ksucta.domain.user;

public enum Role {
    ADMIN,
    HR,
    CUSTOMER;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
