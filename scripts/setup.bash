export CLASSPATH=.:./bin:./libs/antlr-3.5.2-complete.jar:./libs/jasmin.jar:./ulclasses:$CLASSPATH

java org.antlr.Tool -fo ./src src/unnamedLanguage.g

javac -d bin src/*.java src/AST/*.java src/AST/Expressions/*.java src/AST/Statements/*.java src/AST/Types/*.java src/Visitors/*.java src/util/*.java src/IR/*.java src/IR/IRTypes/*.java src/IR/Instructions/*.java
