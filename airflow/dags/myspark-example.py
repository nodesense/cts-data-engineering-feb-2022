from datetime import datetime

from airflow.models import DAG
from airflow.providers.apache.spark.operators.spark_jdbc import SparkJDBCOperator
from airflow.providers.apache.spark.operators.spark_sql import SparkSqlOperator
from airflow.providers.apache.spark.operators.spark_submit import SparkSubmitOperator

# schedule_interval=None,
    
with DAG(
    dag_id='myspark_example_dag',
    start_date=datetime(2021, 1, 1),
    schedule_interval='*/5 * * * *',
    catchup=False,
    tags=['spark_example'],
) as dag:
    # [START howto_operator_spark_submit]
    submit_job1 = SparkSubmitOperator(
        application="/home/ubuntu/airflow/examples/spark-example1.py", task_id="submit_job1"
    )
    # [END howto_operator_spark_submit]
 
    submit_job2 = SparkSubmitOperator(
        application="/home/ubuntu/airflow/examples/spark-example1.py", task_id="submit_job2"
    )


    submit_job1 >> submit_job2
