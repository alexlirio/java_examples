package br.com.example.designpattern.behavioral.observer;

public class NewsChannelObserverTest {

    public static void main(String[] args) {
        NewsAgencyObservable observable = new NewsAgencyObservable();
        NewsChannelObserver observer = new NewsChannelObserver();

        observable.addObserver(observer);
        observable.setNews("Pandemic End");
        System.out.println(observer.getNews()); // "news";
    }
}
