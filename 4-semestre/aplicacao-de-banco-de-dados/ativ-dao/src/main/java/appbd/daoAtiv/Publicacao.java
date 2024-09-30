/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbd.daoAtiv;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author luanh
 */
@Entity
@Table(name = "PUBLICACAO")
@NamedQueries({
    @NamedQuery(name = "Publicacao.findAll", query = "SELECT p FROM Publicacao p")})
public class Publicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_PUBLICACAO")
    private Integer codigoPublicacao;
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "ANO_PUBLICACAO")
    private Integer anoPublicacao;
    @Column(name = "AUTOR")
    private String autor;
    @Column(name = "TIPO_PUBLICACAO")
    private String tipoPublicacao;
    @OneToMany(mappedBy = "codigoPublicacao")
    private List<Emprestimo> emprestimoList;

    public Publicacao() {
    }

    public Publicacao(Integer codigoPublicacao) {
        this.codigoPublicacao = codigoPublicacao;
    }

    public Publicacao(Integer codigoPublicacao, String titulo) {
        this.codigoPublicacao = codigoPublicacao;
        this.titulo = titulo;
    }

    public Integer getCodigoPublicacao() {
        return codigoPublicacao;
    }

    public void setCodigoPublicacao(Integer codigoPublicacao) {
        this.codigoPublicacao = codigoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipoPublicacao() {
        return tipoPublicacao;
    }

    public void setTipoPublicacao(String tipoPublicacao) {
        this.tipoPublicacao = tipoPublicacao;
    }

    public List<Emprestimo> getEmprestimoList() {
        return emprestimoList;
    }

    public void setEmprestimoList(List<Emprestimo> emprestimoList) {
        this.emprestimoList = emprestimoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPublicacao != null ? codigoPublicacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicacao)) {
            return false;
        }
        Publicacao other = (Publicacao) object;
        if ((this.codigoPublicacao == null && other.codigoPublicacao != null) || (this.codigoPublicacao != null && !this.codigoPublicacao.equals(other.codigoPublicacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Publicacao[ codigoPublicacao=" + codigoPublicacao + " ]";
    }
    
}
