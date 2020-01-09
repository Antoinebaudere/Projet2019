package sample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Project {

    //Constante globale non modifiable (final)
    static private final String filePath = "src\\sample\\Foot.txt";
    static private final int nbDeTweetTotal=899597;
    static private final String delimiter = "\t";

    //ArrayList contenant l'intégralité des Tweets contenu dans les données.
    public ArrayList<Tweet> sortedSurfaceFormSet = new ArrayList<>();

    //Fonction permettant l'import des données (Utilisation de la classe Buffered Reader)
    public void importdonnee(){
        BufferedReader br = null;
        try {
            String sCurrentLine;
            FileInputStream fr = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fr, Charset.forName("UTF-8"));
            br = new BufferedReader(isr);
            int compteur = 0;
            //Une itération dans ce while équivaut à une ligne du fichier texte, cad un tweet
            while ((sCurrentLine = br.readLine()) != null) {

                String[] nextLine = sCurrentLine.split(delimiter);
                if (nextLine.length != 5 && nextLine.length != 4) {
                    System.out.println("Nettoyage ligne " + compteur);
                }
                compteur++;
                //On construit l'arrayList sortedSurfaceFormSet Tweet par Tweet en fonction du nombre de tabulations
                if (nextLine.length == 5) {
                    sortedSurfaceFormSet.add(new Tweet(nextLine[0], nextLine[1], nextLine[2].substring(0, 19), nextLine[3], nextLine[4]));
                }

                if (nextLine.length == 4) {
                    sortedSurfaceFormSet.add(new Tweet(nextLine[0], nextLine[1], nextLine[2].substring(0, 19), nextLine[3]));
                }
                //Affichage compteur tous les 1000 tweets
                if(compteur%1000==0)
                    System.out.println("Importé à " +compteur*100/nbDeTweetTotal+" %");


            }
            System.out.println("Import terminé");
            //On ferme le fichier
            br.close();
        } catch (IOException e) {
            //l'exception est attrapée ici
            e.printStackTrace();
        }
    }
}
