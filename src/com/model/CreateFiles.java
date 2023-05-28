package com.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.beans.RealTweetStream;
import com.beans.TweetStream;

public class CreateFiles {

    public static String createFile(ArrayList<RealTweetStream> twitStreamList) {
    	String path="D:\\Shilpa\\ProjectGuru\\Twinkle\\twitter\\WebContent\\upload\\test_real.txt";
    	try{
            // Create new file
            
            //String path="D:\\a\\hi.txt";
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0;i<twitStreamList.size();i++){
            	// Write in file
            	String content = "\t"+twitStreamList.get(i).getTweetContent();
                bw.write(content);
                bw.append("\n");
            }

            
            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    	
    	return path;
    	
    }
    public static String createFile1(ArrayList<TweetStream> twitStreamList) {
    	String path="D:\\Shilpa\\ProjectGuru\\Twinkle\\twitter\\WebContent\\upload\\test_off.txt";
    	try{
            // Create new file
            
            //String path="D:\\a\\hi.txt";
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0;i<twitStreamList.size();i++){
            	// Write in file
            	String content = "\t"+twitStreamList.get(i).getTweet_content();
                bw.write(content);
                bw.append("\n");
            }

            
            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    	
    	return path;
    	
    }
}