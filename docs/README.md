## 🚀 구현할 기능
---

## BridgeGame

- [x] 칸을 이동할 때 사용하는 메소드: move()
- [x] 게임을 다시 시작할 때 사용하는 메소드: retry()

## BridgeMaker

- [x] 다리를 리턴하는 메소드: makeBridge()

## BridgeRandomNumberGenerator

- [x] 랜덤으로 반환해주는 메소드: generate()

## InputView

- [x] 다리의 길이를 입력받는 메소드: readBridgeSize()
- [x] 사용자가 이동할 칸을 입력받는 메소드: readMoving()
- [x] 게임을 다시 시작 혹은 종료 메소드: readGameCommand()

## OutputView

- [x] 이동한 다리의 상태를 출력하는 메소드: printMap()
- [x] 게임의 최종 결과를 출력하는 메소드: printResult()

## Validator

- [x] 다리의 길이가 3 ~ 20이 아닌 경우 유효성 검사
- [x] 다리의 길이가 숫자가 아닌 경우 유효성 검사
- [x] 입력한 사이즈와 다리의 길이가 같은지 확인하는 검사
- [x] 생성된 다리가 U or D 만으로 생성된지 확인하는 검사
- [x] 입력된 이동 방향이 U or D인지 확인하는 검사
- [x] 게임 재시작 커멘드가 R or Q인지 확인하는 검사

## ExceptionMessage

- [x] 다리의 길이가 3 ~ 20이 아닌 경우 메시지
- [x] 다리의 길이가 숫자가 아닌 경우 메시지
- [x] 생성된 다리의 길이가 다를 경우 메시지
- [x] 생성된 다리의 내부가 다를 경우 메시지
- [x] 이동 방향이 잘못 입력된 경우 메시지
- [x] 게임 재시작 커멘드가 잘못 입력된 경우 메시지

## BridgeGameLauncher
- [x] 게임에 필요한 의존성을 주입 시켜줌
- [x] 게임 메소드
