package br.edu.fateclins.javacafe.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author apazi
 */
@Entity
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (length = 50, nullable = false)
    private String nome;
    @Column (length = 100)
    private String senha;
    @Column (length = 100, nullable = false, unique = true)
    private String email;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Transient
    private int idade;
    @ManyToOne
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = criptografarSenha(senha);
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
      this.senha = criptografarSenha(senha);
      //this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            sdf.setLenient(false);
            this.dataNascimento = sdf.parse(dataNascimento);
        } catch (ParseException ex){
            System.out.println("A data de nascimento deve ser no formato dd/mm/aaaa");
        }
    }

    public int getIdade() {
        if(this.dataNascimento != null){
            Calendar dtNasc = new GregorianCalendar();
            dtNasc.setTime(this.dataNascimento);
            Calendar hoje = Calendar.getInstance();
            idade = hoje.get(Calendar.YEAR) - dtNasc.get(Calendar.YEAR);
            dtNasc.add(Calendar.YEAR, idade);
            if(hoje.before(dtNasc)){
                idade--;
            }
        }
        return idade;
    }

    private void setIdade(int idade) {
        this.idade = idade;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    private String criptografarSenha(String senha){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            BigInteger hash = 
                    new BigInteger(1,md.digest(senha.getBytes()));
            this.senha = hash.toString();
        } catch (NoSuchAlgorithmException ex){
            System.out.println("Erro ao criptografar a senha");
        }
        return this.senha;
    }
    
    public boolean logar(Usuario userTentativa){
        if(userTentativa == null){
            return false;
        }
        return userTentativa.getSenha().equals(this.getSenha());
    }
    
    public boolean validarFormatoSenha(String senha) {
        // REGRA: maiusculas, minusculas, numeros e caracteres especiais, minimo 8.
        //        USANDO EXPRESSÃO REGULAR!
        //(?=.*[0-9]) um dígito deve ocorrer pelo menos uma vez
        //(?=.*[a-z]) uma letra minúscula deve ocorrer pelo menos uma vez
        //(?=.*[A-Z]) uma letra maiúscula deve ocorrer pelo menos uma vez
        //(?=.*[@#$%^&+=!]) um caractere especial deve ocorrer pelo menos uma vez
        //(?=\\S+$) nenhum espaço em branco permitido em toda a string
        //.{8,} pelo menos 8 caracteres
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}";

        return senha.matches(pattern);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
