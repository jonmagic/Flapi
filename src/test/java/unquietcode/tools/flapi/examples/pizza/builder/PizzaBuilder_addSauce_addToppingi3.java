
package unquietcode.tools.flapi.examples.pizza.builder;

import javax.annotation.Generated;
import unquietcode.tools.flapi.examples.pizza.DisappearingPizzaExample.SauceType;
import unquietcode.tools.flapi.examples.pizza.DisappearingPizzaExample.Topping;


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
public interface PizzaBuilder_addSauce_addToppingi3 <_ReturnType >{


    unquietcode.tools.flapi.examples.pizza.DisappearingPizzaExample.Pizza bake();

    PizzaBuilder_addToppingi3 <_ReturnType> addSauce(SauceType sauceType);

    PizzaBuilder_addSauce_addToppingi2 <_ReturnType> addTopping(Topping topping);

}
