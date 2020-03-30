export CLASSPATH=.:./bin:./libs/antlr-3.5.2-complete.jar:./libs/jasmin.jar:./ulclasses:$CLASSPATH
for fullfile in tests/a4_tests/*.ul
do
java Compiler "$fullfile"> /dev/null
done

for fullfile in tests/a4_tests/*.j
do
java jasmin.Main -d ulclasses "$fullfile"> /dev/null
done

for fullfile in ulclasses/*.class
do
filename=$(basename -- "$fullfile")
filename="${filename%.*}"
echo Executing "$filename":
java "$filename"
echo
echo =============================
echo
done
