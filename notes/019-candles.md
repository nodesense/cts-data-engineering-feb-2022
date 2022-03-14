
Tick - input/json

Timestamp - milliseconds 
symbol - TSLA
price - 10 USD 
volume - 20

timestamp             symbol      price   volume
March 14, 13:30:01       TSLA     10.5      40       -- OPEN
March 14, 13:30:14       TSLA     11    50       -- HIGH
March 14, 13:30:34       TSLA     9.95      20   -- LOW
March 14, 13:30:58       TSLA     10.75    10      -- CLOSE


---
Output : candle/json format 

traded_value = 10 * 20 + 10.5 * 50 + 11 * 40 = 1165

525 + 200 + 440

1 minute window 

  Timestamp              symbol       volume         traded_value  open  low  high  close 
March 14, 13:30:00      TSLA            110               1165  

