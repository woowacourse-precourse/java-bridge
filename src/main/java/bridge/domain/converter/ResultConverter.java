package bridge.domain.converter;

public class ResultConverter {

    /**
     * 건너는 것에 대한 성공/실패 여부에 따라<br/>
     * PlayerBoard 내 다리 상태에 입력할 기호를 반환한다.
     *
     * @param isCrossable {@link bridge.domain.calculator.BridgeCalculator#isCrossable(int, String)}
     * @return O/X 값 <strong>(String)</strong>
     * <br/>
     * @see bridge.domain.PlayerBoard#addResultOfBridge(String, String)
     */
    public String convertToMark(boolean isCrossable) {
        if (isCrossable) {
            return "O";
        }
        return "X";
    }

}
