http://stackoverflow.com/questions/16377754/parse-json-file-using-gson
http://stackoverflow.com/questions/20152710/gson-get-json-value-from-string
http://www.javacreed.com/simple-gson-example/

Gson gson = new Gson();
JsonObject jobj = gson.fromJson(jsonText, JsonObject.class);
String description_Value=jobj.get("content").getAsJsonObject().get("description").getAsString();

{
	"id": "Fellbachquelle",
	"content":{
		"description": "this is the description",
		"key2": "value2",
		"key3": "value3"
	}	
}
----------------------------------------------------------------------------------------------
{
     "waypoints" : {
              "ship": { 
             "first_type": [[0,0],[5,7],[2,8],[4,4],[10,10],[12,0],[0,12],[12,8],[8,8]]                          
             },
              "boat": { 
                       "first_type": [[0,0],[5,7],[2,8],[4,4],[10,10],[12,0],[0,12],[12,8],[8,8]]                            
                       }
              }
   }
JsonArray types = map_json
    .getAsJsonObject("waypoints")
    .getAsJsonObject("ship")
    .getAsJsonArray("first_type";

for(final JsonElement type : types) {
    final JsonArray coords = type.getAsJsonArray():
}
----------------------------------------------------------------------------------------------
List<MyModel> myModelList = gson.fromJson(jsonArray.toString(), listType);
----------------------------------------------------------------------------------------------
double result = jobj.get("test").getAsDouble();
----------------------------------------------------------------------------------------------
