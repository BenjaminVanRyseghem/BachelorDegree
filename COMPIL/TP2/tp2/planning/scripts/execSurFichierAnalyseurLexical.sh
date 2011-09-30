#!/bin/sh

# exécution de LanceurAnalyseurLexical
# texte à analyser ds un fichier
# nom du fichier passé en ligne de commande
#
# M. Nebut

#*******************************
# la classe contenant votre main
MAIN=planningMaster.executeurs.LanceurAnalyseurLexical

#*******************************
java $MAIN $1
