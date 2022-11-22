package bridge;
/**
 * 예외처리를 위한 함수를 모아놓은 클래스    
 */
public class Exception{
    /**
     * 다리의 길이가 3 ~ 20 사이 숫자인지 확인하는 함수 
     */
    public void inputLenCheck(int num){
        if(num < 3 || num > 20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 다리를 건너는 명령어가 U 또는 D로 입력되는지 확인하는 함수
     */
    public void inputStringUpAndDownCheck(String upAndDown){
        if(!upAndDown.equals("U") && !upAndDown.equals("D")){
            throw new IllegalArgumentException("[ERROR] 움직이는 위치는 U 또는 D 으로만 동작합니다.");
        }
    }

    /**
     * 재도전 또는 종료가 R 또는 Q로 입력되는지 확인하는 함수
     */
    public void inputRetryCheck(String retry){
        if(!retry.equals("R") && !retry.equals("Q")){
            throw new IllegalArgumentException("[ERROR] 재시작 여부는 R 또는 Q로만 동작합니다.");
        }
    }

    /**
     * 입력되는 다리 길이가 숫자를 제외한 입력인지 확인하는 함수
     */
    public void inputStringCheck(String inputCheck){
        String compareString = "^[0-9]+$";
        if(!inputCheck.matches(compareString)){
            throw new IllegalArgumentException("[ERROR] 3 ~ 20사이 숫자만 입력해주세요.");
        }
    }
}
