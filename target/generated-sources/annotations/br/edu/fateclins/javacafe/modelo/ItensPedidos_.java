package br.edu.fateclins.javacafe.modelo;

import br.edu.fateclins.javacafe.modelo.Pedido;
import br.edu.fateclins.javacafe.modelo.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-11-27T13:32:54")
@StaticMetamodel(ItensPedidos.class)
public class ItensPedidos_ { 

    public static volatile SingularAttribute<ItensPedidos, Produto> produto;
    public static volatile SingularAttribute<ItensPedidos, Double> valor;
    public static volatile SingularAttribute<ItensPedidos, Pedido> pedido;
    public static volatile SingularAttribute<ItensPedidos, Integer> id;
    public static volatile SingularAttribute<ItensPedidos, Integer> quantidade;

}