Kafka 
    Why Kafka? 
    I can do streaming with socket programming, why I need kafka?
        with Kafka,
            consumer and producer are disconnected, have a broker in between
            publish message, consumed by multiple consumers
            multiple producer can publish messaegs, multiple consumer can subcribe/consume
            message persistance until retention period, consumer can re-read message
            fault tolerance, reliablity, high availablity, performance
            topic, partitios

    Producer to Broker, is it push architecture or pull architecture?
          push

    Consumer to Broker,  is it push architecture or pull architecture?
          pull

    What is called back-pressure, how kafka solve backpressure problem?
        consumer may have limitation/bottleneck with respect to how many messages it can handle at a moment

        broker never push message to consumer, so no pressure on consumer from broker
        consumer is pulling data from broker, as per its own scale. consumer read message from broker

    Why should we use Kafka infront of Apache Spark for streaming? Why not use Spark itself it handle DB, any external systems like social tweets, 3rd party systems?
        if the target system down, kafka broker  hold message in persist log system,
        so that failed target system can read message when the system is up

    What is KSQL?
        KSQL is streaming engine on top of KAfka Streams, KSTREAM and KTable,
        query message from kafka

    What is KTable?
        A change log from aggregation [sum, count, min, max etc] output, the changes in result /data is updated in change log stream

    In Spark, difference between Batch vs Stream?
        
