#!/bin/sh

# exécution de LanceurAnalyseurSyntaxique
# texte à analyser ds un fichier
# nom du fichier passé en ligne de commande
#
# M. Nebut

#*******************************
# la classe contenant votre main
MAIN=init.executeurs.LanceurAnalyseurSyntaxique

#*******************************
java $MAIN $1
