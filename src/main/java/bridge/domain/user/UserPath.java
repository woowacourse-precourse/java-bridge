package bridge.domain.user;

public class UserPath {

    private final Path upPath;
    private final Path downPath;

    public UserPath() {
        this.upPath = new Path();
        this.downPath = new Path();
    }

    public void addUserPath(boolean status, MoveType moveType) {
        if (moveType == MoveType.UP_TYPE) {
            upPath.addPath(status);
            downPath.addEmptyPath();
            return;
        }
        upPath.addEmptyPath();
        downPath.addPath(status);
    }

    public void clearUserPath() {
        upPath.clearPath();
        downPath.clearPath();
    }

    @Override
    public String toString() {
        return String.format("%s%s", upPath, downPath);
    }
}
