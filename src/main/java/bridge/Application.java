package bridge;


public class Application {

    public static void main(String[] args) {
        int count = 0;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        boolean result = true;
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        while(result){
            count++;
            InputView inputView = new InputView(bridgeMaker, count);
            result = inputView.playGame();
        }
    }

}
