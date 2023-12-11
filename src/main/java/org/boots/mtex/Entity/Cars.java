package org.boots.mtex.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cars {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "corpus_id")
    private Long corpus_id;
    @Column(name = "wheels_id")
    private Long wheels_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "name")
    private String name;

    public Long getCorpus_id() {
        return corpus_id;
    }

    public Long getWheels_id() {
        return wheels_id;
    }

    public void setCorpus_id(Long corpusId) {
        this.corpus_id = corpusId;
    }


    public void setWheels_id(Long wheelsId) {
        this.wheels_id = wheelsId;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
