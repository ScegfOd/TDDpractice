#!/bin/bash
cd /home/jjcombs/workspace/tdd_1/src/
rmiregistry &
java -Djava.rmi.server.codebase=file:/home/jjcombs/workspace/tdd_1/src/ -cp /home/jjcombs/workspace/tdd_1/src/ tdd_1.ServerOperation
