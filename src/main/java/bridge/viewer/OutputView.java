package bridge.viewer;

import bridge.domain.Position;
import bridge.domain.PositionTable;
import bridge.domain.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String RESULT_MESSAGE = "최종 게임 결과";
    public static final String WIN_MESSAGE = "게임 성공 여부: 성공";
    public static final String LOSE_MESSAGE = "게임 성공 여부: 실패";
    public static final String TRY_MESSAGE = "총 시도한 횟수: ";
    public static final String PASS = " O ";
    public static final String EMPTY = "   ";
    public static final String FAIL = " X ";

    public void printMap(PositionTable userTable) {
        System.out.println(String.join("|",draw(userTable, position -> position.isUp())));
        System.out.println(String.join("|",draw(userTable, position -> position.isDown())));
    }

    public void printResult(PositionTable userTable, Result result) {
        List<String> upBridge = draw(userTable, position -> position.isUp());
        List<String> downBridge = draw(userTable, position -> position.isDown());
        if (result.isLose()) {
            replace(upBridge);
            replace(downBridge);
        }
        System.out.println(String.join("|",draw(userTable, position -> position.isUp())));
        System.out.println(String.join("|",draw(userTable, position -> position.isDown())));
    }

    private void replace(List<String> bridge) {
        int lastIndex = bridge.size()-1;
        if (bridge.get(lastIndex).equals(PASS)) {
            bridge.remove(lastIndex);
            bridge.add(FAIL);
        }
    }

    private static List<String> draw(PositionTable userTable, Predicate<Position> p) {
        List<String> outMessage = new ArrayList<>();
        for (Position position : userTable.getTable()) {
            if (p.test(position)) {
                outMessage.add(PASS);
                continue;
            }
            outMessage.add(EMPTY);
        }
        return outMessage;
    }
}
