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