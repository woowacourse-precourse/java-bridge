package bridge.View;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String start = "다리 건너기 게임을 시작합니다.";
    private static final String end = "게임 성공 여부: ";
    private static final String count = "총 시도한 횟수: ";
    private static final String success = "성공";
    private static final String failure = "실패";

    public static void printStart(){
        System.out.println(start);
    }

    public static void printResult(int result, int count_try) {
        if (result == 1) {
            System.out.println(end + success);
            System.out.println(count + count_try);
            return;
        }
        System.out.println(end + failure);
        System.out.println(count + count_try);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static int printMap(String moving) {
        if (moving.equals("O")){
        map("O");
            return 2;
        }
        map("X");
        return 3;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
    }

    private static void map(String c){
        System.out.println("[ " + c +  " ] ");
    }
}
