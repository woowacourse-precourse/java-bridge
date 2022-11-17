## 기능 명세서

### 입력

- 다리 길이 입력받기
  - 0일 경우 아래 칸, 1인 경우 위 칸
  - 예외 : 3 이상 20 이하의 숫자만 입력 가능
- 플에이어가 이동할 칸 입력받기
  - 예외 : O, X 값이 아니면 예외 처리
- 재시작 여부 값 입력받기

### Bridge
- UpBridge, DownBridge 로 분리하여 클래스 생성

### 규칙
1. InputView에서만 사용자 입력을 받을 수 있다
2. BridgeGame 에서는 InputView, OutputView를 사용하지 않는다