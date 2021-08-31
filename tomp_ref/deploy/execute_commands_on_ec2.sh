#!/usr/bin/env bash


sudo kill -9 $(sudo lsof -t -i:8083)
echo "Killed process running on port 8083"

java -jar -Dspring.profiles.active=car reference-1.2.2-exec.jar
echo "Started server using java -jar command"