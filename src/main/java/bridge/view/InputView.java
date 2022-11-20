package bridge.view;

import bridge.Env;
import bridge.Lang;
import bridge.util.Console;
import bridge.util.Validator;
import bridge.util.Parser;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String response = Console.readLine(Lang.get(Lang.INPUT_BRIDGE_SIZE));
        Validator.checkConsoleInputNumberInRange(
                List.of(Env.MIN_SIZE_OF_BRIDGE, Env.MAX_SIZE_OF_BRIDGE),
                response
        );

        return Parser.toIntFrom(response);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String response = this.getMovingResponse();
        Validator.checkConsoleCommandIsCorrect(
                List.of(Env.CODE_OF_UP, Env.CODE_OF_DOWN),
                response
        );

        return response;
    }

    private String getMovingResponse() {
        return Console.readLine(Lang.format(
                Lang.SELECT_SLAB,
                Env.CODE_OF_UP,
                Env.CODE_OF_DOWN
        ));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String response = this.getGameCommandResponse();
        Validator.checkConsoleCommandIsCorrect(
                List.of(Env.CODE_OF_RETRY, Env.CODE_OF_QUIT),
                response
        );

        return response;
    }

    private String getGameCommandResponse() {
        return Console.readLine(Lang.format(
                Lang.SELECT_RETRY_OR_QUIT,
                Env.CODE_OF_RETRY,
                Env.CODE_OF_QUIT
        ));
    }

}
