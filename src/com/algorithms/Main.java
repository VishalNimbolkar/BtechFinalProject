package com.algorithms;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.dom4j.tree.DefaultAttribute;

import com.connection.ConnectionUtils;
import com.model.UserDao;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Comment;
import com.restfb.types.Page;
import com.restfb.types.Place;
import com.restfb.types.Post;
import com.restfb.types.Post.Likes;
import com.restfb.types.User;
import com.restfb.types.Post.Comments;
import java.sql.PreparedStatement;

public class Main {

	public String getdata(String token, String Name) throws SQLException {
		String interest = "";
		try {
			aho ahocorasick = new aho();
			String allnewdata;
			String msgval = "";
			String postval = "";

			String access = token;
			String preference = "";
			String msgvaluenew = "";
			String postnewval = "";
			// EAACEdEose0cBAItmotZBbBJQqUWfGLXqrkFSypZAQSHfuI4Y6snzKZBNsjE2nyZAkYKmJnQ7ZCkAgbucIvaSqblzcwP3wUHJQ54iETLK3KreDd2ESHn7YcTVfWEaaOr7lpSZA8J5zVh1tqbnXPH0l4WY1RwbSjZAFhCoyI3ZAdZAJCHKQfEzttWtPtfsHZBDWIzYIZD
			// EAACEdEose0cBADPCZBWJ9LEtrP9lWXYHAH6SZAib793ZBoMMSOKYJAW8unTTU3wlhBeIMZBqr3HBN1QOZAixeuXUwufjVN1wP2wHPLEr3RHO07ztZBkZCeA1qx4oXzWjJtJVYCvZB2uIFcJbXcSV1oQTNhBx30pdgEUjm4ICGDA6hpegFbuP5g7wcqEeyMblPUEZD
			// EAACEdEose0cBABy2wOKtiUWmZBf9ybBBr92cmbTl13SZAgMwMzjUEZAVQGwhrQNV4xNyV8FeCmEOoh188qWjIzrIE9LdcLI0AjuqqM1ElvGJc777swZCGUBH0eZAoC8N3M8gc4xc3kvBCyQzCoVjDXZAaD4WEHb5p9OxHH5ZBdSmZA2zKdCETeN6D6Mg398mXhMZD
			// EAAC70LwWaD8BAJTUge4AKPGqzLa1VFqnOrW5gaHZAbUZBmZB19tqS5znY9ik12j2HDuVkpcc80x3PfNdQhIND0Cwi6TmVUbJwkK2dbBdhKz5T4sNrbnQ8bZCZC8u8dMvjqy3mtYoZCgeBmRBsvS70U5ZBrxk69ZB78AZD
			// EAACEdEose0cBAOXBrIPxCw1xFZAns5wxhgVDU57o3iJguDwMT63miUcYovNw9sv4iNO5VE5PTwGhzrEO2jQcNqH4KqZBKaaPZALWsIZBBGml7KUpzUTZCn8cFFsF5z4zYeHcJc4jFoWdmHR53rqWYVOgZCZBZAiEcAZAOUzTI2nFPIPhiTfILpBznU0Dn0MgyCQAZD
			System.out.println("access>>>>>>>>>>>>" + access);
			FacebookClient Fb = new DefaultFacebookClient(access);
			// User me=Fb.fetchObject("me", User.class);
			// System.out.println(me.getName()+"\n email :"+me.getEmail()+"\n
			// :"+me.getBirthday()+"\n Favourites :"+me.getFavoriteTeams()+"\n
			// Gender:"+me.getGender()+"\n Intrest:"+me.getInterestedIn()+"\n
			// :"+me.getFavoriteTeams()+me.getEducation()+me.getUpdatedTime());
			/*
			 * Page page=Fb.fetchObject("karan",Page.class); Connection<Post>
			 * postFeed=Fb.fetchConnection("me/feed",Post.class); for(List<Post> postPage
			 * :postFeed) { for (Post post : postPage) { System.out.println("Post: " +
			 * post); } }
			 */
			Connection<Post> myFeed = Fb.fetchConnection("me/feed", Post.class);

			// Get the iterator
			Iterator<List<Post>> it = myFeed.iterator();
			ArrayList<String> msg = new ArrayList<String>();
			ArrayList<Place> places = new ArrayList<Place>();
			ArrayList<String> postdata = new ArrayList<String>();
			ArrayList<String> caption = new ArrayList<String>();
			ArrayList<String> like = new ArrayList<String>();

			ArrayList<String> alldata = new ArrayList<String>();
			UserDao db=new UserDao();
			db.TruncateTable();
			while (it.hasNext()) {
				List<Post> myFeedPage = it.next();
				for (Post post : myFeedPage) {
					
					System.out.println("Message: " + post.getMessage());
					System.out.println("Likes: " + post.getLikes());
					System.out.println("Comments: " + post.getComments());
					System.out.println("Id: " + post.getId());
					System.out.println("Time: " + post.getCreatedTime());
					System.out.println("Checkins: " + post.getPlace());
					System.out.println("Caption  : " + post.getCaption());
					System.out.println("place  : " + post.getName());

					String newpost = post.getName();
					String msgdata = post.getMessage();
					// Likes like=post.getLikes();

					Comments comments = post.getComments();
					String Date = post.getCreatedTime().toString();
					String Caption = post.getCaption();
					Place place = post.getPlace();

					places.add(place);
					msg.add(msgdata);
					caption.add(Caption);
					postdata.add(newpost);
					System.out.println("CHECK IN Place>>>>>>>>>>>>>>>>>>>>" + places);

					String query = "insert into tbl_fbdata(id,email,msg,time)values(?,?,?,?)";

					java.sql.Connection con = ConnectionUtils.getConnection();
					PreparedStatement pst = con.prepareStatement(query);
					
					pst.setInt(1, 0);
					pst.setString(2, Name);
					pst.setString(3, msgdata);
					pst.setString(4, Date);
					int j = pst.executeUpdate();
					if (j > 0) {
						System.out.println("query done..");
					} else {
						System.out.println("query fail..");
					}

				}
			}

			for (String msgvalue : msg) {
				msgvaluenew = msgvaluenew + msgvalue;
			}
			for (String postvalue : postdata) {
				postnewval = postnewval + postvalue;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return interest;
	}
}