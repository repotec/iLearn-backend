package com.fabric.ilearn.model.lrn.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lrn_registered_subjects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = "registeredSubject-graph",
        attributeNodes = @NamedAttributeNode(value = "lrnSubject", subgraph = "role-subgraph"),
        subgraphs = @NamedSubgraph(name = "role-subgraph", attributeNodes = @NamedAttributeNode("lrnSubjectLocales")))
public class LrnRegisteredSubject implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="REGISTER_SUBJECT_ID")
    private long registerSubjectId;

    @Column(name= "SEMESTER_ID")
    private long semesterId;

    @Column(name="SUBJECT_ID", insertable = false, updatable = false)
    private long subjectId;

    @ManyToOne
    @JoinColumn(name="SUBJECT_ID")
    private LrnSubject lrnSubject;
}
