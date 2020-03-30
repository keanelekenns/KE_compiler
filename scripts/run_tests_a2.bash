export CLASSPATH=.:./bin:./libs/antlr-3.5.2-complete.jar:./libs/jasmin.jar:./ulclasses:$CLASSPATH
for filename in tests/a2_tests/*.ul
do
java Compiler "$filename"
done
