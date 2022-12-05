package basicCountingPackage;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;

public abstract class BasicCountingCheck extends AbstractCheck {
	
	protected Number result = 0;
	
	public Number getResult()
	{
		return result;
	}

}
