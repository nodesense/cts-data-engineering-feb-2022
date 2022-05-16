
# Spark Cluster with Linux

Components of Spark Clusters?

1. Spark Driver - Core, Spark Context, Spark Session, etc, Application

2. Master - To allocate Executor resources [JVM, Core, Memory] for Spark Driver, 
            Spark Driver demand resources,
            Spark Master/Cluster manager get resources allocated via Worker

3. Worker - Part of node [VM], to create executor as per master request [JVM, Cores Memory]

4. Executor - Execute Spark Tasks

Open command prompt, run cluster master aka cluster manager

```
spark-class org.apache.spark.deploy.master.Master
```

Now check, http://localhost:8080/   from ubuntu browser

May check on on windows 

http://ubuntu-virtual-machine:8080



open command prompt Run Worker 1
copy the master url and paste in below command

```
spark-class org.apache.spark.deploy.worker.Worker spark://192.168.174.129:7077
```


open command prompt Run Worker 2
copy the master url and paste in below command

```
spark-class org.apache.spark.deploy.worker.Worker spark://192.168.174.129:7077
```

Open anaconda py37 command prompt, run spark shell with default config
copy the master url and paste in below command

```
pyspark --master spark://192.168.174.129:7077
```

Stop the spark shell, 

start the spark shell with specific requirements..
open  anaconda py37 command prompt
 
```
pyspark  --master spark://192.168.174.129:7077 --driver-memory 2G --executor-memory 2G --executor-cores 1
```

 

With speicific number of executors


--executor-cores - how many executor per core assum --executor-cores is 1, 
if the system has 8 cores, it will create 8 executors  

```
pyspark  --master spark://192.168.174.129:7077 --driver-memory 2G --executor-memory 2G --executor-cores 1 --num-executors 1  
```

--num-executors 1 -  1 executor use all cores if executor-cores not mentioned

```
pyspark  --master spark://192.168.174.129:7077 --driver-memory 2G --executor-memory 2G   --num-executors 1  --conf spark.executor.instances=1
```


