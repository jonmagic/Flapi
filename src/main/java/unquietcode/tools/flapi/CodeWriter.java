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

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.writer.FileCodeWriter;
import com.sun.codemodel.writer.SingleStreamCodeWriter;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.FileChannel;

/**
 * @author Ben Fagin
 * @version 03-10-2012
 */
public class CodeWriter {

	public static void writeToStream(JCodeModel model, OutputStream stream) {
		SingleStreamCodeWriter writer = new SingleStreamCodeWriter(stream);

		try {
			model.build(writer);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}

		System.out.println(stream.toString());
	}

	public static void writeToDirectory(JCodeModel model, File directory) {
		try {
			FileCodeWriter fileWriter = new FileCodeWriter(directory, false);
			model.build(fileWriter);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void writeRequiredClasses(File folder) {
		String path = Constants.getSupportPath(folder);
		File dir = new File(path);

		if (!dir.exists()) {
			boolean create = dir.mkdirs();
			if (!create) {
				throw new DescriptorBuilderException("Unable create output directory '"+path+"'.");
			}
		}

		for (String requiredFile : Constants.REQUIRED_FILES) {
			String fileName = requiredFile+".java";
			copyFile(getResourceFile(fileName), createFile(dir.getAbsolutePath(), fileName));
		}
	}

	//---o---o---o---o---o---o---o---o---o---o---o---o---o---o---o---o---o---o---o---o---o---o---//

	private static File getResourceFile(String name) {
		URL url = CodeWriter.class.getClassLoader().getResource(name);
		File f;

		if (url == null) {
			throw new DescriptorBuilderException("Cannot find file '"+name+"' (this is an internal error).");
		}

		try {
			f = new File(url.toURI());
		} catch (URISyntaxException ex) {
			throw new DescriptorBuilderException(ex);
		}

		if (!f.exists()) {
			throw new DescriptorBuilderException("Cannot find file '"+name+"' (this is an internal error).");
		}

		return f;
	}

	private static File createFile(String path, String name) {
		File file = new File(path+File.separator+name);

		if (file.exists()) {
			if (!file.delete()) {
				throw new DescriptorBuilderException("Could not remove old file '"+file.getAbsolutePath()+"'.");
			}
		}

		boolean create;
		try {
			create = file.createNewFile();
		} catch (IOException ex) {
			throw new DescriptorBuilderException("Error creating file.", ex);
		}

		if (!create) {
			throw new DescriptorBuilderException("Error creating file.");
		}

		return file;
	}

	private static void copyFile(File sourceFile, File destFile) {
		FileChannel source = null;
		FileChannel destination = null;

		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} catch (Exception ex) {
			throw new DescriptorBuilderException("Error while writing files.", ex);
		} finally {
			if (source != null) {
				try {source.close();} catch (Exception ex) { /* nothing */ }
			}

			if (destination != null) {
				try {destination.close();} catch (Exception ex) { /* nothing */ }
			}
		}
	}
}
