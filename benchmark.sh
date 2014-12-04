#!/bin/zsh

PATTERN=${1:-*.scala}
SCALA_VERSION=${2:-2.11.4}
JAVA_VERSION=${3:-1.7}
SCALA_COMPILER=${4:-scalac}

CURRENT=$(cd $(dirname $0); pwd)
TARGET_DIR=$CURRENT/tmp

JAVA_HOME=`/usr/libexec/java_home -v $JAVA_VERSION`
export PATH=$JAVA_HOME/bin:$PATH
java -version
echo "JAVA_OPTS=$JAVA_OPTS" >&2
echo >&2

svm -s $SCALA_VERSION >&2
scalac -version
echo >&2

echo "start benchmarks." >&2
echo >&2

echo -e 'filename\tavg\tmed\tmin\tmax'
find scala -name $PATTERN -type f | while read filename; do
    result=`avgtime -r 10 ${SCALA_COMPILER} -d ${TARGET_DIR} ${filename}`
    med=`echo ${result} | grep "Median time" | sed -e "s/.*: //"`
    avg=`echo ${result} | grep "Avg time" | sed -e "s/.*: //"`
    min=`echo ${result} | grep "Minimum" | sed -e "s/.*: //"`
    max=`echo ${result} | grep "Maximum" | sed -e "s/.*: //"`
    echo -e "${filename}\t${avg}\t${med}\t${min}\t${max}"
done


echo "finish benchmarks." >&2
