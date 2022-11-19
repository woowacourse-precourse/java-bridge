package bridge.view.output;

import bridge.status.Direction;
import bridge.status.UserStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    public void printWelcomeMessage() {
        print(OutputMessage.WELCOME_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(UserStatus userStatus) {
        String upperMap = makeMap(userStatus, Direction.getUpTextSource());
        print(upperMap);

        String belowMap = makeMap(userStatus, Direction.getDownTextSource());
        print(belowMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(UserStatus userStatus) {
        print(OutputMessage.GAME_RESULT);
        printMap(userStatus);
    }

    private String makeMap(UserStatus userStatus, String directionToDraw) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int position = 0; position <= userStatus.getPosition(); position++) {
            sb.append(userStatus.getUserScoreByDirectionOrElseSpace(directionToDraw, position));
            sb.append("|");
        }

        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");

        return sb.toString();
    }

    private void print(String message) {
        System.out.println(message);
    }
}
