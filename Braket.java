package com.company;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;

public class Braket{

    public static String[] findBrakets(String br, JsonArray brackets){

        for(int i=0;i<brackets.size();i++){
            JsonObject bb = Json.parse(brackets.get(i).toString()).asObject();
            if((br.equals( bb.get("left").asString()))&&(br.equals( bb.get("right").asString()))){
                return new String[]{bb.get("right").asString(),"any"};
            }
            if (br.equals( bb.get("left").asString())){
                return new String[]{bb.get("right").asString(),"left"};
            }
            if (br.equals( bb.get("right").asString())){
                return new String[]{bb.get("left").asString(),"right"};
            }
        }

        return new String[]{"","none"};
    }

}
