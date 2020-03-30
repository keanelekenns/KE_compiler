export CLASSPATH=.:./bin:./libs/antlr-3.5.2-complete.jar:./libs/jasmin.jar:./ulclasses:$CLASSPATH
for filename in tests/a1_tests/accept_tests/*.ul
do
java Compiler "$filename"
done

for filename in tests/a1_tests/reject_tests/*.ul
do
java Compiler "$filename"
done
