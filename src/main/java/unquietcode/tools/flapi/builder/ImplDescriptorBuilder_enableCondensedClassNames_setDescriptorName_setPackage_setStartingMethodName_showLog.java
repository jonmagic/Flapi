
package unquietcode.tools.flapi.builder;

import java.lang.reflect.Field;
import unquietcode.tools.flapi.MinimumInvocationsException;
import unquietcode.tools.flapi.ObjectWrapper;


/**
 * This class was generated using Flapi, the fluent API generator for Java.
 * Modifications to this file will be lost upon regeneration.
 * You have been warned!
 * 
 * Visit http://www.unquietcode.com/flapi for more information.
 * 
 * 
 * Generated on May 09, 2012 23:25:34 CDT using version 0.1
 * 
 */
public class ImplDescriptorBuilder_enableCondensedClassNames_setDescriptorName_setPackage_setStartingMethodName_showLog
    implements DescriptorBuilder_enableCondensedClassNames_setDescriptorName_setPackage_setStartingMethodName_showLog
{

    private final DescriptorHelper _helper;
    private final Object _returnValue;
    int ic_Descriptor_setDescriptorName$String_descriptorName = 1;
    int ic_Descriptor_setPackage$String_packageName = 1;
    int ic_Descriptor_setReturnType$Class_returnType = 1;

    ImplDescriptorBuilder_enableCondensedClassNames_setDescriptorName_setPackage_setStartingMethodName_showLog(DescriptorHelper helper, Object returnValue) {
        _helper = helper;
        _returnValue = returnValue;
    }

    private void _transferInvocations(Object next) {
        Class clazz = next.getClass();
         
        try {
            Field field = clazz.getDeclaredField("ic_Descriptor_setDescriptorName$String_descriptorName");
            field.setInt(next, ic_Descriptor_setDescriptorName$String_descriptorName);
        } catch (Exception _x) {
            // nothing
        }
         
        try {
            Field field = clazz.getDeclaredField("ic_Descriptor_setPackage$String_packageName");
            field.setInt(next, ic_Descriptor_setPackage$String_packageName);
        } catch (Exception _x) {
            // nothing
        }
         
        try {
            Field field = clazz.getDeclaredField("ic_Descriptor_setReturnType$Class_returnType");
            field.setInt(next, ic_Descriptor_setReturnType$Class_returnType);
        } catch (Exception _x) {
            // nothing
        }
    }

    private void _checkInvocations() {
        if (ic_Descriptor_setDescriptorName$String_descriptorName > 0) {
            throw new MinimumInvocationsException("Expected at least 1 invocations of method 'setDescriptorName(String descriptorName)'.");
        }
        if (ic_Descriptor_setPackage$String_packageName > 0) {
            throw new MinimumInvocationsException("Expected at least 1 invocations of method 'setPackage(String packageName)'.");
        }
        if (ic_Descriptor_setReturnType$Class_returnType > 0) {
            throw new MinimumInvocationsException("Expected at least 1 invocations of method 'setReturnType(Class returnType)'.");
        }
    }

    public MethodBuilder_addBlockChain addMethod(String methodSignature) {
        ObjectWrapper<MethodHelper> helper1 = new ObjectWrapper<MethodHelper>();
        _helper.addMethod(methodSignature, helper1);
         
        MethodBuilder_addBlockChain step1 = new ImplMethodBuilder_addBlockChain(helper1 .get(), this);
        MethodBuilder_addBlockChain retval = step1;
        _transferInvocations(retval);
        return retval;
    }

    public Object build() {
        _checkInvocations();
        _helper.build();
         
        Object retval = _returnValue;
        return retval;
    }

    public MethodBuilder_addBlockChain startBlock(String blockName, String methodSignature) {
        ObjectWrapper<MethodHelper> helper1 = new ObjectWrapper<MethodHelper>();
        ObjectWrapper<BlockHelper> helper2 = new ObjectWrapper<BlockHelper>();
        _helper.startBlock(blockName, methodSignature, helper1, helper2);
         
        BlockBuilder step2 = new ImplBlockBuilder(helper2 .get(), this);
        MethodBuilder_addBlockChain step1 = new ImplMethodBuilder_addBlockChain(helper1 .get(), step2);
        MethodBuilder_addBlockChain retval = step1;
        _transferInvocations(retval);
        return retval;
    }

    public DescriptorBuilder_setDescriptorName_setPackage_setStartingMethodName_showLog enableCondensedClassNames(boolean value) {
        _helper.enableCondensedClassNames(value);
         
        DescriptorBuilder_setDescriptorName_setPackage_setStartingMethodName_showLog retval = new ImplDescriptorBuilder_setDescriptorName_setPackage_setStartingMethodName_showLog(_helper, _returnValue);
        _transferInvocations(retval);
        return retval;
    }

    public DescriptorBuilder_enableCondensedClassNames_setPackage_setStartingMethodName_showLog setDescriptorName(String descriptorName) {
        _helper.setDescriptorName(descriptorName);
         
        DescriptorBuilder_enableCondensedClassNames_setPackage_setStartingMethodName_showLog retval = new ImplDescriptorBuilder_enableCondensedClassNames_setPackage_setStartingMethodName_showLog(_helper, _returnValue);
        --ic_Descriptor_setDescriptorName$String_descriptorName;
        _transferInvocations(retval);
        return retval;
    }

    public DescriptorBuilder_enableCondensedClassNames_setDescriptorName_setStartingMethodName_showLog setPackage(String packageName) {
        _helper.setPackage(packageName);
         
        DescriptorBuilder_enableCondensedClassNames_setDescriptorName_setStartingMethodName_showLog retval = new ImplDescriptorBuilder_enableCondensedClassNames_setDescriptorName_setStartingMethodName_showLog(_helper, _returnValue);
        --ic_Descriptor_setPackage$String_packageName;
        _transferInvocations(retval);
        return retval;
    }

    public DescriptorBuilder_enableCondensedClassNames_setDescriptorName_setPackage_showLog setStartingMethodName(String methodName) {
        _helper.setStartingMethodName(methodName);
         
        DescriptorBuilder_enableCondensedClassNames_setDescriptorName_setPackage_showLog retval = new ImplDescriptorBuilder_enableCondensedClassNames_setDescriptorName_setPackage_showLog(_helper, _returnValue);
        _transferInvocations(retval);
        return retval;
    }

    public DescriptorBuilder_enableCondensedClassNames_setDescriptorName_setPackage_setStartingMethodName showLog(boolean value) {
        _helper.showLog(value);
         
        DescriptorBuilder_enableCondensedClassNames_setDescriptorName_setPackage_setStartingMethodName retval = new ImplDescriptorBuilder_enableCondensedClassNames_setDescriptorName_setPackage_setStartingMethodName(_helper, _returnValue);
        _transferInvocations(retval);
        return retval;
    }

}
