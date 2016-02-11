if [ -z "$1" ]
	then
	echo "Please insert your version..."
else
	mvn -N versions:set -DnewVersion=$1

	cd chartizate-text-writer-api
	mvn -N versions:set -DnewVersion=$1
	cd ..

	cd chartizate-text-writer
	mvn -N versions:set -DnewVersion=$1
	cd ..
fi

