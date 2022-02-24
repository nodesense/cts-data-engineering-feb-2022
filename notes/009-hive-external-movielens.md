## MovieLens DataSet in Hive 


To access downloaded files in Terminal,

```
cd ~
cd Downloads
cd ml-latest-small
```

### DIY

```
CREATE DATABASE IF NOT EXISTS removeme; 
```
#### Movies table


1. create a directory called "/movies" in HDFS, give READ/Write permission 777 to the folder
2. Upload movies.csv into HDFS /movies directory
3. Create Hive Database called "moviedb" if not exist
4. Create external table called "movies" inside "moviedb" with movie_id int type,title string,genres string columns which Location  "hdfs://localhost:9000/movies" with skip header lines 1
5. Run SELECT query with moviedb.movies table

#### Ratings table 


1. create a directory called "/ratings" in HDFS, give READ/Write permission 777 to the folder
2. Upload ratings.csv into HDFS /ratings directory
3. Create external table called "ratings" inside "moviedb" with columns user_id INT,movie_id INT,rating DECIMAL(10,0),timestamp INT  which Location  "hdfs://localhost:9000/ratings" with skip header lines 1
4. Run SELECT query with moviedb.ratings table


-- Do same steps for links and tags table ensure column name follow a convention userId => user_id