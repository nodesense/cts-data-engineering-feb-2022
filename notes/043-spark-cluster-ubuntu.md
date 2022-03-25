
# Spark Cluster with Linux

Open command prompt, run cluster master aka cluster manager

```
spark-class org.apache.spark.deploy.master.Master
```

Now check, http://localhost:8080/

open command prompt Run Worker 1
copy the master url and paste in below command

```
spark-class org.apache.spark.deploy.worker.Worker spark://192.168.80.128:7077
```


open command prompt Run Worker 2
copy the master url and paste in below command

```
spark-class org.apache.spark.deploy.worker.Worker spark://192.168.80.128:7077
```

Open anaconda py37 command prompt, run spark shell with default config
copy the master url and paste in below command

```
pyspark --master spark://192.168.80.128:7077
```

Stop the spark shell, 

start the spark shell with specific requirements..
open  anaconda py37 command prompt
 
```
pyspark  --master spark://192.168.80.128:7077 --driver-memory 6G --executor-memory 4G --executor-cores 2
```

With speicific number of executors

```
pyspark  --master spark://192.168.80.128:7077 --driver-memory 6G --executor-memory 4G --executor-cores 2 --num-executors 1
```


