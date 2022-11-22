package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String upResult, String downResult) {
        System.out.printf("[ %c", upResult.charAt(0));
        for (int index = 1; index < upResult.length(); index++) {
            System.out.printf(" | %c", upResult.charAt(index));
        }
        System.out.println(" ]");
        System.out.printf("[ %c", downResult.charAt(0));
        for (int index = 1; index < downResult.length(); index++) {
            System.out.printf(" | %c", downResult.charAt(index));
        }
        System.out.println(" ]");
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String upResult, String downResult) {
        System.out.println("최종 게임 결과");
        printMap(upResult, downResult);
    }
}
