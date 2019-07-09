package showboard;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observer;

/**
 * <h1>The Interface IBoard.</h1>
 *
 * @author fredy Manfouo
 * @since 2019-07-08
 * @see Dimension
 * @see Rectangle
 * @see ISquare
 * @see IPawn
 */
public interface IBoard {

    /**
     Ajoute le carré.
      *
      * @param square
      * le carré
      * @param x
      * le x
      * @param y
      *            le y
     */
    void addSquare(ISquare square, int x, int y);

    /**
          * Ajoute le pion.
          *
          * @param pawn
          * le pion
          */
    void addPawn(IPawn pawn);

    /**
          * Obtient l'observateur.
          *
          * @retour l'observateur
          */
    Observer getObserver();

    /**
          * Définit la dimension.
          *
          * dimension @param
          * la nouvelle dimension
          */
    void setDimension(Dimension dimension);

    /**
          * Obtient la dimension.
          *
          * @retour la dimension
          */
    Dimension getDimension();

    /**
      * Définit le cadre d'affichage.
      *
      * @param displayFrame
      * le nouveau cadre d'affichage
      */
    void setDisplayFrame(Rectangle displayFrame);
}
