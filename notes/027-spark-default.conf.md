## spark-default.conf 


This is a default file for spark runtime, where we can mention spark default settings,
master/cluster, hive, warehouse settings, default partitions etc including the jar files to be loaded, the locations of  jars files in other directories

1. copy the /opt/spark-3.1.3-bin-hadoop2.7/conf/spark-default.conf.template into /opt/spark-3.1.3-bin-hadoop2.7/conf/spark-default.conf

2. Open the spark-default.conf in text editor

3. Add below jar file as part of jars

```
spark.jars.packages org.apache.spark:spark-sql-kafka-0-10_2.12:3.1.3
```

4. Save the file

5. Now in Pyspark or in Scala, no need to set environment variables for each script. Now kafka driver shall be loaded for every spark application

below statement is not needed for every script

```
os.environ['PYSPARK_SUBMIT_ARGS'] = f'--packages org.apache.spark:spark-sql-kafka-0-10_{SCALA_VERSION}:{SPARK_VERSION} pyspark-shell'
```