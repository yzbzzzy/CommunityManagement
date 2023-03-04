package cn.dsrank.communitymanagement.constant;

public class UserRoleConstants {
    private UserRoleConstants() {
        throw new IllegalStateException("Cannot create instance of static constant class");
    }

    public static final String ROLE_USER = "ROLE_USER";

    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    public static final String ROLE_SUPER_ADMIN = "ROLE_SUPER_ADMIN";
    public static final String ROLE_NO = "ROLE_NO";
    public static final String ROLE_RENTER="ROLE_RENTER";
    public static final String ROLE_LEASER="ROLE_LEASER";
}
