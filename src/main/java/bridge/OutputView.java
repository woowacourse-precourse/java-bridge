package bridge;

import java.util.List;

enum Brackets {
    START("[ "), BLANK(" "), MATCH("O"), MISMATCH("X"), MIDDLE(" | "), END(" ]");
    private final String symbol;

    Brackets(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String UP = "U";
    private static final String DOWN = "D";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int step, List<String> answer, List<String> submitted) {
        printUpperBridge(step,answer,submitted);
        printLowerBridge(step,answer,submitted);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
    public void printUpperBridge(int step, List<String> answer, List<String> submitted) {
        System.out.print(Brackets.START.getSymbol());
        for (int loop = 0; loop < step+1; loop++) {
            String loopAnswer=answer.get(loop);
            String loopSubmitted=submitted.get(loop);
            if(loop!=0){
                System.out.print(Brackets.MIDDLE.getSymbol());
            }
            if (loopSubmitted.equals(UP) && loopSubmitted.equals(loopAnswer)){
                System.out.print(Brackets.MATCH.getSymbol());
            }
            if (loopSubmitted.equals(UP) && !loopSubmitted.equals(loopAnswer)) {
                System.out.print(Brackets.MISMATCH.getSymbol());
            }
            if (loopSubmitted.equals(DOWN)) {
                System.out.print(Brackets.BLANK.getSymbol());
            }
        }
        System.out.println(Brackets.END.getSymbol());
    }
    public void printLowerBridge(int step, List<String> answer, List<String> submitted) {
        System.out.print(Brackets.START.getSymbol());
        for (int loop = 0; loop < step+1; loop++) {
            String loopAnswer=answer.get(loop);
            String loopSubmitted=submitted.get(loop);
            if(loop!=0){
                System.out.print(Brackets.MIDDLE.getSymbol());
            }
            if (loopSubmitted.equals(DOWN) && loopSubmitted.equals(loopAnswer)){
                System.out.print(Brackets.MATCH.getSymbol());
            }
            if (loopSubmitted.equals(DOWN) && !loopSubmitted.equals(loopAnswer)) {
                System.out.print(Brackets.MISMATCH.getSymbol());
            }
            if (loopSubmitted.equals(UP)) {
                System.out.print(Brackets.BLANK.getSymbol());
            }
        }
        System.out.println(Brackets.END.getSymbol());
    }
}
