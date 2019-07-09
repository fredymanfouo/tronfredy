package showboard;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observer;

import javax.swing.JFrame;

/**
 * <h1>The Class BoardFrame.</h1>
 * <p>
 * Cette classe sert uniquement � charger le BoardPanel. Il �tend JPanel et impl�mente IBoard.
 * </p>
 * <p>
 * BoardPanel �tant une classe priv�e, BoardPanel est une fa�ade..
 * </p>
 *
 * @author fredy Manfouo
 * @since 2017-07-08
 * @see JFrame
 * @see BoardPanel
 * @see Dimension
 * @see Rectangle
 * @see IBoard
 * @see ISquare
 * @see IPawn
 */
public class BoardFrame extends JFrame implements IBoard {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6563585351564617603L;

    /** The initial frame size. */
    private static final int  defaultFrameSize = 700;

    /** The board panel. */
    private final BoardPanel  boardPanel;

    /**
     * istancie un nouveau panel
    *@author fredy Manfouo 
     *since 2019-07-08
     */
    public BoardFrame(final String title, final Boolean decorated) {
        super();
        this.setTitle(title);
        this.setSize(defaultFrameSize, defaultFrameSize);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(decorated);
        this.boardPanel = new BoardPanel();
        this.setContentPane(this.boardPanel);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    public BoardFrame(final String title) {
        this(title, false);
    }

    /**
     *instancier un nouveau board frame 
     *@author fredy Manfouo 
     *since 2019-07-08
     */
    public BoardFrame() {
        this("", false);
    }

  
    public BoardFrame(final Boolean decorated) {
        this("", decorated);
    }

    @Override
    public final void addSquare(final ISquare square, final int x, final int y) {
        this.getBoardPanel().addSquare(square, x, y);
    }

    @Override
    public final void addPawn(final IPawn pawn) {
        this.getBoardPanel().addPawn(pawn);
    }

    @Override
    public final Observer getObserver() {
        return this.getBoardPanel();
    }

    @Override
    public final void setDimension(final Dimension dimension) {
        this.getBoardPanel().setDimension(dimension);
    }

    @Override
    public final Dimension getDimension() {
        return this.getBoardPanel().getDimension();
    }

    /**
     *Obtient le cadre d'affichage.
����� * @retournez le cadre d'affichage
     */
    public final Rectangle getDisplayFrame() {
        return this.getBoardPanel().getDisplayFrame();
    }

    @Override
    public final void setDisplayFrame(final Rectangle displayFrame) {
        this.getBoardPanel().setDisplayFrame(displayFrame);
    }

    /**
     *Obtient le tableau de bord.
����� * @retour le panneau
     */
    private BoardPanel getBoardPanel() {
        return this.boardPanel;
    }

    /**
     * V�rifie si la largeur est boucl�e.
����� * @retour le bool�en
     */
    public final Boolean isWidthLooped() {
        return this.getBoardPanel().isWidthLooped();
    }

    /**
  * D�finit la largeur en boucle.
����� *
����� * @param widthLooped
����� * la nouvelle largeur en boucle
     */
    public final void setWidthLooped(final Boolean widthLooped) {
        this.getBoardPanel().setWidthLooped(widthLooped);
    }

    /**
    * V�rifie si la hauteur est boucl�e.
����� *
����� * @retour le bool�en
     */
    public final Boolean isHeightLooped() {
        return this.getBoardPanel().isHeightLooped();
    }

    /**
     *D�finit la hauteur en boucle.
����� *
����� * @param heightLooped
����� * la nouvelle hauteur en boucle
     */
    public final void setHeightLooped(final Boolean heightLooped) {
        this.getBoardPanel().setHeightLooped(heightLooped);
    }
}
