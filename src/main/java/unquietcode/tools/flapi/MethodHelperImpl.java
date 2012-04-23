package unquietcode.tools.flapi;

import unquietcode.tools.flapi.builder.MethodHelper;
import unquietcode.tools.flapi.outline.MethodOutline;

/**
 * @author Ben Fagin
 * @version 03-04-2012
 */
public class MethodHelperImpl implements MethodHelper {
	final MethodOutline method;

	MethodHelperImpl() {
		this(new MethodOutline());
	}

	MethodHelperImpl(MethodOutline method) {
		this.method = method;
	}
	
	@Override
	public void once() {
		method.minOccurrances = 0;
		method.maxOccurrances = 1;
	}

	@Override
	public void any() {
		method.minOccurrances = 0;
		method.maxOccurrances = -1;
	}

	@Override
	public void last() {
		method.minOccurrances = 0;
		method.maxOccurrances = 1;
		method.isTerminal = true;
	}

	@Override
	public void atLeast(int num) {
		if (num < 0) {
			throw new RuntimeException("must have at least >= 0");
		}

		method.minOccurrances = num;
	}

	@Override
	public void atMost(int num) {
		if (num <= 0) {
			throw new RuntimeException("must have at least > 0");
		}

		method.maxOccurrances = num;
	}

	@Override
	public void between(int atLeast, int atMost) {
		atMost(atMost);
		atLeast(atLeast);
	}
}
