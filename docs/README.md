# JAVA-BRIDGE 다리건너기

## 구현 기능 목록

### Application
1. 다리 건너기 게임 On

### BridgeGame
1. getUpstairsBridge
- 윗층 다리 이동시 List 생성
2. getDownstairsBridge
- 아래층 다리 이동시 List 생성
3. move
- 1,2번을 합침
4. retry
- Q 입력시 boolean false 리턴
5. getTriedAnswerCount
- 시도한 정답 개수 세기 (다리 이동 로직 구현시 필요)
6. returnToPreviousStatus
- 게임 재시작하면서 무브, 시도한 정답 배열을 직전 상태로 돌리기
7. checkWrongAnswer
- 출력시 정답 조건 
8. getGameCompleteStatus
- 게임 종료시 정답 조건

### GameController
1. 게임 진행 프로세스 구현

### BridgeMaker
1. 난수 생성 후 U,D 넣어서 다리 List 만들기

### Constant
1. 2개 이상 클래스에서 쓰이는 상수 보관

### ErrorMessage(Enum)
1. 예외 처리 메시지 보관

### InputValidation
1. 입력값 검증

### InputView
1. 다리 길이 입력 받음
2. 다리 이동 입력 받음
3. 게임 재시작 / 종료 여부 입력 받음

### OutputView
1. 게임 시작 문구
2. 게임 진행 문구
3. 프린트맵
4. 게임 종료 문구
5. 최종 게임 결과

## 체크리스트
- [x] 게임 종료할 때 초기화 진행
- [x] 
- [x] 에러 내역 output enum으로 구현
- [x] 에러 핸들링 ([ERROR]로 방출)
    1. - [x] 다리 길이 입력값이 3 ~ 20 범위가 아닐 때
    2. - [x] 다리 길이 입력값이 정수가 아닐 때
    3. - [x] 다리 이동 입력값이 U , D가 아닐떄
    4. - [x] 게임 재시작 여부 입력값이 R, Q가 아닐떄
- [x] 테스팅코드