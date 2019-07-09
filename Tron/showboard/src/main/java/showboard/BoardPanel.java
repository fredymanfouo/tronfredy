package showboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * <h1>The Class BoardPanel.</h1>
 * <p>
 * Cette classe représente le tableau sous forme d'image. Il étend JPanel
 * </p>
 * <p>
 * Il utilise un tableau ISquare [] [], une liste & lt; IPawn & gt; comme liste de pions
 * </p>
 * <p>
 * Si un ISquare n'a pas d'image, la noImage est utilisée
 * </p>
 * <p>
 * Le même noImage est utilisé pour illustrer le bord du tableau.
 * </p>
 * <p>
 * La classe implémente l'interface Observer pour observer l'Observable qui stocke les données du tableau. À
  * chaque mise à jour, l'image est construite.
 * </p>
 * <p>
 *  La totalité de l'image n'est pas affichée, seule la zone représentée par l'affichage Rectangle apparaît dans
  * panneau. Si ce rectangle est supérieur à la dimension du tableau, la valeur noImage est également utilisée.
 * </p>
 *
 * @author fredy Manfouo
 * @since 2019-07-08
 * @see JPanel
 * @see Dimension
 * @see Rectangle
 * @see Image
 * @see ISquare
 * @see IPawn
 * @see Observer
 * @see Observable
 */
class BoardPanel extends JPanel implements Observer {

    /**Le serialVersionUID constant. */
    private static final long   serialVersionUID = -3618605287900763008L;

    /**Les carrés représentent le carré du tableau. */
    private ISquare[][]         squares;

    /** Les pions représentent une liste de tous les pions sur le plateau. */
    private final List<IPawn>   pawns;

    /**
     *La dimension est utilisée pour connaître la largeur et la hauteur de la planche. Il est utilisé principalement
      * avec la propriété des carrés
     */
    private Dimension           dimension;

    /** Le centre du tableau.*/
    private Rectangle           displayFrame;

    /**The no image is used to factorize the NoImage loading.. */
    private final BufferedImage noImage;

    /** The width looped. */
    private Boolean             widthLooped      = false;

    /** The height looped. */
    private Boolean             heightLooped     = false;

    /**
     * Instancie un nouveau panneau.
     */
    BoardPanel() {
        super();
        this.pawns = new ArrayList<>();
        this.noImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics = this.noImage.createGraphics();
        graphics.setColor(Color.darkGray);
        graphics.fillRect(0, 0, 2, 2);
    }

    /**
     * Paint component.
     *
     * @param graphics
     *            the graphics
     */

    @Override
    public final void paintComponent(final Graphics graphics) {

        final Map<String, ArrayList<IPawn>> mapPawn = this.createMapPawn();

        for (int x = this.getCornerMinX(); x <= this.getCornerMaxX(); x++) {
            for (int y = this.getCornerMinY(); y <= this.getCornerMaxY(); y++) {
                this.drawSquareXY(graphics, x, y);
                this.drawPawnsXY(graphics, mapPawn, x, y);
            }
        }
    }


    @Override
    public final void update(final Observable observable, final Object object) {
        this.repaint();
    }

    /**
     * joute le carré.
      *
      * @param square
      * le carré
      * @param x
      * le x
      * @param y
      *            the y

     */
    public final void addSquare(final ISquare square, final int x, final int y) {
        this.squares[x][y] = square;
    }

    /**
     * Adds the pawn.
     *
     * @param pawn
     *            the pawn
     */
    public final void addPawn(final IPawn pawn) {
        this.getPawns().add(pawn);
    }

    /**
     *Obtient l'image XY.
      *
      * @param x
      * le x
      * @param y
      *            ils
      * @param widthLimit
      * la limite de largeur
      * @param heightLimit
      * la limite de hauteur
      * @retourne l'image XY
      *           
     */
    private Image getImageXY(final int x, final int y, final int widthLimit, final int heightLimit) {
        Image image;
        final int realX = this.calculateRealX(x);
        final int realY = this.calculateRealY(y);
        if ((realX < 0) || (realY < 0) || (realX >= widthLimit) || (realY >= heightLimit)) {
            image = this.noImage;
        } else {
            image = this.squares[realX][realY].getImage();
            if (image == null) {
                image = this.noImage;
            }
        }
        return image;
    }

    /**
     *Calculer X réel
      *
      * @param x
      * le x
      * @retour le int
     */
    private int calculateRealX(final int x) {
        if (!this.isWidthLooped()) {
            return x;
        }
        return (x + this.getDimension().width) % this.getDimension().width;
    }

    /**
     *Calculer le Y réel
      *
      * @param et
      * le et
      * @retour le int
      */
    private int calculateRealY(final int y) {
        if (!this.isHeightLooped()) {
            return y;
        }
        return (y + this.getDimension().height) % this.getDimension().height;
    }

    /**
       * Obtient les pions.
          *
          * @retour les pions
          */
    private List<IPawn> getPawns() {
        return this.pawns;
    }

    /**
          * Obtient la dimension.
          *
          * @retour la dimension
          * @see Dimension
          */
    public final Dimension getDimension() {
        return this.dimension;
    }

    /**
          * Définit la dimension.
          *
          * dimension @param
          * la nouvelle dimension
          */
    public final void setDimension(final Dimension dimension) {
        this.dimension = dimension;
        this.squares = new ISquare[this.getDimension().width][this.getDimension().height];
    }

    /**
          * Obtient le cadre d'affichage.
          *
          * @retour le displayFrame
     */
    public final Rectangle getDisplayFrame() {
        return this.displayFrame;
    }

    /**
          * Définit le cadre d'affichage.
          *
          * @param displayFrame
          * le displayFrame à définir
          */
    public final void setDisplayFrame(final Rectangle displayFrame) {
        this.displayFrame = displayFrame;
    }

    /**
          * Vérifie si la largeur est bouclée.
          *
          * @retour le booléen
          */
    public Boolean isWidthLooped() {
        return this.widthLooped;
    }

    /**
          * Définit la largeur en boucle.
          *
          * @param widthLooped
          * la nouvelle largeur en boucle
          */
    public void setWidthLooped(final Boolean widthLooped) {
        this.widthLooped = widthLooped;
    }

   /**
          * Vérifie si la hauteur est bouclée.
          *
          * @retour le booléen
          */
    public Boolean isHeightLooped() {
        return this.heightLooped;
    }

    /**
         * Définit la hauteur en boucle.
          *
          * @param heightLooped
          * la nouvelle hauteur en boucle
          */
    
    public void setHeightLooped(final Boolean heightLooped) {
        this.heightLooped = heightLooped;
    }

    /**
      * Crée le pion de la carte.
          *
          * @retournez la carte
          */
    private Map<String, ArrayList<IPawn>> createMapPawn() {
        final Map<String, ArrayList<IPawn>> mapPawn = new HashMap<>();
        String key;

        for (final IPawn pawn : this.getPawns()) {
            key = this.createMapPawnKey(pawn.getX(), pawn.getY());
            ArrayList<IPawn> listPawn = mapPawn.get(key);
            if (listPawn == null) {
                listPawn = new ArrayList<>();
                mapPawn.put(key, listPawn);
            }
            listPawn.add(pawn);
        }
        return mapPawn;
    }

    /**
          * Crée la clé de pion de la carte.
          *
          * @param x
          * le x
          * @param y
          *            ils
          * @retour la ficelle
          */
    private String createMapPawnKey(final int x, final int y) {
        return x + ":" + y;
    }

    /**
      Dessine le carré XY.
      *
      * @param graphics
      * les graphiques
      * @param x
      * le x
      * @param y
      *            le y     */
    private void drawSquareXY(final Graphics graphics, final int x, final int y) {
        Image image;
        image = this.getImageXY(x, y, this.getWidthLimit(), this.getHeightLimit());
        graphics.drawImage(image, this.getSquareSizeWidth() * (x - this.getCornerMinX()),
                this.getSquareSizeHeight() * (y - this.getCornerMinY()), this.getSquareSizeWidth(),
                this.getSquareSizeHeight(), this);

    }

    /**
     *Dessinez des pions XY.
      *
      * @param graphics
      * les graphiques
      * @param mapPawn
      * le pion de la carte
      * @param x
      * le x
      * @param y
      *            le y
     */
    private void drawPawnsXY(final Graphics graphics, final Map<String, ArrayList<IPawn>> mapPawn, final int x,
            final int y) {
        final List<IPawn> listPawn = mapPawn.get(this.createMapPawnKey(this.calculateRealX(x), this.calculateRealY(y)));
        if (listPawn != null) {
            for (final IPawn pawn : listPawn) {
                graphics.drawImage(pawn.getImage(), this.getSquareSizeWidth() * (x - this.getCornerMinX()),
                        this.getSquareSizeHeight() * (y - this.getCornerMinY()), this.getSquareSizeWidth(),
                        this.getSquareSizeHeight(), this);
            }
        }
    }

    /**
      * Obtient la limite de largeur.
      *
      * @retour la limite de largeur
      
     */
    private int getWidthLimit() {
        return Math.min(this.getDisplayFrame().width + this.getDisplayFrame().x, this.getDimension().width);
    }

    /**
      * Obtient la limite de hauteur.
      *
      * @retour la limite de hauteur
     */
    private int getHeightLimit() {
        return Math.min(this.getDisplayFrame().height + this.getDisplayFrame().y, this.getDimension().height);
    }

    /**
     * Obtient le coin min X.
      *
      * @retour le coin min X    
 */
    private int getCornerMinX() {
        return this.getDisplayFrame().x;
    }

    /**
     * Obtient le coin max X.
      * @retour le coin max X
     */
    private int getCornerMaxX() {
        return this.getDisplayFrame().x + this.getDisplayFrame().width;
    }

    /**
      *Obtient le coin min Y.
      *
      * @retour le coin min Y
     */
    private int getCornerMinY() {
        return this.getDisplayFrame().y;
    }

    /**
     * Gets the corner max Y.
     *
     * @return the corner max Y
     */
    private int getCornerMaxY() {
        return this.getDisplayFrame().y + this.getDisplayFrame().height;
    }

    /**
     * Obtient la largeur de la taille carrée.
      * @retour le carré taille largeur
     */
    private int getSquareSizeWidth() {
        return this.getWidth() / this.getDisplayFrame().width;
    }

    /**
     *Obtient la taille de la taille carrée.
      * @retourne la taille carrée hauteur
     */
    private int getSquareSizeHeight() {
        return this.getHeight() / this.getDisplayFrame().height;
    }

}
