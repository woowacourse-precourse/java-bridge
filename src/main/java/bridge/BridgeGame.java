package bridge;

import static bridge.BridgeGameController.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> BRIDGE_ANSWER;
    private List<String> playerList = new ArrayList<>();
    private Boolean success = false;
    private Integer tryCount = 0;
    private Integer moveCount = 0;

    BridgeGame(List<String> BRIDGE_ANSWER) {
        this.BRIDGE_ANSWER = BRIDGE_ANSWER;
    }

    public void Start() {
        Repeat();
        ShowFinalMap(playerList, BRIDGE_ANSWER);
        ShowFinalResult(success, tryCount);
    }

    public Boolean Repeat() {
        Boolean retry = true;
        while (retry) {
            Play();
            if (playerList.equals(BRIDGE_ANSWER)) {
                success = true;
                break; }
            retry = retry();
        }
        return retry;
    }

    public Boolean Play() {
        moveCount = 0;
        playerList.clear();
        success = false;
        Boolean repeat = true;
        while (repeat && (moveCount < BRIDGE_ANSWER.size())) { repeat = Proceed(); }
        tryCount ++;
        return true;
    }

    public Boolean Proceed() {
        String playerInput = RepeatReadMoving();
        return AnalyzeBridgeInput(playerInput);
    }

    public Boolean AnalyzeBridgeInput(String playerInput) {
        if (BRIDGE_ANSWER.get(moveCount).equals(playerInput))
        { move(playerInput);
            return true; }
        if (!BRIDGE_ANSWER.get(moveCount).equals(playerInput))
        { move(playerInput);
            return false; }
        return false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String playerInput) {
        playerList.add(playerInput);
        BridgeGameController.ShowResult(playerInput, playerList, BRIDGE_ANSWER);
        moveCount ++;
        return playerInput;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean retry() {
        return BridgeGameController.RepeatRetry();
    }

    public List<String> GetPlayerList() {
        return playerList;
    }

    public void SetPlayerList(List<String> list) {
        playerList = list;
    }

    public void SetMoveCount(int number) {
        moveCount = number;
    }

    public Boolean GetSuccess() {
        return success;
    }

    public int GetTryCount() {
        return tryCount;
    }

    public int GetMoveCount() {
        return moveCount;
    }
}