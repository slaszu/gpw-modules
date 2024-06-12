#!/bin/bash

repo="https://github.com/slaszu/gpw-modules/releases/download/TAG/app-APP.jar"

echo "Add tag name"

cmd="curl -L $repo -o ./APP-github-release.jar"
cmd=${cmd/TAG/"$1"}

cmd1=${cmd//APP/"admin"}
cmd2=${cmd//APP/"restapi"}

echo "Command: $cmd1"
eval $cmd1

echo "Command: $cmd2"
eval $cmd2