package leetcode.medium;

import java.util.*;

public class DesignTwitter {

    Map<Integer, User> userMap = new HashMap<>();
    int time;

    public static void main(String args[]){
        DesignTwitter d = new DesignTwitter();
        d.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        d.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        d.follow(1, 2);    // User 1 follows user 2.
        d.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        d.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        d.unfollow(1, 2);  // User 1 unfollows user 2.
        d.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }

    public DesignTwitter() {

    }

    public void postTweet(int userId, int tweetId) {
        time++;
        if(userMap.get(userId) == null){
            User nu = new User();
            userMap.put(userId, nu);
        }
        userMap.get(userId).tweets.addFirst(new Tweet(time, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if(userMap.get(userId)==null) return new ArrayList<>();
        PriorityQueue<Tweet> tweets = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        for(int i : userMap.get(userId).follows){
            if(userMap.get(i) == null) continue;
            User f = userMap.get(i);
            Iterator<Tweet> it = f.tweets.iterator();
            int count = 0;
            while (it.hasNext() && count < 10){
                tweets.add(it.next());
                if(tweets.size()>10) tweets.poll();
                count++;
            }
        }

        Iterator<Tweet> it = userMap.get(userId).tweets.iterator();
        int count = 0;
        while (it.hasNext() && count < 10){
            tweets.add(it.next());
            if(tweets.size()>10) tweets.poll();
            count++;
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!tweets.isEmpty()) {
            res.addFirst(tweets.poll().tweetId);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(userMap.get(followerId) == null){
            User nu = new User();
            userMap.put(followerId, nu);
        }
        userMap.get(followerId).follows.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if( userMap.get(followerId) == null) return;
        userMap.get(followerId).follows.remove(followeeId);
    }

    class User{
        Set<Integer> follows = new HashSet<>();
        LinkedList<Tweet> tweets = new LinkedList<>();
    }

    class Tweet{
        int time;
        int tweetId;

        public Tweet(int time, int tweetId){
            this.time = time;
            this.tweetId = tweetId;
        }
    }
}
