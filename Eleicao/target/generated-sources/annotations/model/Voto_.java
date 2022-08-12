package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Candidato;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-04T07:46:11")
@StaticMetamodel(Voto.class)
public class Voto_ { 

    public static volatile SingularAttribute<Voto, Candidato> idcan;
    public static volatile SingularAttribute<Voto, Usuario> idus;
    public static volatile SingularAttribute<Voto, Integer> idvoto;
    public static volatile SingularAttribute<Voto, Date> datavoto;

}