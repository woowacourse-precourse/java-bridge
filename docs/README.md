## 🚀 구현할 기능
---

## BridgeGame

- [ ] 칸을 이동할 때 사용하는 메소드: move()
- [ ] 게임을 다시 시작할 때 사용하는 메소드: retry()

## BridgeMaker

- [ ] 다리의 길이를 입력 받아 리스트를 리턴하는 메소드: makeBridge()

## BridgeRandomNumberGenerator

- [ ] 랜덤으로 0 또는 1을 반환해주는 메소드: BridgeNumberGenerator 에서 상속 받은 generate()

## InputView
- [x] 다리의 길이를 입력받는 메소드: readBridgeSize()
- [ ] 사용자가 이동할 칸을 입력받는 메소드: readMoving()
- [ ] 사용자의 게임을 다시 시작 혹은 종료 여부를 묻는 메소드: readGameCommand()

## OutputView
- [ ] 현재까지 이동한 다리의 상태를 출력하는 메소드: printMap()
- [ ] 게임의 최종 결과를 출력하는 메소드: printResult()

## Validator
- [x] 다리의 길이가 3 ~ 20이 아닌 경우 유혀성 검사
- [x] 다리의 길이가 숫자가 아닌 경우 유효성 검사
    ```
    예외 발생할 경우들을 모아 놓은 객체 추후 구현내용을 추가할 예정

## ExceptionMessage
- [x] 다리의 길이가 형태에 맞지 않을 경우의 메시지
    ```
    예외 메세지들을 모아둔 Enum 추후 내용을 추가할 예정