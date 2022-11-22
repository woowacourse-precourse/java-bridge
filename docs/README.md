# JAVA-BRIDGE 다리건너기

## 구현 기능 목록
### InputView
1. 다리 길이 입력 받음 (3 ~ 20)   
2. 이동할 칸 입력 받음 (U / D)
3. 게임 재시작 / 종료 여부 입력 받음 (R / Q)

### OutputView
1. 게임 시작 문구
2. 게임 진행 문구
3. 프린트맵
4. 게임 종료 문구
- 최종 게임 결과
- 게임 성공 여부
- 총 시도 횟수

### BridgeGame
1. getUpstairsBridge
2. getDownstairsBridge
3. move
4. retry
5. getTriedAnswerCount
6. returnToPreviousStatus
7. checkWrongAnswer
8. getGameCompleteStatus

### BridgeMaker
1. 난수 생성 후 U,D 넣어서 다리 List 만들기

### Constant
1. 2개 이상 클래스에서 쓰이는 상수 보관

### ErrorMessage(Enum)
1. 예외 처리 메시지 보관

### GameController
1. 게임 전반적인 프로세스 진행

### InputValidation
1. 입력값 검증 클래스




에러핸들링
테스트코드
메인 Depth 줄이기
enum
첫번째 답 지울떄 정답처리

