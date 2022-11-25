# call_billing

# Step 1: 
Please wait about 6 minutes because we embed the full environment (maven,..)
</br>
Please run command in call_billing folder. (cd call_billing)
</br>
run command : docker build -t call_billing .

# Step 2:
run command: docker run -p 8080:8080 call_billing

# Step 3:
access: http://127.0.0.1:8080/swagger-ui.html

# Step 4:
Test
</br>
#NOTE:
I used free MySQL DB . So if you have a DB problem. You can change config values in application-dev.yml and run sql script in sql folder! (the detail in below the  image) , then please rebuild docker
</br>

[image](https://user-images.githubusercontent.com/26063810/203938523-81487a97-131a-47ef-9b3e-954da1054381.png)
 
