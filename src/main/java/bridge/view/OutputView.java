package bridge.view;

import bridge.bridge.Bridge;
import bridge.config.BridgeStatus;
import bridge.config.GameResultStatus;
import bridge.game.Game;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import static bridge.config.BridgeStatus.DOWN;
import static bridge.config.BridgeStatus.UP;
import static bridge.config.GameResultStatus.*;
import static bridge.config.Message.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START = "[";
    private static final String DIVISION = "|";
    private static final String EMPTY = " ";
    private static final String END = "]";
    private static final int IDX_UP = 0;
    private static final int IDX_DOWN = 1;

    private String bridgeMap;
    private String[] splitMap;
    private boolean first;
    private int count;

    public OutputView() {
        this.bridgeMap = START + END + "\n" + START + END;
        this.splitMap = bridgeMap.split("\n");
        this.first = true;
        this.count = 0;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printGameResultMap(Bridge bridge) {
        System.out.println(GAME_RESULT);
        if (this.first) {
            splitMap = creatFirstMap(splitMap, bridge);
        }
        if (!this.first) {
            splitMap = createBridgeMap(splitMap, bridge);
        }
        bridgeMap = splitMap[IDX_UP] + "\n" + splitMap[IDX_DOWN];
        this.count++;
        System.out.println(bridgeMap);
    }

    private String[] creatFirstMap(String[] splitMap, Bridge bridge) {
        BridgeStatus status = bridge.getBridge().get(count);
        if (status == UP) {
            splitMap = createFirstUpMap(splitMap, bridge);
        }
        if (status == DOWN) {
            splitMap = createFirstDownMap(splitMap, bridge);
        }
        this.first = false;
        return splitMap;
    }

    private String[] createFirstUpMap(String[] splitMap, Bridge bridge) {
        GameResultStatus status = bridge.getGameResultStatuses().get(count);
        splitMap[IDX_UP] = START + status.getResult() + END;
        splitMap[IDX_DOWN] = START + EMPTY + END;
        return splitMap;
    }

    private String[] createFirstDownMap(String[] splitMap, Bridge bridge) {
        GameResultStatus status = bridge.getGameResultStatuses().get(count);
        splitMap[IDX_UP] = START + EMPTY + END;
        splitMap[IDX_DOWN] = START + status.getResult() + END;
        return splitMap;
    }


    private String[] createBridgeMap(String[] splitMap, Bridge bridge) {
        BridgeStatus status = bridge.getBridge().get(count);
        if (status == UP) {
            splitMap = createUpMap(splitMap, bridge);
        }
        if (status == DOWN) {
            splitMap = createDownMap(splitMap, bridge);
        }
        return splitMap;
    }

    private String[] createUpMap(String[] splitMap, Bridge bridge) {
        GameResultStatus status = bridge.getGameResultStatuses().get(count);
        splitMap[IDX_UP] = splitMap[IDX_UP].substring(0, splitMap[IDX_UP].length() - 1) + DIVISION + status.getResult() + END;
        splitMap[IDX_DOWN] = splitMap[IDX_UP].substring(0, splitMap[IDX_UP].length() - 1) + DIVISION + EMPTY + END;
        return splitMap;
    }

    private String[] createDownMap(String[] splitMap, Bridge bridge) {
        GameResultStatus status = bridge.getGameResultStatuses().get(count);
        splitMap[IDX_UP] = splitMap[IDX_UP].substring(0, splitMap[IDX_UP].length() - 1) + DIVISION + EMPTY + END;
        splitMap[IDX_DOWN] = splitMap[IDX_UP].substring(0, splitMap[IDX_UP].length() - 1) + DIVISION + status.getResult() + END;
        return splitMap;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printGameResultAndCount(Game game) {
        System.out.println(SUCCESS_OR_FAIL + game.getGameStatus());
        System.out.println(TOTAL_TRY_COUNT + game.getCount());
    }
}
