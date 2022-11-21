package bridge;


public class Application {

    public static void main(String[] args) {
        int count = 0;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        boolean result = true;
        while(result){
            count++;
            InputView inputView = new InputView(bridgeMaker, count);
            result = inputView.playGame();
        }
    }

}
