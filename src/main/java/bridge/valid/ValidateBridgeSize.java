package bridge;

public class ValidateBridgeSize {
    public int validateBridgeSize(String size){
        validate(size);
        return Integer.parseInt(size);
    }

    private void validate(String size){
        if(!validateConsistOfNumber(size)){
            throw new IllegalArgumentException("다리의 길이는 숫자를 입력해야합니다.");
        }
        if(validateOutOfRange(Integer.parseInt(size))){
            throw new IllegalArgumentException("다리의 길이는 3부터 20까지 입니다.");
        }
    }

    private boolean validateConsistOfNumber(String size){
        final String numbers="[0-9]+";
        if(size.matches(numbers)){
            return true;
        }
        return false;
    }

    private boolean validateOutOfRange(int size){
        if(size<3||size>20){
            return true;
        }
        return false;
    }
}
