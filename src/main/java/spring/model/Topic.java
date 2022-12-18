package spring.model;

public class Topic {
    private String TopicName;

    public Topic() {

    }

    public Topic(String TopicName) {
        this.TopicName = TopicName;
    }


    public String getTopicName() {
        return TopicName;
    }

    public void setTopicName(String TopicName) {
        this.TopicName = TopicName;
    }
}