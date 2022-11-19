# 📚 기능목록

# ⌨️ 사용자 입력을 받는다. - `InputView`

- 다리길이 입력 #readBridgeSize
    - ⚠️ 숫자가 아니면 예외
    - ⚠️ 3 ~ 20 사이의 숫자가 아니면 예외
- 이동 방향 입력 #readMoving
    - ⚠️ U, D 값이 아니면 예외
- 게임 재시작 여부 입력 #readGameCommand
    - ⚠️ R, Q 값이 아니면 예외

## 🖥️ 게임 진행 상황과 결과를 출력한다. - `OutputView`

- 게임 시작 메시지 출력 #printInit
- 게임 진행상황을 출력 #printMap
- 게임 종료 후 결과 출력 #printResult

## 🕹️ 다리 건너기 게임을 진행한다. - `BridgeGame`

- 움직임을 수행한다. #move
- 게임을 재시작한다. #retry
- 진행 상태를 알려준다.
- 진행 횟수를 알려준다.

# 다리를 생성해준다. - `BridgeMaker`

- 다리를 생성한다. #makeBridge