## Hive External Tables

Developers or ETL tools like Spark, Apache Nifi, Airflow... will upload data to hadoop directory
ETL tools will update the files or delete the files..

The data is managed outside HIVE.

```

nano employees1.csv
```
paste below

```
1,jane,sales
2,john,marketting
```

Save data in nano, exit nano editor

Ctrl + o  - write file

Ctrl + X - exit nano

```
nano employees2.csv
```

paste below

```
3,will,account
4,smith,qa
```

hdfs dfs -mkdir /employees

hdfs dfs -chmod 777 /employees

hdfs dfs -put employees1.csv /employees


hdfs dfs -put employees2.csv /employees

```

 
open terminal 

```
cd $HIVE_HOME
```

then run hive cli,

```
$HIVE_HOME/bin/hive
```

create table in default db

```sql
CREATE EXTERNAL TABLE IF NOT EXISTS employees(
  employee_id INT, 
  name STRING, 
  dept STRING
  )
  COMMENT 'Employee Names'
  ROW FORMAT DELIMITED
  FIELDS TERMINATED BY ','
  STORED AS TEXTFILE
  LOCATION '/employees';
```


```sql
SHOW TABLES IN default;
```

Desc table, check location, table type 
Location:           	hdfs://localhost:9000/employees	 
Table Type:         	EXTERNAL_TABLE 

```sql
DESC  FORMATTED employees;
```

below query should get all the employees from employees1.cav, employees1.csv

```sql
SELECT * FROM employees;
```


Now try to remove employees1.csv from hadoop.. Developer from the file from hadoop
Spark ETL removed the file


```
 hdfs dfs -rm /employees/employees1.csv
```

will show records from employees2.csv since employees1.csv removed..

Data is managed outside hive,, HIVE ONLY QUERY THE DATA

```sql
SELECT * FROM employees;
```


### DO NOT TRY NOW

CREATE TABLE IF NOT EXISTS employees(
  employee_id INT, 
  name STRING, 
  dept STRING
  )
  COMMENT 'employees names managed';

INSERT OVERWRITE TABLE employees SELECT * FROM employees_ext;

SELECT * from employees; 



SELECT * from employees;   

```

```
 insert into employees_ext (employee_id, name, dept) values(8,'krish','sales');
```

```
 hdfs dfs -ls /employees
  hdfs dfs -cat /employees/000000_0

```

```
insert into employees_ext (employee_id, name, dept) values(9,'nila','sales');

```

```
hdfs dfs -ls /employees

you may notice /employees/000000_0_copy_1 created 

hdfs dfs -cat /employees/000000_0

hdfs dfs -cat /employees/000000_0_copy_1
```

 DROP TABLE employees_ext;

```
 hdfs dfs -rm /employees/employees1.csv
```

then in hive, 

```
select * from employees_ext;
```