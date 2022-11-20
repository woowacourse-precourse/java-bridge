package bridge.exception;

import bridge.information.GameInInformation;

import java.util.NoSuchElementException;

public class ValidException {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INPUT_INTEGER = " 다리 길이는 정수형으로 입력되어야 합니다.";
    private static final String INPUT_VALID_RANGE = " 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INPUT_NEXT_POSITION = " 이동할 칸의 입력은 U 또는 D 입니다.";
    private static final String INPUT_NEXT_GAME_MODE = " 다음 게임을 위한 입력은 Q 또는 R 입니다.";
    public void validInteger(String inputString){
        try{
            Integer.parseInt(inputString);
        } catch (NumberFormatException e){
            System.out.println(ERROR_MESSAGE + INPUT_INTEGER);
            throw new NoSuchElementException();
        }
        catch (NoSuchElementException e){
            System.out.println(ERROR_MESSAGE + INPUT_INTEGER);
            throw new IllegalArgumentException();
        }
    }

    public void validIntegerRange(int length){
        if(!(3 <= length && length <= 20)){
            System.out.println(ERROR_MESSAGE + INPUT_VALID_RANGE);
            throw new IllegalArgumentException();
        }
    }

    public void validMoveNextStep(String next){
        validStringLength(next);
        validMoveStringType(next);
    }

    public void validOrder(String order){
        validStringLength(order);
        validOrderType(order);
    }

    private void validStringLength(String next){
        if(next.length() != 1){
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void validMoveStringType(String next){
        if(!next.equals(GameInInformation.UP) && !next.equals(GameInInformation.DOWN)) {
            System.out.println(ERROR_MESSAGE + INPUT_NEXT_POSITION);
            throw new IllegalArgumentException();
        }
    }

    private void validOrderType(String order){
        if(order.equals(GameInInformation.RESTART)) return;
        if(order.equals(GameInInformation.QUIT)) return;
        System.out.println(ERROR_MESSAGE + INPUT_NEXT_GAME_MODE);
        throw new IllegalArgumentException();
    }
}
