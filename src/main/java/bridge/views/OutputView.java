package bridge.views;

import bridge.types.BridgeType;
import bridge.types.MoveResult;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private String cache;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<BridgeType> bridge, int location, MoveResult result) {
        Message message = new Message(bridge, location, result);
        StringBuilder messenger = new StringBuilder()
                .append(message.create(BridgeType.U))
                .append(message.create(BridgeType.D));
        cache = messenger.toString();
        print(cache);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        String result = "성공";
        if (cache.contains("X")) {
            result = "실패";
        }
        print("최종 게임 결과\n" + cache + "\n게임 성공 여부: " + result);
    }

    public void printStart() {
        print("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeRequest() {
        print("다리의 길이를 입력해주세요.");
    }

    public void printMoveTypeRequest() {
        print("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRestartRequest() {
        print("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printGameCount(int count) {
        print("총 시도한 횟수: " + count);
    }

    private void print(String message) {
        System.out.println(message);
    }

    private class Message {
        List<BridgeType> bridge;
        int location;
        MoveResult result;

        Message(List<BridgeType> bridge, int location, MoveResult result) {
            this.bridge = bridge;
            this.location = location;
            this.result = result;
        }

        public String create(BridgeType direction) {
            StringBuilder message = new StringBuilder(progress(direction));
            if (result == MoveResult.FAIL) {
                return message.append(fail(direction)).toString();
            }
            if (result == MoveResult.PASS) {
                return message.append(pass(direction)).toString();
            }

            throw new IllegalArgumentException("[ERROR] 허용되지 않은 출력이 발생했습니다");
        }

        private String progress(BridgeType target) {
            StringBuilder message = new StringBuilder("[");
            for (int i = 0; i < location; i++) {
                message.append(progressAdapter(bridge.get(i), target));
            }
            return message.toString();
        }

        private String fail(BridgeType target) {
            if (bridge.get(location) == target) {
                return "   ]\n";
            }
            return " X ]\n";
        }

        private String pass(BridgeType target) {
            if (bridge.get(location) == target) {
                return " O ]\n";
            }
            return "   ]\n";
        }

        private String progressAdapter(BridgeType current, BridgeType target) {
            if (current == target) {
                return " O |";
            }
            return "   |";
        }
    }
}