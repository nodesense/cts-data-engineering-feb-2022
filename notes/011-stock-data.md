
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

## Daily Data


Open Terminal 


```

cd ~/Downloads

cd StockData

hdfs dfs -put StockIntraDay-2021-2022/    /raw

```

Check folder size after uploading content

```
hdfs dfs -dus /raw
```


Check folder size after  converting to parquet format

```
hdfs dfs -dus /silver
```


