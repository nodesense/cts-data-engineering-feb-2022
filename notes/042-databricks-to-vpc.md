https://docs.databricks.com/administration-guide/cloud-configurations/aws/vpc-peering.html

1. JDBC with PostgreSQL

```python

#  install library mysql:mysql-connector-java:8.0.28
# install org.postgresql:postgresql:42.3.3
# READING FROM POSTGRESQL from RDS
popularMoviesDf = ( spark.read
.format("jdbc")
.option("url", "jdbc:postgresql://<<HOSTNAME>>:5432/<<DBNAME>>")
.option("driver", "org.postgresql.Driver")
.option("user", "postgres")
.option("password", "<<PASSWORD>>")
.option("dbtable", "popular_movies")
 .load()
 )

popularMoviesDf.printSchema()
popularMoviesDf.show(5)

```

## JDBC Write


```python
# WRITE TO JDBC, Just an example
# it will create an employee table and write content
data = [ ("James", "Sales", 3000),
    ("Michael", "Sales", 4600),
    ("Robert", "Sales", 4100),
    ("Maria", "Finance", 3000),
    ("James", "Sales", 3000),
    ("Scott", "Finance", 3300),
    ("Jen", "Finance", 3900),
    ("Jeff", "Marketing", 3000),
    ("Kumar", "Marketing", 2000),
    ("Saif", "Sales", 4100)
   ]

empDf = spark.createDataFrame(data=data, schema=['name', 'dept', 'salary'])
empDf.printSchema()
empDf.show()

( empDf
.write
 .mode("overwrite")
.format("jdbc")
.option("url", "jdbc:postgresql://<<HOSTNAME>>:5432/<<DBNAME>>")
.option("driver", "org.postgresql.Driver")
.option("user", "postgres")
.option("password", "<<PASSWORD>>")
.option("dbtable", "employees")
 .save()
)
```

#### Read employees from PostgresQL

```python
#  install library mysql:mysql-connector-java:8.0.28
# install org.postgresql:postgresql:42.3.3
# READING FROM POSTGRESQL from RDS
emp2 = ( spark.read
.format("jdbc")
.option("url", "jdbc:postgresql://<<HOSTNAME>>:5432/<<DBNAME>>")
.option("driver", "org.postgresql.Driver")
.option("user", "postgres")
.option("password", "<<PASSWORD>>")
.option("dbtable", "employees")
 .load()
 )

emp2.printSchema()
emp2.show(5)
```


2. JDBC with MySQL

```sql
CREATE DATABASE trainingdb;

use trainingdb;

CREATE TABLE symbols (symbol VARCHAR(200), sector VARCHAR(100))

INSERT INTO symbols VALUES ('TSLA', 'AUTOMOBILE');

INSERT INTO symbols VALUES ('INFY', 'IT');
```

```python
#  install library mysql:mysql-connector-java:8.0.28
# install org.postgresql:postgresql:42.3.3
# READING FROM POSTGRESQL from RDS
# java.lang.ClassNotFoundException: com.mysql.jdbc.Driver, to solve this, go to computing cluster, library install mysql driver

symbolDf = ( spark.read
.format("jdbc")
.option("url", "jdbc:mysql://<<HOST>>:3306/trainingdb")
.option("driver", "com.mysql.jdbc.Driver")
.option("user", "admin")
.option("password", "<<PASSWORD>>")
.option("dbtable", "symbols")
 .load()
 )

symbolDf.printSchema()
symbolDf.show(5)
```

```python
# WRITE TO JDBC, Just an example
# it will create an employee table and write content
data = [ ("James", "Sales", 3000),
    ("Michael", "Sales", 4600),
    ("Robert", "Sales", 4100),
    ("Maria", "Finance", 3000),
    ("James", "Sales", 3000),
    ("Scott", "Finance", 3300),
    ("Jen", "Finance", 3900),
    ("Jeff", "Marketing", 3000),
    ("Kumar", "Marketing", 2000),
    ("Saif", "Sales", 4100)
   ]

empDf = spark.createDataFrame(data=data, schema=['name', 'dept', 'salary'])
empDf.printSchema()
empDf.show()

( empDf
.write
 .mode("overwrite")
.format("jdbc")
.option("url", "jdbc:mysql://<<HOST>>:3306/trainingdb")
.option("driver", "com.mysql.jdbc.Driver")
.option("user", "admin")
.option("password", "<<PASSWORD>>")
.option("dbtable", "employees")
 .save()
)
```


```python


#  install library mysql:mysql-connector-java:8.0.28
# install org.postgresql:postgresql:42.3.3
# READING FROM POSTGRESQL from RDS
emp2 = ( spark.read
.format("jdbc")
.option("url", "jdbc:mysql://<<HOST>>:3306/trainingdb")
.option("driver", "com.mysql.jdbc.Driver")
.option("user", "admin")
.option("password", "<<PASSWORD>>")
.option("dbtable", "employees")
 .load()
 )

emp2.printSchema()
emp2.show(5)
```

3. JDBC with Redshift


```python
# install library  com.amazon.redshift:redshift-jdbc42:2.1.0.5   from mvn
# WRITE TO JDBC, Just an example
# it will create an employee table and write content
data = [ ("James", "Sales", 3000),
    ("Michael", "Sales", 4600),
    ("Robert", "Sales", 4100),
    ("Maria", "Finance", 3000),
    ("James", "Sales", 3000),
    ("Scott", "Finance", 3300),
    ("Jen", "Finance", 3900),
    ("Jeff", "Marketing", 3000),
    ("Kumar", "Marketing", 2000),
    ("Saif", "Sales", 4100)
   ]

empDf = spark.createDataFrame(data=data, schema=['name', 'dept', 'salary'])
empDf.printSchema()
empDf.show()

( empDf
.write
 .mode("overwrite")
.format("jdbc")
.option("url", "jdbc:redshift://<<HOSTNAME>>:5439/dev")
.option("driver", "com.amazon.redshift.jdbc42.Driver")
.option("user", "awsuser")
.option("password", "<<PASSWORD>>")
.option("dbtable", "employees")
 .save()
)
```

#### read from redshift

```python
#  install library mysql:mysql-connector-java:8.0.28
# install org.postgresql:postgresql:42.3.3
# READING FROM POSTGRESQL from RDS
emp2 = ( spark.read
.format("jdbc")
.option("url", "jdbc:redshift://<<HOSTNAME>>:5439/dev")
.option("driver", "com.amazon.redshift.jdbc42.Driver")
.option("user", "awsuser")
.option("password", "<<PASSWORD>>")
.option("dbtable", "employees")
 .load()
 )

emp2.printSchema()
emp2.show(5)
```

