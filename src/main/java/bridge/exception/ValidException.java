package bridge.exception;

import bridge.constant.ErrorMessage;
import bridge.constant.GameInInformation;

import java.util.NoSuchElementException;

public class ValidException {
    public boolean validInteger(String inputString){
        boolean isCan = false;
        try{
            Integer.parseInt(inputString);
            isCan = true;
        } catch (NumberFormatException e){
            System.out.println(ErrorMessage.ERROR_MESSAGE + ErrorMessage.INPUT_INTEGER);
            throw new NoSuchElementException();
        } catch (NoSuchElementException e){
            System.out.println(ErrorMessage.ERROR_MESSAGE + ErrorMessage.INPUT_INTEGER);
            throw new IllegalArgumentException();
        } finally {
            if(!isCan) return false;
            return true;
        }
    }

    public boolean validIntegerRange(int length){
        if(!(3 <= length && length <= 20)){
            System.out.println(ErrorMessage.ERROR_MESSAGE + ErrorMessage.INPUT_VALID_RANGE);
            return false;
        }
        return true;
    }

    public boolean validMoveNextStep(String next){
        boolean length = validStringLength(next);
        boolean type = validMoveStringType(next);
        if(length && type) return true;
        return false;
    }

    public boolean validOrder(String order){
        boolean length = validStringLength(order);
        boolean orderType = validOrderType(order);
        if(length && orderType) return true;
        return false;
    }

    private boolean validStringLength(String next){
        if(next.length() != 1){
            System.out.println(ErrorMessage.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validMoveStringType(String next){
        if(!next.equals(GameInInformation.UP) && !next.equals(GameInInformation.DOWN)) {
            System.out.println(ErrorMessage.ERROR_MESSAGE + ErrorMessage.INPUT_NEXT_POSITION);
            return false;
        }
        return true;
    }

    private boolean validOrderType(String order){
        if(!order.equals(GameInInformation.RESTART) && !order.equals(GameInInformation.QUIT)) {
            System.out.println(ErrorMessage.ERROR_MESSAGE + ErrorMessage.INPUT_NEXT_POSITION);
            return false;
        }
        return true;
    }
}
