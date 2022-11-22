package bridge.exception;

public class DesignatedTypeException {
    private static final String BASIC_ERROR_MESSAGE = "[ERROR]";

    public static void allNumberCheck(String size) {
        for (char number : size.toCharArray()) {
            unitNumberCheck(number);
        }//for
    }// numberCheck

    private static void unitNumberCheck(char number) {
        if (57 < number || number < 47) {
            System.out.println(BASIC_ERROR_MESSAGE + " 다리의 길이를 숫자로 입력해주세요.");
            throw new IllegalArgumentException(BASIC_ERROR_MESSAGE + " 다리의 길이를 숫자로 입력해주세요.");
        }//if
    }//unitNumberCheck

    public static void UDCheck(String movement) {
        if (!(movement.equals("D") || movement.equals("U"))) {
            System.out.println(BASIC_ERROR_MESSAGE + " 지정된 문자를 입력해 주세요.");
            throw new IllegalArgumentException(BASIC_ERROR_MESSAGE + " 지정된 문자를 입력해 주세요.");
        }//if
    }// UDCheck

    public static void RQCheck(String movement) {
        if (!(movement.equals("R") || movement.equals("Q"))) {
            System.out.println(BASIC_ERROR_MESSAGE + " 지정된 문자를 입력해 주세요.");
            throw new IllegalArgumentException(BASIC_ERROR_MESSAGE + " 지정된 문자를 입력해 주세요.");
        }//if
    }// RQCheck
}//end class
