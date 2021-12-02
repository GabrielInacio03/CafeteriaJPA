package br.edu.fateclins.javacafe.modelo;

import br.edu.fateclins.javacafe.modelo.ItensPedidos;
import br.edu.fateclins.javacafe.modelo.Mesa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-12-01T17:04:31")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile ListAttribute<Pedido, ItensPedidos> itens;
    public static volatile SingularAttribute<Pedido, Date> dataHorario;
    public static volatile SingularAttribute<Pedido, Mesa> mesa;
    public static volatile SingularAttribute<Pedido, Integer> id;
    public static volatile SingularAttribute<Pedido, String> status;

}