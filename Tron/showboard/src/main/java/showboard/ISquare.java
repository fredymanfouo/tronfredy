package showboard;

import java.awt.Image;

/**
 * <h1>The Interface ISquare.</h1>
 * <p>
 *Une classe peut impl�menter l'interface ISquare quand elle veut �tre affich�e sur un IBoard
 * </p>
 *
 * @author fredy Manfouo
 * since 2019-07-08
 * @version 1.1
 * @see Image
 */
public interface ISquare {

	 /**
	 ����� * Obtient l'image.
	 ����� *
	 ����� * @retournez l'image
	 ����� */
    Image getImage();
}
