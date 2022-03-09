
create a kafka topic called 'order-book' with 3 partitions, 1 replica 

run a console producer with key and value pair to topic 'order-book'
key is stock symbol, value is quantity purchased

run the console consumer order-book for with a group 'order-book-console-consumer'

```
publish data, receive in consumer 
stop consumer 
publish data 
start consumer 
check the data not read by consumer are consumed by consumer or not
```


to list all consumers

```
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic  order-book
```

```
kafka-console-producer --broker-list localhost:9092 --topic order-book --property "parse.key=true" --property "key.separator=:"
```


```
kafka-consumer-groups --bootstrap-server localhost:9092 --list
```

to start consumer with specific group

```
kafka-console-consumer --bootstrap-server localhost:9092 --topic order-book --group order-book-console-consumer    --property print.key=true
```


to describe a specific group 

```
kafka-consumer-groups --bootstrap-server localhost:9092 --describe  --group order-book-console-consumer
```


dry run - print plan without resetitng offsets

```
kafka-consumer-groups --bootstrap-server localhost:9092  --group order-book-console-consumer --reset-offsets --to-earliest --dry-run --topic order-book
```

execute shall reset the offsets to earliest, begining of offset

```
kafka-consumer-groups --bootstrap-server localhost:9092  --group order-book-console-consumer --reset-offsets --to-earliest --execute --topic order-book
```



execute shall reset the offsets to latest, end of offset,
consumer shall read only new messages

```
kafka-consumer-groups --bootstrap-server localhost:9092  --group order-book-console-consumer --reset-offsets --to-latest --execute --topic order-book
```


## reset kafka consumer group offset to specific time onwards, 

like yesterday night 12:00 am, last week, month beginging etc

run the kafka-console-consumer to print timestamp

```
kafka-console-consumer --bootstrap-server localhost:9092 --topic order-book --group order-book-console-consumer    --property print.key=true  --property print.timestamp=true
````

To Reset offset based on timestamp

Copy the timestamp displayed by previous command, input the timestamp in below website,

https://currentmillis.com/ 

Refer UTC time

```
Example Date: Wed Mar 09 2022 10:42:45

 format for date : YYYY-MM-DDTHH:mm:SS.sss

 example format: 2022-03-09T17:00:00.000
  
 UTC Wed Mar 09 2022 15:42:45
          2022-03-09T15:42:45.000
```
 
```
kafka-consumer-groups --bootstrap-server localhost:9092  --group order-book-console-consumer  --reset-offsets --to-datetime 2022-03-09T17:00:00.000  --execute --topic order-book
```
