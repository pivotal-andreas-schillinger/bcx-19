#1 Register Asset-Communication Package
    https://accounts.bosch-iot-suite.com/subscriptions
#2 Claim Device and copy Things Id
#3 Copy IoT Things Api Token
#4 Create IoT Permissions Service Binding
##4.1 Login to Permissions Dashboard
    https://permissions.s-apps.de1.bosch-iot-cloud.com/service-ui/users
##4.2 Create Technical User
###4.2.1 Copy User Id and Tenant Name
###4.2.2 Logout from Permissions
###4.2.3 Login to Permissions with Technical User
###4.2.4 Change password as prompted
#5 Add credentials to DemoApplication.java

#6 Login to Bosch IoT Cloud (BIC) via cf cli
    cf login -a api.sys.de1.bosch-iot-cloud.com
#7 Push demo application to BIC
#8 Click on App Route to see Things Json in Browser


# Docu Things Java SDK:
    https://things.eu-1.bosch-iot-suite.com/dokuwiki/doku.php?id=dev_guide:java_api:start
