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
     * 유저가 이동할 칸을 입력받는다.
     * @param : 유저가 움직일 칸 (위 아래)
     * @return : 예외처리 true or false
     */
    public boolean inputUserMovingCheck(String input) {
        try {
            if(isUorD(input)) {
                return true;
            }
        }catch (IllegalArgumentException e) {
            return false;
        }
        return false;
    }
    /**
     * 유저가 게임을 종료할지 결정하는 입력 예외
     * @param : (재시도: R, 종료: Q)
     * @return : 예외처리 true or false
     */
    public boolean inputReGameCommandCheck(String input){
        try {
            if(isRorQ(input)) {
                return true;
            }
        }catch (IllegalArgumentException e) {
            System.out.println(e.getClass()+" [ERROR] : 문자를 잘못 입력하셨습니다");
            return false;
        }
        return false;
    }
    /**
     * R 과 Q가 아니면 예외 처리
     * @param : (재시도: R, 종료: Q)
     * @return : 예외처리 true or exeption
     * @exception IllegalArgumentException
     */
    public boolean isRorQ(String input) throws IllegalArgumentException{
        if(input.equals("R") || input.equals("Q")){
            return true;
        }

        throw new IllegalArgumentException();
    }
    /**
     * U 과 D가 아니면 예외 처리
     * @param : (위: U, 아래: D)
     * @return : 예외처리 true or exeption
     * @exception IllegalArgumentException
     */
    public boolean isUorD(String input) throws IllegalArgumentException{
        if(input.equals("U") || input.equals("D")){
            return true;
        }
        System.out.println("[ERROR] : 문자를 잘못 입력하셨습니다.");
        throw new IllegalArgumentException();
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
