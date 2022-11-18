package bridge.view;

import bridge.domain.BridgeStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * 패키지 변경 가능
 * 메서드의 이름 변경 불가
 * 인자와 반환 타입은 필요에 따라 추가, 변경 가능
 * 값 출력을 위해 필요한 메서드 추가 가능
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeStatus bridgeStatus) {
        System.out.println(bridgeStatus.getMessage());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(Message.RESULT.msg);
    }

    public void printStart() {
        System.out.println(Message.START.msg + "\n");
    }

    public void printLengthInput() {
        System.out.println(Message.PUT_LENGTH.msg);
    }

    public void printMoveInput() {
        System.out.println(Message.PUT_MOVE.msg);
    }

    public void printRetry() {
        System.out.println(Message.RETRY.msg);
    }

    public void printComplete(boolean success) {
        if(success) {
            System.out.println(Message.COMPLETION.msg + "성공");
            return;
        }
        System.out.println(Message.COMPLETION.msg + "실패");
    }

    public void printTryCount(int tryCount) {
        System.out.println(Message.TRY_COUNT.msg + tryCount);
    }

    public void printLine() {
        System.out.println();
    }
}