package bridge.enums;

public enum BridgeConstants {

    UPSIDE("U"),
    DOWNSIDE("D"),
    SUCCESS("성공"),
    FAIL("실패"),
    RETRY("R"),
    QUIT("Q"),
    CORRECT("O"),
    INCORRECT("X"),
    BLANK(" "),
    DIVIDE(" | "),
    BRACKET_OPEN("[ "),
    BRACKET_CLOSE(" ]");


    private final String value;

    BridgeConstants(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
