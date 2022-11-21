package view.output;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * <p>
 * 요구사항
 * 1. 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * 2. OutputView 의 패키지는 변경할 수 있다.
 * 3. OutputView 의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 4. 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {
    public void printStartMessage() {
        OutputMessage.START_MESSAGE.print();
    }

    public void printMap(String bridge) {
        System.out.println(bridge);
    }

    public void printResult(String bridge) {
        OutputMessage.END_MESSAGE.print();
        printMap(bridge);
    }

    public void printStatistic(int recursiveCount, String result) {
        OutputMessage.SUCCESS_OR_FAIL.print();
        System.out.print(result);
        OutputMessage.TOTAL_NUMBER.print();
        System.out.print(recursiveCount);
    }
}