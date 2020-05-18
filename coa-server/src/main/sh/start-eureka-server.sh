#!/bin/sh
LANG=zh_CN.UTF-8
export LANG
cur_date=` date +%Y-%m-%d" "%H:%M:%S `
RunFlag='coaserver-eureka01';
for pid in `ps -ef | grep "${RunFlag}" | grep -v "grep" | awk ' { print $2 } '`
do
kill -9 $pid
done

WORK_HOME="/home/lcims/work/zhangjp/coa-server"

cd ${WORK_HOME}
nohup /home/lcims/app/jdk1.8.0_161/bin/java -Dtarget=${RunFlag} -Dspring.config.location=${WORK_HOME}/conf/application-eureka.yml -Dserver.port=9031 -Dlogging.file.name=${WORK_HOME}/logs/coaserver-eureka-01.log -jar ${WORK_HOME}/jar/coa-server-eureka-1.0.0.jar >/dev/null 2>&1 &
echo $cur_date, server is started! >> ${WORK_HOME}/logs/console.log 2>&1