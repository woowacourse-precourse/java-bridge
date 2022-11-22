package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printInitialization() {
        System.out.println(OutputMessage.INITIALIZATION.get());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> layers) {
        List<String> bridgeFirstLayer = makeTotalBridge(layers.get(0));
        List<String> bridgeSecondLayer = makeTotalBridge(layers.get(1));

        printLayer(bridgeFirstLayer);
        System.out.println();
        printLayer(bridgeSecondLayer);
        System.out.println();
    }

    public void printLayer(List<String> layer) {
        for (String s : layer) {
            System.out.print(s);
        }
    }

    public List<String> makeTotalBridge(List<String> layer) {
        List<String> output = new ArrayList<>();

        output.add(OutputMessage.BRIDGE_HEAD.get());
        output.addAll(addMiddleLine(layer));
        output.add(layer.get(layer.size() - 1));
        output.add(OutputMessage.BRIDGE_TAIL.get());

        return output;
    }

    public List<String> addMiddleLine(List<String> layer) {
        List<String> output = new ArrayList<>();

        for (int i = 0; i < layer.size() - 1; i++) {
            output.add(layer.get(i) + OutputMessage.BRIDGE_MIDDLE.get());
        }

        return output;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> layers, String success, int trial) {
        System.out.println();
        System.out.println(OutputMessage.TOTAL.get());
        printMap(layers);
        System.out.println();
        System.out.println(OutputMessage.RESULT.get() + success);
        System.out.println(OutputMessage.TRIAL.get() + trial);
    }
}

enum OutputMessage {

    INITIALIZATION("다리 건너기 게임을 시작합니다.\n"),

    BRIDGE_HEAD("["),
    BRIDGE_TAIL("]"),
    BRIDGE_MIDDLE("|"),

    SUCCESS("성공"),
    FAILURE("실패"),

    TOTAL("최종 게임 결과"),
    RESULT("게임 성공 여부: "),
    TRIAL("총 시도한 횟수: "),

    ERROR("[ERROR]"),
    ERROR_BRIDGE_SIZE(" 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_NOT_MOVING_COMMAND(" 이동할 칸은 위 (U) 혹은 아래 (D)를 선택헤 주세요."),
    ERROR_LOWER_MOVING_COMMAND(" 이동할 칸은 위 (U) 혹은 아래 (D)를 대문자로 입력해 주세요."),
    ERROR_NOT_RETRY_COMMAND(" 재시도 (R) 혹은 종료 (Q)를 선택해 주세요."),
    ERROR_LOWER_RETRY_COMMAND(" 재시도 (R) 혹은 종료 (Q)를 대문자로 입력해 주세요.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}