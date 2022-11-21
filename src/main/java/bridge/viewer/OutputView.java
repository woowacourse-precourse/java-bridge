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
    public static final String OPEN = "[";
    public static final String CLOSE = "]";
    public static final String SEPARATOR = "|";

    public static void printMap(PositionTable userTable) {
        showMap(userTable, Position::isUp);
        showMap(userTable, Position::isDown);
    }

    public static void printResult(PositionTable userTable, Result result) {
        if (result.isLose()) {
            showReviseMap(userTable, Position::isUp);
            showReviseMap(userTable, Position::isDown);
        }
        if (result.isWin()) {
            showMap(userTable, Position::isUp);
            showMap(userTable, Position::isDown);
        }

    }

    private static void showMap(PositionTable userTable, Predicate<Position> p) {
        System.out.println(OPEN+String.join(SEPARATOR,draw(userTable, p))+CLOSE);
    }
    private static void showReviseMap(PositionTable userTable, Predicate<Position> p) {
        System.out.println(OPEN+String.join(SEPARATOR,replace(draw(userTable, p)))+CLOSE);
    }

    private static List<String> replace(List<String> bridge) {
        int lastIndex = bridge.size()-1;
        if (bridge.get(lastIndex).equals(PASS)) {
            bridge.remove(lastIndex);
            bridge.add(FAIL);
        }
        return bridge;
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
