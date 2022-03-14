```
Step 1

 Date + Time [scala/spark]  with new column ("TimeHour")
2022-03-13 9:17             ==> 2022-03-13 9:00
2022-03-13 9:18             ==> 2022-03-13 9:00
2022-03-13 9:32             ==> 2022-03-13 9:00

Step 2: Use Step 1 as Input

Df2 = df.groupBy("symbol", "TimeHour")
    .agg (sum("volume"))

Timestamp                       Symbol        Volume 
2022-03-13 9:00    TSLA  100000000
2022-03-13 10:00  TSLA  100001000
2022-03-13 10:00 TSLA  100003000


Step 3: Use Step 2 as Input

Volume Gain - Lead/Lag/window 
Then you can diff beteen volume , then you can claculate GainP

Timestamp         Symbol        Volume[Optional]      VolumeGain    VolumeGainP
2022-03-13 10:00  TSLA          100001000               1000         1000/100001000=


```