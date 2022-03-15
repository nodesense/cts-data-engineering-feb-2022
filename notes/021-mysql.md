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

password is team1234






