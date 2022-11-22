package bridge;

import bridge.enums.GameCommand;
import bridge.enums.GameOver;
import bridge.enums.GameResult;
import bridge.enums.MovingDirection;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.mapper.GameCommandMapper;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameHost {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameHost(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    private GameProgress gameProgress = new GameProgress();
    private List<String> userInput = new ArrayList<>();
    private List<String> bridge = new ArrayList<>();

    public void runGame() {
        startGame();

        while(gameProgress.getGameOver() == GameOver.YET) {
            runOneStep();
            bridgeGame.verifyGameSuccess(bridge, userInput, gameProgress);
            judgeNextStep();
        }

        endGame();
    }

    public void startGame() {
        printStartingComment();

        int bridgeSize = inputView.readBridgeSizeUntilSuccess();
        bridge = bridgeGame.getBridgeMaker().makeBridge(bridgeSize);

        System.out.println(bridge);
    }

    public void printStartingComment() {
        System.out.println("다리 건너기 게임을 시작합니다." + System.lineSeparator());
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void runOneStep() {
        printGuideComment();
        String moving = inputView.readMovingSizeUntilSuccess();
        bridgeGame.move(userInput, moving);
        outputView.printMap(bridge, userInput);
    }

    public void judgeNextStep() {
        if(gameProgress.getGameResult()==GameResult.FAILED) {
            printRetrialComment();
            String gameCommand = inputView.readGameCommand();
            gameProgress.gameCommand = GameCommandMapper.getInstance().stringToGameCommand(gameCommand);

            if(gameProgress.gameCommand.equals(GameCommand.RETRIAL)) {
                bridgeGame.retry(userInput, gameProgress);
            }
        }
    }

    public void endGame() {
        System.out.println("최종 게임 결과");
        outputView.printMap(bridge,userInput);
        outputView.printResult(gameProgress);
    }

    public void printGuideComment() {
        System.out.printf("이동할 칸을 선택해주세요. (위: %s, 아래: %s)" + System.lineSeparator(),
                MovingDirection.UPPER.getDirection(), MovingDirection.LOWER.getDirection());
    }

    public void printRetrialComment() {
        System.out.printf("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)" + System.lineSeparator(),
                GameCommand.RETRIAL.getExpression(), GameCommand.QUIT.getExpression());
    }

    public List<String> getBridge() {
        return bridge;
    }

}
