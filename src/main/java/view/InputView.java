package view;

import camp.nextstep.edu.missionutils.Console;
import game.GameAnnounce;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(GameAnnounce.start.getAnnouncement());
        String size = Console.readLine();
        Valid.isLengthValid(size);
        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(GameAnnounce.userMove.getAnnouncement());
        String moving = Console.readLine();
        Valid.isEnterValid(moving);
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(GameAnnounce.userRestart.getAnnouncement());
        String finish = Console.readLine();
        Valid.isEnterFinishValid(finish);
        return finish;
    }
}
