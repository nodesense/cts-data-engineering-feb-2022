```
sudo apt update

sudo apt upgrade
 
sudo apt install openjdk-8-jdk curl wget jq -y
```

# Kafka part

```
wget http://packages.confluent.io/archive/5.5/confluent-5.5.5-2.12.tar.gz

tar xf confluent-5.5.5-2.12.tar.gz

sudo mv confluent-5.5.5 /opt

sudo chmod 777 /opt/confluent-5.5.5
```

# MySQL JDBC for Kafka 

```
wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.1.47.tar.gz

tar xf mysql-connector-java-5.1.47.tar.gz
cp mysql-connector-java-5.1.47/*.jar /opt/confluent-5.5.5/share/java/kafka-connect-jdbc

```

```
echo "export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64" >> ~/.bashrc
echo "export JRE_HOME=/usr/lib/jvm/java-8-openjdk-amd64" >> ~/.bashrc 


echo "export KAFKA_HOME=/opt/confluent-5.5.5" >> ~/.bashrc
echo "export PATH=\$PATH:\$KAFKA_HOME/bin" >>  ~/.bashrc

```

```
confluent local start
```


we need to ensure that the hadoop-vm is accessible by name, also ip address

in linux terminal,

```
ping 192.168.11.218
```

```
ping hadoop-vm
```


guidance, use your initial to create topics..

gk-invoices


