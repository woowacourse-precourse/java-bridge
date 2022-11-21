package bridge;

/**
 * 예외를 처리해주는 클래스
 */
public class Exeption {

    /**
     * 다리 길이를 입력 받을 때 예외처리 모음
     * @param : 입력받는 다리 길이
     * @return : 예외처리 true or false
     */
    public boolean inputBridgeSizeCheck(String number){
        try {
            if(isDigit(number) && isRightRange(number) ) {
                return true;
            }
        }catch (IllegalArgumentException e) {
            return false;
        }
        return false;
    }

    /**
     * 숫자가 아닐 때
     * @param number : 다리길이
     * @return : 예외처리 true or exeption
     * @exception IllegalArgumentException
     */
    public boolean isDigit(String number) throws IllegalArgumentException{
        try{
            Integer.parseInt(number);
        }catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : 숫자를 입력해주세요 ");
        }
        return true;
    }
    /**
     * 3과 20 사이가 아닐 때
     * @param number : 다리길이
     * @return : 예외처리 true or exeption
     * @exception IllegalArgumentException
     */
    public boolean isRightRange(String number) throws IllegalArgumentException{
        int numCheck = Integer.parseInt(number);
        if(!(numCheck >= 3 && numCheck <=20)) {
            System.out.println("[ERROR] : 올바른 숫자 범위를 입력해주세요");
            throw new IllegalArgumentException();
        }
        return true;
    }


}
