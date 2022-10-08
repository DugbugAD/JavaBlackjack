import javax.swing.*;

public class blackjack {
    static int[] dealer = new int[21];
    static int[] user = new int[21];
    static int dealerCards = 2;
    static int userCards = 2;
    static int userAce = 0;
    static int dealerAce = 0;
    static int[] CARDS = new int[] {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
    };

    static int rand() {
        boolean empty = true;
        for (int i = 0; i < 104; i++) {
            if (CARDS[i] != 0) {empty = false; break;}
        }
        if (empty) { 
            CARDS = new int[] {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
            };
            JOptionPane.showMessageDialog(null, "The deck has been reset");
        }
        while (true) {
            int x = (int) (Math.random() * 104);
            int draw = CARDS[x];
            if (draw != 0) {
                CARDS[x] = 0; 
                return draw;
            }
        }
    }

    static String text(boolean showDealersCards) {
        String s;
        if (!showDealersCards) {
            if (dealer[0] == 11) s = "Dealer: J";
            else if (dealer[0] == 12) s = "Dealer: Q";
            else if (dealer[0] == 13) s = "Dealer: K";
            else if (dealer[0] == 1) s = "Dealer: A";
            else s = "Dealer: " + dealer[0];
            for (int i = 1; i < 21; i++) {
                if (dealer[i] != 0)  {
                    s +=  ", -";
                }
            }
            if (user[0] == 11) s += "\nYou: J";
            else if (user[0] == 12) s += "\nYou: Q";
            else if (user[0] == 13) s += "\nYou: K";
            else if (user[0] == 1) s += "\nYou: A";
            else s += "\nYou: " + user[0];
            for (int i = 1; i < 21; i++) {
                if (user[i] != 0) {
                    if (user[i] == 11) s += ", J";
                    else if (user[i] == 12) s += ", Q";
                    else if (user[i] == 13) s += ", K";
                    else if (user[i] == 1) s += ", A";
                    else s+= ", " + user[i];
                }
            }
            return s;
        } else {
            if (dealer[0] == 11) s = "Dealer: J";
            else if (dealer[0] == 12) s = "Dealer: Q";
            else if (dealer[0] == 13) s = "Dealer: K";
            else if (dealer[0] == 1) s = "Dealer: A";
            else s = "Dealer: " + dealer[0];
            for (int i = 1; i < 21; i++) {
                if (dealer[i] != 0)  {
                    if (dealer[i] == 11) s += ", J";
                    else if (dealer[i] == 12) s += ", Q";
                    else if (dealer[i] == 13) s += ", K";
                    else if (dealer[i] == 1) s += ", A";
                    else s +=  ", " + dealer[i];
                }
            }
            if (user[0] == 11) s += "\nYou: J";
            else if (user[0] == 12) s += "\nYou: Q";
            else if (user[0] == 13) s += "\nYou: K";
            else if (user[0] == 1) s += "\nYou: A";
            else s += "\nYou: " + user[0];
            for (int i = 1; i < 21; i++) {
                if (user[i] != 0) {
                    if (user[i] == 11) s += ", J";
                    else if (user[i] == 12) s += ", Q";
                    else if (user[i] == 13) s += ", K";
                    else if (user[i] == 1) s += ", A";
                    else s+= ", " + user[i];
                }
            }
            return s;
        }
    }

    static int userSum() {
        int sum = 0;
        for (int i = 0; i < 21; i++) {
            if (user[i] == 1) userAce++;
            if (user[i] == 11 || user[i] == 12 || user[i] == 13) sum -= (user[i] - 10);
            sum += user[i];
        }
        for (int i = 0; i < userAce; i++) {
            if (sum + 10 <= 21) sum += 10;
        }
        return sum;
    }
    static int dealerSum() {
        int sum = 0;
        for (int i = 0; i < 21; i++) {
            if (dealer[i] == 1) dealerAce++;
            if (dealer[i] == 11 || dealer[i] == 12 || dealer[i] == 13) sum -= (dealer[i] - 10);
            sum += dealer[i];
        }
        for (int i = 0; i < dealerAce; i++) {
            if (sum + 11 <= 21) sum += 10;
        }
        return sum;
    }

    static void dealerDraw() {
        int counter = 0;
        while (dealerSum() < 17) {
            counter++;
            dealer[dealerCards] = rand();
            dealerCards++;
        }
        JOptionPane.showMessageDialog(null, "The dealer hits " + counter + " times!");
    }

    static void RESET() {
        for (int i = 0; i < 21; i++) {user[i] = 0; dealer[i] = 0;}
        dealerCards = 2;
        userCards = 2;
        dealerAce = 0;
        dealerAce = 0;

    }
    public static void main(String[] args) {
        boolean playAgain = true;
        while (playAgain) {
            dealer[0] = rand();
            dealer[1] = rand();

            user[0] = rand();
            user[1] = rand();


            boolean gameOver = false;
            String[] options = new String[] {"HIT", "STAND"};


            while (!gameOver) {
                if (userSum() > 21 || dealerSum() > 21) {
                    gameOver = true; 
                    break;
                }
                int hitOrStand = JOptionPane.showOptionDialog(null, text(false) + "\nWould you like to HIT or STAND?", "Blackjack",
                JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); // 0 = hit; 1 = stand; 
                
                if (hitOrStand == 0) {
                    user[userCards] = rand();
                    userCards++;
                } else gameOver = true;
            }

            if (userSum() > 21 && dealerSum() > 21) JOptionPane.showMessageDialog(null, text(true) + "\nDouble bust! You tied!");
            else if (userSum() > 21) JOptionPane.showMessageDialog(null, text(true) + "\nBust! You went over 21");
            else if (dealerSum() > 21) JOptionPane.showMessageDialog(null, text(true) + "\nThe dealer busted! You win!");
            else{
                dealerDraw();
                if (dealerSum() > 21) JOptionPane.showMessageDialog(null, text(true) + "\nThe dealer busted! You Win!");
                else if (userSum() > dealerSum()) JOptionPane.showMessageDialog(null, text(true) + "\nYou Win!");
                else if (userSum() < dealerSum()) JOptionPane.showMessageDialog(null, text(true) + "\nYou Lost!");
                else JOptionPane.showMessageDialog(null, text(true) + "\nYou Tied!");
            }
            
            playAgain = (JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Blackjack",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
            RESET();
        }
    }
}
