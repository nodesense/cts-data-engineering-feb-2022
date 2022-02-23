```
export YARN_EXAMPLES=$HADOOP_HOME/share/hadoop/mapreduce

$ ./yarn jar $YARN_EXAMPLES/hadoop-mapreduce-examples-2.7.7.jar pi 16 1000
 
```

Check application status on YARN

http://localhost:8088/cluster



  hadoop jar $YARN_EXAMPLES/hadoop-mapreduce-examples-2.7.7.jar grep /test/ /output 'MSFT'
  cat output/*
