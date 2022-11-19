package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.FootrestLocation;
import bridge.utils.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    private BridgeGame game;
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGameController() {
        this.game = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public static BridgeGameController init() {
        return new BridgeGameController();
    }

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다"); // 위치 여기가 맞을까?
        Bridge bridge = this.makeBridge();
        game.saveBridge(bridge);
        Integer movingResult = moveUser();
        //결정하다 다음 행동을
        if (movingResult == -1) {
            determineWhatToDo();
        }
        // 종료(1인 경우, 성공적인 로직은 바로 종료)
        this.outputView.printResult();
    }

    private void determineWhatToDo() {
        String command = this.inputView.readGameCommand();
        if (command.equals('R')) {
            //발자취를 초기화하고
            Integer movingResult = moveUser();
            //결정하다 다음 행동을
            if (movingResult == -1) {
                determineWhatToDo();
            }
            this.outputView.printResult();
        }
        if (command.equals('Q')) {
            this.outputView.printResult();
        }
    }

    private Integer moveUser() {
        try {
            String command = inputView.readMoving();
            FootrestLocation footrestLocation = FootrestLocation.valueOfUsingUserInput(command);
            Integer movingResult = game.move(footrestLocation);
            // game에게 발자취를 꺼낸다
            System.out.println("movingResult is " + movingResult);
            if (movingResult == 0) {
                return moveUser();
            }
            return movingResult;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR: 아웃풋으로 옮기기]" + e.getMessage());
            return moveUser();
        }
    }

    private Bridge makeBridge() {
        try {
            Integer bridgeSize = inputView.readBridgeSize();
            return new Bridge(bridgeMaker.makeBridge(bridgeSize));
        } catch (IllegalArgumentException e ) {
            return makeBridge();
        }
    }
}
