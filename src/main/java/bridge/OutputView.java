package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private int gameTry = 1;


    public static void start() {
        System.out.println("다리 건너기 게임을 시작합니다");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요");
    }

    public void printChooseUpOrDown() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D");
    }

    public void printRetryOrQuit() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q");
    }

    public void printGameResult() {
        System.out.println("최종 게임 결과");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userInput, boolean passFail) {
        String[][] bridge = bridgeResult(userInput, passFail);
        System.out.println("[ " + String.join(" | ", bridge[0]) + " ]");
        System.out.println("[ " + String.join(" | ", bridge[1]) + " ]");
    }

    public String[][] bridgeResult(List<String> userInput, boolean passFail) {
        Map<String, Integer> upDownAndNumber = Map.of("U", 0, "D", 1);
        String[][] bridgeOutput = new String[userInput.size()][userInput.size()];
        for (int index = 0 ; index< userInput.size()-1 ; index++) {
            bridgeOutput[upDownAndNumber.get(userInput.get(index))][index] = "O";
            bridgeOutput[1-upDownAndNumber.get(userInput.get(index))][index] = " ";
        }
        if (passFail) {
            bridgeOutput[upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = "O";
            bridgeOutput[1-upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = " ";
            return bridgeOutput;
        }
        bridgeOutput[upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = "X";
        bridgeOutput[1-upDownAndNumber.get(userInput.get(userInput.size()-1))][userInput.size()-1] = " ";
        return bridgeOutput;
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> userInput, boolean passFail) {
        Map<Boolean, String> gameResult = Map.of(true, "성공", false, "실패");
        System.out.println("최종 게임 결과");
        String[][] bridge = bridgeResult(userInput, passFail);
        System.out.println("[ " + String.join(" | ", bridge[0]) + " ]");
        System.out.println("[ " + String.join(" | ", bridge[1]) + " ]");
        System.out.println("게임 성공 여부: " + gameResult.get(passFail));
        System.out.println("총 시도한 횟수: " + gameTry);
        gameTry++;
    }

    /**
     * 유저에게 받은 값과 생성된 다리의 index값을 비교하여 upperBridge와 lowerBridge에 값 추가
     * 만들어진 문자열을 바탕으로 출력할 예정
     */

}
