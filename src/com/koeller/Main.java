package com.koeller;

import java.util.List;

/**
 * Krypterer og dekrypterer med alfabetet deklarert i FileReader, dvs. alle bokstaver i det norske alfabetet, både store og små.
 * Linjeskift og mellomrom (+ andre symboler) blir ikke endret!
 *
 * Svaret skrives til fil.
 *
 * Forventet argumenter:
 * 1: path til fil med tekst som skal krypteres/dekrypteres
 * 2: antall forskyvninger i alfabetet (som tall)
 * 3: krypter eller dekrypter
 *
 */
public class Main {

    static FileReader reader = new FileReader();

    public static void main(String[] args) {
        if (args.length != 3)
            throw new IllegalArgumentException("Du må oppgi følgende argumenter: filpath, antall forsyvning og kryptere/dekryptere");

        if ("krypter".equals(args[2].toLowerCase())) {
            List<String> kryptertListe = reader.krypter(reader.readFile(args[0]), Integer.parseInt(args[1]));
            reader.writeFile(args[0].replaceFirst(".txt", "Kryp.txt"), kryptertListe);

        } else if ("dekrypter".equals(args[2].toLowerCase())) {
            List<String> dekryptertListe = reader.dekrypter(reader.readFile(args[0]), Integer.parseInt(args[1]));
            reader.writeFile(args[0].replaceFirst(".txt", "Dekryp.txt"), dekryptertListe);
        } else {
            throw new IllegalArgumentException("Jeg kan kun kryptere og dekryptere, du ba meg: " + args[2]);
        }
    }
}
