package sample;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

// Création de la classe Tweet
public class Tweet {

    // Définition des variables qui la compose
    private String idTweet;
    private String Pseudo;
    private LocalDateTime Date;
    private String Contenu;
    private String NomRetweet;

    // Définition de la structure d'un tweet avec RT
    public Tweet(String idTweet, String Pseudo, String Date, String Contenu, String NomRetweet) {
        setIdTweet(idTweet);
        setPseudo(Pseudo);
        setDate(Date);
        setContenu(Contenu);
        setNomRetweet(NomRetweet);
        
    }

    // Définition de la structure d'un Tweet sans RT (surcharge)
    public Tweet(String idTweet, String Pseudo, String Date, String Contenu) {
        setIdTweet(idTweet);
        setPseudo(Pseudo);
        setDate(Date);
        setContenu(Contenu);
    }



    // Getter et Setter des variables précedemment définies
    public String getIdTweet() {
        return idTweet;
    }

    public void setIdTweet(String idTweet) {
        this.idTweet = idTweet;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public void setPseudo(String pseudo) {
        this.Pseudo = pseudo;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(String date) {
        //Création d'un formateur pour passer la date au type "LocalDateTime"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime formatDateTime = LocalDateTime.parse(date, formatter);
        this.Date=LocalDateTime.parse(date, formatter);
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String contenu) {
        this.Contenu = contenu;
    }

    public String getNomRetweet() {
        return NomRetweet;
    }

    public void setNomRetweet(String nomRetweet) {
        this.NomRetweet = nomRetweet;
    }
}
