# 다리 건너기 기능 목록

## Controller

    - 다리 건너기 게임 준비 및 실행을 담당

## Domain

    - BridgeGame
        - move, retry

## Service

    - BridgeService
        - BridgeMaker

## Util

    - BridgeNumberGenerator
        - Bridge 정답 랜덤 생성

## View

    - 사용자 Input
        - 다리 길이 입력
        - 사용자 이동 입력
        - 게임 재시도 입력
    - 사용자 Output
        - 다리 이동 시각화
        - 게임 결과 시각화