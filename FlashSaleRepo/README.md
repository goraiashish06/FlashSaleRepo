# FlashSaleRepo
Repository created for the falsh sale design
Flash Sales

Configuration
    src/main/java/com/sale/flashsale/config/AppConfig.java
    
Java properties file in src/main/resources/config/flashsale.properties.


    h2 url => db.url. Default db name is flashsale, and this has to be created before running tests.
    h2 username => sa
    h2 password => 

API

This library contains two public facing APIs:

    Internal API is at com.sale.flashsale.controller.FlashSaleInternalController. This is not to be exposed outside.
    Internal Endpoints: /createflashsale, /stopflashsale,  /stopflashsale
    
    External API is at com.sale.flashsale.controller.FlashSaleController.
    External Endpoints:/register, /sale
    


We have made some assumptions:

    A flashsale holds only 1 product
    Buyer can only register if the flashsale is not running
    flashsale is started/stopped manually
    Purchase limit per buyer per flashsale is 1
    Payment is not implemented
