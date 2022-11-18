package constants;

public enum ResultTable {
    PASS("성공", 1),
    FAIL("실패", -1);

    private String resultText;
    private int resultNumber;

    ResultTable(String resultText, int resultNumber) {
        this.resultText = resultText;
        this.resultNumber = resultNumber;
    }

    public String getResultText() {
        return resultText;
    }

    public int getResultNumber() {
        return resultNumber;
    }
}
