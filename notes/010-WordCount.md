## WordCount example 

# refer notebook for code example

```
touch words.txt

echo "   spark kafka  " >> words.txt
echo " kafka   spark pyspark " >> words.txt
echo "                " >> words.txt
echo "spark" >> words.txt
echo "" >> words.txt
echo "APACHE Kafka APache SParK " >> words.txt

cat words.txt

hdfs dfs -put words.txt /words.txt

hdfs dfs -ls /
```
