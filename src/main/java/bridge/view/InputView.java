package bridge.view;

import bridge.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }


    public String readBridgeSize() {
        System.out.println(Message.INPUT_MESSAGE_BRIDGE_LENGTH);
        return Console.readLine();
    }

    public int readBridgeSizeUntilValidate(String bridgeLength, boolean flag){
        do{
            try{
                bridgeLength = readBridgeSize();
                inputValidator.validateBridgeLength(bridgeLength);
                flag = false;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while(flag);
        return Integer.parseInt(bridgeLength);
    }

    public String readMoving() {
        System.out.println(Message.INPUT_MESSAGE_MOVING);
        String movingLocation = Console.readLine();
        return movingLocation;
    }

    public String readMovingUntilValidate(String moving, boolean flag){
        do{
            try{
                moving = readMoving();
                inputValidator.validateMoving(moving);
                flag = false;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while(flag);
        return moving;
    }

    public String readGameCommand() {
        System.out.println(Message.INPUT_MESSAGE_GAME_COMMAND);
        String command = Console.readLine();
        return command;
    }

    public String readGameCommandUntilValidate(String command, boolean flag){
        do{
            try{
                command = readGameCommand();
                inputValidator.validateGameCommand(command);
                flag = false;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }while(flag);
        return command;
    }

}
