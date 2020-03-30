chmod 755 tests/a3_tests/codegen

export CLASSPATH=.:./bin:./libs/antlr-3.5.2-complete.jar:/home/jcorless/csc435/codegen/jasmin-2708/classes/:/home/jcorless/csc435/codegen/polyglot-1.3.4/classes/:/home/jcorless/csc435/codegen/soot-2708/classes/:/home/jcorless/csc435/codegen/polyglot-1.3.4/cup-classes/:$CLASSPATH

echo
echo "Testing factorial"
echo
java Compiler tests/a3_tests/factorial.ul -ir > factorial.ir
./tests/a3_tests/codegen --file=factorial.ir > fact.j && java jasmin.Main fact.j
java factorial
echo
echo "Done factorial"

echo
echo "Testing if"
echo
java Compiler tests/a3_tests/if.ul -ir > if.ir
./tests/a3_tests/codegen --file=if.ir > if.j && java jasmin.Main if.j
java if
echo
echo "Done if"

echo
echo "Testing an array"
echo
java Compiler tests/a3_tests/ar.ul -ir > ar.ir
./tests/a3_tests/codegen --file=ar.ir > ar.j && java jasmin.Main ar.j
java ar
echo
echo "Done array"

echo
echo "Testing an expression"
echo
java Compiler tests/a3_tests/expr.ul -ir > expr.ir
./tests/a3_tests/codegen --file=expr.ir > expr.j && java jasmin.Main expr.j
java expr
echo
echo "Done expression"

echo
echo "Testing Towers of Hanoi"
echo
java Compiler tests/a3_tests/towersOfHanoi.ul -ir > towersOfHanoi.ir
./tests/a3_tests/codegen --file=towersOfHanoi.ir > towersOfHanoi.j && java jasmin.Main towersOfHanoi.j
java towersOfHanoi
echo
echo "Done towers"

echo "Cleaning main directory..."
rm *.ir
rm *.j
rm *.class
echo
echo "All done!"