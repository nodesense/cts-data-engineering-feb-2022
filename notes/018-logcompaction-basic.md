## Log compaction 

Under development

Messages in kafka 
 Facts - no changes are needed
    Weather Data 
    Meter Data 

    If sensor producting, continouse messages are generated 

Settings/configurations msg 

AC   - 18 Deg C, FAN mode on, swing on 
Fan  - speed level - 4, FAN is off 
Light - Light off or on 

1 Kafka Message, AC1.Status [Kafka Key] = Off 
1 Kafka Message, AC1.Status [Kafka Key] = On
1 Kafka Message, AC1.Swing [Kafka Key] =  On
1 Kafka Message, AC1.FAN [Kafka Key] =  4
1 Kafka Message, AC1.Temp [Kafka Key] =  18

1 Kafka Message, AC1.Status [Kafka Key] = Off
1 Kafka Message, AC1.Swing [Kafka Key] =  Off
1 Kafka Message, AC1.FAN [Kafka Key] =  1


cleanup policy 
                delete - it will delete the message after retention period 
                compact - IT will keep the last known keys with values, remove
                           the older keys , it won't delete all data, instead 
                           retain last known keys 

Result of compaction 
                1 Kafka Message, AC1.Temp [Kafka Key] =  18
                1 Kafka Message, AC1.Status [Kafka Key] = Off
                1 Kafka Message, AC1.Swing [Kafka Key] =  Off
                1 Kafka Message, AC1.FAN [Kafka Key] =  1


kafka-console-producer --broker-list localhost:9092 --topic settings1 --property "parse.key=true" --property "key.separator=:"

 Occurs 
 welcome