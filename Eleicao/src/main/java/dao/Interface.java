package dao;
import model.*;
import java.util.*;

public interface Interface {
    public Usuario logar(String login, String senha);
    public List<Candidato> preencheCan();
    public String votar (Voto voto);
    public void novoCan(Candidato candidato);
    public List<Object[]> apuracao();
    
}//interface
