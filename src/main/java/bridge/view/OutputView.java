package bridge.view;

import bridge.domain.CurrentBridge;

import java.util.List;

import static bridge.constant.Constant.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(CurrentBridge currentBridge) {
        printSection(currentBridge.getUpperSection());
        printSection(currentBridge.getLowerSection());
    }

    private void printSection(List<String> section) {
        StringBuilder sb = new StringBuilder(LEFT_BRACKET);
        for (int i = 0; i < section.size(); i++) {
            sb.append(WHITE_SPACE).append(section.get(i)).append(WHITE_SPACE);
            if (i < section.size() - 1) {
                sb.append(VERTICAL_BAR);
            }
        }
        sb.append(RIGHT_BRACKET);
        System.out.println(sb);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
