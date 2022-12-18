package spring.controllers;

import net.app.db.config.EnglishWordsEntity;
import net.app.db.config.GermanyWordsEntity;
import net.app.db.config.TopicsEntity;
import net.app.db.config.WordsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import spring.model.Search;
import spring.model.Topic;
import spring.model.Word;

import java.util.List;

@Controller

public class FirstController {
    @Autowired
    private DAO dao;



    @GetMapping("/show_topics")
    public String show_topics(Model model){
        List<TopicsEntity> list = dao.getAllTopic();
        model.addAttribute("topics",list);
        return "topics/show_topics";
    }
    @GetMapping("/show_words_on_topic/{id}")
    public String show_words_on_topic(@PathVariable("id") int id, Model model){
        model.addAttribute("topicName",dao.getTopicNameOnId(id));
        //model.addAttribute("topic_name")
        model.addAttribute("words",dao.getAllWordsOnTopicId(id));
        return "words/all_words_in_topic";

    }
    @GetMapping("/new_topic")
    public String newTopic(@ModelAttribute("topic") Topic topic ) {
     return "topics/new";
    }

    @GetMapping("/show_translate_on_english/{id}")
    public String show_translate_on_english(@PathVariable("id") int id, Model model){
        model.addAttribute("word",dao.getEnglishWordOnId(id));
        return "words/show_translate_on_english";

    }
    @GetMapping("/show_translate_on_germany/{id}")
    public String show_translate_on_germany(@PathVariable("id") int id, Model model){
        model.addAttribute("word",dao.getGermanyWordOnId(id));
        return "words/show_translate_on_germany";

    }
    @PostMapping("/create_topic")
    public String create(@ModelAttribute("topic")  Topic topic) {
        TopicsEntity top = new TopicsEntity();
        top.setNameTopic(topic.getTopicName());
        top.setId(0);
        dao.saveTopic(top);
        return "redirect:/show_topics";
    }

    @GetMapping("/new_word")
    public String newWord(@ModelAttribute("word") Word word,Model model ) {
        model.addAttribute("topics",dao.getAllTopic());
        return "words/new";
    }
    @PostMapping("/create_word")
    public String create_word(@ModelAttribute("word")  Word word) {

        WordsEntity wordsR = new WordsEntity();
        wordsR.setId(0);
        wordsR.setWord(word.getWordR());
        wordsR.setTopicId(word.getTopicId());
        dao.saveWord(wordsR);
        EnglishWordsEntity wordE = new EnglishWordsEntity();
        wordE.setId(0);
        wordE.setWord(word.getWordEnglish());
        wordE.setIdWordR(dao.getWordId(word.getWordR()));
        dao.saveEnglishWord(wordE);
        GermanyWordsEntity wordG = new GermanyWordsEntity();
        wordG.setId(0);
        wordG.setWord(word.getWordGermany());
        wordG.setIdWordR(dao.getWordId(word.getWordR()));
        dao.saveGermanyWord(wordG);
        return "redirect:/show_topics";
    }
    @GetMapping("/show_all_words")
    public String showAllWords(Model model){
        model.addAttribute("words",dao.getAllWords());
        return  "words/show_all_words";
    }
    @GetMapping("/delete_word/{id}")
    public  String delWord(@PathVariable("id") int id, Model model){
        dao.deleteWord(id);
       return  "redirect:/show_all_words";
    }
    @GetMapping("/search_word")
    public String searchWord(@ModelAttribute("search") Search search){
        return "words/search";
    }
    @PostMapping("/find_word")
    public String create(@ModelAttribute("search") Search search,Model model) {
        List<WordsEntity> list = dao.searchWords(search.getWord());
        model.addAttribute("words",list);
        return "words/result_search";
    }





}
