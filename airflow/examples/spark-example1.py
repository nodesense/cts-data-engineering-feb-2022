from pyspark.conf import SparkConf
config = SparkConf()
# config.set("property", "value")
config.setAppName("DataFrameBasic")

from pyspark.sql import SparkSession
# spark Session, entry point for Spark SQL, DataFrame
spark = SparkSession.builder\
                    .config(conf=config)\
                    .getOrCreate()

sc = spark.sparkContext

products = [
    # (product_id, product_name, price, brand_id, offer)
    (1, 'iPhone', 1000.0, 100, 0),
    (2, 'Galaxy', 545.50, 101, None),
    (3, 'Pixel', 645.99, 101, None)
]

# no data type mentioned, however we will let spark to infer schema by reading data
schema = ['product_id', 'product_name', 'price', 'brand_id', 'offer']

productDf = spark.createDataFrame(data=products, schema=schema)

# every data frame has schema, we can print it
productDf.printSchema()
# ASCII FORMAT
productDf.show() # 20 records

