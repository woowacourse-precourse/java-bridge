# 설계
레이어 패키지 구조 사용
- 프로젝트 규모 발전에 대한 우려가 없다고 판단해 모듈 단위로의 분리를 요하지 않으므로 해당 패키지 구조를 선택
- domain, util, view

## 시나리오
1. 게임 시작 문장 출력 → `OutputView`
2. 다리 길이 입력문 출력 → `OutputView`
3. 다리 길이 입력 → `InputView`
    1. 예외 처리 → `Validator`
4. 입력에 맞는 다리 생성 → `BridgeNumberGenerator`, `BridgeRandomNumberGenerator`, `BridgeMaker`
5. 이동 칸 입력문 출력 → `OutputView`
6. 이동 칸 입력 → `InputView`
    1. 예외 처리 → `Validator`
7. 다리 이동 결과 출력 → `OutputView`
8. 게임 상태 변경 → `GameResult`
    1. 성공, 끝 도달 X → 5로 이동
    2. 성공, 끝 도달 O
        1. “최종 게임 결과” 출력 → `OutputView`
        2. 다리 이동 결과 출력 → `OutputView`
        3. “게임 성공 여부: 성공” 출력 → `OutputView`
        4. “총 시도한 횟수: {}” 출력 → `OutputView`
    3. 실패 → 9로 이동
9. 게임 추가 여부 입력문 출력 → `OutputView`
10. 게임 추가 여부 입력 → `InputView`
    1. 예외 처리 → `Validator`
11. 게임 상태 변경 → `GameResult`
    1. 재시도 → 5로 이동
    2. 종료
        1. “최종 게임 결과” 출력 → `OutputView`
        2. 다리 이동 결과 출력 → `OutputView`
        3. “게임 성공 여부: 실패” 출력 → `OutputView`
        4. “총 시도한 횟수: {}” 출력 → `OutputView`

## 필요한 기능
- [ ]  다리 길이 입력
- [ ]  다리 길이 입력에 대한 예외 처리
- [ ]  다리 생성
- [ ]  이동 칸 입력
- [ ]  이동 칸 입력에 대한 예외 처리
- [ ]  다리 이동
- [ ]  다리 이동 결과 출력
- [ ]  게임 상태 변경
- [ ]  게임 추가 여부 입력
- [ ]  게임 추가 여부 입력에 대한 예외 처리
- [ ]  게임 종료에 대한 출력