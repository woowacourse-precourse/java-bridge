package bridge.view;

import bridge.domain.User;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(User user) {
        System.out.println("[ "+String.join(" | ", user.getUpSpace())+" ]");
        System.out.println("[ "+String.join(" | ", user.getDownSpace())+" ]");
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(User user) {
        System.out.println("최종 게임 결과");
        System.out.println("총 시도한 횟수: " + user.getTryCount());
    }

    public static void printException(String message) {
        System.out.println(message);
    }

    public static void printRetry(){
        System.out.println("게임을 다시 시작하시겠습니까 ? 재시작 :R 종료 :Q");
    }

    public static void printSuccess() {
    }

    public static void printFail() {
    }
}
