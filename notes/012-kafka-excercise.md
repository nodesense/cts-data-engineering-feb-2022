
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