**setup azure storage with docker :**

https://hub.docker.com/r/microsoft/azure-storage-azurite

**pull & run docker image:**

docker run -p 10000:10000 -p 10001:10001 -p 10002:10002 mcr.microsoft.com/azure-storage/azurite

**download microsoft azure storage explorer :**

https://learn.microsoft.com/en-us/azure/storage/common/storage-use-emulator

**Create queue in azure storage explorer**

created queue name local

![image](https://github.com/user-attachments/assets/bebd3a9a-9600-495a-9f69-298a40a589a0)

**below config are required for our sping boot application**

**queue endpoint**

![image](https://github.com/user-attachments/assets/b20d7fbb-3243-40cf-b2c1-91dee67bc0e2)


**SAS Token:**

right click -> get shared access signature

![image](https://github.com/user-attachments/assets/17db208b-4662-410c-b1de-3638c57f64da)

check all permissions & click on create

![image](https://github.com/user-attachments/assets/e3b3fcd1-06a9-4420-8094-930efb008c1c)


**Through API endpoint send message to azure storage queue**

![image](https://github.com/user-attachments/assets/f498ddd0-f80f-470f-8672-ed42f2e6c579)


**message at azure storage queue:**

![image](https://github.com/user-attachments/assets/e0ff69ed-d392-4e56-ba0b-d274ebc7384e)

**message received at application side by scheduler:**

![image](https://github.com/user-attachments/assets/5e50ad9b-dd3b-40f6-8716-85810194595c)

