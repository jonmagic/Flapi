
package unquietcode.tools.flapi.examples.calculator.builder;

import javax.annotation.Generated;
import unquietcode.tools.flapi.support.v0_2.BuilderImplementation;
import unquietcode.tools.flapi.support.v0_2.ObjectWrapper;


/**
 * This class was generated using Flapi, the fluent API generator for Java.
 * Modifications to this file will be lost upon regeneration.
 * You have been warned!
 * 
 * Visit http://www.unquietcode.com/flapi for more information.
 * 
 * 
 * Generated on June 24, 2012 16:46:25 CDT using version 0.2
 * 
 */
@Generated(value = "unquietcode.tools.flapi", date = "June 24, 2012 16:46:25 CDT", comments = "generated using Flapi, the fluent API generator for Java")
public class ImplCalculationBuilder
    implements CalculationBuilder, BuilderImplementation
{

    private final CalculationHelper _helper;
    private final BuilderImplementation _returnValue;

    ImplCalculationBuilder(CalculationHelper helper, BuilderImplementation returnValue) {
        _helper = helper;
        _returnValue = returnValue;
    }

    public BuilderImplementation _getParent() {
        return null;
    }

    private void _transferInvocations(Object next) {
        // nothing
    }

    public void _checkInvocations() {
        // nothing
    }

    public CalculationBuilder abs() {
        _helper.abs();
         
        return this;
    }

    public CalculationBuilder divide(int value) {
        _helper.divide(value);
         
        return this;
    }

    public ObjectWrapper equals() {
        ObjectWrapper intermediateResult = _helper.equals();
         
        return intermediateResult;
    }

    public CalculationBuilder minus(int value) {
        _helper.minus(value);
         
        return this;
    }

    public CalculationBuilder mod(int value) {
        _helper.mod(value);
         
        return this;
    }

    public CalculationBuilder plus(int value) {
        _helper.plus(value);
         
        return this;
    }

    public CalculationBuilder power(int value) {
        _helper.power(value);
         
        return this;
    }

    public CalculationBuilder times(int value) {
        _helper.times(value);
         
        return this;
    }

}
