package bridge.view;

import bridge.domain.GameStatus;
import bridge.domain.User;
import java.util.List;

public class OutputView {

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
}
