## 기능 구현 목록

### BridgeGame

- run: 전체 프로그램을 구동하는 메서드
- move: 사용자가 칸을 이동할 때 사용하는 메서드
- retry: 사용자가 게임을 다시 시도할 때 사용하는 메서드

### BridgeMaker

- makeBridge: 다리의 길이를 입력 받아서 다리를 생성해주는 메서드

### BridgeNumberGenerator

- generate: 랜덤 숫자 추출 추상 메서드

### BridgeRandomNumberGenerator

- generate: 랜덤 숫자 추출 구현 메서드

### InputView

- readBridgeSize: 다리 길이를 입력받는 메서드
- readMoving: 사용자가 이동할 칸을 입력받는 메서드
- readGameCommand: 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는 메서드

### OutputView

- printStart: 게임 시작 알림 출력 메서드
- printInputLength: 다리 길이 입력 알림 출력 메서드
- printInputChooseCell: 칸 선택 알림 출력 메서드
- printMap: 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력하는 메서드
- printResult: 게임의 최종 결과를 정해진 형식에 맞춰 출력하는 메서드

### Validation

- validateBridgeSizeInput: 다리 길이 입력 유효성 검사 메서드
- validateMoving: 칸 선택 입력 유효성 검사 메서드
- validateGameCommand: 재시작 여부 입력 유효성 검사 메서드
- isNumeric: 입력이 숫자인지 판별하는 메서드
- isMovingCommand: 유효한 칸 선택 입력인지 판별하는 메서드
- isGameCommand: 유효한 재시작 입력인지 판별하는 메서드