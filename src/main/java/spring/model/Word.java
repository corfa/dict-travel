package spring.model;

public class Word {
    private String WordR;
    private int TopicId;
    private String WordEnglish;
    private String WordGermany;

    public Word() {

    }

    public void setWordR(String wordR) {
        WordR = wordR;
    }

    public void setTopicId(int topicId) {
        TopicId = topicId;
    }

    public void setWordEnglish(String wordEnglish) {
        WordEnglish = wordEnglish;
    }

    public void setWordGermany(String wordGermany) {
        WordGermany = wordGermany;
    }

    public String getWordR() {
        return WordR;
    }

    public int getTopicId() {
        return TopicId;
    }

    public String getWordEnglish() {
        return WordEnglish;
    }

    public String getWordGermany() {
        return WordGermany;
    }

    public Word(String WordR, int TopicId, String WordEnglish, String WordGermany) {
        this.WordR = WordR;
        this.TopicId = TopicId;
        this.WordEnglish = WordEnglish;
        this.WordGermany = WordGermany;
    }


}

