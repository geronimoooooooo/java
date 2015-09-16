http://stackoverflow.com/questions/16377754/parse-json-file-using-gson
http://stackoverflow.com/questions/20152710/gson-get-json-value-from-string
http://www.javacreed.com/simple-gson-example/

		Gson gson = new Gson();
		JsonObject jobj = gson.fromJson(jsonText, JsonObject.class);
					
		String description_Value = jobj.get("content").getAsJsonObject().get("description").getAsString();
		JsonArray jarr = jobj.get("content").getAsJsonObject().get("keywords").getAsJsonArray();
				
		ArrayList<String> list_keywords = new ArrayList<String>();
		list_keywords = gson.fromJson(jarr.toString(), ArrayList.class);
		
		ObservedProperty [] obser =new Gson().fromJson(jobj.get("content").getAsJsonObject().get("observedProperties"), ObservedProperty[].class);
		String xyz= jobj.get("content").getAsJsonObject().get("observedProperties").getAsJsonArray().get(0).getAsJsonObject().get("observedPropertyName").getAsString();
		
		ObservedProperty ob =new Gson().fromJson(jobj.get("content").getAsJsonObject().get("observedProperties").getAsJsonArray().get(1), ObservedProperty.class);

    
{
	"id": "Fellbachquelle",
	"content":{
		"description": "this is the description",
		"keywords": ["weather","hydrology","gauge"],
		"observedProperties":[
			{			
				"observedPropertyName" = "Temperatur",
				"observedPropertyNameHref"="http://..",
				"quality_text_value" = "here ist quality value",
				"uomTitle" = "title1"
			},
			{
				"observedPropertyName" = "Wasserpegel",
				"observedPropertyNameHref"="http://..",
				"quality_text_value" = "here ist quality value",
				"uomTitle" = "title2"
			}
		]
	}	
}
package tstp;
import com.google.gson.annotations.SerializedName;
/**
 * This class is used to store data regarding ObservedProperties.
 *
 */
public class ObservedProperty {
	
	public String observedPropertyName;
	public String name = "";
	public String name_href = "";
	public String quantityDefinition_nameURL = "";
	public String uom_code = "";
	public String uom_href = "";
	@SerializedName("uomTitle")
	public String uom_title = "";
	public String quality_href = "";
	public String quality_text_value = "";
	
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
PRETTYPRINTING!!!!
jsonText = TextFiles.readTextFileWithServletsAsStream_UTF8("insert_observation_services/"+s);
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	JsonParser jp = new JsonParser();
	JsonElement je = jp.parse(jsonText);
	String prettyJsonString = gson.toJson(je);
	System.out.println(prettyJsonString);
----------------------------------------------------------------------------------------------
