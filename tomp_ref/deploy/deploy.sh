#!/usr/bin/env bash

rm -rf target/
echo "Deleted target/ folder"

cd ..
mvn package
echo "Generating jar file"

pemFile="/Users/kevinkuhfeldt/.ssh/id_rsa.pem"

scp -i $pemFile deploy/execute_commands_on_ec2.sh ec2-user@3.123.228.24:/home/ec2-user
echo "Copied latest 'execute_commands_on_ec2.sh' file from local machine to ec2 instance"

scp -r -i $pemFile ./src/main/resources ec2-user@3.123.228.24:/home/ec2-user/src/main
echo "Copied resources from local machine to ec2 instance"

scp -i $pemFile ./target/reference-1.2.2-exec.jar ec2-user@3.123.228.24:/home/ec2-user
echo "Copied jar file from local machine to ec2 instance"

echo "Connecting to ec2 instance and starting server using java -jar command"
ssh -i $pemFile ec2-user@3.123.228.24 ./execute_commands_on_ec2.sh
