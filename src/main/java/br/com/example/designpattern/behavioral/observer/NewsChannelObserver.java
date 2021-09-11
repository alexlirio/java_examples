package br.com.example.designpattern.behavioral.observer;

/**
 * Observer (or Publish/Subscribe):
 * Recognizable by behavioral methods which invokes a method on an instance of
 * another abstract/interface type, depending on own state.
 */
public class NewsChannelObserver implements Channel {

    private String news;

    @Override
    public void update(Object news) {
        this.setNews((String) news);
    } 

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
