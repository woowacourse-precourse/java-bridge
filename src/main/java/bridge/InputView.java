package bridge.View;
import bridge.Utils.Validator.GameCommandValidator;
import bridge.Utils.Validator.MovementValidator;
import camp.nextstep.edu.missionutils.Console;
import bridge.Utils.Validator.BridgeLengthValidator;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
    	printFirstLine(moveOutput);
        printSecondLine(moveOutput);
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
    	 String movement = Console.readLine();
    	 System.out.print("[ ");
         for (int i = 0; i < moveOutput.size(); i++) {
             if (i % 2 == 0) {
                 System.out.print(moveOutput.get(i));
                 if ((moveOutput.size() != 2) && ((i+2) != moveOutput.size())) {
                     System.out.print(" | ");
                 }
             }
         }
         System.out.println(" ]");
         return MovementValidator.movementValid(movement);

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
    	 String gameCommand = Console.readLine();
         gameCommand = GameCommandValidator.commandValid(gameCommand);
         System.out.print("[ ");
         for (int i = 0; i < moveOutput.size(); i++) {
             if (i % 2 == 1) {
                 System.out.print(moveOutput.get(i));
                 if ((moveOutput.size() != 2) && ((i+1) != moveOutput.size())) {
                     System.out.print(" | ");
                 }
             }
         }
         System.out.println(" ]");
         return gameCommand;
    }
}
