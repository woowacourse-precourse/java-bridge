package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean move(List<String> bridge, int count) {
        List<String> posList = new ArrayList<>();

        try {
            moving(bridge, posList);
            outputView.printResult(true, posList, count);
        } catch (IllegalArgumentException e) {
            if (retry(posList, count)) {
                return true; // 반복o
            }
            return false; // 반복x
        }
        return false; // 반복x
    }

    private void moving(List<String> bridge, List<String> posList) {
        for (int i = 0; i < bridge.size(); i++) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String movingPos = inputView.readMoving();
            posList.add(movingPos);

            if (!(movingPos.equals(bridge.get(i)))) {
                throw new IllegalArgumentException();
            }
            outputView.printMap(posList, true);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Boolean retry(List<String> posList, int count) {
        outputView.printMap(posList, false);
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String s = inputView.readGameCommand();
        if (s.equals("Q")) {
            outputView.printResult(false, posList, count);
            return false;
        }
        return true;
    }
}
