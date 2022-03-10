# customers placing order for particular symbol
#  columns: symbol, type: Buy | Sell, quantity: int, price: double, order_type: limit | market | sl

# kafka-topics  --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic stock-orders
# kafka-avro-console-consumer --bootstrap-server localhost:9092 --topic stock-orders --from-beginning

import random
import sectors
import datetime 
from confluent_kafka import avro
from confluent_kafka.avro import AvroProducer
import time

types = ['Buy', 'Sell']
order_types = ['LIMIT', 'MARKET', 'SL']
quantities = [100, 500,1000, 2000]
symbols = [sector["Symbol"] for sector in sectors.get_sectors()]
DELAY = 10

print(symbols)

SAMPLES = 1000
ORDER_TOPIC = "stock-orders"

ORDER_SCHEMA_STR = """
{
   "namespace": "com.example",
   "name": "Order",
   "type": "record",
   "fields" : [
     {
       "name" : "symbol",
       "type" : "string"
     },
     {
       "name" : "customer_id",
       "type" : "string"
     },
     {
       "name" : "type",
       "type" : "string"
     },
     {
       "name" : "quantity",
       "type" : "int"
     },
       {
       "name" : "price",
       "type" : "double"
     },
     {
       "name" : "order_type",
       "type" : "string"
     },
     
     {
       "name" : "timestamp",
       "type" : "long"
     }
   ]
}
"""

KEY_SCHEMA_STR = """
{
   "namespace": "my.test",
   "name": "key",
   "type": "string"
}
"""

ORDER_SCHEMA = avro.loads(ORDER_SCHEMA_STR)
KEY_SCHEMA = avro.loads(KEY_SCHEMA_STR)


def delivery_report(err, msg):
    """ Called once for each message produced to indicate delivery result.
        Triggered by poll() or flush(). """
    if err is not None:
        print('Message delivery failed: {}'.format(err))
    else:
        print('Message delivered to {} [{}]'.format(msg.topic(), msg.partition()))

# at very first producer shalll upload schema to schema registry

avroProducer = AvroProducer({
    'bootstrap.servers': 'localhost:9092',
    'on_delivery': delivery_report,
    'schema.registry.url': 'http://localhost:8081'
    }, default_key_schema=KEY_SCHEMA, default_value_schema=ORDER_SCHEMA)


for i in range(SAMPLES):
    type = random.choice(types)
    order_type = random.choice(order_types)
    symbol = random.choice(symbols)

    quantity = random.choice(quantities)
    price = float(random.randint(5, 50))
    customer_id =  str(random.randint(1000, 1200))

    order_time = datetime.datetime.now()
    timestamp = int(order_time.timestamp() * 1000)

    print(order_time, timestamp)

    value = {
        "type": type,
        "order_type": order_type,
        "symbol": symbol,
        "quantity": quantity,
        "price": price,
        "timestamp": timestamp,
        "customer_id": customer_id
    }

    key = customer_id
 

    print('msg ', value)


    avroProducer.produce(topic=ORDER_TOPIC, value=value, key=key)
    avroProducer.flush()
    time.sleep(DELAY)
   