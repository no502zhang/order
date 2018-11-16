#!/bin/bash

# 配置
APP_NAME=order
APP_PATH=/home/ubuntu/app/$APP_NAME
LOG_PATH=/home/ubuntu/logs/$APP_NAME

# 启动
start_app() {
	echo "start..."
	cd $APP_PATH
	nohup java -jar $APP_NAME.jar >> $LOG_PATH/catalina.out 2>&1 &
}

# 停止
stop_app(){
	echo "stop..."
	PID=$(ps -ef | grep $APP_NAME.jar | grep -v grep | awk '{print $2}')
	if [ -z "$PID" ] ; then
		echo "Application is already stopped"
	else
		echo "stop $PID"
		ps -ef | grep $APP_NAME.jar | grep -v grep | awk '{print $2}' |xargs kill -9
	fi
}

# 重启
restart_app(){
	echo "restart..."

	stop_app

	sleep 3

	start_app
}

# 命令参数
echo "do $1"
case "$1" in
	start)
		start_app
		;;
	stop)
		stop_app
		;;
	restart)
		restart_app
		;;
esac
echo "done"
