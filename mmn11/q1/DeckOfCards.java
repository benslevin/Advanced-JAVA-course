import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

//The class deckOfCards initializers the deck, with all the cards in it
//Has functions for the deck such as shuffle and deal card
public class DeckOfCards {

    private static final SecureRandom randomNumber = new SecureRandom(); // Random number generator
    private static final int NUM_OF_CARDS = 52; // Number of cards in a deck

    private ArrayList<Card> deck = new ArrayList<>(NUM_OF_CARDS); // Creating new Deck for game
    private int currentCard = 0;

    // Initializing the Deck with 52 cards
    public DeckOfCards() {
        String[] faces = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suit = {"Hearts", "Dimonds", "Clubs", "Spades"};

        for(int i = 0; i < NUM_OF_CARDS; i++){
            deck.add(i, new Card(faces[i%13], suit[i/13]));
        }
    }

    // Shuffling the deck
    public void shuffle(){
        currentCard = 0;
        for(int first = 0; first < deck.size(); first++){
            int second = randomNumber.nextInt(NUM_OF_CARDS); // Randomizing the card number for a better shuffle
            Collections.swap(deck, first, second);
        }
    }

    // Deal one card each time with "pointer" to top of deck
    public Card dealCard(){
        if (currentCard < deck.size()){ //checks if there are any more cards in deck
            return deck.get(currentCard++);
        }
        else {
            return null;//no more card in deck
        }
    }

    // Printing the Deck
    public void getCard(){
        for(int i = 0; i < NUM_OF_CARDS; i++) {
            System.out.println(deck.get(i));
        }
    }
}
