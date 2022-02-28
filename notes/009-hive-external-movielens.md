## MovieLens DataSet in Hive 


To access downloaded files in Terminal,

```
cd ~
cd Downloads
cd ml-latest-small
```

### DIY

```sql
CREATE DATABASE IF NOT EXISTS moviedb; 
```
#### Movies table


1. create a directory called "/movies" in HDFS, give READ/Write permission 777 to the folder
2. Upload movies.csv into HDFS /movies directory
3. Create Hive Database called "moviedb" if not exist
4. Create external table called "movies" inside "moviedb" with movie_id int type,title string,genres string columns which Location  "hdfs://localhost:9000/movies" with skip header lines 1
5. Run SELECT query with moviedb.movies table




```
hdfs dfs -mkdir /movies

hdfs dfs -chmod 777 /movies

hdfs dfs -put movies.csv /movies

```

CREATE EXTERNAL TABLE call it as movies, IGNORE HEADER IN CSV



```sql
CREATE EXTERNAL TABLE IF NOT EXISTS moviedb.movies(
  movie_id INT, 
  title STRING,
  genres STRING
  )
  COMMENT 'movielens movies'
  ROW FORMAT DELIMITED
  FIELDS TERMINATED BY ','
  STORED AS TEXTFILE
  LOCATION 'hdfs://localhost:9000/movies'
  TBLPROPERTIES ("skip.header.line.count"="1");
```


```sql
select * from moviedb.movies limit 5;
```

#### Ratings table 


1. create a directory called "/ratings" in HDFS, give READ/Write permission 777 to the folder
2. Upload ratings.csv into HDFS /ratings directory
3. Create external table called "ratings" inside "moviedb" with columns user_id INT,movie_id INT,rating DECIMAL(10,0),timestamp INT  which Location  "hdfs://localhost:9000/ratings" with skip header lines 1
4. Run SELECT query with moviedb.ratings table




```
hdfs dfs -mkdir /ratings

hdfs dfs -chmod 777 /ratings

hdfs dfs -put ratings.csv /ratings

```

CREATE EXTERNAL TABLE call it as ratings, IGNORE HEADER IN CSV



```sql
CREATE EXTERNAL TABLE IF NOT EXISTS moviedb.ratings(
   user_id INT,
   movie_id INT,
   rating DECIMAL(10,0),
   rating_timestamp INT 
  )
  COMMENT 'movielens ratings'
  ROW FORMAT DELIMITED
  FIELDS TERMINATED BY ','
  STORED AS TEXTFILE
  LOCATION 'hdfs://localhost:9000/ratings'
  TBLPROPERTIES ("skip.header.line.count"="1");
```

```sql
select * from moviedb.ratings limit 5;
```


## Few Quries

```sql
SELECT * FROM moviedb.ratings WHERE rating >= 4.5;
```

```
SELECT * FROM moviedb.ratings WHERE rating >= 3.5 AND rating <= 4.0;
```


SELECT rating from moviedb.ratings LIMIT 10;



-- Do same steps for links and tags table ensure column name follow a convention userId => user_id


change location if needed

```sql
ALTER TABLE moviedb.movies SET LOCATION 'hdfs://localhost:9000/movies';
```