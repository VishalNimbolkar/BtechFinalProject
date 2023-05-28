package com.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

import com.beans.RealTweetStream;
import com.beans.TweetStream;

public class CreateArff2 {
	public static String createArffFile(ArrayList<TweetStream> twitStreamList){
		ArffSaver saver = new ArffSaver();
		String file="D:\\Shilpa\\ProjectGuru\\Twinkle\\twitter\\WebContent\\upload\\train_off3.arff";
		File f=new File(file);
		FastVector      atts;
	    FastVector      attsRel;
	    FastVector      attVals;
	    FastVector      attValsRel;
	    Instances       data;
	    Instances       dataRel;
	    double[]        vals;
	    double[]        valsRel;
	    int             i;

	    // 1. set up attributes
	    atts = new FastVector();	    
	    // - numeric
	    atts.addElement(new Attribute("spamclass", (FastVector)null));
	    atts.addElement(new Attribute("tweetcontent", (FastVector)null));
	    /*atts.addElement(new Attribute("twitid"));
	    atts.addElement(new Attribute("username", (FastVector)null));
	    atts.addElement(new Attribute("tweetcontent", (FastVector)null));
	    atts.addElement(new Attribute("createaccount"));
	    atts.addElement(new Attribute("followers"));
	    atts.addElement(new Attribute("followings"));
	    atts.addElement(new Attribute("userfavorite"));
	    atts.addElement(new Attribute("listed"));
	    atts.addElement(new Attribute("tweetcount"));
	    atts.addElement(new Attribute("retweetcount"));
	    atts.addElement(new Attribute("hashtagcount"));
	    atts.addElement(new Attribute("mentioncount"));
	    atts.addElement(new Attribute("urlcount"));
	    atts.addElement(new Attribute("charcount"));
	    atts.addElement(new Attribute("digitcount"));
	    //atts.addElement(new Attribute("classify", (FastVector)null));
	    */data = new Instances("MyTestRelation", atts, 0);
	    // - nominal
	    attVals = new FastVector();
	    for(int j=0;j<twitStreamList.size();j++){
	    	vals = new double[data.numAttributes()];
	    	vals[0] = data.attribute(0).addStringValue(twitStreamList.get(j).getResult());
	        // - numeric
	        vals[1] = data.attribute(1).addStringValue(twitStreamList.get(j).getTweet_content());
	     // - string
	        /*vals[2] = data.attribute(2).addStringValue(twitStreamList.get(j).getUserName());
	        vals[3] = data.attribute(3).addStringValue(twitStreamList.get(j).getTweetContent());
	     // - numeric
	        vals[4] = twitStreamList.get(j).getCreatedAcct();
	        vals[5] = twitStreamList.get(j).getFollowers();
	        vals[6] = twitStreamList.get(j).getFollowings();
	        vals[7] = twitStreamList.get(j).getUserfavourites();
	        vals[8] = twitStreamList.get(j).getListed();
	        vals[9] = twitStreamList.get(j).getTweetCount();
	        vals[10] = twitStreamList.get(j).getRetweetCount();
	        vals[11] = twitStreamList.get(j).getHashtagCount();
	        vals[12] = twitStreamList.get(j).getUserMention();
	        vals[13] = twitStreamList.get(j).getUrlCount();
	        vals[14] = twitStreamList.get(j).getCharCount();
	        vals[15] = twitStreamList.get(j).getDigitCount();
	        //
*/	        data.add(new Instance(1.0, vals));
	        saver.setInstances(data);  
	        try {
				saver.setFile(f);
				 saver.writeBatch();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(f));
			writer.write(data.toString());
		    writer.flush();
		    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   return file;
		
	}
	public static String createArffFile1(ArrayList<RealTweetStream> twitStreamList){
		ArffSaver saver = new ArffSaver();
		String file="D:\\Shilpa\\ProjectGuru\\Twinkle\\twitter\\WebContent\\upload\\train_real3.arff";
		File f=new File(file);
		FastVector      atts;
	    FastVector      attsRel;
	    FastVector      attVals;
	    FastVector      attValsRel;
	    Instances       data;
	    Instances       dataRel;
	    double[]        vals;
	    double[]        valsRel;
	    int             i;

	    // 1. set up attributes
	    atts = new FastVector();	    
	    // - numeric
	    atts.addElement(new Attribute("spamclass", (FastVector)null));
	    atts.addElement(new Attribute("tweetcontent", (FastVector)null));
	    /*atts.addElement(new Attribute("twitid"));
	    atts.addElement(new Attribute("username", (FastVector)null));
	    atts.addElement(new Attribute("tweetcontent", (FastVector)null));
	    atts.addElement(new Attribute("createaccount"));
	    atts.addElement(new Attribute("followers"));
	    atts.addElement(new Attribute("followings"));
	    atts.addElement(new Attribute("userfavorite"));
	    atts.addElement(new Attribute("listed"));
	    atts.addElement(new Attribute("tweetcount"));
	    atts.addElement(new Attribute("retweetcount"));
	    atts.addElement(new Attribute("hashtagcount"));
	    atts.addElement(new Attribute("mentioncount"));
	    atts.addElement(new Attribute("urlcount"));
	    atts.addElement(new Attribute("charcount"));
	    atts.addElement(new Attribute("digitcount"));
	    //atts.addElement(new Attribute("classify", (FastVector)null));
	    */data = new Instances("MyTestRelation", atts, 0);
	    // - nominal
	    attVals = new FastVector();
	    for(int j=0;j<twitStreamList.size();j++){
	    	vals = new double[data.numAttributes()];
	    	vals[0] = data.attribute(0).addStringValue(twitStreamList.get(j).getResult());
	        // - numeric
	        vals[1] = data.attribute(1).addStringValue(twitStreamList.get(j).getTweetContent());
	     // - string
	        /*vals[2] = data.attribute(2).addStringValue(twitStreamList.get(j).getUserName());
	        vals[3] = data.attribute(3).addStringValue(twitStreamList.get(j).getTweetContent());
	     // - numeric
	        vals[4] = twitStreamList.get(j).getCreatedAcct();
	        vals[5] = twitStreamList.get(j).getFollowers();
	        vals[6] = twitStreamList.get(j).getFollowings();
	        vals[7] = twitStreamList.get(j).getUserfavourites();
	        vals[8] = twitStreamList.get(j).getListed();
	        vals[9] = twitStreamList.get(j).getTweetCount();
	        vals[10] = twitStreamList.get(j).getRetweetCount();
	        vals[11] = twitStreamList.get(j).getHashtagCount();
	        vals[12] = twitStreamList.get(j).getUserMention();
	        vals[13] = twitStreamList.get(j).getUrlCount();
	        vals[14] = twitStreamList.get(j).getCharCount();
	        vals[15] = twitStreamList.get(j).getDigitCount();
	        //
*/	        data.add(new Instance(1.0, vals));
	        saver.setInstances(data);  
	        try {
				saver.setFile(f);
				 saver.writeBatch();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(f));
			writer.write(data.toString());
		    writer.flush();
		    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   return file;
		
	}
}
