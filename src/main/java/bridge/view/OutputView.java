package bridge.view;

import bridge.domain.GameResult;
import bridge.utils.constants.Comments;
import bridge.utils.constants.Commons;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResult gameResult) {
        String firstLine = getLine(Commons.INDEX_ZERO.getNumber(), gameResult);
        String secondLine = getLine(Commons.INDEX_ONE.getNumber(), gameResult);

        System.out.println(firstLine);
        System.out.println(secondLine);
        printLine();
    }

    private String getLine(int index, GameResult gameResult) {
        StringBuilder line = new StringBuilder(Comments.LEFT_BRACKET.getComment());
        for (String place : gameResult.getResult().get(index)) {
            line.append(getPlaceOutput(place));
        }
        line.deleteCharAt(line.length() - Commons.INDEX_ONE.getNumber());
        return line.append(Comments.RIGHT_BRACKET.getComment()).toString();
    }

    private String getPlaceOutput(String place) {
        return Comments.BLANK.getComment()
                + place
                + Comments.BLANK.getComment()
                + Comments.SEPARATOR.getComment();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult) {
        System.out.println(Comments.FINAL_GAME_RESULT.getComment());
        printMap(gameResult);

        System.out.println(getGameSuccessOrNot(gameResult));
        System.out.println(Comments.NUMBER_OF_ATTEMPTS.getComment() + gameResult.getAttempts());
    }

    public String getGameSuccessOrNot(GameResult gameResult) {
        if (gameResult.isGameFail()) {
            return Comments.GAME_SUCCESS_OR_NOT.getComment() + Comments.FAIL.getComment();
        }
        return Comments.GAME_SUCCESS_OR_NOT.getComment() + Comments.SUCCESS.getComment();
    }

    public void gameStart() {
        System.out.println(Comments.GAME_START.getComment());
    }

    public void chooseBridgeSize() {
        System.out.println(Comments.INPUT_BRIDGE_SIZE.getComment());
    }

    public void chooseMovePlace() {
        System.out.println(Comments.INPUT_MOVE_PLACE.getComment());
    }

    public void chooseGameRestart() {
        System.out.println(Comments.INPUT_GAME_RESTART.getComment());
    }

    public void printLine() {
        System.out.println();
    }
}
