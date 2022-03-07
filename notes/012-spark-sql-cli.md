# Spark SQL CLI

Open Terminal to run the commands.

Write direct SQL statement and execute in spark
Internally same DF, Catalyst and no different from using pyspark shell

```
spark-sql  --hiveconf hive.metastore.uris=thrift://localhost:9083  --hiveconf hive.metastore.warehouse.dir=hdfs://localhost:9000/user/hive/warehouse
 

```

```sql
SHOW DATABASES
```

```
SHOW TABLES IN moviedb
```

```
SELECT * from moviedb.movies LIMIT 5
```
