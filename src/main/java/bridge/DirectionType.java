package bridge;

public enum DirectionType {
    UP("U", 1),
    DOWN("D",0);

    private int num;
    private String str;

    DirectionType(String str, int num){
        this.str= str;
        this.num =num;
    }

    public int getNum(){
        return this.num;
    }
    public String getStr(){
        return this.str;
    }

    public static DirectionType findByNum (int num){
        for(DirectionType v : values()){
            if( v.getNum() == num) return v;
        }
        return null;
    }


}
