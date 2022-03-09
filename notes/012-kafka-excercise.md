
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

execute shall reset the offsets

```
kafka-consumer-groups --bootstrap-server localhost:9092  --group order-book-console-consumer --reset-offsets --to-earliest --execute --topic order-book
```