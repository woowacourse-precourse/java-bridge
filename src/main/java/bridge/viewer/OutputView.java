package bridge.viewer;

import com.sun.security.jgss.GSSUtil;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String startMessage = "다리 건너기 게임을 시작합니다.";
    private final String endMessage = "최종 게임 결과";
    private final String successMessage = "게임 성공 여부: 성공";
    private final String failureMessage = "게임 성공 여부: 실패";
    private final String numberOfTrialMessage = "총 시도한 횟수: ";

    public void printStart() {
        System.out.println(startMessage);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    //index => 현재까지 진행된 index
    public void printMap(char[][] map, int index) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++) {
            sb.append("[");
            for(int j = 0; j <= index; j++) sb.append(" " + map[i][j] + " |");
            sb.deleteCharAt(sb.length()-1);
            sb.append("]" + System.getProperty("line.separator"));
        }
        System.out.println(sb.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int numberOfTrials) {
        if(isSuccess) {
            System.out.println(successMessage);
            System.out.println(numberOfTrialMessage + numberOfTrials);
            return;
        }
        System.out.println(failureMessage);
        System.out.println(numberOfTrialMessage + numberOfTrials);
    }

    public void printEndMessage() {
        System.out.println(endMessage);
    }
}
