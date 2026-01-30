#!/usr/bin/env bash
set -euo pipefail

AUTH="${JENKINS_USER}:${JENKINS_API_TOKEN}"

RESP_QUEUE="$(curl -sS -X POST \
  "${JENKINS_BASE_URL}/job/${JENKINS_JOB}/buildWithParameters" \
  --user "$AUTH" \
  --data-urlencode "BRANCH=${BRANCH:-feature}" \
  --data-urlencode "SUITE=${SUITE:-smoke_test}" \
  -D - -o /dev/null)"

QUEUE_URL=$(echo "$RESP_QUEUE" | awk 'BEGIN{IGNORECASE=1} /^location:/{print $2}' | tr -d '\r')
QUEUE_API="${QUEUE_URL}api/json?tree=executable%5Bnumber,url%5D"

for i in {1..300}; do
  RESP="$(curl -sS "$QUEUE_API" --user "$AUTH")"
  BUILD_NUMBER="$(echo "$RESP" | jq -r '.executable.number // empty')"
  [[ -n "$BUILD_NUMBER" ]] && break
  sleep 1
done

[[ -n "${BUILD_NUMBER:-}" ]] || { echo "Queue timeout"; exit 1; }

BUILD_API="${JENKINS_BASE_URL}/job/${JENKINS_JOB}/${BUILD_NUMBER}/api/json"

for i in {1..900}; do
  BUILD_RESP="$(curl -sS "$BUILD_API" --user "$AUTH")"
  RESULT="$(echo "$BUILD_RESP" | jq -r '.result // empty')"
  [[ -n "$RESULT" ]] && break
  sleep 1
done

[[ "$RESULT" == "SUCCESS" ]] || { echo "Build failed: $RESULT"; exit 1; }

echo "Jenkins build success."
