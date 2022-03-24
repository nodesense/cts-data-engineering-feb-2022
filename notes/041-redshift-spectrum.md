# link Glue CataLog

Linking Glue database with redshift spectrum.. we have to create an external schema
in redshift, that points to glue database, we have mention the role we have 
created to access the glue catalog through redshift spectrum.


Syntax

```sql
create external schema if not exists <<schema_name>>
from data catalog
database '<<gluecatalogdbname>>'
region 'us-east-2' 
iam_role 'arn:aws:iam::418688292996:role/TRAINING_REDSHIFT_ROLE';
```

Example

```sql

create external schema if not exists gk_schema
from data catalog
database 'gk_db'
region 'us-east-2' 
iam_role 'arn:aws:iam::418688292996:role/TRAINING_REDSHIFT_ROLE';
```

now PostgreSQL shall have schema called gk_schema created, which can be accessible
from left side of query editor..

Below query runs on RedShift Spectrum which runs query on S3 Data Lake

```sql
SELECT * FROM gk_schema.movies
```