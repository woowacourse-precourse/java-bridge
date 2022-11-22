package bridge.command;

public enum UserMove {
    UP("U"),
    DOWN("D");

    private String userMove;

    UserMove(String userMove) {
        this.userMove = userMove;
    }

    public String getUserMove() {
        return userMove;
    }


}
