package bridge;

import bridge.domain.Bridge;
import bridge.game.BridgeGame;
import bridge.domain.User;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class GameProcess {
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private InputView inputView;
    private OutputView outputView;
    private Boolean clear = false;

    public GameProcess(BridgeGame bridgeGame, BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        User user = new User();

        //테이블 생성
        List<List<StringBuilder>> moveTable = new ArrayList<>();
        moveTable.add(new ArrayList<>());
        moveTable.add(new ArrayList<>());

        outputView.println("다리 건너기 게임을 시작합니다.");

        boolean gameStart = true;

        play(gameStart, user, moveTable);

        outputView.printResult(moveTable, user.getRetry(), clear);
    }

    private void play(Boolean gameStart, User user, List<List<StringBuilder>> moveTable) {
        //다리 길이 입력, 다리 생성
        Integer bridgeSize = inputView.readBridgeSize(e-> outputView.printError(e.getMessage()));
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));

        while (gameStart) {
            // 테이블 초기화
            moveTable.get(0).clear();
            moveTable.get(1).clear();

            // 사용자 최종 위치 계산
            int userPosition = userMove(bridgeSize, bridge, moveTable);

            // 실패시 재시작 여부
            gameStart = retryOrNot(bridgeSize, userPosition, user);
        }
    }

    private boolean retryOrNot(Integer bridgeSize, int userPosition, User user) {
        clear = cleared(bridgeSize, userPosition);
        if (!clear) {
            return bridgeGame.retry(inputView.readGameCommand(e-> outputView.printError(e.getMessage())), user);
        }
        return false;
    }

    private boolean cleared(Integer bridgeSize, Integer userPosition) {
        return userPosition == bridgeSize;
    }

    private int userMove(Integer bridgeSize, Bridge bridge, List<List<StringBuilder>> moveTable) {
        int index = 0;

        String way;

        do {
            // 움직일 방향 입력
            way = inputView.readMoving((e)-> outputView.printError(e.getMessage()));
        } while (movable(index++, way, bridge, moveTable) && index < bridgeSize );

        return index;
    }


    private boolean movable(int index, String way, Bridge bridge, List<List<StringBuilder>> moveTable) {
        // 이동 가능한지 확인
        boolean moved = bridgeGame.move(index, way, bridge);
        // 이동 결과 출력
        outputView.printMap(bridge.getTwoWays(), index, way, moveTable);

        return moved;
    }
}
