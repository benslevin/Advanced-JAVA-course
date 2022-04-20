import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;

public class WarGame {

    // The program is a card WarGame where 2 players play, and the one with the higher cards wins
    // When there is war, each player draws 3 cards, and the one with the highest card wins the war deck as well
    // The game ends when someone losses all te cards they own, and the winner has all the cards
    public static void main(String[] args) {

        final int HALF_DECK = 26;

        DeckOfCards myDeck = new DeckOfCards();
        ArrayList<Card> player1Deck = new ArrayList<>(); // Initializing the deck for player 1
        ArrayList<Card> player2Deck = new ArrayList<>(); // Initializing the deck for player 2
        ArrayList<Card> warDeck = new ArrayList<>(); // Initializing the deck for war to keep the cards

        System.out.println("Printing the deck formed: ");
        printDeck(myDeck); // printing the new deck to see all cards
        myDeck.shuffle();// Shuffles the deck before the game starts
        System.out.println("Printing the shuffled deck: ");
        printDeck(myDeck); // printing shuffled deck to see the function worked

        //Deals the deck witch holds 52 card, and splits it to 26 cards for each player
        for(int i = 0; i < HALF_DECK; i++){
            player1Deck.add(myDeck.dealCard());
            player2Deck.add(myDeck.dealCard());
        }

        //Starting the game
        JOptionPane.showMessageDialog(null, "Game Start!");
        while(player1Deck.size() != 0 && player2Deck.size() != 0){
            Card topCardPlayer1 = player1Deck.get(0);
            Card topCardPlayer2 = player2Deck.get(0);

            JOptionPane.showMessageDialog(null, "Player 1 drew: " + topCardPlayer1.toString() + "\nPlayer 2 drew " + topCardPlayer2.toString());

            int player1 = topCardPlayer1.getFaceValue(); // Getting the numeric value of the face
            int player2 = topCardPlayer2.getFaceValue(); // Getting the numeric value of the face

            int outcome = compareHands(player1, player2);

            if(outcome == 1){
                JOptionPane.showMessageDialog(null, "The winner of this round is: player 1!");
                roundWinner(player1Deck, player2Deck, topCardPlayer1, topCardPlayer2);
            } else if(outcome == 2) {
                JOptionPane.showMessageDialog(null, "The winner of this round is: player 2!");
                roundWinner(player2Deck, player1Deck, topCardPlayer2, topCardPlayer1);
            } else if(outcome == 3){
                war(warDeck, player1Deck, player2Deck, topCardPlayer1, topCardPlayer2);
            }
        }

        // Calls the function to see if the game ended
        noCardsLeft(player1Deck, player2Deck);
    }


    // Compares the cards of each player
    public static int compareHands (int player1, int player2){
        if(player1 > player2){
            return 1;
        }
        else if(player1 < player2){
            return 2;
        }
        else{
            return 3;
        }
    }

    // Set of actions for the winner of the round, moves the cards to the winner deck
    public static void roundWinner(ArrayList<Card> winnerDeck, ArrayList<Card> loserDeck, Card winnerCard, Card loserCard){
        winnerDeck.add(winnerDeck.size(), winnerCard);
        winnerDeck.add(winnerDeck.size(), loserCard);
        winnerDeck.remove(0);
        loserDeck.remove(0);
    }

    // The function for a war in case the cards value match
    public static void war(ArrayList<Card> warDeck, ArrayList<Card> player1Deck, ArrayList<Card> player2Deck, Card topCardPlayer1, Card topCardPlayer2){

        int player1war;
        int player2war;
        boolean war = true;

        while (war) {
            JOptionPane.showMessageDialog(null, "War");
            warDeck.add(topCardPlayer1);
            warDeck.add(topCardPlayer2);
            player1Deck.remove(0);
            player2Deck.remove(0);

            // Adds the cards to the war deck
            addCardsToWarDeck(warDeck, player1Deck, topCardPlayer1);
            addCardsToWarDeck(warDeck, player2Deck, topCardPlayer2);

            // In case last card was used
            noCardsLeft(player1Deck, player2Deck);

            // Draws new cards
            topCardPlayer1 = player1Deck.get(0);
            topCardPlayer2 = player2Deck.get(0);

            // Gets the value of the cards
            player1war = topCardPlayer1.getFaceValue();
            player2war = topCardPlayer2.getFaceValue();

            // Compares the cards
            int warOutcome = compareHands(player1war, player2war);
            if(warOutcome == 1){
                JOptionPane.showMessageDialog(null, "The winner of this round is: player 1!");
                addCardsFromWarDeck(warDeck, player1Deck);
                roundWinner(player1Deck, player2Deck, topCardPlayer1, topCardPlayer2);
                break;
            } else if (warOutcome == 2){
                JOptionPane.showMessageDialog(null, "The winner of this round is: player 2!");
                addCardsFromWarDeck(warDeck, player2Deck);
                roundWinner(player2Deck, player1Deck, topCardPlayer2, topCardPlayer1);
                break;
            }
        }
    }

    // Adds the cards of both players to the war deck
    public static void addCardsToWarDeck(ArrayList<Card> warDeck, ArrayList<Card> playerDeck, Card topCardPlayerDeck) {

        final int WAR = 2; // A number for knowing if there are enough cards to pay a war
        if (playerDeck.size() <= WAR) {
            while(playerDeck.size() > 1) { // Checks to see that there are enough cards to play
                topCardPlayerDeck = playerDeck.get(0);
                warDeck.add(topCardPlayerDeck);
                playerDeck.remove(0);
            }
        } else {
            for (int i = 0; i < WAR; i++) {
                topCardPlayerDeck = playerDeck.get(0);
                warDeck.add(topCardPlayerDeck);
                playerDeck.remove(0);
            }

        }
    }

    // Adds the cards from the war deck to the winner of the war
    public static void addCardsFromWarDeck (ArrayList<Card> warDeck, ArrayList<Card> winnerDeck){
        for (int i = warDeck.size() - 1; i >= 0 ; i--){
            winnerDeck.add(winnerDeck.size(), warDeck.get(i));
            warDeck.remove(i);
        }
    }

    // Checks if there are no cards left and exits the program in case the game is finished
    public static void noCardsLeft(ArrayList<Card> player1Deck, ArrayList<Card> player2Deck){
        if(player1Deck.size() == 0){
            JOptionPane.showMessageDialog(null, "Player 1 has no cards left, player 2 is the winner!");
            System.exit(0);
        }
        else if(player2Deck.size() == 0){
            JOptionPane.showMessageDialog(null, "Player 2 has no cards left, player 1 is the winner!");
            System.exit(0);
        }
    }

    // Prints the Deck
    public static void printDeck(DeckOfCards deck){
        deck.getCard();
    }
}
