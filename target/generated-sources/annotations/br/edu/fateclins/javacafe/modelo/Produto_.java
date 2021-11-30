package br.edu.fateclins.javacafe.modelo;

import br.edu.fateclins.javacafe.modelo.Tipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-27T13:32:53")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Double> preco;
    public static volatile SingularAttribute<Produto, Tipo> tipo;
    public static volatile SingularAttribute<Produto, String> foto;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Integer> id;

}