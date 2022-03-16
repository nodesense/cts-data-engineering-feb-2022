
If Ubuntu doesn't connect internet 

```
su root
```
# Don't you hate when you need to root to fix dumb issues?
```
service network-manager stop
rm /var/lib/NetworkManager/NetworkManager.state
service network-manager start
reboot -h now

```

reference... 
help URL-- > https://gist.github.com/micrypt/1207324