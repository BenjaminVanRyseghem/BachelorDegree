#!/bin/sh

# test de l'analyseur syntaxique Init
#
# M. Nebut

#*******************************
# la classe contenant votre main pour les tests positifs
MAINPOS=init.testeurs.TesteurPositifAnalyseurSyntaxique
# la classe contenant votre main pour les tests négatifs
MAINNEG=init.testeurs.TesteurNegatifAnalyseurSyntaxique
# répertoire test positif
POS=test/OK
# répertoire test negatif
NEG=test/KO

#*******************************

echo "*******************************************" ;
echo "***                 OK                  ***" ;
echo "*******************************************" ;

for f in `find $POS -name \*.init`
do
    echo $f ;
    java $MAINPOS $f ;
    echo "";
done

echo "*******************************************" ;
echo "***                 KO                  ***" ;
echo "*******************************************" ;

for f in `find $NEG -name \*.init`
do
    echo $f ;
    java $MAINNEG $f ;
    echo "";
done


