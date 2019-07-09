package model;
/**
 * <h1>The  Model class</h1>
 * 
 * 
 * @version 1.0
 */
public class TronModel implements ITronModel{
	private IGrid grid;
	/** 
	 *@author fredy Manfouo
	 * since 2019-07-08
	 * @see model.ITronModel#getGrid()
	 */
	public IGrid getGrid() {
		return grid;
	}
	/**
	 * 
	 * @see model.ITronModel#setGrid(model.IGrid)
	 */
	public void setGrid(IGrid grid) {
		this.grid = grid;
	}

	
	
	
}
