package com.iiitb.factory;

import org.w3c.dom.NodeList;

import com.iiitb.blocks.Block;
import com.iiitb.blocks.Constant;
import com.iiitb.blocks.Subsystem;
import com.iiitb.blocks.Sum;
import com.iiitb.cfg.Accfg;
import com.iiitb.constant.Constants;
import com.iiitb.utility.BlockFactoryUtility;

public class BlockFactory {

	/**
	 * @param blockName
	 *            - Based on blockName instance of a particular class is created
	 * @param attributes
	 *            - Passed as a parameter to utility method
	 * @return - Object with necessary attributes (e.g accfg) set
	 */
	public static Block generateBlock(String blockName, NodeList attributes) {

		Block block = null;
		if (blockName.startsWith(Constants.CONST)) {
			block = new Constant(blockName);
			BlockFactoryUtility.setBlockAttributes(Constants.VALUE, attributes,
					block);

		}

		if (blockName.startsWith(Constants.SUM)) {
			block = new Sum(blockName);

			BlockFactoryUtility.setBlockAttributes(Constants.INPUT, attributes,
					block);

		}

		return block;

	}

	
	/** Method caters to Subsystem block. The instance of Accfg to be passed is computed as part of
	 * underlying subsystem 
	**/
	
	public static Block generateBlock(String blockName, Accfg accfg) {
		Block block = null;
		if (blockName.startsWith(Constants.SUB_SYS)) {
			block = new Subsystem(accfg, blockName);

		}
		return block;
	}

}
