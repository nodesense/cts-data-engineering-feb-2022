## Hadoop Dev Setup

#### incomplete work

open linux terminal

```

mv $HADOOP_HOME/etc/hadoop/core-site.xml $HADOOP_HOME/etc/hadoop/core-site.xml.original
mv $HADOOP_HOME/etc/hadoop/hdfs-site.xml $HADOOP_HOME/etc/hadoop/hdfs-site.xml.original
mv $HADOOP_HOME/etc/hadoop/mapred-site.xml $HADOOP_HOME/etc/hadoop/mapred-site.xml.original
mv $HADOOP_HOME/etc/hadoop/yarn-site.xml $HADOOP_HOME/etc/hadoop/yarn-site.xml.original


wget -P $HADOOP_HOME/etc/hadoop/ https://raw.githubusercontent.com/nodesense/kafka-workshop/master/hadoop/core-site.xml
wget -P $HADOOP_HOME/etc/hadoop/ https://raw.githubusercontent.com/nodesense/kafka-workshop/master/hadoop/hdfs-site.xml
wget -P $HADOOP_HOME/etc/hadoop/ https://raw.githubusercontent.com/nodesense/kafka-workshop/master/hadoop/mapred-site.xml
wget -P $HADOOP_HOME/etc/hadoop/ https://raw.githubusercontent.com/nodesense/kafka-workshop/master/hadoop/yarn-site.xml

```
## First time

```
ssh localhost


hdfs namenode -format


start-all.sh



jps 



```

## In Case DataNode, namenode not starting after start-all.sh or stop-all.sh

```
stop-all.sh

ssh localhost

sudo rm -rf /data/hdfs

sudo mkdir /data/hdfs

sudo chmod 777 -R /data/hdfs

hdfs namenode -format

start-all.sh 

jps
```

Open browser to check whether hdfs namenode working..

http://localhost:50070/


