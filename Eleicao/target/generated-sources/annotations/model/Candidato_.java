package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Voto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-04T07:46:11")
@StaticMetamodel(Candidato.class)
public class Candidato_ { 

    public static volatile SingularAttribute<Candidato, String> nomecan;
    public static volatile SingularAttribute<Candidato, Integer> idcan;
    public static volatile CollectionAttribute<Candidato, Voto> votoCollection;
    public static volatile SingularAttribute<Candidato, String> chapa;

}