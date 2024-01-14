interface FeedFilterStrategy {
    void filterContent();
}

class FriendsPostsStrategy implements FeedFilterStrategy {
    @Override
    public void filterContent() {
        System.out.println("Showing posts from friends");
    }
}

class TrendingPostsStrategy implements FeedFilterStrategy {
    @Override
    public void filterContent() {
        System.out.println("Showing trending posts");
    }
}

class InterestBasedPostsStrategy implements FeedFilterStrategy {
    @Override
    public void filterContent() {
        System.out.println("Showing posts based on your interests");
    }
}

class SocialMediaFeed {
    private FeedFilterStrategy strategy;

    public SocialMediaFeed(FeedFilterStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(FeedFilterStrategy strategy) {
        this.strategy = strategy;
    }

    public void showFeed() {
        strategy.filterContent();
    }
}

public class Strategy {
    public static void main(String[] args) {
        SocialMediaFeed feed = new SocialMediaFeed(new FriendsPostsStrategy());
        feed.showFeed();

        feed.setStrategy(new TrendingPostsStrategy());
        feed.showFeed();

        feed.setStrategy(new InterestBasedPostsStrategy());
        feed.showFeed();
    }
}
