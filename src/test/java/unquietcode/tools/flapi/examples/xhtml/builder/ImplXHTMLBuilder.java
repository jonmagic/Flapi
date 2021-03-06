
package unquietcode.tools.flapi.examples.xhtml.builder;

import javax.annotation.Generated;
import org.w3c.dom.Document;
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
public class ImplXHTMLBuilder
    implements XHTMLBuilder, BuilderImplementation
{

    private final XHTMLHelper _helper;
    private final BuilderImplementation _returnValue;

    ImplXHTMLBuilder(XHTMLHelper helper, BuilderImplementation returnValue) {
        _helper = helper;
        _returnValue = returnValue;
    }

    public BuilderImplementation _getParent() {
        return _returnValue;
    }

    private void _transferInvocations(Object next) {
        // nothing
    }

    public void _checkInvocations() {
        // nothing
    }

    public XHTMLBuilder addComment(String comment) {
        _helper.addComment(comment);
         
        return this;
    }

    public Document done() {
        BuilderImplementation cur = _returnValue;
        while (cur!= null) {
            cur._checkInvocations();
            cur = cur._getParent();
        }
         
        Document intermediateResult = _helper.done();
         
        return intermediateResult;
    }

    public ElementBuilder_setValue startElement(String tagName) {
        ObjectWrapper<ElementHelper> helper1 = new ObjectWrapper<ElementHelper>();
        _helper.startElement(tagName, helper1);
         
        ImplElementBuilder_setValue step1 = new ImplElementBuilder_setValue(helper1 .get(), this);
        _transferInvocations(step1);
        return step1;
    }

}
