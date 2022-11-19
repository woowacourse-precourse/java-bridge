package bridge;

public class User {
    private String pathOfUpperBridge;
    private String pathOfLowerBridge;

    public User() {
        this.pathOfUpperBridge = "";
        this.pathOfLowerBridge = "";
    }

    public String getPathOfUpperBridge() {
        return pathOfUpperBridge;
    }

    public String getPathOfLowerBridge() {
        return pathOfLowerBridge;
    }

    public void addPathOfBridge(String direction, String result) {
        firstOrNot();
        if (direction.equals("U")) {
            this.pathOfUpperBridge += result;
            this.pathOfLowerBridge += " ";
        }
        if (direction.equals("D")) {
            this.pathOfUpperBridge += " ";
            this.pathOfLowerBridge += result;
        }
    }

    public boolean isFirst() {
        return this.pathOfUpperBridge.isEmpty();
    }

    public void firstOrNot() {
        if (isFirst()) {
            return;
        }
        pathOfUpperBridge += " | ";
        pathOfLowerBridge += " | ";
    }
}
