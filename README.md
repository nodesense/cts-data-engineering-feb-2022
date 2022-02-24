## Remote Desktop Menu

Ctrl + Shift + Alt

## Ubuntu Services to start

Do whenever you restart ubuntu/window system restart/system start

Start hadoop cluster

```
ssh localhost

start-all.sh

jps 
```

Open new Terminal,

Start Meta Data Server for hive

```
cd $HIVE_HOME 

$HIVE_HOME/bin/hive --service metastore
```

Open new terminal, 

Start Hive Server 2 for JDBC, web etc

```
cd $HIVE_HOME
$HIVE_HOME/bin/hive --service hiveserver2 --hiveconf hive.server2.thrift.port=10000 --hiveconf hive.root.logger=INFO,console
```


## Run Hive Cli that connects to Meta Data Server

Open new Command prompt

```
cd $HIVE_HOME
```


```
$HIVE_HOME/bin/hive

```

To check Hive Server Web UI http://localhost:10002/

To Check HDFS Web UI http://localhost:50070

To check resource manager http://localhost:8088

## Jupyter on Windows

1. Windows Start, Type Miniconda, 
2. Open Miniconda command prompt
3. `cd \workshop`
4. `jupyter lab`



## Virtual Env


create venv

created files in venv 

run using python interpretter

used Python REPL -  READ EVAL PRINT LOOP

Notebooks - jupyter  - HTML notebook - interactive development

open miniconda from start menu

cd c:\workshop


conda install jupyterlab

    want to proceed? [y/n]  y

to start jupyter notebooks,

jupyter lab

the command above, start  a web server, which allows to write python code 
interactively in notebooks, runs on port 8888, need a token to work
