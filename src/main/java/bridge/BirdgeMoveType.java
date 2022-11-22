package bridge;

public enum BirdgeMoveType {

    upGoMovement("O",0),
    downGoMovement("O",1),
    upStopMovement("X",0),
    downStopMovement("X",1);

    private String code;
    private int index;

    BirdgeMoveType(String code, int index) {
        this.code = code;
        this.index = index;
    }

    public String getCode(){
        return code;
    };

    public int getIndex() {
        return index;
    }
}
