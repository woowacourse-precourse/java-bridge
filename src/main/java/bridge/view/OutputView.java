package bridge.view;

import bridge.domain.GameResult;
import bridge.domain.Moving;
import bridge.domain.MovingResult;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String INIT_MAP = "[  ]";

    private static Map<String, StringBuilder> map;

    static {
        map = new LinkedHashMap<>();
        map.put(
                Moving.UP.direction(), new StringBuilder(INIT_MAP)
        );
        map.put(
                Moving.DOWN.direction(), new StringBuilder(INIT_MAP)
        );
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MovingResult moveResult) {
        for (String part : map.keySet()) {
            StringBuilder printer = map.get(part);
            insertSeparator(printer);
            printPart(part, printer, moveResult);
        }

        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult) {
        StringBuilder resultBuilder = new StringBuilder();

        resultBuilder.append("최종 게임 결과").append(LINE_SEPARATOR);
        for (StringBuilder printer : map.values()) {
            resultBuilder.append(printer.toString()).append(LINE_SEPARATOR);
        }
        resultBuilder.append(LINE_SEPARATOR);

        resultBuilder.append("게임 성공 여부: ").append(gameResult.getResult()).append(LINE_SEPARATOR);
        resultBuilder.append("총 시도한 횟수: ").append(gameResult.getTotalTry()).append(LINE_SEPARATOR);
        System.out.println(resultBuilder);
    }

    public void initMap() {
        for (String part : map.keySet()) {
            map.put(part, new StringBuilder(INIT_MAP));
        }
    }

    private void insertSeparator(StringBuilder printer) {
        int lastSpaceIndex = printer.lastIndexOf(" ");

        if (lastSpaceIndex != 2) {
            printer.insert(lastSpaceIndex, " | ");
        }
    }

    private void printPart(String part, StringBuilder printer, MovingResult movingResult) {
        int insertIndex = printer.lastIndexOf(" ");

        if (part.equals(movingResult.getMoving())) {
            printer.insert(insertIndex, movingResult.getResult());
            System.out.println(printer);
            return;
        }

        printer.insert(insertIndex, " ");
        System.out.println(printer);
    }

}
