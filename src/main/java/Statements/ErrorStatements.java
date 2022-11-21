package Statements;

public enum ErrorStatements {

    NOT_NUMBER_ERROR("[ERROR] 숫자가 아닙니다. 숫자를 입력해주세요."),
    NUMBER_RANGE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_FORMAT_ERROR("[ERROR] 유효하지 않은 형식입니다. 형식에 맞는 값을 입력해주세요."),
    EXIT_PROGRAM("프로그램을 종료합니다.");


    private final String warning;
    ErrorStatements(String warning) {this.warning = warning;}

    public String warned(){return warning;}
}
