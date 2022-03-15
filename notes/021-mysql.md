# MysqL Setup

Source:  https://phoenixnap.com/kb/install-mysql-ubuntu-20-04

```
sudo apt update
```

```
sudo apt upgrade
```

### MySQL Server

```
sudo apt install mysql-server
```

### MySQL Cli

```
sudo apt install mysql-client
```

Is Mysql Installed?

```
mysql --version
```

```
exit
```

on bash/shell

```
sudo mysql_secure_installation
```

Low 

passsword: team1234

Say no for rest of the questions


```
sudo systemctl status mysql
```

Press q to exit


Now login into mysql as root user


```
sudo mysql -u root
```

 


```
mysql> create database testdb;
```
Query OK, 1 row affected (0.01 sec)

```
mysql> use testdb;
```
Database changed
```
mysql> create table test(id int);
```
Query OK, 0 rows affected (0.02 sec)
```
mysql> insert into test values (1);
```
Query OK, 1 row affected (0.01 sec)
```
mysql> insert into test values (2);
```
Query OK, 1 row affected (0.00 sec)

```
mysql> select  * from test;

```

+------+
| id   |
+------+
|    1 |
|    2 |
+------+
2 rows in set (0.00 sec)





