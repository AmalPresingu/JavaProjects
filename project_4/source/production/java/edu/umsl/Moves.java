package edu.umsl;

public class Moves {

    /*
    move 1: slice 1 head // regenerate 1 head
    move 2: slice 1 tail // regenerate 2 tails
    move 3: slice 2 heads // no consequence
    move 4: slice 2 tails // regenerate 1 head
     */

    int heads;
    int tails;

    Moves() {
        heads = 0;
        tails = 0;
    }

    Moves (int h, int t) {
        heads = h;
        tails = t;
    }

    //accessing hydra to slice 1 head and regenerate 1 head
    public void move1 (Moves h) {
        h.heads -= 1;
        h.heads += 1;
    }

    //slice 1 tail and regenerate 2 tails
    public void move2 (Moves h) {
        h.tails -= 1;
        h.tails += 2;
    }

    //slice 2 heads
    public void move3 (Moves h) {
        h.heads -= 2;
    }

    //slice 2 tails and regenerate 1 head
    public void move4 (Moves h) {
        h.tails -= 2;
        h.heads += 1;
    }

    public void cancelHeads (Moves h) {
        h.heads += 0;
    }

    public void cancelTails (Moves h) {
        h.tails += 0;
    }
}
