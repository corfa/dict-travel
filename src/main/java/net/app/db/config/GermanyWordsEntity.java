package net.app.db.config;

import javax.persistence.*;

@Entity
@Table(name = "germany_words", schema = "dict_travel", catalog = "")
public class GermanyWordsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "word")
    private String word;
    @Basic
    @Column(name = "id_word_r")
    private Integer idWordR;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getIdWordR() {
        return idWordR;
    }

    public void setIdWordR(Integer idWordR) {
        this.idWordR = idWordR;
    }
}
