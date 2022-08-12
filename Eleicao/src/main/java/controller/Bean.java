package controller;

import model.*;
import java.util.*;
import java.io.Serializable;
import javax.faces.bean.*;
import javax.faces.model.DataModel;
import dao.*;
import javax.faces.model.ListDataModel;


@ManagedBean(name = "ct")
@SessionScoped

public class Bean implements Serializable {

    public Bean() {
        preencheCan();
        apuracao();
    }//builder

    private Usuario usuario = new Usuario();
    private List<Candidato> listaCan = new ArrayList<>();
    private String cpNome;
    private DataModel tabelaCan;
    
    private List<Object[]> listaVot = new ArrayList<>();
    private DataModel tabelaVot;
    
    private String cpLogin;
    private String cpSenha;
    private String cpCandidato;
    private String cpChapa;
    

    public void apuracao() {
        listaVot = new DaoInterface().apuracao();
        tabelaVot = new ListDataModel(listaVot);
    }//apuracao

    public String btLogar() {
        String tela = "index";
        Interface dao = new DaoInterface();
        usuario = dao.logar(getCpLogin(), getCpSenha());
        setCpNome(usuario.getNomus());
        if (usuario.getLogin().equals("adm")){
             tela = "votacaoAdm";
        } else{
            tela = "votacao";
        }
        return tela;
    }//btLogar

    public void btLimpar() {
        setCpLogin(null);
        setCpSenha(null);
    }
    
    public String btCadCan(){
        return "cadCan";
    }
    
    public String btVoltar(){
        return "votacaoAdm";
    }
    
    public String btApuraVoto(){
        return "apuraVoto";
    }
    
    public String btSair(){
        return "index";
    }

    public void preencheCan() {
        listaCan = new DaoInterface().preencheCan();
        tabelaCan = new ListDataModel(listaCan);
    }//preencheCan
    
     public String btCadastrar(){
        Candidato candidato = new Candidato();
        candidato.setNomecan(getCpCandidato());
        candidato.setChapa(getCpChapa());
        Interface dao = new DaoInterface();
        dao.novoCan(candidato);
        preencheCan();
        return "votacaoAdm";
    }//btCadastrar

    public String btVotar() {
        Voto voto = new Voto();
        voto.setIdus(usuario);
        Candidato candidato = (Candidato) tabelaCan.getRowData();
        voto.setIdcan(candidato);
        voto.setDatavoto(new Date());
        Interface dao = new DaoInterface();
        dao.votar(voto);
        return btSair();
    }

//////////////GET e SET

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCpNome() {
        return cpNome;
    }

    public void setCpNome(String cpNome) {
        this.cpNome = cpNome;
    }

    public List<Candidato> getListaCan() {
        return listaCan;
    }

    public void setListaCan(List<Candidato> listaCan) {
        this.listaCan = listaCan;
    }

    public DataModel getTabelaCan() {
        return tabelaCan;
    }

    public void setTabelaCan(DataModel tabelaCan) {
        this.tabelaCan = tabelaCan;
    }

    public List<Object[]> getListaVot() {
        return listaVot;
    }

    public void setListaVot(List<Object[]> listaVot) {
        this.listaVot = listaVot;
    }

    public DataModel getTabelaVot() {
        return tabelaVot;
    }

    public void setTabelaVot(DataModel tabelaVot) {
        this.tabelaVot = tabelaVot;
    }

    public String getCpLogin() {
        return cpLogin;
    }

    public void setCpLogin(String cpLogin) {
        this.cpLogin = cpLogin;
    }

    public String getCpSenha() {
        return cpSenha;
    }

    public void setCpSenha(String cpSenha) {
        this.cpSenha = cpSenha;
    }

    public String getCpChapa() {
        return cpChapa;
    }

    public void setCpChapa(String cpChapa) {
        this.cpChapa = cpChapa;
    }

    public String getCpCandidato() {
        return cpCandidato;
    }

    public void setCpCandidato(String cpCandidato) {
        this.cpCandidato = cpCandidato;
    }
}//class