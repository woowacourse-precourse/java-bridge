package bridge.domain;

public enum ResultMap {
    DIRECTION_MAP(0),
    SIGN_MAP(1);


    final private int index;

    ResultMap(int index){
        this.index = index;
    }

    public int index(){
        return this.index;
    }
}
