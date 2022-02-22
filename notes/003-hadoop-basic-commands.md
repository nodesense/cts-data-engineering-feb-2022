---
title: "Hadoop Commands"
date: "2020-10-10"
excerpt: "Hadoop Commands"
---

## Hadoop Freq Used Commands


to start the hadoop local cluster

```bash
$HADOOP_HOME/sbin/start-all.sh
```


to stop the hadoop local cluster

```bash
$HADOOP_HOME/sbin/stop-all.sh
```

to know what are the Hadoop services running

```bash
jps
```


to list the files and directories in hadoop root directory /

```
hdfs dfs -ls /
```

to create a directory in hdfs

```
hdfs dfs -mkdir /test
```

To create empty file,

```
hdfs dfs -touchz /test/welcome.txt
```

Check if welcome.txt created or not

```
 hdfs dfs -ls /test
``` 

To copy from local folder to HDFS 

to create a file in local folder, 

```
touch employees.csv

echo "John,40,M" >> employees.csv
echo "Mary,30,F" >> employees.csv
```

to put the file into HDFS

```
hdfs dfs -copyFromLocal ./employees.csv /test
``` 


Or use put command too

```
hdfs dfs -put ./employees.csv /test
``` 

to print or display content of the file

```
hdfs dfs -cat /test/employees.csv
```


to copy the files from hadoop to local directory/system

```
hdfs dfs -copyToLocal /test/employees.csv ./employees2.csv
```

or use get command

```
hdfs dfs -get /test/employees.csv ./employees3.csv
```

Moving file from local to Hadoop [source shall be removed afterwards]

```
touch sourcefile.txt
echo "greeting" >> sourcefile.txt
```

```
hdfs dfs -moveFromLocal ./sourcefile.txt /test
```

```
hdfs dfs -ls /test
```

## Handle files within HDFS

Copy files/directory from hdfs to hdfs 

```
hdfs dfs -cp /test /test2 
```

Move files/directory from hdfs to hdfs

```
hdfs dfs -mv /test2 /test3
```


### Delete files

```
hdfs dfs -rmr /test3/sourcefile.txt
```

or to delete all files and directory too

```
hdfs dfs -rmr /test3
```

### utility commands

To check disk usage on each file in given directory

```
hdfs dfs -du /test
```

Total size of file/directory 

```
hdfs dfs -dus /test
```

To get last modified information 

```
hdfs dfs -stat /test/employees.csv

hdfs dfs -stat /test
```

To set replication factor for a particular file, beyound default settings in core-site.xml

```
hdfs -setrep -R -w 4 /test/employees.csv
hdfs -setrep -R -w 4 /test
```

- -R means recursive
- -w means wait until all files are replicated


### HDFS Blocks specific commands

```
hdfs fsck / -files -blocks
```


## Excercises

create a file called in local system

touch stocks.csv

use nano or echo to  create file, update the content as shown below
```
product_code,quantity
10000, 1000
10010, 100
```

-- In hadoop

Create a directory called /inventory

upload stacks.csv to hadoop inventory directory

get the whole file using get or copyToLocal

List inventory directory in hadoop

delete the file from inventory 