package bridge.model;

public enum ExceptionCode {
     NOT_NUMBER("[ERROR] 숫자 외의 문자가 포함되어 있습니다."),
    OUT_OF_RANGE("[ERROR] 3 이상 20 이하의 숫자만 입력할 수 있습니다.");

     private String message;

     ExceptionCode(String message) {
         this.message = message;
     }

     public String getMessage() {
         return this.message;
     }
}
