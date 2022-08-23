# SaveDataCache
This service is very useful when saving data for a short time and then using it again in your application.

The service is created so that a person's data can be saved for 120 seconds and then deleted. 
It is very useful if a transaction is being carried out and this data needs to be consulted several times.

The highlight of this service is that it is very easy to add the type of data that needs to be added, 
so it is not a problem to add or change the data that needs to be saved.

The service receives the data to be saved in JSON format and an ID will be assigned to it, 
so that later with it the information that was previously saved can be retrieved.


Request to save data, endpoint (Method.POST) ==> http://localhost:8080/data/save

{
    "requestData" : {
        "name" : "Michael",
        "lastname" : "Light",
        "age" : "40",
        "nationality" : "argentina"
    }
}



You will get this Response:

{
    "id": "be5d9501-2297-49ca-b110-e095c085ae1d",
    "message": "To get the Data through from ID"
}


You must save the ID, because is necessary to get back the data saved.



Request to get data, endpoint (Method.GET) ==> http://localhost:8080/data/get/be5d9501-2297-49ca-b110-e095c085ae1d

You will get this Response: 

{
    "data": {
        "name": "Michael",
        "nationality": "argentina",
        "age": "40",
        "lastname": "Light"
    }
}

