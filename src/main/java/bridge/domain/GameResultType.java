package bridge.domain;

import java.util.Arrays;

public enum GameResultType {
    WIN_DOWN(true,true,"   "," O "),
    WIN_UP(true,false," O ","   "),
    LOSE_DOWN(false,true,"   "," X "),
    LOSE_UP(false,false," X ","   ");
    private final boolean winLose;
    private final boolean upDown;
    private final String upString;
    private final String downString;

    GameResultType(boolean winLose,boolean upDown,String upString,String downString){
        this.downString = downString;
        this.upDown = upDown;
        this.upString = upString;
        this.winLose = winLose;
    }
        public boolean getWinLose(){
        return winLose;
    }
    public boolean getUpDown(){
        return upDown;
    }
    public String getUpString(){
        return upString;
    }
    public String getDownString(){
        return downString;
    }
    public static GameResultType getGameResultType(boolean winLose,boolean upDown){
        return Arrays.stream(GameResultType.values())
                .filter(gameResultType -> gameResultType.getWinLose() == winLose)
                .filter((gameResultType -> gameResultType.getUpDown() == upDown))
                .findFirst()
                .orElse(null);
    }
}
