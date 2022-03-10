## KSQL Cli

To clear screen, Ctrl + L

To stop SELECT statement, Ctrl + C

```
ksql> SHOW TOPICS;
```

 Kafka Topic                 | Partitions | Partition Replicas 
---------------------------------------------------------------
 default_ksql_processing_log | 1          | 1                  
 sectors                     | 3          | 1                  
---------------------------------------------------------------
```
ksql> SHOW STREAMS;
```
 Stream Name         | Kafka Topic                 | Format 
------------------------------------------------------------
 KSQL_PROCESSING_LOG | default_ksql_processing_log | JSON   
------------------------------------------------------------
```
ksql> SHOW TABLES;
```

 Table Name | Kafka Topic | Format | Windowed 
----------------------------------------------
----------------------------------------------

```
ksql> CREATE STREAM SECTOR_STREAM(Symbol VARCHAR, Industry VARCHAR) WITH (KAFKA_TOPIC='sectors',VALUE_FORMAT='JSON');
```

 Message        
----------------
 Stream created 
----------------

```
ksql> SHOW STREAMS;
```

```
 Stream Name         | Kafka Topic                 | Format 
------------------------------------------------------------
 KSQL_PROCESSING_LOG | default_ksql_processing_log | JSON   
 SECTOR_STREAM       | sectors                     | JSON   
------------------------------------------------------------
 ```

```
ksql> SELECT * FROM SECTOR_STREAM EMIT CHANGES; 
```


Press CTRL-C to interrupt


on other temrinal, run 
```
cd workshop
cd kafka
python kafka-sector-publisher.py
```

check in KSQL, 
```
+-----------------------------+-----------------------------+-----------------------------+-----------------------------+
|ROWTIME                      |ROWKEY                       |SYMBOL                       |INDUSTRY                     |
+-----------------------------+-----------------------------+-----------------------------+-----------------------------+
|1646930736239                |AMBER                        |AMBER                        |CONSUMER GOODS               |
|1646930736239                |Symbol                       |Symbol                       |Industry                     |
|1646930736239                |ORIENTELEC                   |ORIENTELEC                   |CONSUMER GOODS               |
|1646930736239                |VGUARD                       |VGUARD                       |CONSUMER GOODS               |
```

---

By default, KSQL SELECT wait for latest messages, it don't read earliest messages, this is by setting..

```
ksql> SELECT * FROM SECTOR_STREAM EMIT CHANGES LIMIT 5;
```

```
ksql> LIST PROPERTIES;
```

```
ksql> SET 'auto.offset.reset'='earliest';
```
Successfully changed local property 'auto.offset.reset' to 'earliest'. Use the UNSET command to revert your change.
ksql> 


To list messages from topic

```
PRINT sectors  FROM BEGINNING LIMIT 10; 
```

```
ksql> CREATE TABLE SECTOR_TABLE (Symbol VARCHAR, Industry VARCHAR) WITH (KAFKA_TOPIC='sectors', VALUE_FORMAT='json');
```
 Message       
---------------
 Table created 
---------------

```
ksql> SHOW TABLES;
```

 Table Name   | Kafka Topic | Format | Windowed 
------------------------------------------------
 SECTOR_TABLE | sectors     | JSON   | false    
------------------------------------------------

```
ksql> SELECT * FROM SECTOR_TABLE EMIT CHANGES;
```




### CREATE STREAM FROM AVRO

```
CREATE STREAM ORDERS_STREAM (type VARCHAR, order_type VARCHAR, symbol VARCHAR, 
                            quantity INT, price DOUBLE, 
                            timestamp BIGINT, customer_id VARCHAR)
        WITH (KAFKA_TOPIC='stock-orders', 
              VALUE_FORMAT='avro',
              TIMESTAMP='timestamp'
        );
```

```
SELECT * FROM ORDERS_STREAM EMIT CHANGES LIMIT 1;
```



SELECT * FROM ORDERS_STREAM WHERE quantity <= 500  EMIT CHANGES;


SELECT symbol, quantity, price FROM ORDERS_STREAM EMIT CHANGES;


SELECT symbol, quantity, price, quantity * price as amount  FROM ORDERS_STREAM EMIT CHANGES;


To list persisted queries,

```
SHOW QUERIES;
```


```
SELECT symbol, COUNT(symbol), SUM(quantity), SUM(quantity * price) FROM ORDERS_STREAM  GROUP BY symbol EMIT CHANGES;

```


```
SELECT symbol, COUNT(symbol) as count, SUM(quantity) as quantity, SUM(quantity * price) as traded_value FROM ORDERS_STREAM GROUP BY symbol EMIT CHANGES;

```

## PERSISTED QUERIES

Persisted queries run inside kafka ksql server, the output of the 
persisted queries shall be published to kafka topic

Persisted queries starts with `CREATE STREAM <name> AS` or 
`CREATE TABLE <name> AS`, 


```
CREATE TABLE ORDERS_SUMMARY AS SELECT symbol, COUNT(symbol) as count, SUM(quantity) as quantity, SUM(quantity * price) as traded_value FROM ORDERS_STREAM GROUP BY symbol;

```
```
 Message                                     
---------------------------------------------
 Created query with ID CTAS_ORDERS_SUMMARY_0 
---------------------------------------------
ksql> 

```


```
SHOW TOPICS;
```

we should see ORDERS_SUMMARY topic..

```
SHOW TABLES;
```

we should see table ORDERS_SUMMARY


every persisted query shall run in background, to see them, 

we need to use

```sql
SHOW QUERIES;
```

to stop persisted queries, we need to use 

```sql
TERMINATE <query-id>
```

example

```sql
TERMINATE CTAS_ORDERS_SUMMARY_0;
```


## Join two streams

sectors stream has Industry, Symbol
JOIN WITH stock-orders has Symbol

Which how many orders placed per sector
How many quantities purchased per sector
How much money /value traded per sector

```
CREATE TABLE SECTOR_SUMMARY AS 
SELECT Industry, COUNT(ORDERS_STREAM.symbol) as count, SUM(quantity) as quantity, SUM(quantity * price) as traded_value FROM ORDERS_STREAM 
LEFT JOIN SECTOR_STREAM WITHIN 1 HOURS ON SECTOR_STREAM.Symbol  = ORDERS_STREAM.symbol
 GROUP BY Industry EMIT CHANGES;
```

```
SELECT * FROM SECTOR_SUMMARY EMIT CHANGES;
```


```
kafka-topics --describe  --bootstrap-server localhost:9092  --topic stock-orders

kafka-topics  --alter --bootstrap-server localhost:9092   --partitions 3 --topic stock-orders

kafka-topics --describe  --bootstrap-server localhost:9092  --topic stock-orders

```