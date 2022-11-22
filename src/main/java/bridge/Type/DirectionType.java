package bridge.Type;

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
    public static DirectionType findByString (String str){
        for(DirectionType v : values()){
            if( v.getStr().equals(str)) return v;
        }
        return null;
    }

    public boolean equalDirection(String str){
        return str.equals(this.str);
    }

    public String mapMakeByDirection(String str, int mapType){
        if (!equalDirection(str) && DirectionType.findByString(str).getNum() != mapType)
            return " ";
        if (!equalDirection(str) && DirectionType.findByString(str).getNum() == mapType)
            return "X";
        if (equalDirection(str) && DirectionType.findByString(str).getNum() == mapType)
            return "O";
        if (equalDirection(str) && DirectionType.findByString(str).getNum() != mapType)
            return " ";
        return null;
    }

}
