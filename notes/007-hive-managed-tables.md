## Hive Managed Tables

Managed table means,

1. Hive meta data server to contain table, column names, location in HDFS
2. Data stored in hadoop directory '/user/hive/warehouse' owned by hive user
3. Data manipulation like INSERT should done using HIVE Query , INSERT, CREATE TABLE AS 
4. Developers, ETL tools should not add/update/replace data in managed table ie '/user/hive/warehouse' locations

## Hive External Table

1. Hive meta data server to contain table, column names, location  in HDFS
2. Data stored in HDFS location, but 
3. Data not stord in hive warehouse directory, data not managed by HIVE
4. Data manipulation like insert, update , delete not done by HIVE
5. Data added to HDFS directory by ETL, or developers may upload data files directly into HDFS

