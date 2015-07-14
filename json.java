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
