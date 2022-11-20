package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> firstLayer, List<String> secondLayer) {
        List<String> bridgeFirstLayer = makeTotalBridge(firstLayer);
        List<String> bridgeSecondLayer = makeTotalBridge(secondLayer);

        for (int i=0; i<bridgeFirstLayer.size(); i++) {
            System.out.print(bridgeFirstLayer.get(i));
        }

        System.out.println();
        for (int i=0; i<bridgeSecondLayer.size(); i++) {
            System.out.print(bridgeSecondLayer.get(i));
        }
    }

    public List<String> makeTotalBridge(List<String> layer) {
        List<String> output = new ArrayList<>();
        output.add(OutputMessage.OUTPUT_BRIDGE_HEAD.get());
        for (int i=0; i<layer.size()-1; i++) {
            output.add(layer.get(i) + OutputMessage.OUTPUT_BRIDGE_MIDDLE.get());
        }
        output.add(layer.get(layer.size()-1));
        output.add(OutputMessage.OUTPUT_BRIDGE_TAIL.get());

        return output;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> layers, int success, int trial) {
        System.out.println(OutputMessage.OUTPUT_TOTAL.get());
        printMap(layers.get(0), layers.get(1));
        if (success == 0) {
            System.out.println(OutputMessage.OUTPUT_RESULT.get() + OutputMessage.OUTPUT_FAILURE.get());
        }
        if (success == 1) {
            System.out.println(OutputMessage.OUTPUT_RESULT.get() + OutputMessage.OUTPUT_SUCCESS.get());
        }
        System.out.println(OutputMessage.OUTPUT_TRIAL.get() + trial);
    }
}

enum OutputMessage {

    OUTPUT_BRIDGE_HEAD("["),
    OUTPUT_BRIDGE_TAIL("]"),
    OUTPUT_BRIDGE_MIDDLE("|"),

    OUTPUT_SUCCESS("성공"),
    OUTPUT_FAILURE("실패"),

    OUTPUT_TOTAL("\n최종 게임 결과"),
    OUTPUT_RESULT("\n게임 성공 여부: "),
    OUTPUT_TRIAL("총 시도한 횟수: ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}