
package annotation;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import phrase.phrase;
import token.token;
import utils.forcedSpotlight;
import utils.spotlight;

 public  class entityAnnotation {

	public static void Annotation(ArrayList<phrase> phraseList){
		spotlight spot = new spotlight();
		Pattern posTags = Pattern.compile("NER");
		for(phrase ph : phraseList){
			String tempString = new String();

			for (token tk: ph.getPhraseToken()){
				tempString = tempString + tk.getValue() + " ";
			}
			JSONArray DBpEquivalent = spot.getDBLookup(tempString, "0.0");			
			try{
				
				JSONObject obj2 = (JSONObject) DBpEquivalent.get(0);
				ph.setUri(obj2.get("uri").toString());
			}

			catch (Exception e){
				//sometimes spotlight does not catch simple URI. 	
				if(posTags.matcher(ph.getPosTag()).find()){
					String uri = forcedSpotlight.getDbpEntity(tempString);
					if(!uri.equals("notFound")){
						ph.setUri(uri);
					}
				}
				continue;
			}
		}
	}
}
