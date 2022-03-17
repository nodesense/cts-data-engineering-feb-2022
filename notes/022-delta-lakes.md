## Delta lake



all the employees to be added as they join
when employee get promotion, his/her record to be updated
when employee leave org, the record should be deleted
csv format - our understanding, delta lake uses parquet
we can only insert files, we cannot delete file, we cannot modify/update existing file

_delta_logs
    journal that contains audit related info, who, when the content is addded as json file

file1.csv
    name     role         
    Joe     Engineer      
    Jane    Manager        
add file1.csv to emp directory, now new file shall be generated in _detal_logs 
    _delta_logs 
            0000000000001.json
                add, file1.csv, 2 records.. meta data, file size size etc

SELECT * FROM employees  - count/results - 2

new person joined, add new file

file2.csv
    name     role         
    Fox      DBAdmin      

Add file2.csv to emp directory,  now new file shall be generated in _detal_logs 

    _delta_logs 
            0000000000001.json
                add, file1.csv, 2 records.. meta data, file size size etc
            0000000000002.json
                add, file2.csv 1  record, file size tc

SELECT * FROM employees  - count/results - 3

Joe is promited as Senior Engineer, but we can't update

UPDATE employees set role = 'Senior Engineer' where name = 'Joe'

Now spark will where are the files where name = 'Joe'
    file1.csv has Joe record
        now spark has to remove/update Joe from file1.csv but it cannot
        spark will generate new file file3.csv, 
        new file will contain Joe with Senior Engineer role
        plus also bring Jane records into file3.csv as it is

file3.csv
      name     role         
     Joe     Senior Engineer
     Jane    Manager


Add file3.csv to emp directory,  now new file shall be generated in _detal_logs 
 

    _delta_logs 
            0000000000001.json
                add, file1.csv, 2 records.. meta data, file size size etc
            0000000000002.json
                add, file2.csv 1  record, file size tc
            0000000000003.json
                add, file3.csv 2  record, file size tc
                remove file1.csv

SELECT * FROM employees  - count/results - 3


Jane left the company, her record to be deleted.. but we cannot delete the record
    Now Jane and Joe both are repersented in file3.csv as file1.csv marked for deletion

DELETE from employees WHERE name =   'Jane'
    Spark will check in file2.csv, file3.csv where if Jane present, file3.csv has Jane
    but file3.csv has Joe record

    it will create file4.csv, insert Joe record into file4.csv , leave the Jane record
        file4.csv 

        name    role
        Joe    Senior Engineer


    _delta_logs 
            0000000000001.json
                add, file1.csv, 2 records.. meta data, file size size etc
            0000000000002.json
                add, file2.csv 1  record, file size tc
            0000000000003.json
                add, file3.csv 2  record, file size tc
                remove file1.csv
            0000000000004.json
                add, file4.csv  1  record, file size tc [only joe record]
                remove file3.csv
            
SELECT * FROM employees [2 results], Fox, Joe
         
         file2.csv
         file4.csv

Final state, where directory will have file1.csv, file2.csv, file3.csv
When we do select statement, 
spakr will check _delta_logs what are the data files to taken for query
    file1.csv - removed from query execution
    file2.csv
    file3.csv

    SELECT st only query file2.csv, file3.csv
directory/employees
    _delta_logs

    file1.csv -- not used for query
    file2.csv
    file3.csv - not used for query
    file4.csv

    _delta_logs 
            0000000000001.json
                add, file1.csv, 2 records.. meta data, file size size etc
            0000000000002.json
                add, file2.csv 1  record, file size tc
            0000000000003.json
                add, file3.csv 2  record, file size tc [promotion, Joe, Jane]
                remove file1.csv
            0000000000004.json
                add, file4.csv  1  record, file size tc [only joe record]
                remove file3.csv

The Files marked for deletion, can be released from system later using 
VACCUM command


We have INSERT, DELETE, UPDATE all done on data lake, without using any LOCK