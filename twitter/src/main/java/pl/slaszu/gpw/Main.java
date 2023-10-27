package pl.slaszu.gpw;

import io.github.redouane59.twitter.TwitterClient;
import io.github.redouane59.twitter.dto.tweet.MediaCategory;
import io.github.redouane59.twitter.dto.tweet.Tweet;
import io.github.redouane59.twitter.dto.tweet.TweetParameters;
import io.github.redouane59.twitter.dto.tweet.UploadMediaResponse;
import io.github.redouane59.twitter.signature.TwitterCredentials;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        TwitterClient twitterClient = new TwitterClient(TwitterCredentials.builder());

        UploadMediaResponse uploadMediaResponse = twitterClient.uploadMedia(
            new File("/home/.../gold.jpg"),
            MediaCategory.TWEET_IMAGE
        );

        TweetParameters.TweetParametersBuilder builder = TweetParameters.builder();
        TweetParameters tweetContent = builder.text("test api").media(
            TweetParameters.Media.builder().mediaIds(List.of(uploadMediaResponse.getMediaId())).build()
        ).build();


        Tweet tweet = twitterClient.postTweet(tweetContent);
        System.out.println(tweet.getId());
        System.out.println(tweet.getText());
        System.out.println(tweet.getCreatedAt());
    }

}