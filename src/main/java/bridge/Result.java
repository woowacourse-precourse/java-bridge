package bridge;

public enum Result {
    SUCCESS("O"), FAIL("X"),;

    private String printSymbol;

    Result(String printSymbol) {
        this.printSymbol = printSymbol;
    }

    //메서드 이름 리팩토링.
    public String getPrintSymbol() {
        return printSymbol;
    }
}
