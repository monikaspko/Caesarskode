package main.java;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FileReader {
    String alfabetetLitenS = "abcdefghijklmnopqrstuvwxyzæøå";
    String alfabetetStorS = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";

    public List<String> readFile(String filnavn) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filnavn));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public List<String> krypter(List<String> linjer, int antall) {
        List<String> kryptertListe = new ArrayList<>();
        String kryptert = "";
        boolean liten = true;
        for (String linje : linjer) {
            kryptert = "";
            char[] chars = linje.toCharArray();
            for (char bokstav : chars) {
                int plass = alfabetetLitenS.indexOf(bokstav);
                if (plass == -1) {
                    plass = alfabetetStorS.indexOf(bokstav);
                    liten = false;
                }
                if (plass == -1) {
                    kryptert += bokstav;
                    liten = true;
                    continue;
                }
                plass += antall;
                char nyChar = ' ';
                if (liten) {
                    nyChar = alfabetetLitenS.charAt(plass % alfabetetLitenS.length());
                } else {
                    nyChar = alfabetetStorS.charAt(plass % alfabetetStorS.length());
                }
                kryptert += String.valueOf(nyChar);
                liten = true;
            }
            kryptertListe.add(kryptert);
        }
        return kryptertListe;
    }

    public List<String> dekrypter(List<String> linjer, int antall) {
        List<String> dekryptertListe = new ArrayList<>();
        String dekryptert = "";
        boolean liten = true;
        for (String linje : linjer) {
            dekryptert = "";
            char[] chars = linje.toCharArray();
            for (char bokstav : chars) {
                int plass = alfabetetLitenS.indexOf(bokstav);
                if (plass == -1) {
                    plass = alfabetetStorS.indexOf(bokstav);
                    liten = false;
                }
                if (plass == -1) {
                    dekryptert += bokstav;
                    liten = true;
                    continue;
                }
                plass -= antall;
                if(plass < 0) {
                    plass = alfabetetLitenS.length() + plass;
                }
                char nyChar = ' ';
                if (liten) {
                    nyChar = alfabetetLitenS.charAt(plass % alfabetetLitenS.length());
                } else {
                    nyChar = alfabetetStorS.charAt(plass % alfabetetStorS.length());
                }
                dekryptert += String.valueOf(nyChar);
                liten = true;
            }
            dekryptertListe.add(dekryptert);
        }
        return dekryptertListe;
    }

    public void writeFile(String filename, List<String> content) {
        try {
            Files.write(Paths.get(filename), content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
