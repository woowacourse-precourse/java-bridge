package bridge.util;

public enum BridgeUtil {

    RESTART("R"),
    QUIT("Q"),
    UP("U"),
    DOWN("D"),
    SUCCESS("성공"),
    FAIL("실패"),
    RIGHT("O"),
    WRONG("X"),
    BLANK(" ");

    private final String value;

    BridgeUtil(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
