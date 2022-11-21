package bridge.error;

public class ErrorHandler {
    final static String PREFIX = "[ERROR] ";
    public static void inputNumberException(){
        throw new IllegalArgumentException(PREFIX+"3-20 사이의 숫자를 입력해주세요");
    }
    public static void moveCommandException(){
        throw new IllegalArgumentException(PREFIX+"U,D만 입력해주세요");
    }
    public static void playerCommandException(){
        throw new IllegalArgumentException(PREFIX+"R,Q만 입력해주세요");
    }
}
