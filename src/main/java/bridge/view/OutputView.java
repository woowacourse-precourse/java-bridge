package bridge.view;

import bridge.constants.ResultMessage;
import org.assertj.core.error.ShouldHaveToString;

import java.util.List;

import static bridge.constants.ResultMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    StringBuilder sb1;
    StringBuilder sb2;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> user, List<String> score) {
        sb1 = new StringBuilder();
        sb2 = new StringBuilder();

        makeResult(user, score);
        System.out.println(sb1);
        System.out.println(sb2);
    }

    public void makeUpper(int idx, List<String> score){
        sb1.append(String.format(" %s ", score.get(idx)));
        sb2.append("   ");

        if (idx != score.size() - 1) {
            sb1.append("|");
            sb2.append("|");
        }
    }

    public void makeLower(int idx, List<String> score) {
        sb2.append(String.format(" %s ", score.get(idx)));
        sb1.append("   ");

        if (idx != score.size() - 1) {
            sb1.append("|");
            sb2.append("|");
        }
    }

    public void makeMap(int idx, List<String> user, List<String> score) {
        if (user.get(idx).equals("U")) {
            makeUpper(idx, score);
            return;
        }
        makeLower(idx, score);
    }

    public void makeResult(List<String> user, List<String> score) {
        setResultStart();
        for (int idx = 0; idx < score.size(); idx++) {
            makeMap(idx, user, score);
        }
        setResultEnd();
    }

    public void setResultStart() {
        sb1.append("[");
        sb2.append("[");
    }

    public void setResultEnd() {
        sb1.append("]");
        sb2.append("]");
    }




    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String gameResult, int count) {
        System.out.println(FINAL_RESULT);
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(GAME_RESULT+gameResult);
        System.out.print(GAME_COUNT+count);
    }
}
