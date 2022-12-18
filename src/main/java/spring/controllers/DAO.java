package spring.controllers;

import net.app.db.config.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DAO {

    public void saveTopic(TopicsEntity topic){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(topic);
        session.getTransaction().commit();
        session.close();
    }
    public void saveWord(WordsEntity word){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(word);
        session.getTransaction().commit();
        session.close();
    }
    public void saveEnglishWord(EnglishWordsEntity word){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(word);
        session.getTransaction().commit();
        session.close();
    }
    public void saveGermanyWord(GermanyWordsEntity word){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(word);
        session.getTransaction().commit();
        session.close();
    }
    public String getTopicNameOnId(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from TopicsEntity where id=:id");
        query.setInteger("id",id);
        TopicsEntity result= (TopicsEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return result.getNameTopic();
    }

    public int getWordId(String word){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from WordsEntity where word=:word");
        query.setString("word",word);
        WordsEntity result= (WordsEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return result.getId();
    }


    public List<TopicsEntity> getAllTopic(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<TopicsEntity> list=session.createQuery("from TopicsEntity").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public List<WordsEntity> getAllWords(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<WordsEntity> list=session.createQuery("from WordsEntity").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public EnglishWordsEntity getEnglishWordOnId(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from EnglishWordsEntity where  id_word_r=:id");
        query.setInteger("id",id);
        EnglishWordsEntity result= (EnglishWordsEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    public GermanyWordsEntity getGermanyWordOnId(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from GermanyWordsEntity where  id_word_r=:id");
        query.setInteger("id",id);
        GermanyWordsEntity result= (GermanyWordsEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    public  List<WordsEntity> getAllWordsOnTopicId(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query= session.createQuery("from WordsEntity where topic_id=:id");
        query.setInteger("id",id);
        List<WordsEntity> list = query.list();

        session.getTransaction().commit();
        session.close();
        return list;
    }
    public void deleteWord(int id){
        deleteWordEnglish(id);
        deleteWordGermany(id);
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from WordsEntity where id=:id");
        query.setInteger("id",id);
        WordsEntity word= (WordsEntity) query.uniqueResult();
        session.delete(word);
        session.getTransaction().commit();
        session.close();
    }
    public void deleteWordEnglish(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from EnglishWordsEntity where id_word_r=:id");
        query.setInteger("id",id);
        EnglishWordsEntity word= (EnglishWordsEntity) query.uniqueResult();
        session.delete(word);
        session.getTransaction().commit();
        session.close();
    }
    public void deleteWordGermany(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from GermanyWordsEntity where id_word_r=:id");
        query.setInteger("id",id);
        GermanyWordsEntity word= (GermanyWordsEntity) query.uniqueResult();
        session.delete(word);
        session.getTransaction().commit();
        session.close();
    }
    public List<WordsEntity> searchWords(String word){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from WordsEntity where word like '%"+word+"%'");
        List<WordsEntity> list = query.list();
        return list;

    }

}
