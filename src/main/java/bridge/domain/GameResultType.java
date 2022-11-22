package bridge.domain;

import java.util.Arrays;

public enum GameResultType {
    WIN_DOWN(true,true,"   "," O ","성공\n"),
    WIN_UP(true,false," O ","   ","성공\n"),
    LOSE_DOWN(false,true,"   "," X ","실패\n"),
    LOSE_UP(false,false," X ","   ","실패\n");
    private final boolean winLose;
    private final boolean upDown;
    private final String upString;
    private final String downString;
    private final String winLoseKr;

    GameResultType(boolean winLose,boolean upDown,String upString,String downString,String winLoseKr){
        this.downString = downString;
        this.upDown = upDown;
        this.upString = upString;
        this.winLose = winLose;
        this.winLoseKr = winLoseKr;
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
    public String getWinLoseKr(){
        return winLoseKr;
    }
    public static GameResultType getGameResultType(boolean winLose,boolean upDown){
        return Arrays.stream(GameResultType.values())
                .filter(gameResultType -> gameResultType.getWinLose() == winLose)
                .filter((gameResultType -> gameResultType.getUpDown() == upDown))
                .findFirst()
                .orElse(null);
    }
}
