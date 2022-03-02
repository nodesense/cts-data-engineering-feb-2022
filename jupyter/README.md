## Jupyter on Linux

Open terminal

Only first time 

```
mkdir workshop
mkdir workshop/pyspark-notebooks

pip install findspark
```

#### Setup Scala Support


```
pip install spylon-kernel
python -m spylon_kernel install --user
```

--------------------------------
## Start jupyter on every day basis

Open Terminal in Ubuntu

```
cd workshop
```

Start jupyter on all ip address

```
jupyter lab --ip=*
```

Now copy the url printed in notebook including token

on the windows chrome browser, paste the link to open jupter notebooks
