package bridge;

public enum DirectionType {
    UP("U", 1),
    DOWN("D",0);

    private int num;
    private String  str;

    DirectionType(String str, int num){
        this.str= str;
        this.num =num;
    }
    public int findByStr(String str){
        return this.num;
    }
    public String findByNum(int num){
        return this.str;
    }
}
