package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Voto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-04T07:46:11")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, Integer> tipo;
    public static volatile SingularAttribute<Usuario, Integer> idus;
    public static volatile SingularAttribute<Usuario, String> nomus;
    public static volatile CollectionAttribute<Usuario, Voto> votoCollection;
    public static volatile SingularAttribute<Usuario, String> login;

}