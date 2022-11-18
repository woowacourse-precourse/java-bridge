package bridge.enums;

public enum IntEnum {
    BRIDGE_START(3),
    BRIDGE_LAST(20),
    UP_INT(1),
    DOWN_INT(0),
    RESET_STAGE(0),
    GAME_WIN(0),
    GAME_CONTINUE(1),
    GAME_LOSE(2);

    private final int num;
    private IntEnum(int num){
        this.num=num;
    }
    public int num(){
        return this.num;
    }
}
