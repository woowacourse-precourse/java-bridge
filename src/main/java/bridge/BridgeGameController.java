package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.FootrestLocation;
import bridge.domain.GameStatus;
import bridge.utils.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

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

        play();

        // 종료(1인 경우, 성공적인 로직은 바로 종료)
        this.outputView.printResult(game.getResult());
    }

    private void play() {
        GameStatus movingResult = moveUser();
        //결정하다 다음 행동을
        if (movingResult == GameStatus.FAIL) { // 게임에 실패한 경우
            try {
                determineWhatToDo();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
                determineWhatToDo();
            }
        }
    }

    private void replay() {
        game.retry();
        play();
    }
    private void determineWhatToDo() {
        String command = this.inputView.readGameCommand();
        if (command.equals("R")) {
            replay();
        }
        else if (command.equals("Q")) {
            this.outputView.printResult(game.getResult());
        } else {
            throw new IllegalArgumentException("R, Q 이외에는 입력할 수 없습니다");
        }
    }



    private GameStatus moveUser() {
        try {
            String command = inputView.readMoving();
            FootrestLocation footrestLocation = FootrestLocation.valueOfUsingUserInput(command);
            GameStatus movingResult = game.move(footrestLocation);

            // game에게 발자취를 꺼낸다
            System.out.println("movingResult is " + movingResult);
            if (movingResult == GameStatus.MOVE_SUCCESS) {
                return moveUser();
            }
            System.out.println("움직임의 결과는 1:성공/0:다음/-1:실패 -- " + movingResult);
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
