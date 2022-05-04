
```
wget https://dlcdn.apache.org/spark/spark-3.1.3/spark-3.1.3-bin-hadoop2.7.tgz

tar xf spark-3.1.3-bin-hadoop2.7.tgz

sudo mv spark-3.1.3-bin-hadoop2.7 /opt

sudo chmod 777 /opt/spark-3.1.3-bin-hadoop2.7
```

```
nano ~/.bashrc
```

Now comment out # spark-2.4.7-bin-hadoop2.7 export statement in bashrc file

```
#export SPARK_HOME=/opt/spark-2.4.7-bin-hadoop2.7
#export PATH=\$PATH:\$SPARK_HOME/bin
```

Ctrl + O to write the file, followed by ENTER key

Ctrl + X to exit nano editor

```
echo "export SPARK_HOME=/opt/spark-3.1.3-bin-hadoop2.7" >> ~/.bashrc
echo "export PATH=\$PATH:\$SPARK_HOME/bin" >>  ~/.bashrc
```

Install findspark

```
pip install findspark
```

close the terminal

Then open Jupyter, test all settings good
