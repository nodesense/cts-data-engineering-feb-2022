If name node or other services down..

```
stop-all.sh
```

```
sudo rm  -rf /data/hdfs
```

```
sudo mkdir /data/hdfs
```

```
sudo chmod 777 -R  /data/hdfs
```

```
ssh localhost


hdfs namenode -format


start-all.sh


jps 
```
