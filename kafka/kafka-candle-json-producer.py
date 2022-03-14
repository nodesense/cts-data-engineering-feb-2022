# simulate real time candles 
#  columns: symbol, type: Buy | Sell, quantity: int, price: double, order_type: limit | market | sl

# kafka-topics  --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic stock-ticks
# kafka-console-consumer --bootstrap-server localhost:9092 --topic stock-ticks --from-beginning


# cd workshop/kafka
# python kafka-candle-json-producer.py

import random
import sectors
import datetime 
from confluent_kafka import Producer
import time
import json 

quantities = [10, 120, 30, 40, 50, 100]
symbols = [sector["Symbol"] for sector in sectors.get_sectors()]

DELAY = 10

SAMPLES =  1000
TOPIC = "stock-ticks"
   
def delivery_report(err, msg):
    """ Called once for each message produced to indicate delivery result.
        Triggered by poll() or flush(). """
    if err is not None:
        print('Message delivery failed: {}'.format(err))
    else:
        print('Message delivered to {} [{}]'.format(msg.topic(), msg.partition()))

# at very first producer shalll upload schema to schema registry

producer = Producer({'bootstrap.servers': 'localhost:9092'})


for i in range(SAMPLES):
    
    symbol = random.choice(symbols)
    volume = random.choice(quantities)

    price = float(random.randint(5, 50))
     
    order_time = datetime.datetime.now()
    timestamp = int(order_time.timestamp() * 1000)

    print(order_time, timestamp)

    value = { 
        "symbol": symbol,
        "volume": volume,
        "price": price,
        "timestamp": timestamp
    }

    key = str(timestamp).encode('utf-8')

    valueStr = json.dumps(value).encode('utf-8')

    print('valueStr ', valueStr)

    producer.produce(topic=TOPIC, value=valueStr, key=key)
    producer.flush()
    time.sleep(DELAY)
   