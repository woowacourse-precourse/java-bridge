package view;

import bridge.BridgeForm;
import controller.Message;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printMessage(Message message) {
        System.out.println(message);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printMap(Map<String, List<String>> result) {
        System.out.println(makeMap(result));
    }

    private StringBuilder makeMap(Map<String, List<String>> result) {
        StringBuilder map = new StringBuilder();
        map.append(Text.START_BRIDGE).append(String.join(Text.SEPARATOR, result.get(BridgeForm.UP.getDirection())));
        map.append(Text.END_BRIDGE).append("\n");
        map.append(Text.START_BRIDGE).append(String.join(Text.SEPARATOR, result.get(BridgeForm.DOWN.getDirection())));
        map.append(Text.END_BRIDGE);

        return map;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
