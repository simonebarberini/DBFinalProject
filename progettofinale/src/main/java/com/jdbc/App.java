package com.jdbc;

import java.util.List;
import java.util.Scanner;

import com.jdbc.dbservice.UserDao;
import com.jdbc.model.User;

public class App 
{
    public static void main( String[] args ){
        UserDao utenteDAO = new UserDao();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Registra un nuovo utente");
            System.out.println("2. Visualizza tutti gli utenti");
            System.out.println("3. Aggiorna un utente");
            System.out.println("4. Cancella un utente");
            System.out.println("5. Esci");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (choice) {
                case 1:
                    System.out.print("Inserisci username: ");
                    String userName = scanner.nextLine();
                    System.out.print("Inserisci l'email: ");
                    String email = scanner.nextLine();
                    System.out.print("Inserisci la password: ");
                    String password = scanner.nextLine();
                    System.out.print("Inserisci l'email: ");
                    scanner.nextLine();
                    double balance = scanner.nextDouble();
                    User nuovoUtente = new User(0, userName,password, email, balance);
                    utenteDAO.createUtente(nuovoUtente);
                    System.out.println("Utente inserito con successo!");
                    break;

                case 2:
                    List<User> users = utenteDAO.getAllUtenti();
                    System.out.println("Elenco utenti:");
                    for (User user : users) {
                        System.out.println(utente);
                    }
                    break;

                case 3:
                    System.out.print("Inserisci l'ID dell'utente da aggiornare: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consuma il newline
                    System.out.print("Inserisci il nuovo nome: ");
                    String nuovoNome = scanner.nextLine();
                    System.out.print("Inserisci la nuova email: ");
                    String nuovaEmail = scanner.nextLine();
                    Utente utenteDaAggiornare = new Utente(idUpdate, nuovoNome, nuovaEmail);
                    utenteDAO.updateUtente(utenteDaAggiornare);
                    System.out.println("Utente aggiornato con successo!");
                    break;

                case 4:
                    System.out.print("Inserisci l'ID dell'utente da cancellare: ");
                    int idDelete = scanner.nextInt();
                    utenteDAO.deleteUtente(idDelete);
                    System.out.println("Utente cancellato con successo!");
                    break;

                case 5:
                    running = false;
                    System.out.println("Uscita dal programma.");
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }

        scanner.close();
        
    }
}
