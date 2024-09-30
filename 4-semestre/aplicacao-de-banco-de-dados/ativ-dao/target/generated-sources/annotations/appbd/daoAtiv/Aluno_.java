package appbd.daoAtiv;

import appbd.daoAtiv.Emprestimo;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-31T22:48:48", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Aluno.class)
public class Aluno_ { 

    public static volatile ListAttribute<Aluno, Emprestimo> emprestimoList;
    public static volatile SingularAttribute<Aluno, Integer> matricula;
    public static volatile SingularAttribute<Aluno, String> nome;

}