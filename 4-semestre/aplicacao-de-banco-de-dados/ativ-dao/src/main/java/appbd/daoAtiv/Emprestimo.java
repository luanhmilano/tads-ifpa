/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbd.daoAtiv;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luanh
 */
@Entity
@Table(name = "EMPRESTIMO")
@NamedQueries({
    @NamedQuery(name = "Emprestimo.findAll", query = "SELECT e FROM Emprestimo e")})
public class Emprestimo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EMPRESTIMO")
    private Integer idEmprestimo;
    @Basic(optional = false)
    @Column(name = "DATA_EMPRESTIMO")
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;
    @Basic(optional = false)
    @Column(name = "DATA_DEVOLUCAO")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    @JoinColumn(name = "ID_ALUNO", referencedColumnName = "MATRICULA")
    @ManyToOne
    private Aluno idAluno;
    @JoinColumn(name = "CODIGO_PUBLICACAO", referencedColumnName = "CODIGO_PUBLICACAO")
    @ManyToOne
    private Publicacao codigoPublicacao;

    public Emprestimo() {
    }

    public Emprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Emprestimo(Integer idEmprestimo, Date dataEmprestimo, Date dataDevolucao) {
        this.idEmprestimo = idEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    public Publicacao getCodigoPublicacao() {
        return codigoPublicacao;
    }

    public void setCodigoPublicacao(Publicacao codigoPublicacao) {
        this.codigoPublicacao = codigoPublicacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmprestimo != null ? idEmprestimo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprestimo)) {
            return false;
        }
        Emprestimo other = (Emprestimo) object;
        if ((this.idEmprestimo == null && other.idEmprestimo != null) || (this.idEmprestimo != null && !this.idEmprestimo.equals(other.idEmprestimo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Emprestimo[ idEmprestimo=" + idEmprestimo + " ]";
    }
    
}
