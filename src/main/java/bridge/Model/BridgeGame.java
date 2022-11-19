package bridge.Model;


import bridge.Utils.Validator.BridgeMoveValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String BLANK = " ";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String inputMove, String currentMove) {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        List<String> result = new ArrayList<>();
        int index = BridgeMoveValidator.compareMoveInputAndNextMove(inputMove, currentMove).getIndex();

        for (int i = 0; i < 2; i++) {
            if (index == i) {
                result.add(BridgeMoveValidator.compareMoveInputAndNextMove(inputMove, currentMove).getOorX());
            }
            result.add(BLANK);
        }
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
