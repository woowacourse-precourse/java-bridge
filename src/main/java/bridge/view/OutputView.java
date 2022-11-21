package bridge;

import java.util.List;
import java.util.Stack;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String RESULT_GAME = "최종 게임 결과";
    private static final String SUCCESS = "성공";
    private static final String FAULURE = "실패";
    private static final String GAME_RESULT_SUCCESS_OR_FAILURE_MESSAGE = "게임 성공 여부: ";
    private static final String TOTAL_ATTEMP_MESSAGE = "총 시도한 횟수: ";
    private static final String BLANK = " ";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> line1, List<String> line2) {
        printLine1Middle(line1);
        printLine2Middle(line2);
    }

    private void printLine1Middle(List<String> line1){
        for(int i=0;i<line1.size();i++){
            if(i == line1.size()-1) {
                System.out.print(PaintingInformation.CLOSE_BRACKET);
                continue;
            }
            System.out.print(line1.get(i));
        }
        System.out.println();
    }

    private void printLine2Middle(List<String> line2){
        for(int i=0;i<line2.size();i++){
            if(i == line2.size()-1) {
                System.out.print(PaintingInformation.CLOSE_BRACKET);
                continue;
            }
            System.out.print(line2.get(i));
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> line1, List<String> line2) {
        System.out.println(RESULT_GAME);
        printInformation(line1, line2);
    }

    public void printInformation(List<String> line1, List<String> line2){
        for (String s : line1) {
            System.out.print(s + BLANK);
        }
        System.out.println();
        for (String s : line2) {
            System.out.print(s + BLANK);
        }
        System.out.println();
    }

    public void printSuccessResult(int attemp){
        System.out.println(GAME_RESULT_SUCCESS_OR_FAILURE_MESSAGE + SUCCESS);
        System.out.println(TOTAL_ATTEMP_MESSAGE + attemp);
    }

    public void printFailureResult(int attemp){
        System.out.println(GAME_RESULT_SUCCESS_OR_FAILURE_MESSAGE + FAULURE);
        System.out.println(TOTAL_ATTEMP_MESSAGE + attemp);
    }
}
