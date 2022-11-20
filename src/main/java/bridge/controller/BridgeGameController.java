package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.GameStatus;
import bridge.domain.User;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private GameStatus gameStatus;
    private User user;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        gameStatus = new GameStatus();
        user = new User();
    }

    public void start() {
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeLength = inputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeLength));
        Bridge copyBridge = new Bridge(bridge.copyBridge());

        System.out.println("다리 건너기 게임을 시작합니다.");

        while (true) {
            //브릿지 복사본 만들기
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String moving = inputView.readMoving();
            boolean check = bridgeGame.move(user, copyBridge, moving);
            String retry = "R";
            outputView.printMap(user);

            if (!check) {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                retry = inputView.readGameCommand();

                if (retry.equals("R")) {
                    user.resetUser();
                    copyBridge = new Bridge(bridge.copyBridge());
                    gameStatus.tryCount += 1;
                }
            }

            if (retry.equals("Q")) {
                break;
            }

            if (copyBridge.getBridge().size() == 0) {
                gameStatus.gameResult = "성공";
                break;
            }
        }
        outputView.printResult(gameStatus, user);
    }
}