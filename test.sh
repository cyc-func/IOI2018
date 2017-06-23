# checks if the solution is correct
# WARNING: Works only for java

# To run, first put sources and files 1.in, 1.out, ..., 10.in, 10.out
# in the same folder as test.sh. Then run
# $ ./test FILENAME

for i in {1..10}
do
	START=$(date +%s.%N)
	testAns=($(eval "javac $1.java && java $1 < ${i}.in"))
	END=$(date +%s.%N)
	DIFF=$(echo "$END - $START" | bc)
	
	correctAns=($(<${i}.out))

	lenTest=${#testAns[@]}
	lenCorrect=${#correctAns[@]}

	isCor=1

	if [ $lenTest -ne $lenCorrect ]
	then
		echo -e "Task $i: Wrong answer \t\t Time elapsed:   ${DIFF}"
		isCor=0
		continue
	fi

	((lenTest--))

	for j in $(seq 0 $lenTest)
	do
		if [ ${testAns[j]} -ne ${correctAns[j]} ]
		then
			echo -e "Task $i: Wrong answer \t\t Time elapsed: ${DIFF}"
			isCor=0
			break
		fi
	done

	if [ $isCor -eq 1 ]
	then
		echo -e "Task $i: Correct answer \t\t Time elapsed: ${DIFF}"
	fi
done
