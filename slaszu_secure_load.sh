#!/bin/bash

cmd="git clone git@bitbucket.org:piotr_flasza/gpw-config-secure.git ./config/secure";

echo "GIT CLONE : $cmd"
eval $cmd


cmd="cd ./config/secure && git pull"

echo "GIT PULL : $cmd"
eval $cmd