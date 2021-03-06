/*******************************************************************************
 Copyright 2012 Benjamin Fagin

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.


     Read the included LICENSE.TXT for more information.
 ******************************************************************************/

package unquietcode.tools.flapi;

import org.junit.Assert;
import org.junit.Test;
import unquietcode.tools.flapi.builder.DescriptorGenerator;

/**
 * Tests which check the build process for the appropriate errors.
 */
public class BuildChecks_T {

	@Test
	public void twoBlocksNoCollision() {
		DescriptorGenerator.create(new DescriptorHelperImpl())
			.setPackage("unquietcode.something")
			.setDescriptorName("Something")
			.setStartingMethodName("create")

			.startBlock("Hello", "hello1()").last()
				.addMethod("end()").last()
			.endBlock()
			.startBlock("Goodbye", "hello2()").any()
				.addMethod("end()").last()
			.endBlock()
		.build();
	}

	@Test(expected=DescriptorBuilderException.class)
	public void blockNameCollisionCheck_twoTopLevel() {
		DescriptorGenerator.create(new DescriptorHelperImpl())
			.setPackage("unquietcode.something")
			.setDescriptorName("Something")
			.setStartingMethodName("create")

			.startBlock("Hello", "hello1()").any().endBlock()
			.startBlock("Hello", "hello2()").any().endBlock()
		.build();
	}

	@Test(expected=DescriptorBuilderException.class)
	public void blockNameCollisionCheck_nested() {
		DescriptorGenerator.create(new DescriptorHelperImpl())
			.setPackage("unquietcode.something")
			.setDescriptorName("Something")
			.setStartingMethodName("create")

			.startBlock("Hello", "hello1()").any()
				.startBlock("Hello", "hello2()").any().endBlock()
			.endBlock()

		.build();
	}

	@Test(expected=DescriptorBuilderException.class)
	public void blockNameCollisionCheck_inBlockChain() {
		DescriptorGenerator.create(new DescriptorHelperImpl())
			.setPackage("unquietcode.something")
			.setDescriptorName("Something")
			.setStartingMethodName("create")

			.addMethod("hello1()").addBlockChain()
				.startBlock("Hello").endBlock()
			.any()

			.startBlock("Hello", "hello2()").any().endBlock()
		.build();
	}

	@Test(expected=DescriptorBuilderException.class)
	public void blockNameCollisionCheck_inBlockChainNested() {
		DescriptorGenerator.create(new DescriptorHelperImpl())
			.setPackage("unquietcode.something")
			.setDescriptorName("Something")
			.setStartingMethodName("create")

			.addMethod("hello1()").addBlockChain()
				.startBlock("Hello")
					.startBlock("Hello", "hello2()").any().endBlock()
				.endBlock()
			.any()

		.build();
	}

	@Test(expected=DescriptorBuilderException.class)
	public void twoMethodsSameSignature() {
		DescriptorGenerator.create(new DescriptorHelperImpl())
			.setPackage("unquietcode.something")
			.setDescriptorName("Something")
			.setStartingMethodName("create")

			.startBlock("Block1", "void hello()").any().endBlock()
			.startBlock("Block2", "void hello()").any().endBlock()
		.build();
	}

	@Test(expected=DescriptorBuilderException.class)
	public void unreferencedBlock() {
		DescriptorGenerator.create(new DescriptorHelperImpl())
			.setPackage("unquietcode.something")
			.setDescriptorName("Something")
			.setStartingMethodName("create")

			.startBlock("Hello", "void hello()").any().endBlock()
			.addMethod("method()").addBlockChain().addBlockReference("Moo").any()
		.build();
	}

	@Test
	public void referencedBlockInChain() {
		DescriptorGenerator.create(new DescriptorHelperImpl())
			.setPackage("unquietcode.something")
			.setDescriptorName("Something")
			.setStartingMethodName("create")

			.addMethod("method()").addBlockChain()
				.startBlock("Hello")
					.addMethod("end()").last()
				.endBlock()
			.last()

			.startBlock("Goodbye", "void hello2()")
				.addBlockChain().addBlockReference("Hello").any()
					.addMethod("last()").last()
				.endBlock()
		.build();
	}

	@Test
	public void selfReferencedBlock() {
		DescriptorGenerator.create(new DescriptorHelperImpl())
			.setPackage("unquietcode.something")
			.setDescriptorName("Something")
			.setStartingMethodName("create")

			.startBlock("BlockA", "void hello1()")
				.addBlockChain().addBlockReference("BlockA").last()

				.addMethod("something()").last()
			.endBlock()

			.startBlock("BlockB", "void hello2()").atMost(1)
				.addMethod("void recurse()").addBlockChain().addBlockReference("BlockB").last()
			.endBlock()
		.build();
	}

	@Test(expected=DescriptorBuilderException.class)
	public void everyBlockHasALastMethod_noMethods() {
		DescriptorGenerator.create(new DescriptorHelperImpl())
			.setPackage("unquietcode.something")
			.setDescriptorName("Something")
			.setStartingMethodName("create")

			.startBlock("Block", "void method()").any()
			.endBlock()
		.build();
	}

	@Test(expected=DescriptorBuilderException.class)
	public void everyBlockHasALastMethod_someMethods() {
		DescriptorGenerator.create(new DescriptorHelperImpl())
			.setPackage("unquietcode.something")
			.setDescriptorName("Something")
			.setStartingMethodName("create")

			.startBlock("Block", "void method()").any()
				.addMethod("sometimes()").atMost(1)
				.addMethod("always()").any()
			.endBlock()
		.build();
	}

	@Test
	public void createMethodIsAValidName() {
		String[] names = new String[]{"4four", "inv*lid", "", " "};

		for (String name : names) {
			try {
				DescriptorGenerator.create(new DescriptorHelperImpl())
					.setPackage("unquietcode.something")
					.setDescriptorName("Something")
					.setStartingMethodName(name)
					.addMethod("done()").last()
				.build();

				Assert.fail("Expected an exception for name '"+name+"'.");
			} catch (DescriptorBuilderException ex) {
				// nothing
			} catch (IllegalArgumentException ex) {
				// nothing
			}
		}
	}
}