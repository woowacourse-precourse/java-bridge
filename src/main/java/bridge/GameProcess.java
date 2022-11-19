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

    private User user;

    public GameProcess(BridgeGame bridgeGame, BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        user = new User();

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
            int userPosition = userMove(bridgeSize, bridge);

            // 실패시 재시작 여부
            gameStart = retryOrNot(bridgeSize, userPosition);
        }
    }

    private boolean retryOrNot(Integer bridgeSize, int userPosition) {
        user.setGameCleared(cleared(bridgeSize, userPosition));
        if (!user.getGameCleared()) {
            return bridgeGame.retry(inputView.readGameCommand(e-> outputView.printError(e.getMessage())));
        }
        return false;
    }

    private boolean cleared(Integer bridgeSize, Integer userPosition) {
        return userPosition == bridgeSize;
    }

    private int userMove(Integer bridgeSize, Bridge bridge) {
        int index = 0;

        String way;

        do {
            // 움직일 방향 입력
            way = inputView.readMoving((e)-> outputView.printError(e.getMessage()));
        } while (movable(index++, way, bridge) && index < bridgeSize );

        return index;
    }


    private boolean movable(int index, String way, Bridge bridge) {
        // 이동 가능한지 확인
        boolean moved = bridgeGame.move(index, way, bridge);
        // 이동 결과 출력
        outputView.printMap(bridge.getMap(), user, index, way);

        return moved;
    }
}
