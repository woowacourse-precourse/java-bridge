package bridge.domain.user;

public enum UserPath {
    CORRECT_PATH("O"),
    WRONG_PATH("X"),
    EMPTY_PATH(" ");

    private final String path;

    UserPath(String path) {
        this.path = path;
    }


    @Override
    public String toString() {
        return String.format("%s", this.path);
    }
}
