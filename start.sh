#!/bin/bash

echo "todo: add --build option !!!!"

dockerComposeTypes=('mysql' 'admin' 'restapi' 'redis')

dockerComposeTypesArgs=()

#prepare args
for name in "$@"
do
    if [[ " ${dockerComposeTypes[@]} " =~ " ${name} " ]]; then
        dockerType=$name
        if [[ ! " ${dockerComposeTypesArgs[@]} " =~ " ${dockerType} " ]]; then
            dockerComposeTypesArgs+=( $dockerType )
        fi
    fi
done

#default, without arg
if [ ${#dockerComposeTypesArgs[@]} -eq 0 ]; then
    echo "Start all services ..."
    for name in "${dockerComposeTypes[@]}"
    do
        dockerComposeTypesArgs+=( $name )
    done
fi

#prepare cmd
cmd="docker-compose";
for name in "${dockerComposeTypesArgs[@]}"
do
    cmd="$cmd -f docker-compose-$name.yml"
done
cmd="$cmd up -d"

echo "Create network for sure"
eval "docker network create gpw-network"

echo "Start cmd : $cmd"
eval $cmd