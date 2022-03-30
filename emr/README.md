# Running Spark on Yarn Mode

SSH into EMR

```
mkdir gk
cd gk

touch movielens.py

nano movielens.py
```

paste the script, edit the db name in 3 places

```python
from pyspark.conf import SparkConf
config = SparkConf()
config.setAppName("MovieLensSQL")


from pyspark.sql import SparkSession
spark = SparkSession.builder\
                    .config(conf=config)\
                    .enableHiveSupport()\
                    .getOrCreate()

sc = spark.sparkContext

spark.sql("""
SELECT * FROM gk_db.ratings LIMIT 5
""").show()

spark.sql("""DROP TABLE IF EXISTS gk_db.emr_popular_movies""")


spark.sql("""
CREATE  TABLE gk_db.emr_popular_movies AS
SELECT movieid, avg(rating) as avg_rating, count(userid) as total_ratings
FROM gk_db.ratings
WHERE movieid IS NOT null
GROUP BY movieid
HAVING avg_rating >= 3.5 AND total_ratings >= 100
""")



```


Ctrl + O - To write the file

Ctrl + X - to quit nano

## Glue Database Location

Go to Glue, spot your db  gk_db, Click on Edit database..
In your s3 bucket, create a folder called `emr-tables`

In location text box,  paste your S3 directory path `s3://gks2-bucket/emr-tables/`

Save the settings

## To run the Spark Application on Client mode

Driver runs on EC2/VM memory, may not have adequote resources, people/application may need to wait for instance to be available.

```
spark-submit movielens.py --master yarn  --deploy-mode client  --driver-memory 4g   --executor-memory 2g  --executor-cores 1
```
## To run spark application on cluster mode


Spark Driver runs inside Yarn container inside the cluster. It can make use of hugh cluster configuration


```
spark-submit movielens.py --master yarn  --deploy-mode cluster   --driver-memory 4g   --executor-memory 2g  --executor-cores 1
```

You may check status of the job in Yarn application UI with socks proxy..

# Spark Memory

Reference: https://miro.medium.com/max/982/1*XceNd8_jFS9R1EDKJ8tsIw.png

Article: https://medium.com/analytics-vidhya/apache-spark-memory-management-49682ded3d42

Reduce the Memory Fraction, less space given for Cache, BroadCast variables..

```
spark-submit movielens.py --master yarn  --deploy-mode client  --driver-memory 4g   --executor-memory 2g  --executor-cores 1 --conf spark.memory.fraction=0.2
```

Increase memory fraction, more space given for cache..

```
spark-submit movielens.py --master yarn  --deploy-mode client  --driver-memory 4g   --executor-memory 2g  --executor-cores 1 --conf spark.memory.fraction=0.75
```
