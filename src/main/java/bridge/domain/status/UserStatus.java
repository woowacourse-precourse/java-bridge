package bridge.domain.status;

public enum UserStatus {
    SUCCESS(),
    OUT();

    UserStatus() {
    }

    public boolean checkUserStatus(UserStatus userStatus) {
        return this.equals(userStatus);
    }
}
