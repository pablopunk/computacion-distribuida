#!/bin/zsh

cd src # codigo fuente

echo " Compilando...\c"

javac -cp ../lib/jade.jar *.java && echo " OK" # compilar clases

echo " Ejecutando..."
java -classpath ../lib/jade.jar:. jade.Boot -gui -agents BuyerAgent:SellerAgent # ejecutar clases
