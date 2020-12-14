package com.fabric.ilearn.model.lrn.level;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="lrn_level_locales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LrnLevelLocale implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="LEVEL_LOCALE_ID")
    private long lrnLevelLocaleId;

    @Column(name="LEVEL_ID", updatable = false, insertable = false)
    private long levelId;

    @Column(name="LEVEL_DISPLAY_NAME")
    private String levelDisplayName;

    @Column(name="LOCALE_CODE")
    private String localeCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LEVEL_ID")
    @JsonBackReference
    private LrnLevel lrnLevel;
}
