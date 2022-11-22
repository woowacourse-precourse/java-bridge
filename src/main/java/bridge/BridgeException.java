package bridge;

public class BridgeException {

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
}
