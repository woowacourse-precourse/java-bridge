package bridge;

import bridge.Constants.Command;
import java.util.List;

public class Application {

    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    private static BridgeGame bridgeGame;

    private static void startGame(){
        outputView.printStartGame();
    }

    private static int getBridgeSize() {
        int bridgeSize;
        // 다리길이 입력받기 + 예외 시 추가적으로 계속 입력
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                outputView.printErrorState(e);
            }
        }
    }
    private static void createBridge(int bridgeSize){
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame.setBridge(bridge);
    }
    private static void settingBridge() {
        // 다리 길이 입력 받는 안내 문구 출력
        outputView.printInputBridgeLength();
        int bridgeSize = getBridgeSize();
        // 다리 생성
        createBridge(bridgeSize);
    }
    private static void setGame(){
        bridgeGame = new BridgeGame();
        BridgeGame.setCountAttempt();
    }
    private static String getDirection() {
        while(true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                outputView.printErrorState(e);
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 게임을 시작하는 문구 출력
        startGame();
        settingBridge();

        while(true){
            setGame();
            // 이동이 성공했을 시에 계속 입력 받기
            while(true) {
                outputView.printInputMoveDirection();
                // 이동할 칸 입력 받기
                String direction = getDirection();

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
                            outputView.printErrorState(e);
                        }
                    }
                    if(command.equals(Command.QUIT)){
                        outputView.printResult(bridgeGame);
                        return;
                    }

                    break;
                }

                if(bridgeGame.isFinish()) {
                    BridgeGame.RESULT = "성공";
                    outputView.printResult(bridgeGame);
                    return;
                }

            }
        }
    }
}
