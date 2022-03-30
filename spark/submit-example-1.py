# https://github.com/nodesense/cts-aws-spark-april-2021/blob/main/notebooks/DFJoin.ipynb

"""
open terminal
cd workshop
cd spark

spark-submit  submit-example-1.py

"""
import sys
import findspark 
findspark.init()

from pyspark.conf import SparkConf
config = SparkConf()
config.setMaster("spark://192.168.80.128:7077").setAppName("DFJoin")
config.set("spark.executor.memory", "4g")
config.set("spark.executor.cores", 2)
config.set("spark.cores.max", 2)
config.set("spark.driver.memory", "4g")

from pyspark.sql import SparkSession
spark = SparkSession.builder.config(conf=config).getOrCreate()

products = [ 
          # (product_id, product_name, brand_id)  
         (1, 'iPhone', 100),
         (2, 'Galaxy', 200),
         (3, 'Redme', 300), # orphan record, no matching brand
         (4, 'Pixel', 400),
]

brands = [
    #(brand_id, brand_name)
    (100, "Apple"),
    (200, "Samsung"),
    (400, "Google"),
    (500, "Sony"), # no matching products
]
 
productDf = spark.createDataFrame(data=products, schema=["product_id", "product_name", "brand_id"])
brandDf = spark.createDataFrame(data=brands, schema=["brand_id", "brand_name"])
productDf.show()
brandDf.show()

# Inner Join
# productDf is left
# brandDf is right
# select/pick only matching record, discord if no matches found
productDf.join(brandDf, productDf["brand_id"] ==  brandDf["brand_id"], "inner").show()

