package bridge;

import bridge.Constants.Command;
import java.util.List;

public class Application {

    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView();
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 게임을 시작하는 문구 출력
        startGame();
        setBridge();
        playGame();

    }

    private static void startGame(){
        outputView.printStartGame();
    }

    private static void setBridge() {
        outputView.printInputBridgeLength();

        int bridgeSize = getBridgeSize();
        createBridge(bridgeSize);
    }

    private static int getBridgeSize() {
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
    private static void setGame(){
        bridgeGame = new BridgeGame();
        BridgeGame.setCountAttempt();
    }

    private static void playGame() {
        while(true){
            setGame();
            // 이동이 성공했을 시에 계속 입력 받기
            while(true) {
                // 이동할 칸 입력 받기
                outputView.printInputMoveDirection();
                String direction = getDirection();

                boolean isCorrect = bridgeGame.move(direction);
                outputView.printMap(bridgeGame);
                if(!isCorrect) {
                    outputView.printInputRetryCommand();
                    String command = getRetryCommand();
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

    private static String getDirection() {
        while(true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                outputView.printErrorState(e);
            }
        }
    }
    private static String getRetryCommand() {
        while(true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                outputView.printErrorState(e);
            }
        }
    }
}
