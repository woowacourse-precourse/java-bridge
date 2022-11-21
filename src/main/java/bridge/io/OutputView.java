package bridge.io;

import java.util.List;

import static java.lang.String.join;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMessage(Message message) {
        System.out.println(message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> route) {
        route.forEach(this::printMapper);
    }

    private void printMapper(List<String> mapper) {
        System.out.printf(Message.ROUTE.toString(), join(Message.SPLIT.toString(), mapper));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> route, String result, int count) {
        System.out.println(Message.END);
        printMap(route);
        System.out.printf(Message.RESULT.toString(), result, count);
    }
}
