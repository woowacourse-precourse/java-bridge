package bridge.view;

import bridge.domain.GameStatus;
import bridge.domain.User;
import java.util.List;

public class OutputView {

    private static final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String START = "다리 건너기 게임을 시작합니다.";
    private static final String SPACE_TO_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String WHETHER_TO_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public void printMap(User user) {
        System.out.printf("[ %s ]\n", bridgeToMap(user.topBridge));
        System.out.printf("[ %s ]\n", bridgeToMap(user.bottomBridge));
    }

    public void printResult(GameStatus gameStatus, User user) {
        System.out.println("최종 게임 결과");
        printMap(user);
        System.out.printf("게임 성공 여부: %s\n", gameStatus.gameResult);
        System.out.printf("총 시도한 횟수: %d", gameStatus.tryCount);
    }

    public String bridgeToMap(List<String> bridge) {
        String str = "";

        for (int i = 0; i < bridge.size()-1; i++) {
            str += bridge.get(i);
            str += " | ";
        }

        str += bridge.get(bridge.size() - 1);
        return str;
    }

    public void askBridgeSize() {
        System.out.println(BRIDGE_SIZE);
    }

    public void printStart() {
        System.out.println(START);
    }

    public void askSpaceToMove() {
        System.out.println(SPACE_TO_MOVE);
    }

    public void askWhetherToRetry() {
        System.out.println(WHETHER_TO_RETRY);
    }
}
