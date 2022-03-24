# PostgreSQL on AWS

1. Created RDS with postgreSQL
2. Added Security Group allow the lab system to connect
3. Used DBeaver to connect PostgreSQL

CREATE database

```sql
CREATE DATABASE   gkdb;
```

now use DBeaver to connect your db...

Create New SQL Script under public schema...

```sql
CREATE TABLE popular_movies(movieid int, name VARCHAR(250), avg_rating DOUBLE PRECISION, total_ratings int)
```

Now refresh left side pane dbname -> schemas -> public