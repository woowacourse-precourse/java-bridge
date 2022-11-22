# 다리건너기

## 기능 목록

- [X] 다리 길이를 숫자로 입력받을수 있다.
  - [X] 자동으로 생성할 다리 길이를 입력 받는다. `readBridgeSize()` 
  - 3 이상 20 이하의 숫자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다. `validatorRangNumber()`
  - 오직 숫자만 접근할수 있도록 처리한다. `validatorOnlyNumber()`
  - U, D를 제외한 문자열이 나오면 예외처리를 할수 있다. `validatorMoving()`
  - R, Q를 제외한 문자열이 나오면 예외처리를 할수 있다. `validatorRestartOREnd()`
- [X] 다리 길이를 입력하라는 출력문을 나타낼 수 있다 `makeBridge()`
- [X] 무작위 값을 판단하는 함수를 만들수 있다. BridegeMaker -> `direction()`
- [X] 건널 수 있는 U 와 D를 입력받을 수 있다. `readSearch()`
- [X] 플레이어는 이동할 U와 D를 입력해 이동할 수 있다. `directionUp()`, `directionDown()`
- [X] 다리를 만드는 함수의 기능을 만들수 있다. `spliceMoveStart()`, `spliceMoverEnd()`
- [X] O, X를 출력해 보여줄 수 있게 표시한다. `OXjudge()`
- [X] 다리의 형태를 line.separator 구분자를 이용해 나타낸다. BridgeGame -> `move()` 
- [X] 게임이 다 끝나면 종료 혹은 재시작 되는 함수를 나타낼수 있다. `readGameCommand()`
- [X] 재시작을 눌렀을 때 처음 다시 게임이 나오게 할수 있다. `retry()`
- [X] 시도횟수를 나타낼수 있다 `printResult()`
  - [X] 총 게임을 한 진행 횟수를 시도한 횟수에 담아 나타낼수 있다.
- [X] 0이면 D 혹은 1이 나오면 U가 나오는 함수를 만들수 있다. `direction()`