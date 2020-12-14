package com.fabric.ilearn.model.adm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="adm_locales")
@Getter
@Setter
@NoArgsConstructor
public class AdmLocale implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "locale_code")
    private String localeCode;

    @Column(name = "locale_name")
    private String localeName;
}
