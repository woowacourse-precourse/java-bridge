package bridge.domain;

public enum BridgeEnum {
    SUCCESS("성공"),
    FAILURE("실패"),
    MOVING("이동"),
    MOVE_SUCCESS("O"),
    MOVE_FAILURE("X");

    private String content;

    BridgeEnum(String content){
        this.content = content;
    }

    public String getValue(){
        return content;
    }
}
