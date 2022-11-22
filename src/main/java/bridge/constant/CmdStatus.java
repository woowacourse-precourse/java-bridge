package bridge.constant;

public enum CmdStatus {
    MoveUp("U"),
    MoveDown("D"),
    Start("R"),
    End("Q");

    private final String alpha;

    CmdStatus(String alpha){
        this.alpha = alpha;
    }

    public String getAlpha(){
        return this.alpha;
    }

    public static boolean moveValidation(String cmd) {
        if (MoveUp.alpha.equals(cmd)){
            return true;
        }
        return MoveDown.alpha.equals(cmd);
    }

    public static boolean reGameValidation(String cmd) {
        if (Start.alpha.equals(cmd)){
            return true;
        }
        return End.alpha.equals(cmd);
    }
}
