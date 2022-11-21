package bridge;

import java.util.List;

/**
 * 값이 유효한지 확인하는 역할을 한다.
 */
public class ValidationChecker {
    /**
     * 숫자가 범위 내에 있는지 확인한다.
     */
    public void checkIntegerRange(int target, int start, int end) throws IllegalArgumentException{
        if(start<=target && target<=end){
            return;
        }
        throw new IllegalArgumentException();
    }

    /**
     * 입력 값이 숫자로 이루어져 있는지 확인한다.
     */
    public void checkInputIsInteger(String target){return;}

     /**
     * 입력 값이 특정 문자로 이루어져 있는지 확인한다.
     */
    public void checkInputIsSpecificString(String target, List<String> specificString){return;}


}
