#!/bin/sh

export HORNETQ_HOME=..
mkdir -p ../logs
# By default, the server is started in the non-clustered standalone configuration

if [ a"$1" = a ]; then CONFIG_DIR=$HORNETQ_HOME/config/stand-alone/non-clustered; else CONFIG_DIR="$1"; fi
if [ a"$2" = a ]; then FILENAME=hornetq-beans.xml; else FILENAME="$2"; fi
RESOLVED_CONFIG_DIR=`cd "$CONFIG_DIR"; pwd`
export CLASSPATH=$RESOLVED_CONFIG_DIR:$HORNETQ_HOME/schemas/
#you can use the following line if you want to run with different ports
#export CLUSTER_PROPS="-Djnp.port=1099 -Djnp.rmiPort=1098 -Djnp.host=localhost -Dhornetq.remoting.netty.host=localhost -Dhornetq.remoting.netty.port=5445"
export JVM_ARGS="$CLUSTER_PROPS -XX:+UseParallelGC -XX:+AggressiveOpts -XX:+UseFastAccessorMethods -Xms512M -Xmx1024M -Dhornetq.config.dir=$RESOLVED_CONFIG_DIR -Djava.util.logging.manager=org.jboss.logmanager.LogManager -Dlogging.configuration=file://$RESOLVED_CONFIG_DIR/logging.properties -Djava.library.path=./lib/linux-i686:./lib/linux-x86_64"
#export JVM_ARGS="-Xmx512M -Djava.util.logging.manager=org.jboss.logmanager.LogManager -Dlogging.configuration=$CONFIG_DIR/logging.properties -Dhornetq.config.dir=$CONFIG_DIR -Djava.library.path=. -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"

export JVM_ARGS="-Djnp.host=`hostname` -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=2090 -Djnp.port=2099 -Djnp.rmiPort=2098 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false $JVM_ARGS"

for i in `ls $HORNETQ_HOME/lib/*.jar`; do
    CLASSPATH=$i:$CLASSPATH
done

echo "***********************************************************************************"
echo "java $JVM_ARGS -classpath $CLASSPATH org.hornetq.integration.bootstrap.HornetQBootstrapServer $FILENAME"
echo "***********************************************************************************"
java $JVM_ARGS -classpath $CLASSPATH -Djava.rmi.server.hostname=`hostname` -Dcom.sun.management.jmxremote org.hornetq.integration.bootstrap.HornetQBootstrapServer $FILENAME