package bridge;

public class ErrorCheck {
    // str이 숫자로 이루어져 있는 지 확인
    public static void isNumberCheck(String str){
        if(!str.matches("^\\d+$")){
            ErrorMessage.isNumberCheckErrorMessage();
        }
    }
    // 다리길이가 3-20 사이인지 확인
    public static void isbridgeLengthMinMaxCheck(int bridgeLength){
        if (bridgeLength < 3 || bridgeLength > 20) {
            ErrorMessage.lengthMinMaxErrorMessage();
        }
    }
    public static void isMoveUporDownCheck(String str){
        if(str.equals("U")||str.equals("D")){
            return;
        }
        ErrorMessage.isMoveUporDownCheckErrorMessage();
    }
    public static void isAnswerRorQCheck(String str){
        if(str.equals("R")||str.equals("Q")){
            return;
        }

        ErrorMessage.isAnswerRorQCheckErrorMessage();
    }
}
