package showboard;

import java.awt.Point;

/**
 * <h1>The Interface IPawn.</h1>
 * <p>
 *Une classe peut implémenter l'interface IPawn lorsqu'elle souhaite passer sur un IBoard.
 * </p>
 *
 * @author fredy Manfouo
 * @since 2019-07-08
 * @see IBoard
 * @see ISquare
 * @see Point
 */
public interface IPawn extends ISquare {

	/**
	      * Obtient la position x.
	      *
	      * @retour le x
	      */
    int getX();

    /**
          * Obtient la position y.
          *
          * @retour le y
          */
    int getY();

    /**
          * Obtient la position Point (int x, int y).
          *
          * @retour la position
          * @see Point
          */
    Point getPosition();
}
