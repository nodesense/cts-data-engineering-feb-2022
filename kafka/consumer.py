from confluent_kafka import Consumer


c = Consumer({
    'bootstrap.servers': 'localhost:9092',
    'group.id': 'mygroup2',
    'auto.offset.reset': 'earliest'
})

c.subscribe(['test'])

while True:
    # read data from broker if any for 1 second time
    msg = c.poll(1.0)

    if msg is None:
        continue
    if msg.error():
        print("Consumer error: {}".format(msg.error()))
        continue

    
    print('Received message: {}'.format(msg.value().decode('utf-8')))

c.close()