# war
Java implementation of the card game War.

## Rules
https://en.wikipedia.org/wiki/War_(card_game)

In this implementation, won cards are added loser's cards first, winner's cards after.
i.e. Player 1 draws 3, Player 2 draws 4 -> 3 and then 4 are added to the bottom of Player 2's hand.

If a player runs out of cards during a war, that player immediately loses.

In the event that both players run out of cards simultaneously, the winner is randomly picked.

## Usage
Developed with gradle 2.5.

To run:
<code>
gradle installApp

cd build/install/war/bin

./war
</code>

Press Enter to advance through the game.
