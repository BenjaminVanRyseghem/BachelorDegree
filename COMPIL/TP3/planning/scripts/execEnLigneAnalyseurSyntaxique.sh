#!/bin/sh

# exécution de LanceurAnalyseurSyntaxique
# texte à analyser en ligne
#
# M. Nebut 


#*******************************

# la classe contenant votre main
MAIN=planningMaster.executeurs.LanceurAnalyseurSyntaxique

#*******************************

echo "Entrez le texte à analyser :"
java $MAIN
