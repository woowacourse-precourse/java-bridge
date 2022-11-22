package bridge;

public class MapArray {
    private String upBridge;
    private String downBridge;

    public MapArray(String upBridge, String downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
    }
    public void addMapO(String input){
        if(input.equals("U")){
            upBridge += "O";
            downBridge += " ";
            return;
        }
        if(input.equals("D")){
            upBridge +=" ";
            downBridge += "O";
        }
    }
    public void addMapX(String input){
        if(input.equals("U")){
            upBridge += "X";
            downBridge += " ";
            return;
        }
        if(input.equals("D")){
            upBridge +=" ";
            downBridge += "X";
        }
    }

    public String getUpBridge() {
        return upBridge;
    }

    public String getDownBridge() {
        return downBridge;
    }
}
