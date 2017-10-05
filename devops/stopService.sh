pid=`ps -ef|grep java | grep -v 'grep'|grep -v 'jenkins'|awk '{print $2}'`

echo $pid

kill -9 $pid