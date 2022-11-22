package bridge;

import bridge.enums.GameCommand;
import bridge.enums.GameOver;
import bridge.enums.GameResult;
import bridge.enums.MovingDirection;
import bridge.io.InputView;
import bridge.io.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameHost {

    private final InputView inputView = new InputView();
    private final BridgeChecker bridgeChecker = new BridgeChecker();
    private final OutputView outputView = new OutputView(bridgeChecker);
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final BridgeGame bridgeGame = new BridgeGame();
    private int trial=1;
    private GameResult gameResult;

    private List<String> bridge;
    private List<String> userInput = new ArrayList<>();

    public void runGame() {
        startGame();

        while(true) {
            runOneStep();
            if(bridgeGame.verifyGameSuccess(bridgeChecker.checkBridgeMatching(bridge, userInput), gameResult)==true) {
                printRetrialComment();
                String gameCommand = inputView.readGameCommand();

                if(gameCommand.equals(GameCommand.Quit.getExpression())) {
                    gameResult = GameResult.FAILED;
                    break;
                }

                bridgeGame.retry(userInput);
                trial++;
            }

            if(bridgeGame.verifyGameOver(bridge, userInput)== GameOver.OVER) {
                gameResult = GameResult.SUCCESS;
                break;
            }

        }

        endGame();
    }

    public void startGame() {
        printStartingComment();
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);

        System.out.println(bridge);
    }

    public void printStartingComment() {
        System.out.println("다리 건너기 게임을 시작합니다." + System.lineSeparator());
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void runOneStep() {
        printGuideComment();
        String moving = inputView.readMoving();
        bridgeGame.move(userInput, moving);
        outputView.printMap(bridge, userInput);
    }

    public void endGame() {
        System.out.println("최종 게임 결과");
        outputView.printMap(bridge,userInput);
        outputView.printResult(trial, gameResult);
    }

    public void printGuideComment() {
        System.out.printf("이동할 칸을 선택해주세요. (위: %s, 아래: %s)" + System.lineSeparator(),
                MovingDirection.Upper.getDirection(), MovingDirection.Lower.getDirection());
    }

    public void printRetrialComment() {
        System.out.printf("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)" + System.lineSeparator(),
                GameCommand.Retrial.getExpression(), GameCommand.Quit.getExpression());
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserInput() {
        return userInput;
    }
}
