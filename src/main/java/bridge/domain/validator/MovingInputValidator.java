package bridge.domain.validator;

import bridge.ui.InputView;
import bridge.util.Directions;
import bridge.util.Errors;

public class MovingInputValidator implements Validator {

    /**
     * 이동 방향 입력 값 통합 Validate 메서드
     * <p>
     *     <strong>호출 메서드</strong><br/>
     *     {@link #validateIsBlank(String)} <br/>
     *     {@link #validateIsInvalid(String)} <br/>
     *     {@link #validateIsUpperCase(String)} <br/>
     * </p>
     * @param inputValue
     * @see InputView#readMoving()
     */
    @Override
    public void validate(String inputValue) {
        validateIsBlank(inputValue);
        inputValue = inputValue.trim();
        validateIsInvalid(inputValue);
        validateIsUpperCase(inputValue);
    }

    /**
     * 이동 방향 입력 값이 공백인지 검사한다.
     *
     * @exception IllegalArgumentException (메세지) {@link Errors#IS_EMPTY}
     * @param inputValue <strong>(String)</strong>
     * @see #validate(String)
     */
    @Override
    public void validateIsBlank(String inputValue) {
        if (inputValue.isBlank()) {
            throw new IllegalArgumentException(Errors.IS_EMPTY.message());
        }
    }

    /**
     * 이동 방향 입력 값이 유효한 값인지 검사한다.
     * <p>
     *     <strong>대소문자 상관없이</strong> {@link bridge.util.Directions#UP} 혹은 {@link bridge.util.Directions#DOWN} 값과의 일치 여부
     * </p>
     *
     * @exception IllegalArgumentException (메세지) {@link Errors#INVALID_MOVE_VALUE}
     * @param inputValue <strong>(String)</strong>
     * @see #validate(String)
     */
    @Override
    public void validateIsInvalid(String inputValue) {
        if (!inputValue.matches("[uUdD]")) {
            throw new IllegalArgumentException(Errors.INVALID_MOVE_VALUE.message());
        }
    }

    /**
     * 재시도 여부 입력 값이 R 혹은 Q 값이 맞는지 검사한다.
     * <p>
     *     {@link bridge.util.Directions#UP} 혹은 {@link bridge.util.Directions#DOWN} 값과의 일치 여부
     * </p>
     *
     * @exception IllegalArgumentException (메세지) {@link Errors#NOT_UPPERCASE}
     * @param inputValue <strong>(String)</strong>
     * @see #validate(String)
     */
    public void validateIsUpperCase(String inputValue) {
        if (!(inputValue.equals(Directions.UP.getValue()) || inputValue.equals(Directions.DOWN.getValue()))) {
            throw new IllegalArgumentException(Errors.NOT_UPPERCASE.message());
        }
    }
}
