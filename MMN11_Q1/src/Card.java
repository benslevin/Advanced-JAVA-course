//The class card initializers the cards and makes sure each card hase a face and suit
//Also has a method for changing the string value of each card to a number value for the game
public class Card {

    private final String suit;
    private final String face;

    // Constructor
    public Card(String cardFace, String cardSuit){
        this.face = cardFace;
        this.suit = cardSuit;
    }

    // Overriding toString form Class Object
    public String toString(){
        return face + " Of " + suit;
    }

    // Getter for face of card
    public String getFace(){
        return face;
    }

    // Checks each face value to match a enum parameter
    public int getFaceValue(){
        switch (getFace()){
            case ("Two"):
                EnumCardValue.CardValue value2 = EnumCardValue.CardValue.TWO;
                return value2.getCardValue();
            case ("Three"):
                EnumCardValue.CardValue value3 = EnumCardValue.CardValue.THREE;
                return value3.getCardValue();
            case ("Four"):
                EnumCardValue.CardValue value4 = EnumCardValue.CardValue.FOUR;
                return value4.getCardValue();
            case ("Five"):
                EnumCardValue.CardValue value5 = EnumCardValue.CardValue.FIVE;
                return value5.getCardValue();
            case ("Six"):
                EnumCardValue.CardValue value6 = EnumCardValue.CardValue.SIX;
                return value6.getCardValue();
            case ("Seven"):
                EnumCardValue.CardValue value7 = EnumCardValue.CardValue.SEVEN;
                return value7.getCardValue();
            case ("Eight"):
                EnumCardValue.CardValue value8 = EnumCardValue.CardValue.EIGHT;
                return value8.getCardValue();
            case ("Nine"):
                EnumCardValue.CardValue value9 = EnumCardValue.CardValue.NINE;
                return value9.getCardValue();
            case ("Ten"):
                EnumCardValue.CardValue value10 = EnumCardValue.CardValue.TEN;
                return value10.getCardValue();
            case ("Jack"):
                EnumCardValue.CardValue value11 = EnumCardValue.CardValue.JACK;
                return value11.getCardValue();
            case ("Queen"):
                EnumCardValue.CardValue value12 = EnumCardValue.CardValue.QUEEN;
                return value12.getCardValue();
            case ("King"):
                EnumCardValue.CardValue value13 = EnumCardValue.CardValue.KING;
                return value13.getCardValue();
            case ("Ace"):
                EnumCardValue.CardValue value14 = EnumCardValue.CardValue.ACE;
                return value14.getCardValue();
        }
        return 0;
    }
}
