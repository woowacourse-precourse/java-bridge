package bridge.view;

import bridge.constant.ErrorMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * - Package 변경 가능
 * - Method 이름 변경 불가능
 * - Method 인자와 반환 타입 변경 가능
 * - 필요 method 추가 가능
 */
public class OutputView {

    public void printGuide(String guide) {
        System.out.println(guide);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String movementMap) {
        System.out.println(movementMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result) {
        System.out.println(result);
    }

    public void printError(Exception exception) {
        System.out.println(exception.getMessage());
        System.out.println(ErrorMessage.INPUT_AGAIN.message());
    }
}
