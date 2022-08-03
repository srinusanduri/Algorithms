package com.algs;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {

   public static void main(String[] args) {

     // ["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"]
//[[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1]]

      Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
      twitter.postTweet(1, 5);
      twitter.postTweet(1, 3);
      twitter.postTweet(1, 101);
      twitter.postTweet(1, 13);
      twitter.postTweet(1, 10);
      twitter.postTweet(1, 2);
      twitter.postTweet(1, 94);
      twitter.postTweet(1, 505);
      twitter.postTweet(1, 333);


      List<Integer> newsFeed = twitter.getNewsFeed(1);
      System.out.println(newsFeed);

   }

   class UserContext {

      int userId;

      Set<Integer> followers = new HashSet<>(); // Her followers
      Set<Integer> followees = new HashSet<>(); // She follows these users
      PriorityQueue<Tweet> tweets = new PriorityQueue<>(new TweetComparator());

      UserContext(int userId) {
         this.userId = userId;
      }
   }

   class Tweet {

      int id;
      LocalDateTime time;

      Tweet(int id, LocalDateTime time) {
         this.id = id;
         this.time = time;
      }


      @Override
      public boolean equals(Object obj) {
         Tweet that = (Tweet) obj;

         return this.id == that.id;
      }
   }

   class TweetComparator implements Comparator<Tweet> {

      @Override
      public int compare(Tweet first, Tweet second) {
         return first.time.isEqual(second.time) ? 0 : (first.time.isAfter(second.time) ? 1 : -1);
      }
   }

   // class ReverseTweetComparator implements Comparator<Tweet> {
   //     @Override
   //     public int compare(Tweet first, Tweet second) {
   //         return first.isEqual(second) ? 0 : (first.isAfter(second) ? -1 : 1);
   //     }
   // }

   Map<Integer, UserContext> data = new HashMap<>();

   /**
    * Initialize your data structure here.
    */
   public Twitter() {

   }

   /**
    * Compose a new tweet.
    */
   public void postTweet(int userId, int tweetId) {
      UserContext userContext = this.getUserContext(userId);

      Tweet tweet = new Tweet(tweetId, LocalDateTime.now());

      PriorityQueue<Tweet> userTweets = userContext.tweets;

      if (userTweets.size() == 10) {
         userTweets.poll();
      }

      userTweets.add(tweet);
   }

   /**
    * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
    * be posted by users who the user followed or by the user herself. Tweets must be ordered from
    * most recent to least recent.
    */
   public List<Integer> getNewsFeed(int userId) {

      PriorityQueue<Tweet> recentTweets = new PriorityQueue<>(new TweetComparator());

      UserContext user = this.getUserContext(userId);

      recentTweets.addAll(user.tweets);

      for (int followeeId : user.followees) {
         UserContext followee = this.getUserContext(followeeId);

         PriorityQueue<Tweet> followeeTweets = followee.tweets;

         for (Tweet tweet : followeeTweets) {
            if (recentTweets.size() == 10) {
               Tweet peek = recentTweets.peek();
               if (tweet.time.isAfter(peek.time)) {
                  recentTweets.poll();
                  recentTweets.add(tweet);
               }
            } else {
               recentTweets.add(tweet);
            }
         }
      }

      List<Integer> newsFeed = new ArrayList<>();

      while (!recentTweets.isEmpty()) {
         newsFeed.add(recentTweets.poll().id);
      }

      List<Integer> result = new ArrayList<>();

      for (int i = newsFeed.size()-1; i >= 0; i--) {
         result.add(newsFeed.get(i));
      }

      return result;
   }

   /**
    * Follower follows a followee. If the operation is invalid, it should be a no-op.
    */
   public void follow(int followerId, int followeeId) {

      if (followerId == followeeId) {
         return;
      }

      UserContext followee = this.getUserContext(followeeId);
      followee.followers.add(followerId);

      UserContext follower = this.getUserContext(followerId);
      follower.followees.add(followeeId);
   }

   /**
    * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
    */
   public void unfollow(int followerId, int followeeId) {

      if (followerId == followeeId) {
         return;
      }

      UserContext followee = this.getUserContext(followeeId);
      followee.followers.remove(followerId);

      UserContext follower = this.getUserContext(followerId);
      follower.followees.remove(followeeId);
   }

   UserContext getUserContext(Integer userId) {
      UserContext userContext = this.data.get(userId);
      if (userContext == null) {
         userContext = new UserContext(userId);
         this.data.put(userId, userContext);
      }

      return userContext;
   }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId); List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId); obj.unfollow(followerId,followeeId);
 */