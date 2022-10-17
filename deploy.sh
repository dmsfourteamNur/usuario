#!/bin/bash

docker-compose down
git fetch
git stash
git reset --hard origin/main
git stash pop
docker-compose build
docker-compose up -d