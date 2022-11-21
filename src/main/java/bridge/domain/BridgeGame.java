package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.util.Constants.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private List<String> topMap;
    private List<String> bottomMap;
    private boolean playerQuit;
    private int tryCount;
    private int step;

    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator, int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
        topMap = new ArrayList<>();
        bottomMap = new ArrayList<>();
        playerQuit = false;
        tryCount = 1;
        step = 0;
    }

    /**
     * 게임을 성공했는지 확인한다.
     * @return 성공하면 true, 실패하면 false
     */
    public boolean isSuccess() {
        return bridge.size() == step;
    }

    /**
     * 사용자의 입력 또는 게임 성공에 의해 게임이 끝났는지 확인한다.
     * @return 끝나면 true, 그렇지 않으면 false
     */
    public boolean isEnd() {
        return isSuccess() || playerQuit;
    }

    /**
     * 사용자의 입력에 따라 칸을 이동한다.
     * @param playerDirection 사용자의 입력("U" 또는 "D")
     * @return 정답과 맞으면 움직일 수 있으므로 true, 그렇지 않으면 false
     */
    public boolean move(String playerDirection) {
        String answer = bridge.get(step);
        addHistoryToMap(answer, playerDirection);
        step++;
        return isSameDirection(answer, playerDirection);
    }

    /**
     * 히스토리를 map에 저장한다.
     * @param answer 컴퓨터가 만들어낸 실제 정답("U" 또는 "D")
     * @param playerDirection 사용자의 입력("U" 또는 "D")
     */
    private void addHistoryToMap(String answer, String playerDirection) {
        if (isSameDirection(answer, playerDirection)) {
            markToMap(playerDirection, O);
            return;
        }
        markToMap(playerDirection, X);
    }

    /**
     * map에 마킹한다.
     * @param playerDirection 사용자의 입력("U" 또는 "D")
     * @param marking map에 마킹할 표식("O" 또는 "X")
     */
    private void markToMap(String playerDirection, String marking) {
        if (playerDirection.equals(UP)) {
            addHistoryToEachMap(marking, BLANK);
            return;
        }
        addHistoryToEachMap(BLANK, marking);
    }

    /**
     * 위와 아래 map에 히스토리를 각각 저장한다.
     * @param top topMap에 저장할 문자열
     * @param bottom bottomMap에 저장할 문자열
     */
    private void addHistoryToEachMap(String top, String bottom) {
        topMap.add(top);
        bottomMap.add(bottom);
    }

    /**
     * 실제 정답과 사용자의 입력이 일치한지 확인한다.
     * @param answer 컴퓨터가 만들어낸 실제 정답("U" 또는 "D")
     * @param playerDirection 사용자의 입력("U" 또는 "D")
     * @return 같으면 true, 다르면 false
     */
    private boolean isSameDirection(String answer, String playerDirection) {
        return answer.equals(playerDirection);
    }

    /**
     * 사용자의 입력을 받아 게임을 다시 시도할지 결정한다.
     * @param gameCommand 사용자의 입력("R" 또는 "Q")
     * 사용자의 입력이 "R"이라면 정답을 제외한 모든 것을 초기화하고 시도 횟수를 기존에서 +1 한다.
     */
    public void retry(String gameCommand) {
        if (gameCommand.equals(RETRY)) {
            topMap = new ArrayList<>();
            bottomMap = new ArrayList<>();
            tryCount++;
            step = 0;
            return;
        }
        playerQuit = true;
    }

    /**
     * 총 시도 횟수를 가져온다.
     * @return 총 시도 횟수
     */
    public int getTryCount() {
        return tryCount;
    }

    /**
     * map을 가져온다.
     * @return 현재까지의 히스토리가 담긴 map
     */
    public List<List<String>> getMap() {
        return List.of(topMap, bottomMap);
    }
}
