package bridge;

import java.util.*;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public enum input {
        Bridge_Size("bridge_size",
                "다리의 길이를 입력해주세요.",
                "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.",
                List.of(IntStream.range(3, 21).toString())),
        Moving_Command("moving_command",
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[ERROR] U, D만 입력할 수 있습니다.",
                List.of("U", "D")),
        Game_Command("game_command",
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "[ERROR] R, Q만 입력할 수 있습니다.",
                List.of("R", "Q"));

        private final String input_type;
        private final String input_message;
        private final String error_message;
        private final List<String> right_input;

        input(String input_type, String input_message, String error_message, List<String> right_input) {
            this.input_type = input_type;
            this.input_message = input_message;
            this.error_message = error_message;
            this.right_input = right_input;
        }

        public static String inputMessageByInputType(String input_type){
            return Arrays.stream(values())
                    .filter(find -> find.input_type == input_type)
                    .findAny().get().input_message;
        }

        public static String errorMessageByInputType(String input_type) {
            return Arrays.stream(values())
                    .filter(find -> find.input_type == input_type)
                    .findAny().get().error_message;
        }

        public static Optional isRightInput(String input_type, String input_value){
            System.out.println(input.inputMessageByInputType(input_type));
            return Arrays.stream(values())
                    .filter(find -> find.input_type == input_type && find.right_input.contains(input_value))
                    .findAny();
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return Integer.valueOf(validateAndReturnInput("bridge_size"));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return validateAndReturnInput("moving_command");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return validateAndReturnInput("game_command");
    }

    private String validateAndReturnInput(String input_type){
        while(true){
            String input_value = readLine();
            Optional validateInput = input.isRightInput(input_type, input_value);
            if(validateInput.isPresent()){
               return input_value;
            }
            System.out.println(input.errorMessageByInputType(input_type));
        }
    }
}
