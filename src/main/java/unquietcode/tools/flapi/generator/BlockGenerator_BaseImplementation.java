package unquietcode.tools.flapi.generator;

import com.sun.codemodel.*;
import unquietcode.tools.flapi.outline.BlockOutline;
import unquietcode.tools.flapi.outline.MethodOutline;

import java.util.Collections;

/**
 * @author Ben Fagin
 * @version 04-24-2012
 *
 * Creates the base implementation for a given block.
 */
public class BlockGenerator_BaseImplementation extends AbstractBlockGenerator<BlockOutline, JDefinedClass> {

	public BlockGenerator_BaseImplementation(BlockOutline outline, GeneratorContext context) {
		super(outline, context);
	}

	@Override
	public JDefinedClass generate() {
		JDefinedClass iBuilder = getInterface(outline.getBaseInterface());
		JDefinedClass cBuilder = getClass(outline.getBaseImplementation());
		cBuilder._implements(iBuilder);

		JFieldVar _helper = cBuilder.field(JMod.PROTECTED+JMod.FINAL, getInterface(outline.getHelperInterface()), "_helper");
		JFieldVar _returnValue = cBuilder.field(JMod.PROTECTED+JMod.FINAL, ref(Object.class), "_returnValue");

		JMethod constructor = cBuilder.constructor(JMod.NONE);
		JVar pHelper = constructor.param(getInterface(outline.getHelperInterface()), "helper");
		JVar pReturnValue = constructor.param(ref(Object.class), "returnValue");

		constructor.body().assign(_helper, pHelper);
		constructor.body().assign(_returnValue, pReturnValue);

		// -------------- //

		// add required methods to base
		for (MethodOutline method : outline.getRequiredMethods()) {
			JExpression initialReturnValue = method.isTerminal() ? JExpr.ref("_returnValue") : JExpr._this();
			addMethod(cBuilder, computeImplementationReturnType(iBuilder, Collections.<MethodOutline>emptySet(), method), initialReturnValue, method);
		}

		return cBuilder;
	}
}
