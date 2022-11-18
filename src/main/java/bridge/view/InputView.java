package bridge.view;

import bridge.exception.ErrorMsg;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.GET_BRIDGE_LENGTH);
        return validated(Console.readLine(), 3, 20);
    }

    private int validated(String input, int min, int max) {
        List<String> allowed = new ArrayList<>();
        for (int i = min; i <= max; i++)
            allowed.add(Integer.toString(i));

        return Integer.parseInt(validated(input, allowed, ErrorMsg.WRONG_BRIDGE_SIZE));
    }

    public  <T> T loopInput(Supplier<T> function){
        while(true){
            try{
                return function.get();
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.CHOOSE_UP_OR_DOWN);
        return validated(Console.readLine(), List.of("U", "D"), ErrorMsg.NOT_ALLOWED_MOVEMENT);
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private String validated(String move, List<String> allowed, ErrorMsg msg){
        if (!allowed.contains(move)){
            throw new IllegalArgumentException(msg.toString());
        }
        return move;
    }
}
