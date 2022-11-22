package view;

import exception.BridgeException;
import exception.GameRestartingException;
import exception.MovingException;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static message.GameMessage.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Bridge_Size.getMessage());
        BridgeException bridgeException = new BridgeException(readLine());
        return bridgeException.getBridgeSize();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Moving.getMessage());
        MovingException movingException = new MovingException(readLine());
        return movingException.getMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Restarting.getMessage());
        GameRestartingException gameRestartingException = new GameRestartingException(readLine());
        return gameRestartingException.getRestarting();
    }
}
