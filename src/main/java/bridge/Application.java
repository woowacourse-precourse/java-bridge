package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();

        int size =inputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker maker = new BridgeMaker(bridgeRandomNumberGenerator);

        List<String> bridge = maker.makeBridge(size); // 다리 생성

        System.out.println(bridge);

        int num = 0;
        String moving = "O";

        int gameCount = 1;

        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        System.out.println("size"+bridge.size());
        while((moving.equals("O"))) {
            num++;
            System.out.println("num"+num);
            String move = inputView.readMoving();
            moving = bridgeGame.move(bridge.get(num), move);


            outputView.printMap(bridge.subList(0, num), move, moving);
            if(bridge.size() == num+1){
                break;

            }
            num++;
        }
        outputView.printResult("성공", gameCount);


    }

}
