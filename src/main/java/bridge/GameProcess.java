package bridge;

import bridge.domain.Bridge;
import bridge.game.BridgeGame;
import bridge.domain.User;
import bridge.view.InputView;
import bridge.view.OutputView;


public class GameProcess {
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private InputView inputView;
    private OutputView outputView;

    public GameProcess(BridgeGame bridgeGame, BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        User user = new User();

        outputView.println("다리 건너기 게임을 시작합니다.");

        boolean gameStart = true;

        play(gameStart, user);

        outputView.printResult(user);
    }

    private void play(Boolean gameStart, User user) {
        //다리 길이 입력, 다리 생성
        Integer bridgeSize = inputView.readBridgeSize(e-> outputView.printError(e.getMessage()));
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));

        while (gameStart) {
            // 유저 정보 초기화
            user.startRound();

            // 사용자 최종 위치 계산
            int userPosition = userMove(bridgeSize, bridge, user);

            // 실패시 재시작 여부
            gameStart = bridgeGame.retry(bridgeSize, userPosition, user,
                    ()->inputView.readGameCommand(e-> outputView.printError(e.getMessage())));
        }
    }

    private int userMove(Integer bridgeSize, Bridge bridge, User user) {
        int index = 0;
        String way;

        do {
            // 움직일 방향 입력
            way = inputView.readMoving((e)-> outputView.printError(e.getMessage()));
        } while (movable(index++, way, bridge, user) && index < bridgeSize );

        return index;
    }


    private boolean movable(int index, String way, Bridge bridge, User user) {
        // 이동 가능한지 확인
        boolean moved = bridgeGame.move(index, way, bridge);
        // 이동 결과 출력
        outputView.printMap(bridge.getMap(), user, index, way);

        return moved;
    }
}
