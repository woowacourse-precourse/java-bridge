# 미션 다리 건너기 기능목록

## 개발 큰 그림
- View
  - InputView 클래스 구현
  - OutputView 클래스 구현
- Domian
  - BridgeInform 클래스 입력값 테스트케이스 작성
  - BridgeInform 클래스 예외처리케이스 작성
  - BridgeMaker 클래스 up, down별 BridegeRandomNumberGenerator 랜덤값 토대로 결과값 리턴 함수
- Controller
  - BridgeGame 클래스에서 View, Domain 연결해주고 필요한 로직 작성

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
  2. 클래스 필요 기능 목록
- BridgeMaker 클래스
  1. 랜덤 함수 입력받아서 게임 결과값 출력
## Controller 기능 목록
- BridgeGame 클래스
  1. View, Domain 연결해주는 기능 록직