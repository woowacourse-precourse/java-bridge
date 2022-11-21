package bridge;

/**
 * 예외를 처리해주는 클래스
 */
public class Exeption {

    //숫자가 아닐 때 {
    public boolean isDigit(String number) {
        try{
            Integer.parseInt(number);
        }catch (IllegalArgumentException e) {
            System.out.println(e + "[ERROR] : 숫자를 입력해 주세요.");
            return false;
        }
        return true;
    }


}
