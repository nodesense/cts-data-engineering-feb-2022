
```
Download below dataset
```

https://github.com/nodesense/stocks/archive/refs/heads/main.zip


extract the files in Download director

open terminal

```
cd ~/Downloads
```


```
hdfs dfs -put stocks-main /stocks
```

```
hdfs dfs -ls   /stocks
```


```
hdfs dfs -ls   /stocks/sectors
```


```
hdfs dfs -ls   /stocks/daily
```