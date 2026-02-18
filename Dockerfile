# FROM openjdk:8-jdk-alpine AS dev
FROM eclipse-temurin:8-jdk-alpine AS dev

# compilation tools
RUN apk update && \
    apk add build-base gcc

# FROM openjdk:8-jre-alpine AS base
FROM eclipse-temurin:8-jre-alpine AS base

# wait-for-it.sh needs bash
RUN apk update && \
    apk add bash mysql-client

FROM base AS v380c

WORKDIR /data

COPY L1J-TW_3.80c /data
EXPOSE 2000

CMD bash /data/ServerStart.sh
