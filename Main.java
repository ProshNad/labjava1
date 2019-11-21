package com.company;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {



    public static void main(String[] args) throws IOException {
	// write your code here
        FileReader fw = new FileReader( "C:\\D\\IdeaProjects\\labjava1\\src\\com\\company\\config.json" );

        JsonObject object = Json.parse(fw).asObject();
        JsonArray brackets = object.get("bracket").asArray();
        fw.close();
        JsonObject b = Json.parse(brackets.get(0).toString()).asObject();
        String b1 = b.get("left").asString();

        System.out.println(b1);
        System.out.println(brackets.toString());
        System.out.println(Braket.findBrakets(b1,brackets)[0]);
        System.out.println(Braket.findBrakets(b1,brackets)[1]);


        FileReader fr = new FileReader( "C:\\D\\IdeaProjects\\labjava1\\src\\com\\company\\input.txt" );
        Scanner scan = new Scanner(fr);
        String inputstr="";
        while (scan.hasNextLine()) {
            inputstr=inputstr+scan.nextLine();
        }
        fr.close();
        System.out.println(inputstr);
        ArrayList<String> buf = new ArrayList<>();
        ArrayList<Integer> ind = new ArrayList<>();

        for(int i=0;i<inputstr.length();i++){
            String now = String.valueOf(inputstr.charAt(i));
            String[] res = Braket.findBrakets(String.valueOf(now),brackets);
            if(!"none".equals(res[1])){
                System.out.println(now);
                if((buf.size()!=0)&&(buf.indexOf(res[0])==buf.size()-1)&&((res[1].equals("right"))||(res[1].equals("any")))){
                    buf.remove(buf.size()-1);
                    ind.remove(ind.size()-1);
                }else{
                    buf.add(now);
                    ind.add(i);
                }
            }
        }

        System.out.println("Somthig go wrong in this positions:"+ind.toString());
        System.out.println(buf.toString());




    }



}
