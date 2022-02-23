## Setup Hive on Ubuntu

```
cd ~

wget https://archive.apache.org/dist/hive/hive-2.3.8/apache-hive-2.3.8-bin.tar.gz

tar xf apache-hive-2.3.8-bin.tar.gz
sudo mv apache-hive-2.3.8-bin /opt/apache-hive-2.3.8

sudo chmod 777  /opt/apache-hive-2.3.8
```


```
sudo nano /etc/environment 
```

paste below 

```
HIVE_HOME=/opt/apache-hive-2.3.8
```
 
To save file in nano editor,

Ctrl + o - write the file content, if prompted to write, press enter key

Ctrl + x - to close nano editor


```
export HIVE_HOME=/opt/apache-hive-2.3.8
```


```
cp $HIVE_HOME/conf/hive-site.xml $HIVE_HOME/conf/hive-site.xml.bak

rm $HIVE_HOME/conf/hive-site.xml
wget -P $HIVE_HOME/conf https://raw.githubusercontent.com/nodesense/cts-data-engineering-feb-2022/main/hive/conf/hive-site.xml

ls $HIVE_HOME/conf

```

```
cd $HIVE_HOME
$HIVE_HOME/bin/schematool -initSchema -dbType derby

```

Check the output like below

## Start Meta Server 

Open new Linux Terminal

```
cd $HIVE_HOME 

$HIVE_HOME/bin/hive --service metastore
```



output of init schema

```
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/opt/apache-hive-2.3.8/lib/log4j-slf4j-impl-2.6.2.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/opt/hadoop-2.7.7/share/hadoop/common/lib/slf4j-log4j12-1.7.10.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.apache.logging.slf4j.Log4jLoggerFactory]
Metastore connection URL:        jdbc:derby:;databaseName=metastore_db;create=true
Metastore Connection Driver :    org.apache.derby.jdbc.EmbeddedDriver
Metastore connection User:       APP
Starting metastore schema initialization to 2.3.0
Initialization script hive-schema-2.3.0.derby.sql
Initialization script completed
schemaTool completed
```

Ensure Meta store server running...


### Hive server 2 for JDBS, Web Access

do this on separate terminal in git bash / ubuntu

```
cd $HIVE_HOME
```

Run Hive Server

```
$HIVE_HOME/bin/hive --service hiveserver2 --hiveconf hive.server2.thrift.port=10000 --hiveconf hive.root.logger=INFO,console
```
 
check if that working on port 10000 by default,

```
<<no need to test>>

netstate -anp | grep 10000
````

Hive server web UI at port 10002

check in browser http://192.168.80.128:10002



## Run Hive Cli that connects to Meta Data Server

Open new Command prompt

```
cd $HIVE_HOME
```


```
$HIVE_HOME/bin/hive

```

```
hive> show tables;


to create database, you have two options, create database/schema



hive> SHOW DATABASES;


hive > CREATE DATABASE ordersdb;


hive> SHOW DATABASES;


hive> CREATE TABLE IF NOT EXISTS brands(id INT, name STRING);

hive> INSERT INTO brands(id,name) values(1, 'Apple');

hive>  insert into brands(id,name) values (3, 'Samsung'), (2, 'Google');

hive> SELECT * from brands;

hive>  DROP TABLE BRANDS;

hive >  DROP DATABASE ordersdb;

```


```

create table test(id int ,name string ) clustered by (id) into 2 buckets stored as orc TBLPROPERTIES('transactional'='true');

INSERT INTO test(id,name) values(1, 'Apple');
 SELECT * from test;

update test set name='Google' where id=1;

 SELECT * from test;
 
 delete from test;
 
 SELECT * from test;
 
 ```


