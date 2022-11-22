package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
enum Brackets {
    START("[ "),
    BLANK(" "),
    MATCH("O"),
    MISSMATCH("X"),
    MIDDLE(" | "),
    END(" ]");
    private final String symbol;

    Brackets(String symbol) {
        this.symbol = symbol;
    }
    public String getSymbol(){
        return symbol;
    }
}

public class OutputView {

    private static final String UP_SIDE = "U";
    private static final String DOWN_SIDE = "D";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int step, List<String> answer, List<String> submission) {
        printUpSideBridge(step, answer, submission);
        printDownSideBridge(step, answer, submission);
    }

    private void printUpSideBridge(int step, List<String> answer, List<String> submission) {
        System.out.println(Brackets.START.getSymbol());
        for (int rotation = 0; rotation < step + 1; rotation++) {
            String rotationAnswer = answer.get(rotation);
            String rotationSubmission = submission.get(rotation);
            if (rotation != 0) {
                System.out.println(Brackets.MIDDLE.getSymbol());
            }
            if (rotationSubmission.equals(UP_SIDE) && rotationSubmission.equals(rotationAnswer)) {
                System.out.println(Brackets.MATCH.getSymbol());
            }
            if (rotationSubmission.equals(UP_SIDE) && !rotationSubmission.equals(rotationAnswer)) {
                System.out.println(Brackets.MISSMATCH.getSymbol());
            }
            if (rotationSubmission.equals(DOWN_SIDE)) {
                System.out.println(Brackets.BLANK.getSymbol());
            }
        }
        System.out.println(Brackets.END.getSymbol());
    }
    private void printDownSideBridge(int step, List<String> answer, List<String> submission) {
            System.out.println(Brackets.START.getSymbol());
            for (int rotation = 0; rotation < step+1; rotation++) {
                String rotationAnswer = answer.get(rotation);
                String rotationSubmission = submission.get(rotation);
                if(rotation !=0){
                    System.out.println(Brackets.MIDDLE.getSymbol());
                }
                if(rotationSubmission.equals(DOWN_SIDE) && rotationSubmission.equals(rotationAnswer)) {
                    System.out.println(Brackets.MATCH.getSymbol());
                }
                if(rotationSubmission.equals(DOWN_SIDE) && !rotationSubmission.equals(rotationAnswer)) {
                    System.out.println(Brackets.MISSMATCH.getSymbol());
                }
                if (rotationSubmission.equals(UP_SIDE)) {
                    System.out.println(Brackets.BLANK.getSymbol());
                }
            }
            System.out.println(Brackets.END.getSymbol());
      }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println("최종 게임 결과");
    }
}
