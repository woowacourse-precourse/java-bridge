# 미션 다리 건너기 기능목록

## 개발 큰 그림
- View
  - InputView 클래스 구현
  - OutputView 클래스 구현
- Domian
  - BridgeInform 클래스 입력값 테스트케이스 작성
  - BridgeInform 클래스 예외처리케이스 작성
  - BridgeInform 클래스 기능 구현
  - BridgeMaker 클래스 up, down별 BridegeRandomNumberGenerator 랜덤값 토대로 결과값 리턴 함수
- Controller
  - BridgeGame 클래스에서 View, Domain 연결해주고 필요한 로직 작성
- Refactoring
  - 변수 이름, 함수 이름
  - 한줄 120라인 넘어가지 않게
  - 예외처리 error메세지 출력
  - 자바 컨벤션, 3주차 공통 피드백 확인

## View 기능 목록
- InputView 클래스
    - 다리 길이 입력 함수
    - 이동할 칸 U/D 입력 함수
    - 게임 재시작 종료 여부 입력
- OutputView 클래스
    - 게임 중간 결과 출력 함수
    - 게임 최종 결과 출력 함수

## Domain기능목록
- BridegeInform 클래스 
  1. 함수 및 예외처리 테스트 목록 
     - 브리지 사이즈 입력값 범위 확인
     - 브리지 방향 입력값 확인
     - 브리지 종료 입력값 확인
  2. 클래스 필요 기능 목록
     - 브리지 관련 정보 get, set 함수 구현
- BridgeMaker 클래스
  1. 사이즈 입력받고 랜덤함수를 통해서 정답 브리지 리턴
## Controller 기능 목록
- BridgeGame 클래스
  1. 사이즈 입력받고 BridgeInform 클래스 생성
  2. BridgeMaker 클래스를 통해 정답 브리지 저장
  3. 사용자에게 move 값 하나씩 입력받으며 결과 출력
  4. 실패시 재도전 여부, 성공시 최종 결과 출력