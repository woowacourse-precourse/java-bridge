package bridge.domain.user;

public class UserPath {

    private final Path upPath;
    private final Path downPath;

    public UserPath() {
        this.upPath = new Path();
        this.downPath = new Path();
    }

    @Override
    public String toString() {
        return String.format("%s%s", upPath, downPath);
    }
}
