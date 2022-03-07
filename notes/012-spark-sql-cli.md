# Spark SQL CLI

Open Terminal to run the commands.

Write direct SQL statement and execute in spark
Internally same DF, Catalyst and no different from using pyspark shell

```
spark-sql  --hiveconf hive.metastore.uris=thrift://localhost:9083  --hiveconf hive.metastore.warehouse.dir=hdfs://localhost:9000/user/hive/warehouse
 

```

```sql
SHOW DATABASES;
```

```
SHOW TABLES IN moviedb;
```

```
SELECT * from moviedb.movies LIMIT 5;
```



CREATE A TEMP VIEW to create popular movies..

```sql
CREATE OR REPLACE TEMP VIEW popular_movies AS
SELECT movie_id, avg(rating) as avg_rating, count(user_id) as total_ratings
FROM moviedb.ratings
WHERE movie_id IS NOT null
GROUP BY movie_id
HAVING avg_rating >= 3.5 AND total_ratings >= 100;

```


```
SHOW TABLES IN moviedb;
```

```sql
CREATE TABLE moviedb.most_popular_movies5 AS 
SELECT movies.movie_id, title, avg_rating, total_ratings 
FROM popular_movies 
INNER JOIN moviedb.movies movies ON popular_movies.movie_id = movies.movie_id
ORDER BY avg_rating DESC
```


```
SHOW TABLES IN moviedb;
```

```sql
SELECT * FROM moviedb.most_popular_movies5 LIMIT 5;
```
