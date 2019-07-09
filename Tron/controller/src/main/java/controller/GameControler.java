package controller;

/**
 * <h1>Game controler</h1>
 * 
 * 
 * @version 1.0
 */
import model.ITronModel;
import view.IView;

public class GameControler implements IController {
	
	IView view ;
	ITronModel model;
	
	/**
	 * Constructor
	 @author fredy Manfouo
	 * since 2019-07-06
	 */
	public GameControler(ITronModel model , IView view) {
		this.model=model;
		this.view=view;
		
		
		
	}
	
	/**
	 * Lance le jeu
	 * @see controller.IController#play()
	 * @author fredy Manfouo
	 * since 2019-07-06
	 */
	
	
	public void play(){
		/** tant que les deux joueurs ne sont pas morts
		 * 
		 */
		while(model.getGrid().getRider1().isAlive() && model.getGrid().getRider2().isAlive()) {
			/**on bouge le rider 1
			 * @author fredy Manfouo
	          * since 2019-07-06
			 */
			model.getGrid().getRider1().move();
			/**si il est mort 
			 * @author fredy Manfouo
	          * since 2019-07-06
			 */
			if(model.getGrid().getRider1().isAlive() == false) {
				/**on affiche le message
				 * @author fredy Manfouo
	              * since 2019-07-06
				 */
				model.getGrid().getTimer().stop();
				model.getGrid().save();
				this.view.displayMessage("Rider 2 Win (Blue) Win in "+model.getGrid().getTimer().getTime()+" Seconds");
			}
			
			
			
			/**pareil pour le rider 2
			 * @author fredy Manfouo
	         * since 2019-07-06
			 */
			model.getGrid().getRider2().move();
			if(model.getGrid().getRider2().isAlive() == false) {
				model.getGrid().getTimer().stop();
				model.getGrid().save();
				this.view.displayMessage("Rider 1 Win (Red) Win in"+model.getGrid().getTimer().getTime()+" Seconds");
			
			}
			
			
			try {
				/**Boucle de temps de jeu
				 * @author fredy Manfouo
	             * since 2019-07-06
				 */
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
