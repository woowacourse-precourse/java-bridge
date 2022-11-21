package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.GameProgress;
import bridge.domain.GameResult;
import bridge.domain.Move;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printWelcome() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printGame(GameResult gameResult) {
        GameProgress nowProgress = gameResult.getProgress();
        if (nowProgress == GameProgress.PLAYING) {
            printMap(nowProgress, gameResult.getBridge());
        }
        if (nowProgress == GameProgress.SUCCESS || nowProgress == GameProgress.FAILURE) {
            System.out.println("최종 게임 결과");
            printMap(nowProgress, gameResult.getBridge());
            printResult(nowProgress, gameResult.getNumberOfAttempts());
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameProgress progress, Bridge bridge) {
        String firstRow = "";
        String secondRow = "";

        //TODO 길이를 줄이자! -> 이게 모두 한번씩 동일한 뭉탱이가 반복되니깐 그 뭉탱이(로우)를 한세트로 처리하게 하면 된다.
        for (String upDown : bridge.getBridge()) {
            if (upDown.equals(Move.UP.getDirection())) {
                firstRow += "O";
                secondRow += " ";
            }
            if (upDown.equals(Move.DOWN.getDirection())) {
                firstRow += " ";
                secondRow += "O";
            }
        }

        // 현재 상태가 실패인 경우, 마지막 글자를 X로 바꾸는 로직 필요
        if (progress == GameProgress.FAILURE) {
            if (firstRow.charAt(firstRow.length() - 1) == 'O') {
                firstRow = firstRow.substring(0, firstRow.length() - 1) + "X";
            }
            if (secondRow.charAt(secondRow.length() - 1) == 'O') {
                secondRow = secondRow.substring(0, secondRow.length() - 1) + "X";
            }
        }

        // 지정된 포맷으로 변환시켜주는 로직 필요
        firstRow = "[ " + String.join(" | ", firstRow.split("")) + " ]";
        secondRow = "[ " + String.join(" | ", secondRow.split("")) + " ]";

        // 정제된 결과를 출력한다.
        System.out.println(firstRow);
        System.out.println(secondRow);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameProgress progress, int attempt) {
        System.out.println("게임 성공 여부: " + progress.getProgress());
        System.out.println("총 시도한 횟수: " + attempt);
    }
}
