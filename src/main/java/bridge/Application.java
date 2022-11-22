package bridge;

public class Application {

    public static void main(String[] args) {
        try{
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            BridgeGame game = new BridgeGame();

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
