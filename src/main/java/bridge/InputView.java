package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.BRIDGE_LENTH_INPUT_MESSAGE);
        while(true){
            try{
                return Integer.parseInt(InputValidator.getValidateInput(InputType.BRIDGE));
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public String readMoving() {
        System.out.println(Message.BRIDGE_MOVE_INPUT_MESSAGE);
        while(true){
            try{
                return InputValidator.getValidateInput(InputType.MOVE);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public String readGameCommand() {
        System.out.println(Message.GAME_REPLAY_INPUT_MESSAGE);
        while(true){
            try{
                return InputValidator.getValidateInput(InputType.REPLAY);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
