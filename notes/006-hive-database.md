## Database 

Database is a data store 
tables are structured data, that consists column names and types

Database contains tables (1 or more tables......)

HQL - Hive Query Language, a flavor of SQL

Database meta data like database name, tables, table names, columns are stored in Hive Meta Server.

Hive Meter Server uses Derby database, but we can mysql or postgreSQL as backend for hive meta server

Hive data shall be stored in hadoop under a directory 

`/user/hive/warehouse`
      if database, name shall be databasename.db

      if table, the name shall be table name brands 


Hive has default database [inbuilt], named `default`

the default database tables are stored directly under `/user/hive/warehouse`

```sql
SHOW TABLES IN default
```


```sql
CREATE DATABASE productsdb
```

the productsdb database tables are stored directly under `/user/hive/warehouse/productsdb.db`


Create a table called products in productsdb database,

```sql
CREATE TABLE productsdb.products(id INT, name STRING, price INT, brand_id INT)
```

the table will be created in hive meta server, the data directory shall be creatd in hdfs
directory `/user/hive/warehouse/productsdb.db/products`

to display tables in other databases,

```sql
SHOW TABLES IN productsdb
```

Create a table called brands under productsdb

```sql
CREATE TABLE productsdb.brands(id INT, name STRING)
```

the table will be created in hive meta server, the data directory shall be creatd in hdfs
directory `/user/hive/warehouse/productsdb.db/brands`

to display tables in other databases,

```sql
SHOW TABLES IN productsdb
```

Insert statement used for inserting data into database..

```sql
INSERT INTO productsdb.products VALUES (1, 'iPhone', 999, 1001)
```

the data shall be added inside `/user/hive/warehouse/productsdb.db/products`
some file name like 0000_0 etc

```sql
INSERT INTO productsdb.brands VALUES (1001, 'Apple')
```

the data shall be added inside `/user/hive/warehouse/productsdb.db/brands`
some file name like 0000_0 etc

To query data from database, we use SELECT statement..

select all columns [id, name, price, brand_id] from products

```sql
SELECT * FROM productsdb.products
```

select two columns [  name, price] from products


```sql
SELECT name, price FROM productsdb.products
```

select all columns where price of product greater than 500


```sql
SELECT * FROM productsdb.products WHERE price > 500
```


select two columns where price of product greater than 500


```sql
SELECT id, price FROM productdb.products WHERE price > 500
```

TERMINOLOGY

SELECT - PROJECTION - project data out of db

WHERE - FILTER 

## Alter table 

After the table is created, we want to modify column, add column, or drop column,
change data type, rename table

```sql

CREATE TABLE productsdb.orders2(id INT, product_id INT);
```


Now use describe to see table description

```sql
DESCRIBE FORMATTED productsdb.orders2;
```

or 


```sql
DESC FORMATTED productsdb.orders2;
```

Add new columns to existing table,

```sql
ALTER TABLE productsdb.orders2 ADD COLUMNS (brand_id INT, amount INT, invoice_id INT);
```

now check desc  

drop existing column invoice_id

*drop column Not working*

```sql
ALTER TABLE productsdb.orders2 DROP COLUMN invoice_id;
```

change column data type,

```sql
ALTER TABLE productsdb.orders2 CHANGE amount amount DECIMAL(10, 0)
```

change table name

```sql
ALTER TABLE productsdb.orders2 RENAME TO productsdb.orders;
```

show tables, check orders in productsdb

```sql
SHOW TABLES in  productsdb;
```