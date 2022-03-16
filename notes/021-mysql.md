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



### Make mysql listen on all IP address to enable connect from windows

to find ip address, use

```
ip addr show
```


```
sudo nano /etc/mysql/mysql.conf.d/mysqld.cnf 
```

find comment out exisitng bind-address and mysqlx-bind-address
and  edit/add below settings

```
bind-address           = 0.0.0.0           
mysqlx-bind-address     = 0.0.0.0
```

Ctrl + O  and Enter key to save the file

Ctrl + X to exit


restart mysql 
```
sudo systemctl restart mysql
```

check if mysql working again

```
sudo systemctl status mysql
```

press q to exit


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


# Create user with all host access

```
sudo mysql -u root
```


```sql
use mysql;
SELECT user FROM user;

CREATE USER 'team'@'%' IDENTIFIED BY 'Team1234!';

GRANT ALL PRIVILEGES ON testdb.* TO 'team'@'%';

FLUSH PRIVILEGES;

 SELECT user FROM user;

```

to exist mysql prompt,

```sql
exit;
```

## FIXME: allow connection from windows


```
sudo mysql -u root
```


```sql
mysql> create database stockdb;
mysql> use stockdb;
```
  
```sql
CREATE TABLE stockdb.sectors(company VARCHAR(200), 
                            industry VARCHAR(200), 
                            symbol VARCHAR(200), 
                            series VARCHAR(200), 
                            isin VARCHAR(200)
                              );
``` 

```sql
exit;
```

## Assign permission to stockdb

```
sudo mysql -u root
```

```sql
use mysql;


GRANT ALL PRIVILEGES ON stockdb.* TO 'team'@'%';

FLUSH PRIVILEGES;


```


```
sudo mysql -u root
```


```sql
use stockdb;

SELECT * FROM sectors;
```