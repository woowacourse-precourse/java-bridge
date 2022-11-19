package bridge;

import java.util.List;

public class Application {

    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        // 게임을 시작하는 문구 출력
        outputView.printStartGame();

        // 다리 길이 입력 받는 안내 문구 출력
        outputView.printInputBridgeLength();
        int bridgeSize;

        // 다리길이 입력받기 + 예외 시 추가적으로 계속 입력
        while (true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }

        // 다리 생성
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame.setBridge(bridge);

        while(true){
            bridgeGame = new BridgeGame();
            String direction;

            BridgeGame.setCountAttempt();
            // 이동이 성공했을 시에 계속 입력 받기
            while(true) {
                outputView.printInputMoveDirection();
                // 이동할 칸 입력 받기
                while(true) {
                    try {
                        direction = inputView.readMoving();
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e);
                    }
                }
                boolean isCorrect = bridgeGame.move(direction);
                outputView.printMap(bridgeGame);
                if(!isCorrect) {
                    String command;
                    while(true) {
                        try {
                            outputView.printInputRetryCommand();
                            command = inputView.readGameCommand();
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e);
                        }
                    }
                    if(command.equals("Q")){
                        outputView.printResult(bridgeGame);
                        return;
                    }

                    break;
                }

                if(bridgeGame.isFinish()) {
                    BridgeGame.result = "성공";
                    outputView.printResult(bridgeGame);
                    return;
                }

            }
        }
    }
}
