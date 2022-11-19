package bridge.view;

import bridge.domain.CurrentBridge;

import java.util.List;

import static bridge.constant.Constant.*;

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

    public void printResult(CurrentBridge currentBridge, boolean successGame, int trialCount) {
        System.out.println("최종 게임 결과");
        printMap(currentBridge);
        if (successGame)
            System.out.println("게임 성공 여부: 성공");
        if (!successGame)
            System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + trialCount);
    }
}
