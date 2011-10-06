#!/bin/sh
java JFlex.Main spec/anLexInit.lex
mv spec/ScannerInit.java src/init/analyseurs