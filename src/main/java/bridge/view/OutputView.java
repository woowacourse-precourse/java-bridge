package bridge.view;

import bridge.domain.User;
import bridge.status.CommentStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printRunGame() {
        System.out.println(CommentStatus.INPUT_COMMENT.getText());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(User user) {
        System.out.println("[ " + String.join(" | ", user.getUpSpace()) + " ]");
        System.out.println("[ " + String.join(" | ", user.getDownSpace()) + " ]");
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(User user) {
        System.out.println();
        System.out.println(CommentStatus.TOTAL_RESULT.getText());
        printMap(user);
        System.out.println();
    }

    public static void printException(String message) {
        System.out.println(message);
    }

    public static void printRetry() {
        System.out.println(CommentStatus.REPLAY_COMMENT.getText());
    }

    public static void printSuccess(User user) {
        System.out.println(CommentStatus.SUCCESS_COMMENT.getText());
        System.out.println(CommentStatus.TOTAL_TRY.getText() + user.getTryCount());

    }

    public static void printFail(User user) {
        System.out.println(CommentStatus.FAIL_COMMENT.getText());
        System.out.println(CommentStatus.TOTAL_TRY.getText() + user.getTryCount());
    }

    public static void printChooseOne() {
        System.out.println(CommentStatus.CHOOSE_BLOCK.getText());
    }

    public static void printWelcomeGame() {
        System.out.println(CommentStatus.WELCOME_COMMENT.getText());
        System.out.println();
    }
}
