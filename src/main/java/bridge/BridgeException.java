package bridge;

public class BridgeException {

    //다리 길이 입력 예외 판별
    public int bridgeInput(int input) {
        int n = 0;
        try{
            n = input;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR]");
        }
        if(n>20 || n<3){
            throw new IllegalArgumentException("[ERROR]");
        }
        return n;
    }

    //사용자가 갈 방향 선택 예외 판별
    public void UserInput(String input){
        if(!(input.equals("U") || input.equals("D"))){
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
