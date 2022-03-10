```
1. Read Sector CSV Files from sectors directory 
     files located here https://github.com/nodesense/stocks/tree/main/sectors
2. Load Each file using file (open function)
3.     for each line in CSV file, 
            parse the line using COMMA (,) string split function

              arr[0] - Company name
              arr[1] - Industry
              arr[2] Symbol
              arr[3] - Series
              arr[4] - ISIN

        then make a python dictionary with below attributes

        Company Name,	Industry,	Symbol,	Series,	ISIN Code
Amara Raja Batteries Ltd.,	AUTOMOBILE,	AMARAJABAT,	EQ,	INE885A01032
         company = {
             Company:  arr[0] 'Amara Raja Batteries Ltd.'
             Industry: ..
             Symbol: arr[2]
            Series : arr[3]
             ISIN: arr[4]
         }

         convert company dict into JSON STRING [json library, json.dumps]

         publish json string to kafka topic called "sectors" with 3 partitions
```