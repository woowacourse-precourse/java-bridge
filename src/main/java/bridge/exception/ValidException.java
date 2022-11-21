package bridge.exception;

import bridge.constant.ErrorMessage;
import bridge.constant.GameInInformation;

import java.util.NoSuchElementException;

public class ValidException {
    public void validInteger(String inputString){
        try{
            Integer.parseInt(inputString);
        } catch (NumberFormatException e){
            System.out.println(ErrorMessage.ERROR_MESSAGE + ErrorMessage.INPUT_INTEGER);
            throw new NoSuchElementException();
        }
        catch (NoSuchElementException e){
            System.out.println(ErrorMessage.ERROR_MESSAGE + ErrorMessage.INPUT_INTEGER);
            throw new IllegalArgumentException();
        }
    }

    public void validIntegerRange(int length){
        if(!(3 <= length && length <= 20)){
            System.out.println(ErrorMessage.ERROR_MESSAGE + ErrorMessage.INPUT_VALID_RANGE);
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
            System.out.println(ErrorMessage.ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void validMoveStringType(String next){
        if(!next.equals(GameInInformation.UP) && !next.equals(GameInInformation.DOWN)) {
            System.out.println(ErrorMessage.ERROR_MESSAGE + ErrorMessage.INPUT_NEXT_POSITION);
            throw new IllegalArgumentException();
        }
    }

    private void validOrderType(String order){
        if(order.equals(GameInInformation.RESTART)) return;
        if(order.equals(GameInInformation.QUIT)) return;
        System.out.println(ErrorMessage.ERROR_MESSAGE + ErrorMessage.INPUT_NEXT_GAME_MODE);
        throw new IllegalArgumentException();
    }
}
