package org.flyfishalex.enums;

/**
 * Created by arusov on 14.05.2015.
 */
public enum Role {
    ADMIN("ROLE_ADMIN"),
    MANAGER("ROLE_STAFF"),
    USER("ROLE_USER"),
    GUEST("ROLE_GUEST ");

    private final String role;

    private Role(final String role) {
        this.role = role;
    }

    public String getCode() {
        return role;
    }

    public static Role getRole(String role) {
        for (Role c : Role.values()) {
            if (c.role.equals(role)) {
                return c;
            }
        }
        return GUEST;
    }
}
