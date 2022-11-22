package bridge.model;

public enum ExceptionCode {
     NOT_NUMBER("[ERROR] 숫자 외의 문자가 포함되어 있습니다."),
    OUT_OF_RANGE("[ERROR] 3 이상 20 이하의 숫자만 입력할 수 있습니다."),
    NOT_U_OR_D("[ERROR] U와 D 중 하나의 문자를 입력해주세요.");

     private String message;

     ExceptionCode(String message) {
         this.message = message;
     }

     public String getMessage() {
         return this.message;
     }
}
