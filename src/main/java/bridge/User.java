package bridge;

public class User {
    private String pathOfUpperBridge;
    private String pathOfLowerBridge;
    private int round;

    public User() {
        this.pathOfUpperBridge = "";
        this.pathOfLowerBridge = "";
        this.round = 0;
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
        plusRound();
    }

    public void firstOrNot() {
        if (round == 0) {
            return;
        }
        pathOfUpperBridge += " | ";
        pathOfLowerBridge += " | ";
    }

    public void plusRound() {
        this.round++;
    }

}
