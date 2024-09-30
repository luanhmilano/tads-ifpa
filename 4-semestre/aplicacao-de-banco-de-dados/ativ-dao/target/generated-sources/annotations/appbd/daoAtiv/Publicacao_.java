package appbd.daoAtiv;

import appbd.daoAtiv.Emprestimo;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-31T22:48:48", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Publicacao.class)
public class Publicacao_ { 

    public static volatile SingularAttribute<Publicacao, Integer> anoPublicacao;
    public static volatile ListAttribute<Publicacao, Emprestimo> emprestimoList;
    public static volatile SingularAttribute<Publicacao, String> tipoPublicacao;
    public static volatile SingularAttribute<Publicacao, Integer> codigoPublicacao;
    public static volatile SingularAttribute<Publicacao, String> titulo;
    public static volatile SingularAttribute<Publicacao, String> autor;

}