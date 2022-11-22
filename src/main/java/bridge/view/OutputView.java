package bridge.view;

import bridge.domain.Game;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String RIGHT = "O";
    private static final String WRONG = "X";
    private static final String SPACE = " ";
    private static final String DIVIDING_LINE = " | ";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String START = "[ ";
    private static final String END = " ]";

    private StringBuilder upView = new StringBuilder();
    private StringBuilder downView = new StringBuilder();


}
