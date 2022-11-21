package bridge;

public class GameProcess {
    private static final InputView inputView = new InputView();
    public static String size;
    public static int length;
    public static void gameStart(){
        try{
            size = inputView.readBridgeSize();
            length = Integer.parseInt(size);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력값이 잘못됨.");
        }
        if(length>20 || length<3){
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력범위가 잘못됨.");
        }
    }
}
