package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    enum Message {

        START("다리 건너기 게임을 시작합니다."),

        BRIDGE_MIDDLE("|"),

        CORRECT(" O "),
        INCORRECT(" X "),
        BLANK("   "),

        SUCCESS("성공"),
        FAILURE("실패"),

        TOTAL("최종 게임 결과"),
        RESULT("게임 성공 여부: "),
        COUNT("총 시도한 횟수: ");

        private final String out;

        Message(String out) {
            this.out = out;
        }

        public String get() {
            return out;
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge) {
        String layers = bridge.toString();
        layers = layers.replace(", ", Message.BRIDGE_MIDDLE.out);
        printUpMap(layers);
        printDownMap(layers);
        System.out.println();
    }


    public void printUpMap(String layers) {
        String convert_layers = layers;
        convert_layers = convert_layers.replace(BridgeGame.Move.UP_CORRECT.get(), Message.CORRECT.out);
        convert_layers = convert_layers.replace(BridgeGame.Move.UP_INCORRECT.get(), Message.INCORRECT.out);
        convert_layers = convert_layers.replace(BridgeGame.Move.DOWN_CORRECT.get(), Message.BLANK.out);
        convert_layers = convert_layers.replace(BridgeGame.Move.DOWN_INCORRECT.get(), Message.BLANK.out);
        System.out.println(convert_layers);
    }

    public void printDownMap(String layers) {
        String convert_layers = layers;
        convert_layers = convert_layers.replace(BridgeGame.Move.DOWN_CORRECT.get(), Message.CORRECT.out);
        convert_layers = convert_layers.replace(BridgeGame.Move.DOWN_INCORRECT.get(), Message.INCORRECT.out);
        convert_layers = convert_layers.replace(BridgeGame.Move.UP_CORRECT.get(), Message.BLANK.out);
        convert_layers = convert_layers.replace(BridgeGame.Move.UP_INCORRECT.get(), Message.BLANK.out);
        System.out.println(convert_layers);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, int count, String success) {
        System.out.println(Message.TOTAL.out);
        printMap(bridge);
        System.out.println(Message.RESULT.out + success);
        System.out.println(Message.COUNT.out + count);
    }

    public void printStart() {
        System.out.println(Message.START.out);
        System.out.println();
    }
}
