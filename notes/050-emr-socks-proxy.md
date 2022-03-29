
# Runs socks proxy

in gitbash where your pem file found

```
 ssh -i yourname.pem -N -D 8157 hadoop@ec2-3-11-111-99.us-east-2.compute.amazonaws.com
```

# steps to install FoxyProxy

```

1. Install Firefox

2. Open Firefox, google for FoxyProxy

3. Install FoxyProxy plugins

4. Look at the Orange fox like icon on top right of the firebox address bar 

5. click Open FoxyProxy icon, then click on Options button

6. Click on + Add button 

7. Set Title to emr

8. Set Proxy Type to SOCKS5

9. Set Proxy IP Address to 127.0.0.1

10. Set Port to 8157

11. Click Save Button

12. On the List, Click on Patterns button for emr

13. Click on Add button

14. Now you can see two list items shown with wildcard access with *.

    14.1  Replace first Pattern * with *ec2*.amazonaws.com* 

    14.2  Replace second pattern * with  *10*.amazonaws.com* 


15. Click Save Button

16. On the FoxyProxy Icon shown on the right of the address bar, click on Foxy icon, select "emr"

17. Now Foxy Icon shown with emr text, this means socks proxy activated

18. Now reference Amazon EMR cluster urls, try to copy and work with firefox


```

# Access EMR Portals

Open below url in Firefox.

```
zepplin 

http://ec2-3-11-111-111.us-east-2.compute.amazonaws.com:8890/	

HDFS 
http://ec2-3-111-111-111.us-east-2.compute.amazonaws.com:9870/	

```
