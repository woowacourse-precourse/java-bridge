package bridge;

import java.util.Objects;

public class ValidationCheck {
    public enum Exceptions{
        ONE("다리 길이는 3이상 20이하여야 합니다."),
        TWO("입력은 숫자이어야 합니다."),
        THREE("위로 이동하려면 U 아래로 이동하려면 D를 입력해 주세요."),
        FOUR("게임을 재시작 하려면 R, 종료하려면 Q를 입력해 주세요.");
        private final String message;
        Exceptions(String message) {
            this.message = message;
        }
        public String getMessage(){
            return message;
        }
    }

    public static boolean validateSizeType(String inputSize){
        for (int i = 0; i < inputSize.length(); i++){
            if (inputSize.charAt(i) < '0' || '9' < inputSize.charAt(i)){
                throw new IllegalArgumentException(Exceptions.TWO.getMessage());
            }
        }
        return true;
    }

    public static boolean validateSizeRange(int inputSize){
        if(inputSize < 3 || 20 < inputSize){
            throw new IllegalArgumentException(Exceptions.ONE.getMessage());
        }
        return true;
    }

    public static boolean validateMoveType(String inputMove){
        if(!inputMove.equals("U") && !inputMove.equals("D") ){
            throw new IllegalArgumentException(Exceptions.THREE.getMessage());
        }
        return true;
    }

    public static boolean validateCommandType(String inputCommand){
        if(!inputCommand.equals("R") && !inputCommand.equals("Q") ){
            throw new IllegalArgumentException(Exceptions.FOUR.getMessage());
        }
        return true;
    }
}
