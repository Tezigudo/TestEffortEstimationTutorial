package functions.distributions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TmpAttribute {
	public Double tmpAttribute = 0.0;
	private static final Logger logger = LogManager.getLogger(TmpAttribute.class);

	public TmpAttribute(){
	}
	public Double getTmpAttribute(){
		logger.info("TmpAttribute is called");
		return tmpAttribute;
	}
}
