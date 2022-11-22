package views;

import java.util.List;
import types.BridgeType;
import types.MoveResult;

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
        StringBuilder message = new StringBuilder();
        message.append(createUpperMessage(bridge, location, result));
        message.append(createDownMessage(bridge, location, result));
        cache = message.toString();
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

    private String createUpperMessage(List<BridgeType> bridge, int location, MoveResult result) {
        StringBuilder message = new StringBuilder("[");
        for (int i = 0; i < location; i++) {
            if (bridge.get(i) == BridgeType.U) {
                message.append(" O |");
                continue;
            }
            message.append("   |");
        }

        if (result == MoveResult.FAIL) {
            if (bridge.get(location) == BridgeType.U) {
                return message.append("   ]\n").toString();
            }
            return message.append(" X ]\n").toString();
        }

        if (result == MoveResult.PASS) {
            if (bridge.get(location) == BridgeType.U) {
                return message.append(" O ]\n").toString();
            }
            return message.append("   ]\n").toString();
        }

        throw new IllegalArgumentException("[ERROR] 허용되지 않은 출력이 발생했습니다");
    }

    private String createDownMessage(List<BridgeType> bridge, int location, MoveResult result) {
        StringBuilder message = new StringBuilder("[");
        for (int i = 0; i < location; i++) {
            if (bridge.get(i) == BridgeType.D) {
                message.append(" O |");
                continue;
            }
            message.append("   |");
        }

        if (result == MoveResult.FAIL) {
            if (bridge.get(location) == BridgeType.D) {
                return message.append("   ]\n").toString();
            }
            return message.append(" X ]\n").toString();
        }

        if (result == MoveResult.PASS) {
            if (bridge.get(location) == BridgeType.D) {
                return message.append(" O ]\n").toString();
            }
            return message.append("   ]\n").toString();
        }

        throw new IllegalArgumentException("[ERROR] 허용되지 않은 출력이 발생했습니다");
    }

}
