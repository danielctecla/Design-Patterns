import java.util.ArrayList;
import java.util.List;

interface Post {
    String getTitle();
    String getMedia();
    String getBody();
}

abstract class SocialMediaPost {
    protected Post post;
    
    public SocialMediaPost(Post post) {
        this.post = post;
    }

    abstract public void displayPost();
}

class TextPost extends SocialMediaPost {
    public TextPost(Post post) {
        super(post);
    }

    @Override
    public void displayPost() {
        System.out.println("--- Text Post ---");
        System.out.println("Title: " + post.getTitle());
        System.out.println("Body: " + post.getBody() + "\n");
    }
}

class ImagePost extends SocialMediaPost {
    public ImagePost(Post post) {
        super(post);
    }

    @Override
    public void displayPost() {
        System.out.println("--- Image Post ---");
        System.out.println("Title: " + post.getTitle());
        System.out.println("Body: " + post.getBody());
        System.out.println("Image: " + post.getMedia() + "\n");
    }
}

class TextPostData implements Post {
    private String title;
    private String body;

    public TextPostData() {
        this.title = "";
        this.body = "";
    }

    public TextPostData(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getBody() {
        return this.body;
    }

    @Override
    public String getMedia() {
        return null;
    }
}

class ImagePostData implements Post {
    private String title;
    private String body;
    private String media;

    public ImagePostData() {
        this.title = "";
        this.body = "";
        this.media = "";
    }

    public ImagePostData(String title, String body, String media) {
        this.title = title;
        this.body = body;
        this.media = media;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getBody() {
        return this.body;
    }

    @Override
    public String getMedia() {
        return this.media;
    }
}

// Bridge_SocialMedia is the client class.
public class Bridge {
    public static void main(String args[]) {
        ArrayList<SocialMediaPost> posts = new ArrayList<>();

        posts.add(new TextPost( new TextPostData("Text Post", "This is a text post") ));
        posts.add(new ImagePost( new ImagePostData("Image Post", "This is an image post", "image.png") ));
        posts.add(new TextPost( new TextPostData("Text Post", "This is another text post") ));
        posts.add(new ImagePost( new ImagePostData("Image Post", "This is another image post", "image2.png") ));

        for(SocialMediaPost post : posts)
            post.displayPost();

    }
}